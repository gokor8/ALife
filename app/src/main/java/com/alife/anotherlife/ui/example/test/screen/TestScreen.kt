package com.alife.anotherlife.ui.example.test.screen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.alife.anotherlife.core.composable.alife_card.ALifeCardCompose
import com.alife.anotherlife.core.composable.alife_card.start_strategy.PocketStrategy
import com.alife.anotherlife.core.composable.button.ButtonBase
import com.alife.anotherlife.core.composable.text.style.Button18
import com.alife.anotherlife.core.navigation.NavigationWrapper
import com.alife.anotherlife.core.ui.screen.DefaultScreen
import com.alife.anotherlife.ui.example.test.custom_composable.CustomCompose
import com.alife.anotherlife.ui.example.test.screen.boxer.TestScreenBoxer
import com.alife.anotherlife.ui.example.test.screen.state.TestScreenAction
import com.alife.anotherlife.ui.screen.registration.tutorial.TutorialScreen
import com.alife.anotherlife.ui.screen.registration.tutorial.navigation.TutorialNavigator

class TestScreen(val navController: NavController) : DefaultScreen() {

    @Composable
    override fun Content(modifier: Modifier)  = Column(modifier) {
        ButtonBase(onClick = {
            navController.navigate(TutorialNavigator().toString())
        }) {
            Text(text = TutorialScreen::class.simpleName ?: ":c")
        }
    }
}