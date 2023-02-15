package com.alife.anotherlife.ui.screen.login.model.buttons

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.alife.anotherlife.ui.screen.login.LoginViewModel
import com.alife.anotherlife.ui.screen.login.model.buttons.text.LoginTextUIAuthModel

class ContainerLoginUIAuthModel(
    private val loginIn: LoginTextUIAuthModel.LoginIn,
    private val registration: LoginTextUIAuthModel.Registration,
    private val lastLeft: UIAuthModel
) : UIAuthModel {

    @Composable
    override fun Button(viewModel: LoginViewModel) = Column(
        horizontalAlignment = Alignment.End
    ) {
        registration.Button(viewModel = viewModel)
        Spacer(modifier = Modifier.fillMaxWidth().padding(bottom = 5.dp))
        Row {
            lastLeft.Button(viewModel = viewModel)
            Spacer(modifier = Modifier.padding(bottom = 5.dp))
            loginIn.Button(viewModel = viewModel)
        }
    }
}