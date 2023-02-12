package com.alife.anotherlife.ui.screen.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.modifier.ScrollableModifier
import com.alife.anotherlife.core.composable.text.TextBase
import com.alife.anotherlife.core.ui.screen.DefaultScreen
import com.alife.anotherlife.core.ui.screen.VMScreen
import com.alife.anotherlife.ui.screen.login.model.buttons.text.StaticTextUIAuthModel

class LoginScreen : VMScreen<LoginViewModel>(ScrollableModifier()) {

    @Composable
    override fun setupViewModel(): LoginViewModel = hiltViewModel()

    @Composable
    override fun Content(modifier: Modifier) {
        Column {

            val state = viewModel.getUIState()

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                TextBase(textResId = R.string.pass_login_in)
            }

            LazyHorizontalGrid(
                modifier = Modifier.height(158.dp),
                rows = GridCells.Fixed(3),
                reverseLayout = true,
                contentPadding = PaddingValues(vertical = 5.dp, horizontal = 5.dp)
            ) {
                items(
                    state.supportedAuthService,
                    span = { authModel ->
                        GridItemSpan(
                            when (authModel) {
                                is StaticTextUIAuthModel.Logo -> maxCurrentLineSpan
                                is StaticTextUIAuthModel.Hint -> 0
                                else -> 1
                            }
                        )
                    }
                ) {
                    it.Button(viewModel = viewModel)
                }
//                item(
//                    span = { GridItemSpan(maxCurrentLineSpan) }
//                ) {
//                    TextBase(
//                        textResId = R.string.horizontal_logo,
//                        modifier = Modifier
//                            .padding(start = 22.dp, end = 21.dp)
//                            .height(IntrinsicSize.Min)
//                            .width(5.dp)
//                    )
//                }
//                item(
//                    span = { GridItemSpan(0) }
//                ) {
//                    TextBase(textResId = R.string.authorization_type)
//                    Spacer(modifier = Modifier.padding(bottom = 14.dp))
//                }
            }
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen().SetupContent()
}
