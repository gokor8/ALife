package com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.usual

import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.addons.copyToClipboard
import com.alife.anotherlife.core.composable.brush.verticalBottomToTopGradient
import com.alife.anotherlife.core.composable.brush.verticalTopToBottomGradient
import com.alife.anotherlife.core.composable.clickableNoRipple
import com.alife.anotherlife.core.composable.clickableNoRipple
import com.alife.anotherlife.core.composable.icon.IconBase
import com.alife.anotherlife.core.composable.image.ImageBase
import com.alife.anotherlife.core.composable.text.style.style16
import com.alife.anotherlife.core.composable.text.style.style36Bold
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.usual.state.ProfileUsualAction
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.usual.state.ProfileUsualState
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.model.ContentFillState
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.model.ProfileConstraintModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.model.ProfileUIDataModel
import kotlinx.coroutines.delay

class ProfileUsualFillState(
    private val profileUIDataModel: ProfileUIDataModel
) : ContentFillState {

    @Composable
    override fun ContentFill(constraints: ProfileConstraintModel) {
        val context = LocalContext.current
        val viewModel: ProfileUsualViewModel = hiltViewModel()
        val state: ProfileUsualState = viewModel.getUIState()

        LaunchedEffect(Unit) {
            viewModel.reduce(ProfileUsualAction.OnInit(profileUIDataModel))
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .layoutId(constraints.topBar)
                .background(verticalTopToBottomGradient())
                .zIndex(1f)
                .systemBarsPadding()
                .padding(bottom = 14.dp)
                .padding(horizontal = 16.dp)
        ) {
            Text(
                state.username,
                style = style16(),
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickableNoRipple {
                        copyToClipboard(context, state.username)
                    }
            )
        }

        ImageBase(
            R.drawable.img_tutor_back,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .layoutId(constraints.image)
                .fillMaxWidth()
                .aspectRatio(360 / 395f)
        )

        Row(
            modifier = Modifier
                .layoutId(constraints.preBottom)
                .zIndex(1f)
                .background(verticalBottomToTopGradient())
                .padding(horizontal = 14.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(state.name, style = style36Bold())

            val durationAnim = 500
            val rotationCircle = 360f

            var rotation by remember { mutableStateOf(0f) }
            val animatedRotation = animateFloatAsState(
                targetValue = rotation,
                animationSpec = TweenSpec(durationMillis = durationAnim),
                label = "animatedRotation"
            )

            IconBase(
                R.drawable.ic_settings,
                tint = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier
                    .rotate(animatedRotation.value)
                    .clickableNoRipple(rememberCoroutineScope()) {
                        rotation += rotationCircle
                        delay(durationAnim.toLong())
                        viewModel.reduce(ProfileUsualAction.StartChanging())
                    }
            )
        }

        Column(
            modifier = Modifier
                .layoutId(constraints.bottom)
                .background(MaterialTheme.colorScheme.background)
                .padding(start = 14.dp)
        ) {
            Text(state.country, style = style16())
            Spacer(modifier = Modifier.padding(8.dp))
            Text(state.description, style = style16())
        }
    }
}