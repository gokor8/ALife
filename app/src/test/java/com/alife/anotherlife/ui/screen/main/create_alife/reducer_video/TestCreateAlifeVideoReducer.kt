package com.alife.anotherlife.ui.screen.main.create_alife.reducer_video

import android.content.Context
import com.alife.anotherlife.core.FakeUIStore
import com.alife.anotherlife.ui.screen.main.create_alife.addons.BaseContextMainExecutorWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.callback.CallbackVideoEvent
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.BaseVideoCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.mapper.BaseVideoCaptureWrapperToState
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.BaseStartVideoCaptureState
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.BaseVideoCaptureState
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.recording.RecordingWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.photo.PicturePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.video.VideoPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.video.CreateAlifeVideoReducer
import com.alife.anotherlife.ui.screen.main.create_alife.reducer_base.test_model.FakeExecutor
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.test.runTest
import java.util.concurrent.Executor

class TestCreateAlifeVideoReducer {

    private lateinit var uiStore: FakeUIStore<CreateAlifeState, CreateAlifeEffect>
    private lateinit var createAlifeVideoReducer: CreateAlifeVideoReducer

    private fun setupReducer() {
        createAlifeVideoReducer = CreateAlifeVideoReducer(uiStore, FakeVideoCaptureToState())
    }


    fun `onStart changed pager state`() = runTest {
        createAlifeVideoReducer.onStart(FakeMainExecutorWrapper(), FakeVideoCaptureState())

        val actual = uiStore.stateCollector.last().pagerContainer

        val expectedStateSize = 2
        val expectedEffectSize = 0
        assertEquals(expectedStateSize, uiStore.stateCollector.size)
        assertEquals(expectedEffectSize, uiStore.effectCollector.size)
        assertTrue(actual.video.pagerItem is VideoPagerItem.OnRecording)
        assertTrue(actual.picture.pagerItem is PicturePagerItem.InitTakePicture)
    }


    // Fake Realization
    class FakeMainExecutorWrapper : BaseContextMainExecutorWrapper {
        override fun getMainExecutor() = FakeExecutor()

        override fun getContext(): Context {
            TODO("Not yet implemented")
        }
    }

    class FakeVideoCaptureState : BaseStartVideoCaptureState {
        override fun start(contextWrapper: BaseContextMainExecutorWrapper) = FakeRecordingWrapper()
    }

    class FakeRecordingWrapper : RecordingWrapper {
        override fun resume() {}
        override fun pause() {}
        override fun stop() {}
    }

    class FakeVideoCaptureToState : BaseVideoCaptureWrapperToState {
        override fun map(
            reducer: CreateAlifeVideoReducer,
            callbackVideoEvent: CallbackVideoEvent,
            captureWrapper: BaseVideoCaptureWrapper
        ) {}
    }
}