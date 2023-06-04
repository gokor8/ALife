package com.alife.anotherlife.ui.screen.main.navigation_bar.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.alife.anotherlife.core.composable.modifier.BaseScrollFillMaxModifier
import com.alife.anotherlife.core.ui.screen.VMScreenLCE
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.model.ProfileConstraintModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.model.ProfileConstraints
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.state.ProfileAction

class ProfileScreen(
    private val innerPadding: PaddingValues,
    override val navController: NavController
) : VMScreenLCE<ProfileViewModel>(BaseScrollFillMaxModifier) {

    @Composable
    override fun setupViewModel(): ProfileViewModel = hiltViewModel()

    override suspend fun onInit() {
        viewModel.reduce(ProfileAction.OnInit())
    }

    @Composable
    override fun SafeContent(modifier: Modifier) {
        val constraints = ProfileConstraintModel()

        ConstraintLayout(
            ProfileConstraints().markup(constraints),
            modifier = modifier
                .padding(innerPadding)
                .imePadding()
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            val fillState = viewModel.getUIState().contentFillState

            key(fillState) {
                fillState.ContentFill(constraints = constraints)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    //ProfileScreen().SetupContent()
}