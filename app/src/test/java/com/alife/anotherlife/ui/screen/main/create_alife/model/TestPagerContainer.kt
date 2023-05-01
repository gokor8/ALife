//package com.alife.anotherlife.ui.screen.main.create_alife.model
//
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.unit.Dp
//import com.alife.anotherlife.ui.screen.main.create_alife.CreateAlifeViewModel
//import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper
//import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.PagerContainer
//import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.pagerContainerOf
//import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.photo.PicturePagerItem
//import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.video.VideoPagerItem
//import org.junit.Before
//import org.junit.Test
//
//class TestPagerContainer {
//
//    lateinit var pagerContainer: PagerContainer
//
//    @Before
//    fun before() {
//        pagerContainer = pagerContainerOf(FakePicturePagerItem(), FakeVideoPagerItem())
//    }
//
//    @Test
//    fun
//
//
//    // Fake Realization
//    class FakePicturePagerItem : PicturePagerItem {
//        @Composable
//        override fun Content(
//            size: Dp,
//            captureWrapper: BaseCaptureWrapper,
//            viewModel: CreateAlifeViewModel
//        ) {}
//    }
//
//    class FakeVideoPagerItem : VideoPagerItem {
//        @Composable
//        override fun Content(
//            size: Dp,
//            captureWrapper: BaseCaptureWrapper,
//            viewModel: CreateAlifeViewModel
//        ) {}
//    }
//}