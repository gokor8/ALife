package com.alife.anotherlife.ui.screen.registration.tutorial.childrens

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.alife_card.ALifeCardCompose
import com.alife.anotherlife.core.composable.alife_card.model.UIAlifeCardModel
import com.alife.anotherlife.core.composable.alife_card.start_strategy.PocketStrategy

class FirstTutorialScreen : BaseTutorialScreen(R.string.tutorial_first_description) {

    @Composable
    override fun MiddleContent(modifier: Modifier) {
        ALifeCardCompose(
            UIAlifeCardModel.Default(
                R.drawable.img_tutor_2_front,
                R.drawable.img_tutor_2_back
            ),
            PocketStrategy(),
            modifier.padding(horizontal = 44.dp)
        )
    }
}

@Preview
@Composable
fun FirstTutorialScreenPreview() {
    FirstTutorialScreen().SetupContent()
}