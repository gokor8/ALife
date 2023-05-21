package com.alife.anotherlife.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.alife.anotherlife.core.navigation.NavigationGraph
import com.alife.anotherlife.core.ui.screen.VMScreen
import com.alife.anotherlife.core.ui.screen.VMScreenLCE
import com.alife.anotherlife.core.ui.state.lce.LCEContent
import com.alife.anotherlife.theme.AnotherLifeTheme
import com.alife.anotherlife.ui.activity.state.MainActivityAction
import com.alife.anotherlife.ui.example.ExampleNavigationGraph
import com.alife.anotherlife.ui.example.test.TestNavGraph
import com.alife.anotherlife.ui.screen.login.navigation.LoginNavRoute
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigationGraph: NavigationGraph

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnotherLifeTheme {
                WindowCompat.setDecorFitsSystemWindows(window, false)
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel: MainActivityViewModel = hiltViewModel()

                    val lceModel = viewModel.getUIState().lceModel
                    val navHostController = rememberNavController()

                    LaunchedEffect(Unit) {
                        viewModel.collectEffect(navHostController)
                    }

                    if (lceModel is LCEContent) {
                        navigationGraph.SetupNavigation(navHostController = navHostController)
                    } else {
                        lceModel.LCEContent(modifier = Modifier)
                    }

                    //DevNavigationGraph().SetupNavigation(navHostController = navHostController)
                    //MainNavigationGraph(
                    //LoginNavRoute()
                    //).SetupNavigation(navHostController = navHostController)
                }
            }
        }
    }
}