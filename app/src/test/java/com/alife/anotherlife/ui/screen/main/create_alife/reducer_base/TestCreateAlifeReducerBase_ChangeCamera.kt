package com.alife.anotherlife.ui.screen.main.create_alife.reducer_base

import com.alife.anotherlife.core.FakeUIStore
import com.alife.anotherlife.ui.screen.main.create_alife.CreateAlifeReducerBase
import com.alife.anotherlife.ui.screen.main.create_alife.model.FakePictureScreenPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.FakeVideoScreenPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.ScreenPagerContainer
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.ScreenPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.ErrorCameraScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture.LoadPictureScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.video.LoadVideoScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.reducer_base.test_model.FakeCapturePictureScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.reducer_base.test_model.FakeCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.reducer_base.test_model.FakeExecutor
import com.alife.anotherlife.ui.screen.main.create_alife.reducer_base.test_model.FakeMainExecutor
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotSame
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import java.util.concurrent.Executor

class TestCreateAlifeReducerBase {

    private lateinit var copyListPicture: MutableList<ScreenPagerItem.Picture>
    private lateinit var copyListVideo: MutableList<ScreenPagerItem.Video>

    private lateinit var uiStore: FakeUIStore<CreateAlifeState, CreateAlifeEffect>
    private lateinit var createAlifeReducerBase: CreateAlifeReducerBase

    @Before
    fun before() {
        copyListPicture = mutableListOf()
        copyListVideo = mutableListOf()

        uiStore = FakeUIStore(
            CreateAlifeState(
                pagerContainer = ScreenPagerContainer(
                    FakePictureScreenPagerItem(copyListPicture),
                    FakeVideoScreenPagerItem(copyListVideo)
                ),
                settingsIntent = null
            )
        )

        createAlifeReducerBase = CreateAlifeReducerBase(
            uiStore,
            FakeCreateAlifePhotoReducer(uiStore),
            FakeCreateAlifeVideoReducer(uiStore)
        )
    }

    private fun setupUIStore(
        pictureScreenState: ScreenState = LoadPictureScreenState(),
        videoScreenState: ScreenState = LoadVideoScreenState()
    ) {
        uiStore = FakeUIStore(
            CreateAlifeState(
                pagerContainer = ScreenPagerContainer(
                    FakePictureScreenPagerItem(copyListPicture, pictureScreenState),
                    FakeVideoScreenPagerItem(copyListVideo, videoScreenState)
                ),
                settingsIntent = null
            )
        )
        createAlifeReducerBase = CreateAlifeReducerBase(
            uiStore,
            FakeCreateAlifePhotoReducer(uiStore),
            FakeCreateAlifeVideoReducer(uiStore)
        )
    }

    @Test
    @OptIn(ExperimentalCoroutinesApi::class)
    fun `change camera`() = runTest {
        createAlifeReducerBase.onChangeCamera()

        val expectedSize = 1
        assertEquals(expectedSize, copyListPicture.size)
    }

    @Test
    @OptIn(ExperimentalCoroutinesApi::class)
    fun `onCameraWrapper with empty wrapper `() = runTest {
        val testCaptureWrapper = FakeCaptureWrapper.EmptyWrapper()

        createAlifeReducerBase.onCameraWrapper(testCaptureWrapper)

        val expectedSize = 0
        assertEquals(expectedSize, copyListPicture.size)
        assertEquals(expectedSize, copyListVideo.size)

        val expectedStatesCount = 2
        assertEquals(expectedStatesCount, uiStore.stateCollector.size)
        assertTrue(uiStore.stateCollector.last().blockingScreen is ErrorCameraScreenState)
        assertNotSame(testCaptureWrapper, uiStore.stateCollector.last().captureWrapper)
    }

    @Test
    @OptIn(ExperimentalCoroutinesApi::class)
    fun `onCameraWrapper with CookedCaptureWrapper`() = runTest {
        val testCaptureWrapper = FakeCaptureWrapper.CookedWrapper()

        createAlifeReducerBase.onCameraWrapper(testCaptureWrapper)

        val expectedPictureSize = 1
        val expectedVideoSize = 0
        assertEquals(expectedPictureSize, copyListPicture.size)
        assertEquals(expectedVideoSize, copyListVideo.size)

        val expectedStatesCount = 2
        assertEquals(expectedStatesCount, uiStore.stateCollector.size)
        assertEquals(testCaptureWrapper, uiStore.stateCollector.last().captureWrapper)
    }

    @Test
    @OptIn(ExperimentalCoroutinesApi::class)
    fun `onCameraWrapper with UselessCaptureWrapper`() = runTest {
        val testCaptureWrapper = FakeCaptureWrapper.UselessWrapper()

        createAlifeReducerBase.onCameraWrapper(testCaptureWrapper)

        val expectedSize = 0
        assertEquals(expectedSize, copyListPicture.size)
        assertEquals(expectedSize, copyListVideo.size)

        val expectedStatesCount = 2
        assertEquals(expectedStatesCount, uiStore.stateCollector.size)
        assertTrue(uiStore.stateCollector.last().blockingScreen is ErrorCameraScreenState)
        assertNotSame(testCaptureWrapper, uiStore.stateCollector.last().captureWrapper)
    }

    @Test
    @OptIn(ExperimentalCoroutinesApi::class)
    fun `test onCreatePhoto`() = runTest {
        val testListData = listOf(
            CaptureTestModel(LoadPictureScreenState()),
            CaptureTestModel(LoadPictureScreenState()),
            CaptureTestModel(FakeCapturePictureScreenState()),
            CaptureTestModel(
                screenState = FakeCapturePictureScreenState(),
                expectedEffect = FakeCreateAlifeEffect.Photo.CreatePhoto(),
                expectedEffectSize = 1
            ),
        )

        testListData.forEach { captureTestModel ->
            setupUIStore(pictureScreenState = captureTestModel.screenState)
            val initState = uiStore.stateCollector.first()

            createAlifeReducerBase.onCreatePhoto(FakeMainExecutor())

            captureTestModel.assert(initState, uiStore, copyListPicture, copyListVideo)
        }
    }


    // Test Realization
    class CaptureTestModel(
        val screenState: ScreenState,
        private val expectedEffect: CreateAlifeEffect? = null,
        private val expectedStateSize: Int = 1,
        private val expectedEffectSize: Int = 0,
        private val expectedPictureVideoListSize: Int = 0,
    ) {
        fun assert(
            expectedState: CreateAlifeState,
            uiStore: FakeUIStore<CreateAlifeState, CreateAlifeEffect>,
            copyListPicture: MutableList<ScreenPagerItem.Picture>,
            copyListVideo: MutableList<ScreenPagerItem.Video>
        ) {
            assertEquals(expectedPictureVideoListSize, copyListPicture.size)
            assertEquals(expectedPictureVideoListSize, copyListVideo.size)
            assertEquals(expectedStateSize, uiStore.stateCollector.size)
            assertEquals(expectedState, uiStore.stateCollector.last())
            assertEquals(expectedEffectSize, uiStore.effectCollector.size)
            assertEquals(expectedEffect, uiStore.effectCollector.lastOrNull())
        }
    }
}