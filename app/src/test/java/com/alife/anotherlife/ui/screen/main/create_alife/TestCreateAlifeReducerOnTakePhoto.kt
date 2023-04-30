package com.alife.anotherlife.ui.screen.main.create_alife

import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageProxy
import com.alife.anotherlife.core.FakeUIStore
import com.alife.anotherlife.ui.screen.main.create_alife.addons.BaseContextMainExecutorWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.mapper.CameraStateToSaveImage
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.EmptyCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.photo.PicturePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.LoadScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.ScreenFirstScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.CameraScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.CameraSecondScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState
import com.alife.core.mapper.Mapper
import com.alife.domain.main.create_alife.BaseSaveAlifeUseCase
import com.alife.domain.main.create_alife.entity.SaveImageEntity
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.test.runTest
import org.junit.Test
import java.io.IOException
import java.lang.Exception
import java.util.concurrent.Executor

class TestCreateAlifeReducerOnTakePhoto {

    lateinit var createAlifeReducer: CreateAlifeReducer
    lateinit var uiStore: FakeUIStore<CreateAlifeState, CreateAlifeEffect>

    private fun setupReducer(
        screenState: ScreenState,
        useCaseException: Exception? = null,
        captureWrapper: BaseCaptureWrapper = FakeCaptureWrapper()
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
            FakeImageProxySelectMapper(),
            FakeSaveAlifeUseCase(useCaseException)
        )
    }

    @Test
    fun `photo without CameraScreenState`() = runTest {
        setupReducer(LoadScreenState())

        createAlifeReducer.onCreatePhoto(FakeContext())

        assertEquals(1, uiStore.stateCollector.size)
        assertEquals(0, uiStore.effectCollector.size)
        val lastState = uiStore.stateCollector.last()
        assertTrue(lastState.screenState is LoadScreenState)
        assertTrue(lastState.pagerItems.first() is PicturePagerItem.TakePicture)
    }

    @Test
    fun `photo with CameraScreenState without Executor`() = runTest {
        setupReducer(ScreenFirstScreenState())

        createAlifeReducer.onCreatePhoto(FakeContext(null))

        assertEquals(1, uiStore.stateCollector.size)
        assertEquals(0, uiStore.effectCollector.size)
        val lastState = uiStore.stateCollector.last()
        assertTrue(lastState.screenState is ScreenFirstScreenState)
        assertTrue(lastState.pagerItems.first() is PicturePagerItem.TakePicture)
    }

    // TODO throw cusom exc from EmptyCaptureWrapper
    // TODO and handle in reducer
    @Test(expected = Throwable::class)
    fun `photo with CameraScreenState with EmptyCaptureWrapper`() = runTest {
        setupReducer(ScreenFirstScreenState(), captureWrapper = EmptyCaptureWrapper())

        createAlifeReducer.onCreatePhoto(FakeContext())
    }

    @Test
    fun `photo with ExceptionCaptureWrapper CameraScreenState`() = runTest {
        setupReducer(ScreenFirstScreenState(), captureWrapper = FakeCaptureWrapper(IOException()))

        createAlifeReducer.onCreatePhoto(FakeContext())

        val secondState = uiStore.stateCollector[1].pagerItems.getCameraItem()
        val thirdState = uiStore.stateCollector[2].pagerItems.getCameraItem()

        assertEquals(3, uiStore.stateCollector.size)
        assertTrue(secondState is PicturePagerItem.OnPictureTaking)
        assertTrue(thirdState is PicturePagerItem.TakePicture)
        assertEquals(1, uiStore.effectCollector.size)
        assertTrue(uiStore.effectCollector.last() is CreateAlifeEffect.CreateAlifeFinish)
    }

    @Test
    fun `photo with CameraScreenState saveImage throw Exception`() = runTest {
        setupReducer(ScreenFirstScreenState(), IOException(), FakeCaptureWrapper())

        createAlifeReducer.onCreatePhoto(FakeContext())

        val secondState = uiStore.stateCollector[1].pagerItems.getCameraItem()
        val thirdState = uiStore.stateCollector[2].pagerItems.getCameraItem()

        assertEquals(3, uiStore.stateCollector.size)
        assertTrue(secondState is PicturePagerItem.OnPictureTaking)
        assertTrue(thirdState is PicturePagerItem.TakePicture)
        assertEquals(1, uiStore.effectCollector.size)
        assertTrue(uiStore.effectCollector.last() is CreateAlifeEffect.CreateAlifeFinish)
    }

    @Test
    fun `test one take photo`() = runTest {
        setupReducer(ScreenFirstScreenState())

        createAlifeReducer.onCreatePhoto(FakeContext())

        assertEquals(3, uiStore.stateCollector.size)
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
        setupReducer(ScreenFirstScreenState())

        createAlifeReducer.onCreatePhoto(FakeContext())

        createAlifeReducer.onCreatePhoto(FakeContext())

        assertEquals(4, uiStore.stateCollector.size)
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
        setupReducer(ScreenFirstScreenState())

        createAlifeReducer.onCreatePhoto(FakeContext())

        createAlifeReducer.onCreatePhoto(FakeContext())

        createAlifeReducer.onCreatePhoto(FakeContext())
        // return из-за того, что стоит LoadState

        assertEquals(5, uiStore.stateCollector.size)
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
    class FakeImageProxySelectMapper : Mapper<ImageProxy, ByteArray> {
        override fun map(inputModel: ImageProxy) = ByteArray(0)
    }

    class FakeContext(
        private val executor: Executor? = Executor { }
    ) : BaseContextMainExecutorWrapper {
        override fun getMainExecutor(): Executor? = executor
    }

    class FakeSaveAlifeUseCase(private val exception: Exception? = null) : BaseSaveAlifeUseCase {

        override suspend fun saveImage(saveImageEntity: SaveImageEntity) {
            exception?.let { throw exception }
        }
    }
}