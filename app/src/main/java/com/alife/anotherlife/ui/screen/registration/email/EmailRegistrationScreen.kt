package com.alife.anotherlife.ui.screen.registration.email

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.alife.anotherlife.R
import com.alife.anotherlife.core.ui.dialog.AbstractDialog
import com.alife.anotherlife.core.ui.dialog.DefaultDialog
import com.alife.anotherlife.core.ui.dialog.DialogButtonStrategy
import com.alife.anotherlife.ui.screen.registration.base.RegistrationScreen

class EmailRegistrationScreen(
    override val navController: NavController
) : RegistrationScreen<EmailRegistrationVM>() {

    @Composable
    override fun setupViewModel(): EmailRegistrationVM = hiltViewModel()

    @Composable
    override fun SafeContent(modifier: Modifier) {
        super.SafeContent(modifier)

        var dialogError by remember {
            mutableStateOf<AbstractDialog?>(null)
        }

        dialogError?.ShowDialog()

        LaunchedEffect(Unit) {
            viewModel.collectEffect(navController) { textRes ->
                dialogError = DefaultDialog(R.string.exception, textRes, DialogButtonStrategy.Empty())
            }
        }
    }

    override suspend fun setupEventCollector() = Unit
}