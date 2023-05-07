package com.alife.anotherlife.ui.screen.main.create_alife.reducer_photo

import com.alife.anotherlife.core.FakeUIStore
import com.alife.anotherlife.ui.screen.main.create_alife.FakeImageProxy
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.CookedCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.ScreenPagerContainer
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.pager_item.Picture
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.pager_item.Video
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.photo.PicturePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.video.VideoPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture.LoadPictureScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.video.LoadVideoScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.photo.CreateAlifePhotoReducer
import com.alife.anotherlife.ui.screen.main.create_alife.reducer_base.FakeCreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.reducer_base.TestCreateAlifeReducerBase
import com.alife.anotherlife.ui.screen.main.create_alife.reducer_base.test_model.FakeCapturePictureScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.reducer_base.test_model.FakeCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.reducer_base.test_model.FakeExecutor
import com.alife.anotherlife.ui.screen.main.create_alife.reducer_base.test_model.FakeMainExecutor
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import java.lang.Exception

class TestCreateAlifePhotoReducer {

    private lateinit var uiStore: FakeUIStore<CreateAlifeState, CreateAlifeEffect>
    private lateinit var createAlifePhotoReducer: CreateAlifePhotoReducer

    @Before
    fun before() {
        setupReducer()
    }

    private fun setupReducer(
        exception: Exception? = null,
        captureWrapper: BaseCaptureWrapper = FakeCaptureWrapper.CookedWrapper()
    ) {
        uiStore = FakeUIStore(
            CreateAlifeState(
                captureWrapper = captureWrapper,
                pagerContainer = ScreenPagerContainer(
                    Picture(LoadPictureScreenState(), PicturePagerItem.InitTakePicture()),
                    Video(LoadVideoScreenState(), VideoPagerItem.InitSizable())
                ),
                settingsIntent = null
            )
        )

        createAlifePhotoReducer = CreateAlifePhotoReducer(
            uiStore,
            FakeCameraStateToSaveImage(),
            FakeImageProxyToByteArray(),
            FakeSaveAlifeUseCase(exception)
        )
    }

    @Test
    fun `onCreatePhoto normal create photo`() = runTest {
        createAlifePhotoReducer.onCreatePhoto(FakeCapturePictureScreenState(), FakeMainExecutor())

        val lastPagerItem = uiStore.stateCollector.last().currentContainerState().pagerItem
        val lastEffect = uiStore.effectCollector.last()

        val stateCount = 2
        val effectCount = 1
        assertEquals(stateCount, uiStore.stateCollector.size)
        assertEquals(effectCount, uiStore.effectCollector.size)
        assertTrue(lastPagerItem is PicturePagerItem.OnPictureTaking)
        assertTrue(lastEffect is FakeCreateAlifeEffect.Photo.CreatePhoto)
    }

    @Test
    fun `onCreatePhoto with UselessCaptureWrapper`() = runTest {
        setupReducer(IllegalStateException())
        createAlifePhotoReducer.onCreatePhoto(FakeCapturePictureScreenState(), FakeMainExecutor())

        val lastPagerItem = uiStore.stateCollector.last().currentContainerState().pagerItem
        val lastEffect = uiStore.effectCollector.last()

        val stateCount = 2
        val effectCount = 1
        assertEquals(stateCount, uiStore.stateCollector.size)
        assertEquals(effectCount, uiStore.effectCollector.size)
        assertTrue(lastPagerItem is PicturePagerItem.OnPictureTaking)
        assertTrue(lastEffect is CreateAlifeEffect.CreateAlifeFinish)
    }

    @Test
    fun `onCreatePhoto with exception in process`() = runTest {
        setupReducer(captureWrapper = FakeCaptureWrapper.UselessWrapper())
        createAlifePhotoReducer.onCreatePhoto(FakeCapturePictureScreenState(), FakeMainExecutor())

        val lastPagerItem = uiStore.stateCollector.last().currentContainerState().pagerItem
        val lastEffect = uiStore.effectCollector.last()

        val stateCount = 2
        val effectCount = 1
        assertEquals(stateCount, uiStore.stateCollector.size)
        assertEquals(effectCount, uiStore.effectCollector.size)
        assertTrue(lastPagerItem is PicturePagerItem.OnPictureTaking)
        assertTrue(lastEffect is CreateAlifeEffect.CreateAlifeFinish)
    }
}