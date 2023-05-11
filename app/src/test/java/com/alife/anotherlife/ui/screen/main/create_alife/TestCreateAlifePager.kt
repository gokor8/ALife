//package com.alife.anotherlife.ui.screen.main.create_alife
//
//import com.alife.anotherlife.core.FakeUIStore
//import com.alife.anotherlife.ui.screen.main.create_alife.addons.BaseContextMainExecutorWrapper
//import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.photo.PicturePagerItem
//import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.FirstScreenState
//import com.alife.anotherlife.ui.screen.main.create_alife.reducer.photo.BaseCreateAlifePhotoReducer
//import com.alife.anotherlife.ui.screen.main.create_alife.reducer.photo.CreateAlifePhotoReducer
//import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
//import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState
//import org.junit.Test
//
//class TestCreateAlifePager {
//
////    lateinit var createAlifeReducer: CreateAlifeReducerBase
////    lateinit var uiStore: FakeUIStore<CreateAlifeState, CreateAlifeEffect>
////
////    private fun setupReducer(screenState: ScreenState) {
////        uiStore = FakeUIStore(CreateAlifeState(screenState = screenState, settingsIntent = null))
////
////        createAlifeReducer = CreateAlifeReducerBase(
////            uiStore,
////            CameraStateToSaveImage(),
////            TestCreateAlifeReducerOnTakePhoto.FakeImageProxySelectMapper(),
////            TestCreateAlifeReducerOnTakePhoto.FakeSaveAlifeUseCase()
////        )
////    }
//
//    @Test
//    fun `change pager state with saving screen state`() {
//         val reducer = CreateAlifePhotoReducer
//
//        reducer.changePager()
//
//        val actual = uiStore.getState().pager.getCameraItem().screenState is FirstScreenState
//    }
//
//    @Test
//    fun `change screen state with saving pager`() {
//        val reducer = CreateAlifePhotoReducer
//
//        reducer.changeCameraState()
//
//        val actual = uiStore.getState().pager.getCameraItem() is PicturePagerItem.TakePicture
//    }
//
//    @Test
//    fun `change pager and screen state`() {
//        val reducer = CreateAlifePhotoReducer
//
//        reducer.changeCameraState()
//        reducer.changePager()
//
//        val actual = uiStore.getState().pager.getCameraItem() is PicturePagerItem.TakePicture
//        val actual = uiStore.getState().pager.getCameraItem().screenState is FirstScreenState
//    }
//
//
//    // Test Realization
//    class FakeCreateAlifePhotoReducer(
//        private val uiStore: FakeUIStore<CreateAlifeState, CreateAlifeEffect>
//    ) : BaseCreateAlifePhotoReducer {
//        override suspend fun onCreatePhoto(contextWrapper: BaseContextMainExecutorWrapper) {
//            uiStore.setState { copy() }
//        }
//
//        override suspend fun onPermissionGranted() {}
//
//        override suspend fun onPermissionFatal() {}
//    }
//}