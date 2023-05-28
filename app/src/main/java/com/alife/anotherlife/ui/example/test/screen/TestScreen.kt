package com.alife.anotherlife.ui.example.test.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.alife.anotherlife.core.composable.button.ButtonBase
import com.alife.anotherlife.core.composable.modifier.SystemPaddingModifier
import com.alife.anotherlife.core.ui.screen.DefaultScreen
import com.alife.anotherlife.ui.screen.main.create_alife.navigation.CreateAlifeNavigator
import com.alife.anotherlife.ui.screen.main.finish_create_alife.photo.navigation.FinishPictureNavigator
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.navigation.FinishVideoNavigator
import com.alife.anotherlife.ui.screen.main.navigation.MainScreenNavigator
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.navigation.HomeNavigator
import com.alife.anotherlife.ui.screen.registration.tutorial.navigation.TutorialNavigator

class TestScreen(val navController: NavController) : DefaultScreen(SystemPaddingModifier) {

    @Composable
    override fun Content(modifier: Modifier) = Surface {
        val listNavigators = listOf(
            TutorialNavigator(),
            MainScreenNavigator(),
            HomeNavigator(),
            CreateAlifeNavigator(),
            FinishPictureNavigator(),
            FinishVideoNavigator()
        )

        LazyColumn(modifier = modifier, contentPadding = PaddingValues(10.dp)) {
            items(listNavigators.size) {
                val navigator = listNavigators[it]

                ButtonBase(onClick = {
                    navController.navigate(navigator.toString())
                }) {
                    Text(text = navigator::class.simpleName ?: ":c")
                }
            }
        }
    }
}