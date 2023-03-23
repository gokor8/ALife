package com.alife.anotherlife.ui.example.test.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.alife.anotherlife.core.composable.button.ButtonBase
import com.alife.anotherlife.core.composable.modifier.ImeModifier
import com.alife.anotherlife.core.ui.screen.DefaultScreen
import com.alife.anotherlife.ui.screen.main.main_screen.navigation.MainScreenNavigator
import com.alife.anotherlife.ui.screen.registration.tutorial.navigation.TutorialNavigator

class TestScreen(val navController: NavController) : DefaultScreen(ImeModifier()) {

    @Composable
    override fun Content(modifier: Modifier) {
        val listNavigators = listOf(TutorialNavigator(), MainScreenNavigator())

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