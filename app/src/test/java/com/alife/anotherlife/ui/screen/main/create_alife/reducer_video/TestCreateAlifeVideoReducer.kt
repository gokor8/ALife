//package com.alife.anotherlife.ui.screen.main.create_alife.reducer_video
//
//import android.content.Context
//import androidx.camera.video.VideoRecordEvent
//import androidx.core.util.Consumer
//import com.alife.anotherlife.core.FakeUIStore
//import com.alife.anotherlife.ui.screen.main.create_alife.addons.BaseContextMainExecutorWrapper
//import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.callback.CallbackVideoEvent
//import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.BaseVideoCaptureWrapper
//import com.alife.anotherlife.ui.screen.main.create_alife.reducer.video.mapper.BaseVideoCaptureWrapperToState
//import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.BaseStartVideoCaptureState
//import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.recording.RecordingWrapper
//import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.options.BaseFileOutputOptions
//import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.options.BaseVideoCaptureBuilder
//import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.photo.PicturePagerItem
//import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.video.VideoPagerItem
//import com.alife.anotherlife.ui.screen.main.create_alife.reducer.video.BaseCreateAlifeVideoReducer
//import com.alife.anotherlife.ui.screen.main.create_alife.reducer.video.CreateAlifeVideoReducer
//import com.alife.anotherlife.ui.screen.main.create_alife.reducer_base.test_model.FakeExecutor
//import com.alife.anotherlife.ui.screen.main.create_alife.reducer_base.test_model.FakeMainExecutor
//import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
//import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState
//import junit.framework.TestCase.assertEquals
//import junit.framework.TestCase.assertTrue
//import kotlinx.coroutines.test.runTest
//import org.junit.Before
//import org.junit.Test
//import java.io.IOException
//import java.lang.Exception
//
//class TestCreateAlifeVideoReducer {
//
//    private lateinit var uiStore: FakeUIStore<CreateAlifeState, CreateAlifeEffect>
//    private lateinit var createAlifeVideoReducer: CreateAlifeVideoReducer
//
//    @Before
//    fun before() {
//        createAlifeVideoReducer = CreateAlifeVideoReducer(
//            uiStore,
//            FakeVideoCaptureToState(),
//            FakeVideoStorageAlifeUseCase(),
//            FakeVideoStorageToOptions(),
//            FakeVideoCaptureBuildFactory()
//        )
//    }
//
//    @Test
//    fun `onStart return video pager state`() = runTest {
//        createAlifeVideoReducer.onStart(FakeMainExecutor(), FakeVideoCaptureState())
//
//        val actual = uiStore.stateCollector.last().pagerContainer
//
//        val expectedStateSize = 2
//        val expectedEffectSize = 0
//        assertEquals(expectedStateSize, uiStore.stateCollector.size)
//        assertEquals(expectedEffectSize, uiStore.effectCollector.size)
//        assertTrue(actual.video.pagerItem is VideoPagerItem.InitSizable)
//        assertTrue(actual.picture.pagerItem is PicturePagerItem.InitTakePicture)
//    }
//
//    @Test
//    fun `onStart throw Exception return blockingScreen?`() = runTest {
//        createAlifeVideoReducer.onStart(
//            FakeMainExecutor(),
//            FakeVideoCaptureState(IOException())
//        )
//
//        val actual = uiStore.stateCollector.last().pagerContainer
//
//        val expectedStateSize = 2
//        val expectedEffectSize = 0
//        assertEquals(expectedStateSize, uiStore.stateCollector.size)
//        assertEquals(expectedEffectSize, uiStore.effectCollector.size)
//        assertTrue(actual.video.pagerItem is VideoPagerItem.InitSizable)
//        assertTrue(actual.picture.pagerItem is PicturePagerItem.InitTakePicture)
//    }
//
//    // Fake Realization
//    class FakeVideoCaptureState(
//        private val exception: Exception? = null
//    ) : BaseStartVideoCaptureState {
//        override fun start(
//            contextWrapper: BaseContextMainExecutorWrapper,
//            videoCaptureBuilder: BaseVideoCaptureBuilder,
//            fileOutputOptions: BaseFileOutputOptions
//        ) = exception?.let { throw exception} ?: FakeRecordingWrapper()
//    }
//
//    class FakeRecordingWrapper : RecordingWrapper {
//        override fun resume() {}
//        override fun pause() {}
//        override fun stop() {}
//    }
//
//    class FakeVideoCaptureToState : BaseVideoCaptureWrapperToState {
//        override fun map(
//            reducer: BaseCreateAlifeVideoReducer,
//            callbackVideoEvent: Consumer<VideoRecordEvent>,
//            captureWrapper: BaseVideoCaptureWrapper
//        ) {}
//    }
//}