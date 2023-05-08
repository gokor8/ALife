//package com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.mapper
//
//import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.InvertiblePagerItem
//import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.ScreenPagerItem
//import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.pager_item.Picture
//import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.pager_item.Video
//import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.video.RecordingPagerItem
//import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture.BaseInvertPictureScreenState
//import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture.BasePictureScreenState
//import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.video.BaseInvertVideoScreenState
//import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.video.SwitchedVideoScreenState
//
//interface ScreenPagerMapper<P : ScreenPagerItem<*, *>> {
//
//    fun map(screenPagerItem: P): P
//
//
//    abstract class Abstract<P : ScreenPagerItem<*, *>> : ScreenPagerMapper<P> {
//
//        override fun map(screenPagerItem: P): P {
//            return if (screenPagerItem.canInvert())
//                screenPagerItem
//            else
//                onFitMap(screenPagerItem)
//        }
//
//        protected abstract fun onFitMap(screenPagerItem: P): P
//    }
//
//    class Picture : Abstract<ScreenPagerItem.Picture>() {
//        override fun onFitMap(screenPagerItem: ScreenPagerItem.Picture): ScreenPagerItem.Picture {
//            val screenState = screenPagerItem.screenState
//            val pagerItem = screenPagerItem.pagerItem
//
//            return if (screenState is BaseInvertPictureScreenState && pagerItem is InvertiblePagerItem) {
//                Picture(screenState.copyInvertCamera(), pagerItem)
//            } else {
//                screenPagerItem
//            }
//        }
//    }
//
//    class Video : Abstract<ScreenPagerItem.Video>() {
//        override fun map(screenPagerItem: ScreenPagerItem.Video): ScreenPagerItem.Video {
//            if (screenPagerItem.canInvert()) return screenPagerItem
//
//            val video = if (screenPagerItem.pagerItem is RecordingPagerItem
//                && screenPagerItem.screenState is BaseInvertVideoScreenState
//            )
//                Video(
//                    SwitchedVideoScreenState(screenState.invertCamera()),
//                    screenPagerItem.pagerItem
//                )
//            else Video(screenState.copyInvertCamera(), pagerItem)
//
//            return container.copy(video = video)
//        }
//
//        override fun onFitMap(screenPagerItem: ScreenPagerItem.Video): ScreenPagerItem.Video {
//            val video = if (screenPagerItem.pagerItem is RecordingPagerItem
//                && screenPagerItem.screenState is BaseInvertVideoScreenState
//            )
//                Video(
//                    SwitchedVideoScreenState(screenState.invertCamera()),
//                    screenPagerItem.pagerItem
//                )
//            else Video(screenState.copyInvertCamera(), pagerItem)
//
//            return container.copy(video = video)
//        }
//    }
//}