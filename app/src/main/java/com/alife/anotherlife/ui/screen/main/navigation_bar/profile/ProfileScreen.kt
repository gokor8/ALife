package com.alife.anotherlife.ui.screen.main.navigation_bar.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.brush.verticalBottomToTopGradient
import com.alife.anotherlife.core.composable.brush.verticalTopToBottomGradient
import com.alife.anotherlife.core.composable.icon.IconBase
import com.alife.anotherlife.core.composable.image.ImageBase
import com.alife.anotherlife.core.composable.modifier.SystemPaddingModifier
import com.alife.anotherlife.core.composable.text.style.style16
import com.alife.anotherlife.core.composable.text.style.style36Bold
import com.alife.anotherlife.core.ui.screen.DefaultScreen
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.model.ProfileConstraintModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.model.ProfileConstraints

class ProfileScreen : DefaultScreen() {

    @Composable
    override fun Content(modifier: Modifier) {
        val constraints = ProfileConstraintModel()

        val onBackgroundColor = MaterialTheme.colorScheme.onBackground

        ConstraintLayout(
            ProfileConstraints().markup(constraints),
            modifier = modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .layoutId(constraints.topBar)
                    .zIndex(1f)
                    .background(verticalTopToBottomGradient())
                    .systemBarsPadding()
                    .padding(vertical = 14.dp, horizontal = 16.dp)
            ) {
                Text("Chypondiks", style = style16())
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
                Text("Gregory", style = style36Bold())
                IconBase(R.drawable.ic_profile_addons, tint = onBackgroundColor)
            }

            Column(
                modifier = Modifier
                    .layoutId(constraints.bottom)
                    .background(MaterialTheme.colorScheme.background)
                    .padding(start = 14.dp)
            ) {
                Text("Russia", style = style16())
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen().SetupContent()
}