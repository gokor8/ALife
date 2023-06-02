package com.alife.anotherlife.ui.screen.main.navigation_bar.home.post_profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.addons.copyToClipboard
import com.alife.anotherlife.core.composable.brush.verticalBottomToTopGradient
import com.alife.anotherlife.core.composable.brush.verticalTopToBottomGradient
import com.alife.anotherlife.core.composable.clickableNoRipple
import com.alife.anotherlife.core.composable.icon.IconBase
import com.alife.anotherlife.core.composable.image.ImageBase
import com.alife.anotherlife.core.composable.text.style.style16
import com.alife.anotherlife.core.composable.text.style.style16Bold
import com.alife.anotherlife.core.composable.text.style.style36Bold
import com.alife.anotherlife.core.ui.screen.VMScreenLCE
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.post_profile.state.PostAction
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.model.ProfileConstraintModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.model.ProfileConstraints

class PostProfileScreen(
    override val navController: NavController,
    private val username: String
) : VMScreenLCE<PostProfileViewModel>() {

    @Composable
    override fun setupViewModel(): PostProfileViewModel = hiltViewModel()

    override suspend fun onInit() {
        viewModel.reduce(PostAction.OnInit(username))
    }

    @Composable
    override fun SafeContent(modifier: Modifier) {
        val context = LocalContext.current

        val constraints = ProfileConstraintModel()
        val state = viewModel.getUIState()

        val onBackgroundColor = MaterialTheme.colorScheme.onBackground

        ConstraintLayout(
            ProfileConstraints().markup(constraints),
            modifier = modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .layoutId(constraints.topBar)
                    .zIndex(1f)
                    .background(verticalTopToBottomGradient())
                    .systemBarsPadding()
                    .padding(vertical = 14.dp)
            ) {
                ImageBase(
                    resId = R.drawable.ic_base_back,
                    colorFilter = ColorFilter.tint(onBackgroundColor),
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .clickableNoRipple {
                            navController.popBackStack()
                        }
                )
                Text(
                    state.username,
                    style = style16Bold(),
                    modifier = Modifier.clickableNoRipple {
                        copyToClipboard(context, state.username)
                    }
                )
            }

            ImageBase(
                com.alife.data.R.drawable.img_voin,
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
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(state.name, style = style36Bold())
                IconBase(R.drawable.ic_profile_addons, tint = onBackgroundColor)
            }

            Column(
                modifier = Modifier
                    .layoutId(constraints.bottom)
                    .background(MaterialTheme.colorScheme.background)
                    .padding(start = 16.dp)
            ) {
                Text(state.country, style = style16())
            }
        }
    }
}