package com.alife.anotherlife.ui.screen.main.create_alife

import androidx.camera.core.CameraSelector
import com.alife.anotherlife.core.FakeUIStore
import com.alife.anotherlife.ui.screen.main.create_alife.mapper.CameraStateToSaveImage
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.LoadScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.CameraFirstScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState
import com.alife.domain.core.usecase.UseCaseResult
import junit.framework.TestCase
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test

class TestCreateAlifeReducerChangeCamera {

    lateinit var createAlifeReducer: CreateAlifeReducer
    lateinit var uiStore: FakeUIStore<CreateAlifeState, CreateAlifeEffect>

    private fun setupReducer(
        screenState: ScreenState,
        useCaseResult: UseCaseResult<Unit>
    ) {
        uiStore = FakeUIStore(CreateAlifeState(screenState = screenState, settingsIntent = null))

        createAlifeReducer = CreateAlifeReducer(
            uiStore,
            CameraStateToSaveImage(),
            TestCreateAlifeReducer.FakeSaveAlifeUseCase(useCaseResult)
        )
    }

    @Test
    fun `test once change camera with CameraFirstState`() = runTest {
        setupReducer(CameraFirstScreenState(), UseCaseResult.Success(Unit))

        createAlifeReducer.onChangeCamera()

        assertEquals(2, uiStore.stateCollector.size)
        assertEquals(0, uiStore.effectCollector.size)
        val screenState = uiStore.stateCollector.last().screenState
        TestCase.assertTrue(screenState is CameraFirstScreenState)
        val cameraFirstScreenState = screenState as CameraFirstScreenState
        assertEquals(CameraSelector.DEFAULT_BACK_CAMERA, cameraFirstScreenState.cameraSelector)
    }

    @Test
    fun `test two change camera with CameraFirstState`() = runTest {
        setupReducer(CameraFirstScreenState(), UseCaseResult.Success(Unit))

        createAlifeReducer.onChangeCamera()
        createAlifeReducer.onChangeCamera()

        assertEquals(3, uiStore.stateCollector.size)
        assertEquals(0, uiStore.effectCollector.size)
        val screenState = uiStore.stateCollector.last().screenState
        TestCase.assertTrue(screenState is CameraFirstScreenState)
        val cameraFirstScreenState = screenState as CameraFirstScreenState
        assertEquals(CameraSelector.DEFAULT_FRONT_CAMERA, cameraFirstScreenState.cameraSelector)
    }

    @Test
    fun `test once change camera with none InvertibleCamera`() = runTest {
        setupReducer(LoadScreenState(), UseCaseResult.Success(Unit))

        createAlifeReducer.onChangeCamera()

        assertEquals(1, uiStore.stateCollector.size)
        assertEquals(0, uiStore.effectCollector.size)
        val screenState = uiStore.stateCollector.last().screenState
        TestCase.assertTrue(screenState is LoadScreenState)
    }
}