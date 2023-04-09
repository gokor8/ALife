package com.alife.anotherlife.ui.screen.main.create_alife

import androidx.camera.core.CameraSelector
import com.alife.anotherlife.core.FakeUIStore
import com.alife.anotherlife.ui.screen.main.create_alife.mapper.CameraStateToSaveImage
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
    fun `test take photo with none CameraScreenState`() = runTest {
        setupReducer(LoadScreenState(), UseCaseResult.Success(Unit))

        createAlifeReducer.onTakePhoto(ByteArray(0))

        assertEquals(1, uiStore.stateCollector.size)
        assertEquals(0, uiStore.effectCollector.size)
        val screenState = uiStore.stateCollector.last().screenState
        assertTrue(screenState is LoadScreenState)
    }

    @Test
    fun `test one take photo`() = runTest {
        setupReducer(CameraFirstScreenState(), UseCaseResult.Success(Unit))

        createAlifeReducer.onTakePhoto(ByteArray(0))

        assertEquals(3, uiStore.stateCollector.size)
        assertEquals(0, uiStore.effectCollector.size)
        val screenState = uiStore.stateCollector.last().screenState
        assertTrue(screenState is CameraSecondScreenState)
        val cameraSecondScreenState = screenState as CameraSecondScreenState
        assertEquals(CameraSelector.DEFAULT_BACK_CAMERA, cameraSecondScreenState.cameraSelector)
    }

    @Test
    fun `test two take photo`() = runTest {
        setupReducer(CameraFirstScreenState(), UseCaseResult.Success(Unit))

        createAlifeReducer.onTakePhoto(ByteArray(0))

        createAlifeReducer.onTakePhoto(ByteArray(0))

        assertEquals(4, uiStore.stateCollector.size)
        assertEquals(1, uiStore.effectCollector.size)
        val screenState = uiStore.stateCollector.last().screenState
        assertTrue(screenState is LoadScreenState)
        assertTrue(uiStore.effectCollector.last() is CreateAlifeEffect.CreateAlifeFinish)
        val cameraSecondScreenState = uiStore.stateCollector[2].screenState as CameraScreenState
        assertEquals(CameraSelector.DEFAULT_BACK_CAMERA, cameraSecondScreenState.cameraSelector)
    }

    @Test
    fun `test one three photo`() = runTest {
        setupReducer(CameraFirstScreenState(), UseCaseResult.Success(Unit))

        createAlifeReducer.onTakePhoto(ByteArray(0))

        createAlifeReducer.onTakePhoto(ByteArray(0))

        createAlifeReducer.onTakePhoto(ByteArray(0))
        // return из-за того, что стоит LoadState

        assertEquals(4, uiStore.stateCollector.size)
        assertEquals(1, uiStore.effectCollector.size)
        assertTrue(uiStore.stateCollector.last().screenState is LoadScreenState)
        assertTrue(uiStore.effectCollector.last() is CreateAlifeEffect.CreateAlifeFinish)
        assertTrue(uiStore.effectCollector.last() is CreateAlifeEffect.CreateAlifeFinish)
        val cameraSecondScreenState = uiStore.stateCollector[2].screenState as CameraScreenState
        assertEquals(CameraSelector.DEFAULT_BACK_CAMERA, cameraSecondScreenState.cameraSelector)
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