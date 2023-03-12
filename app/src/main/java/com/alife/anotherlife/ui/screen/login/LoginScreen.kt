package com.alife.anotherlife.ui.screen.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.modifier.ScrollableModifier
import com.alife.anotherlife.core.composable.text.TextBase
import com.alife.anotherlife.core.ui.screen.DefaultScreen
import com.alife.anotherlife.core.ui.screen.VMScreen
import com.alife.anotherlife.ui.screen.login.model.buttons.text.StaticTextUIAuthModel
import com.alife.anotherlife.ui.screen.login.state.LoginAction

class LoginScreen(override val navController: NavController) :
    VMScreen<LoginViewModel>(ScrollableModifier()) {

    @Composable
    override fun setupViewModel(): LoginViewModel = hiltViewModel()

    @Composable
    override fun Content(modifier: Modifier) {
        Column {

            LaunchedEffect(true) {
                viewModel.reduce(LoginAction.InitAction())
            }

            val state = viewModel.getUIState()

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                TextBase(textResId = R.string.pass_login_in)
            }

            StaticTextUIAuthModel.Hint().Button(
                viewModel = viewModel,
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 14.dp)
            )

            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                reverseLayout = true,
                verticalAlignment = Alignment.Bottom,
                contentPadding = PaddingValues(bottom = 15.dp, start = 5.dp, end = 5.dp)
            ) {
                items(state.supportedAuthService) { authServiceModel ->
                    authServiceModel.Button(viewModel = viewModel, Modifier)
                }
            }
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen(rememberNavController()).SetupContent()
}
