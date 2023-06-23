package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.compose

import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.alife.anotherlife.core.composable.clickableNoRipple
import com.alife.anotherlife.core.composable.icon.MockProfileIcon
import com.alife.anotherlife.core.composable.image.ExtendImageBase
import com.alife.anotherlife.theme.Shapes

@Composable
fun PostCardCompose(
    profileName: String,
    timestamp: String,
    modifier: Modifier = Modifier,
    avatar: String? = null,
    onProfileClick: () -> Unit,
    mainContent: @Composable (Modifier) -> Unit
) {
    val profileCardModel = ProfileCardModel()

    ConstraintLayout(ProfileCardConstraints().markup(profileCardModel)) {
        val profileIconModifier = Modifier
            .layoutId(profileCardModel.profileIcon)
            .size(28.dp)
            .clip(CircleShape)
            .clickableNoRipple(onClick = onProfileClick)

        avatar?.apply {
            ExtendImageBase(
                model = avatar,
                contentScale = ContentScale.Crop,
                modifier = profileIconModifier
            )
        } ?: MockProfileIcon(profileIconModifier)

        Text(
            profileName,
            modifier = Modifier
                .layoutId(profileCardModel.username)
                .clickableNoRipple(onClick = onProfileClick)
        )
        Text(timestamp, modifier = Modifier.layoutId(profileCardModel.timestamp))

        mainContent(
            modifier
                .layoutId(profileCardModel.alife)
                .clip(Shapes.large)
                .heightIn(max = 500.dp)
                .fillMaxWidth()
        )
    }
}