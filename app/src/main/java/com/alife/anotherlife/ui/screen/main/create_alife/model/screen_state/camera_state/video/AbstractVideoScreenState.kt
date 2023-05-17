package com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.video

import androidx.camera.core.CameraSelector
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.with
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.icon.IconBase
import com.alife.anotherlife.core.composable.text.TextBase
import com.alife.anotherlife.core.composable.text.style.Title28Style
import com.alife.anotherlife.core.ui.permission.PermissionStatus
import com.alife.anotherlife.ui.screen.main.create_alife.CreateAlifeViewModel
import com.alife.anotherlife.ui.screen.main.create_alife.composable.CameraPreviewComposable
import com.alife.anotherlife.ui.screen.main.create_alife.model.audio.BaseAudioActionModel
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.BaseVideoCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.CameraScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.InvertibleScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeAction
import com.google.accompanist.permissions.ExperimentalPermissionsApi

interface BaseVideoScreenState : ScreenState

interface BaseInvertVideoScreenState : BaseVideoScreenState,
    InvertibleScreenState<BaseVideoScreenState>

abstract class AbstractVideoScreenState(
    cameraSelector: CameraSelector = CameraSelector.DEFAULT_FRONT_CAMERA,
) : CameraScreenState(cameraSelector), BaseInvertVideoScreenState {

    override fun cameraPermissionAction(status: PermissionStatus) =
        CreateAlifeAction.VideoPermission(status, this)


    abstract fun onVideoWrapper(
        captureWrapper: BaseVideoCaptureWrapper
    ): CreateAlifeAction.OnVideoWrapper

    @Composable
    override fun SafeContent(viewModel: CreateAlifeViewModel) {
        CameraPreviewComposable(
            viewModel.videoSetupFactory.create(cameraSelector),
            modifier = Modifier.fillMaxSize()
        ) { viewModel.reduce(CreateAlifeAction.OnVideoWrapper.Default(it)) }
    }

    @OptIn(ExperimentalAnimationApi::class, ExperimentalPermissionsApi::class)
    @Composable
    override fun TopRowContent(
        viewModel: CreateAlifeViewModel,
        modifier: Modifier
    ) {
        ConstraintLayout(modifier = modifier.fillMaxWidth()) {
            val (title, timer, audio) = createRefs()

            TextBase(
                textResId = R.string.horizontal_short_logo,
                style = Title28Style().style(),
                modifier = Modifier.constrainAs(title) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            )

            val state = viewModel.getUIState()

            AnimatedContent(
                targetState = state.timerUnit,
                transitionSpec = { EnterTransition.None.with(ExitTransition.None) },
                modifier = Modifier.constrainAs(timer) {
                    top.linkTo(title.bottom, 4.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            ) { timerUnit ->
                Text(
                    text = timerUnit.time(),
                    style = Title28Style().style(),
                    modifier = Modifier.animateEnterExit(
                        enter = scaleIn(),
                        exit = scaleOut()
                    )
                )
            }

            val audioPermission = viewModel.audioPermission.requirePermission(viewModel)

            key(audioPermission) {
                viewModel.reduce(
                    CreateAlifeAction.OnChangedAudio(
                        BaseAudioActionModel.PermissionStatus(audioPermission.status)
                    )
                )
            }

            Switch(
                checked = state.audioEnabledModel.isChecked(),
                onCheckedChange = { isChecked ->
                    audioPermission.launchPermissionRequest()

                    // TODO maybe change on Checked only
                    viewModel.reduce(
                        CreateAlifeAction.OnChangedAudio(
                            BaseAudioActionModel.Checked(isChecked)
                        )
                    )
                },
                thumbContent = {
                    IconBase(icon = R.drawable.ic_dialog_micro, Modifier.padding(6.dp))
                },
                colors = SwitchDefaults.colors(
                    uncheckedTrackColor = Color.Transparent,
                    checkedBorderColor = Color.Transparent,
                    disabledCheckedBorderColor = Color.Transparent,
                    disabledUncheckedBorderColor = Color.Transparent
                ),
                enabled = state.pagerContainer.video.canSwitchAudio(),
                modifier = Modifier
                    .padding(24.dp)
                    .constrainAs(audio) {
                        top.linkTo(parent.top)
                        start.linkTo(title.end)
                        end.linkTo(parent.end)
                        bottom.linkTo(title.bottom)
                    }
            )
        }
    }
}