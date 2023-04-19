package com.alife.anotherlife.ui.screen.main.create_alife

import androidx.camera.core.CameraSelector
import com.alife.anotherlife.core.FakeUIStore
import com.alife.anotherlife.ui.screen.main.create_alife.mapper.CameraStateToSaveImage
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.CameraPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.LoadScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.CameraFirstScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.CameraScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.CameraSecondScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState
import com.alife.domain.core.usecase.UseCaseResult
import com.alife.domain.main.create_alife.BaseSaveAlifeUseCase
import com.alife.domain.main.create_alife.entity.SaveImageEntity
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Test

class TestCreateAlifeReducer {

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
            FakeSaveAlifeUseCase(useCaseResult)
        )
    }

    @Test
    fun `photo without CameraScreenState`() = runTest {
        setupReducer(LoadScreenState(), UseCaseResult.Success(Unit))

        createAlifeReducer.onTakePhoto(ByteArray(0))

        assertEquals(1, uiStore.stateCollector.size)
        assertEquals(0, uiStore.effectCollector.size)
        val lastState = uiStore.stateCollector.last()
        assertTrue(lastState.screenState is LoadScreenState)
        assertTrue(lastState.pagerItems.first() is CameraPagerItem.TakePicture)
    }

    @Test
    fun `photo with CameraFirstScreen and OnPictureTaking`() = runTest {
        setupReducer(CameraFirstScreenState(), UseCaseResult.Success(Unit))

        createAlifeReducer.onStartTakePhoto(CameraPagerItem.OnPictureTaking())
        createAlifeReducer.onTakePhoto(ByteArray(0))

        assertEquals(3, uiStore.stateCollector.size)
        assertEquals(0, uiStore.effectCollector.size)
        val lastState = uiStore.stateCollector.last()
        assertTrue(lastState.screenState is CameraSecondScreenState)
        assertTrue(lastState.pagerItems.first() is CameraPagerItem.TakePicture)
    }

    @Test
    fun `test start taking photo with none CameraScreenState`() = runTest {
        setupReducer(LoadScreenState(), UseCaseResult.Success(Unit))

        createAlifeReducer.onStartTakePhoto(CameraPagerItem.OnPictureTaking())

        assertEquals(2, uiStore.stateCollector.size)
        assertEquals(0, uiStore.effectCollector.size)
        val lastState = uiStore.stateCollector.last()
        assertTrue(lastState.screenState is LoadScreenState)
        assertTrue(lastState.pagerItems.first() is CameraPagerItem.OnPictureTaking)
    }

    @Test
    fun `test one take photo`() = runTest {
        setupReducer(CameraFirstScreenState(), UseCaseResult.Success(Unit))

        createAlifeReducer.onTakePhoto(ByteArray(0))

        assertEquals(2, uiStore.stateCollector.size)
        assertEquals(0, uiStore.effectCollector.size)
        val screenState = uiStore.stateCollector.last().screenState
        assertTrue(screenState is CameraSecondScreenState)
        assertEquals(
            CameraSelector.DEFAULT_BACK_CAMERA,
            (screenState as CameraSecondScreenState).cameraSelector
        )
    }

    @Test
    fun `test two take photo`() = runTest {
        setupReducer(CameraFirstScreenState(), UseCaseResult.Success(Unit))

        createAlifeReducer.onTakePhoto(ByteArray(0))

        createAlifeReducer.onTakePhoto(ByteArray(0))

        assertEquals(2, uiStore.stateCollector.size)
        assertEquals(1, uiStore.effectCollector.size)
        val lastState = uiStore.stateCollector.last()
        assertTrue(lastState.screenState is CameraSecondScreenState)
        assertTrue(uiStore.effectCollector.last() is CreateAlifeEffect.CreateAlifeFinish)
        assertEquals(
            CameraSelector.DEFAULT_BACK_CAMERA,
            (lastState.screenState as CameraScreenState).cameraSelector
        )
    }

    @Test
    fun `test one three photo`() = runTest {
        setupReducer(CameraFirstScreenState(), UseCaseResult.Success(Unit))

        createAlifeReducer.onTakePhoto(ByteArray(0))

        createAlifeReducer.onTakePhoto(ByteArray(0))

        createAlifeReducer.onTakePhoto(ByteArray(0))
        // return из-за того, что стоит LoadState

        assertEquals(2, uiStore.stateCollector.size)
        assertEquals(2, uiStore.effectCollector.size)
        val lastState = uiStore.stateCollector.last()
        assertTrue(lastState.screenState is CameraSecondScreenState)
        assertTrue(uiStore.effectCollector.last() is CreateAlifeEffect.CreateAlifeFinish)
        assertEquals(
            CameraSelector.DEFAULT_BACK_CAMERA,
            (lastState.screenState as CameraScreenState).cameraSelector
        )
    }

    // Fake Realization
    class FakeSaveAlifeUseCase(
        private val useCaseResult: UseCaseResult<Unit>
    ) : BaseSaveAlifeUseCase {

        override suspend fun saveImage(saveImageEntity: SaveImageEntity): UseCaseResult<Unit> {
            return useCaseResult
        }
    }
}