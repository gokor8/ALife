package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.alife_card.ALifeCardCompose
import com.alife.anotherlife.core.composable.alife_card.start_strategy.DefaultStrategy
import com.alife.anotherlife.core.composable.icon.MockProfileIcon

@Composable
fun ProfileCardCompose(
    profileName: String,
    timestamp: String,
    avatar: String? = null,
) {
    val profileCardModel = ProfileCardModel()

    ConstraintLayout(ProfileCardConstraints().markup(profileCardModel)) {
        val profileIconModifier = Modifier
            .layoutId(profileCardModel.profileIcon)
            .size(28.dp)
            .clip(CircleShape)

        avatar?.apply {
            AsyncImage(
                model = avatar,
                contentDescription = null,
                modifier = profileIconModifier,
                contentScale = ContentScale.Crop
            )
        } ?: MockProfileIcon(profileIconModifier)

        Text(profileName, modifier = Modifier.layoutId(profileCardModel.username))
        Text(timestamp, modifier = Modifier.layoutId(profileCardModel.timestamp))

        ALifeCardCompose(
            R.drawable.img_tutor_back,
            R.drawable.img_tutor_front,
            offsetsStartStrategy = DefaultStrategy(),
            modifier = Modifier
                .layoutId(profileCardModel.alife)
                .height(486.dp)
        )
    }
}

@Preview
@Composable
fun ProfileCardPreview() {
    ProfileCardCompose(profileName = "Vlad", timestamp = "2 ч. назад")
}