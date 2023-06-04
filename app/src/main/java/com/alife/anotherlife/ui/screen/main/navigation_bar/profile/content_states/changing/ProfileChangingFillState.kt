package com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.changing

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.brush.verticalBottomToTopGradient
import com.alife.anotherlife.core.composable.brush.verticalTopToBottomGradient
import com.alife.anotherlife.core.composable.clickableNoRipple
import com.alife.anotherlife.core.composable.icon.IconBase
import com.alife.anotherlife.core.composable.image.ImageBase
import com.alife.anotherlife.core.composable.text.style.style16
import com.alife.anotherlife.core.composable.text.style.style36Bold
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.ProfileViewModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.changing.state.ProfileChangingAction
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.changing.state.ProfileChangingState
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.model.ContentFillState
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.model.ProfileConstraintModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.model.ProfileUIDataModel

class ProfileChangingFillState(
    private val profileUIDataModel: ProfileUIDataModel
) : ContentFillState {

    private val imageExtension = "image/*"

    @Composable
    override fun ContentFill(constraints: ProfileConstraintModel) {
        val viewModel: ProfileChangingViewModel = hiltViewModel()
        val state: ProfileChangingState = viewModel.getUIState()

        LaunchedEffect(Unit) {
            viewModel.reduce(ProfileChangingAction.OnInit(profileUIDataModel))
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .layoutId(constraints.topBar)
                .background(verticalTopToBottomGradient())
                .zIndex(2f)
                .systemBarsPadding()
                .padding(bottom = 14.dp)
                .padding(horizontal = 16.dp)
        ) {
            BasicTextField(
                state.username,
                textStyle = style16(),
                singleLine = true,
                onValueChange = { newUsername ->
                    viewModel.reduce(ProfileChangingAction.OnUsername(newUsername))
                },
                modifier = Modifier.fillMaxWidth()
            )
        }

        val pickImage = rememberLauncherForActivityResult(
            ActivityResultContracts.GetContent()
        ) { fileUriState ->
            fileUriState?.apply {
                viewModel.reduce(ProfileChangingAction.OnPhoto(fileUriState))
            }
        }

        ImageBase(
            R.drawable.img_tutor_back,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .layoutId(constraints.image)
                .zIndex(1f)
                .fillMaxWidth()
                .aspectRatio(360 / 395f)
                .clickableNoRipple {
                    pickImage.launch(imageExtension)
                }
        )

        Row(
            modifier = Modifier
                .layoutId(constraints.preBottom)
                .zIndex(2f)
                .background(verticalBottomToTopGradient())
                .padding(horizontal = 14.dp),
            //horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BasicTextField(
                value = state.name,
                textStyle = style36Bold(),
                singleLine = true,
                onValueChange = { name ->
                    viewModel.reduce(ProfileChangingAction.OnName(name))
                }
            )
            ImageBase(
                resId = R.drawable.ic_close,
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground),
                modifier = Modifier.zIndex(2f)
            )
            Spacer(modifier = Modifier.padding(start = 24.dp))
            ImageBase(
                resId = R.drawable.ic_task_list,
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground),
            )
        }

        Column(
            modifier = Modifier
                .layoutId(constraints.bottom)
                .background(MaterialTheme.colorScheme.background)
                .padding(start = 14.dp)
        ) {
            Text("Russia", maxLines = 1, style = style16())
        }
    }
}