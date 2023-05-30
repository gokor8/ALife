package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.compose

import androidx.compose.foundation.layout.aspectRatio
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
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import com.alife.anotherlife.core.composable.alife_card.ALifeCardCompose
import com.alife.anotherlife.core.composable.alife_card.model.UIAlifeCardModel
import com.alife.anotherlife.core.composable.alife_card.start_strategy.DefaultStrategy
import com.alife.anotherlife.core.composable.icon.MockProfileIcon

@Composable
fun PostPhotoCardCompose(
    profileName: String,
    timestamp: String,
    avatar: String? = null,
    photoCardModel: UIAlifeCardModel
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
            photoCardModel,
            offsetsStartStrategy = DefaultStrategy(),
            modifier = Modifier
                .layoutId(profileCardModel.alife)
                .aspectRatio(328/480f)
        )
    }
}

@Preview
@Composable
fun ProfileCardPreview() {
    //PostPhotoCardCompose(profileName = "Vlad", timestamp = "2 ч. назад")
}