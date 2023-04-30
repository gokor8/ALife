package com.alife.anotherlife.ui.screen.main.create_alife

import androidx.camera.core.CameraSelector
import com.alife.anotherlife.core.FakeUIStore
import com.alife.anotherlife.ui.screen.main.create_alife.mapper.CameraStateToSaveImage
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.LoadScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.ScreenFirstScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.photo.CreateAlifePhotoReducer
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState
import junit.framework.TestCase
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test

class TestCreateAlifeReducerChangeCamera {

    lateinit var createAlifeReducer: CreateAlifeReducer
    lateinit var uiStore: FakeUIStore<CreateAlifeState, CreateAlifeEffect>

    private fun setupReducer(screenState: ScreenState) {
        uiStore = FakeUIStore(CreateAlifeState(settingsIntent = null))

        createAlifeReducer = CreateAlifeReducer(uiStore, )
    }

    @Test
    fun `test once change camera with CameraFirstState`() = runTest {
        setupReducer(ScreenFirstScreenState())

        createAlifeReducer.onChangeCamera()

        val firstScreenState = uiStore.stateCollector[0].screenState
        val secondScreenState = uiStore.stateCollector[1].screenState

        assertEquals(2, uiStore.stateCollector.size)
        assertEquals(0, uiStore.effectCollector.size)
        (firstScreenState as ScreenFirstScreenState).also {
            assertEquals(CameraSelector.DEFAULT_FRONT_CAMERA, it.cameraSelector)
        }
        (secondScreenState as ScreenFirstScreenState).also {
            assertEquals(CameraSelector.DEFAULT_BACK_CAMERA, it.cameraSelector)
        }
    }

    @Test
    fun `test two change camera with CameraFirstState`() = runTest {
        setupReducer(ScreenFirstScreenState())

        createAlifeReducer.onChangeCamera()
        createAlifeReducer.onChangeCamera()

        val secondScreenState = uiStore.stateCollector[1].screenState
        val thirdScreenState = uiStore.stateCollector[2].screenState

        assertEquals(3, uiStore.stateCollector.size)
        assertEquals(0, uiStore.effectCollector.size)
        (secondScreenState as ScreenFirstScreenState).also {
            assertEquals(CameraSelector.DEFAULT_BACK_CAMERA, it.cameraSelector)
        }
        (thirdScreenState as ScreenFirstScreenState).also {
            assertEquals(CameraSelector.DEFAULT_FRONT_CAMERA, it.cameraSelector)
        }
    }

    @Test
    fun `test once change camera with none InvertibleCamera`() = runTest {
        setupReducer(LoadScreenState())

        createAlifeReducer.onChangeCamera()

        assertEquals(1, uiStore.stateCollector.size)
        assertEquals(0, uiStore.effectCollector.size)
        val screenState = uiStore.stateCollector.last().screenState
        TestCase.assertTrue(screenState is LoadScreenState)
    }
}