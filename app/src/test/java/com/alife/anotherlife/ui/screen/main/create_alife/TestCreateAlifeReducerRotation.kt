package com.alife.anotherlife.ui.screen.main.create_alife

import androidx.camera.core.ImageProxy
import com.alife.anotherlife.core.FakeUIStore
import com.alife.anotherlife.ui.screen.main.create_alife.mapper.CameraStateToSaveImage
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.EmptyCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.LoadScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.CameraFirstScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState
import com.alife.domain.core.usecase.UseCaseResult
import junit.framework.TestCase
import kotlinx.coroutines.test.runTest
import org.junit.Test
import java.util.concurrent.Executor

class TestCreateAlifeReducerRotation {

    lateinit var createAlifeReducer: CreateAlifeReducer
    lateinit var uiStore: FakeUIStore<CreateAlifeState, CreateAlifeEffect>

    private fun setupReducer(
        screenState: ScreenState,
        captureWrapper: BaseCaptureWrapper
    ) {
        uiStore = FakeUIStore(
            CreateAlifeState(
                screenState = screenState,
                captureWrapper = captureWrapper,
                settingsIntent = null
            )
        )

        createAlifeReducer = CreateAlifeReducer(
            uiStore,
            CameraStateToSaveImage(),
            TestCreateAlifeReducerOnTakePhoto.FakeImageProxySelectMapper(),
            TestCreateAlifeReducerOnTakePhoto.FakeSaveAlifeUseCase()
        )
    }

    @Test
    fun `test isInvertButtonEnable state return enabled`() = runTest {
        setupReducer(CameraFirstScreenState(), FakeCaptureWrapper())

        val expected = true

        TestCase.assertEquals(expected, uiStore.stateCollector.first().canInvert())
    }

    @Test
    fun `test isInvertButtonEnable return disabled`() = runTest {
        setupReducer(CameraFirstScreenState(), EmptyCaptureWrapper())

        val expected = false

        TestCase.assertEquals(expected, uiStore.stateCollector.first().canInvert())
    }

    @Test
    fun `test isInvertButtonEnable return disabled screen state`() = runTest {
        setupReducer(LoadScreenState(), FakeCaptureWrapper())

        val expected = false

        TestCase.assertEquals(expected, uiStore.stateCollector.first().canInvert())
    }

    @Test
    fun `test isInvertButtonEnable return disabled screen state and wrapper`() = runTest {
        setupReducer(LoadScreenState(), EmptyCaptureWrapper())

        val expected = false

        TestCase.assertEquals(expected, uiStore.stateCollector.first().canInvert())
    }
}