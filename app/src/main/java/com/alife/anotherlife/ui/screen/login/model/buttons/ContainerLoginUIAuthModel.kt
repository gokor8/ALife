package com.alife.anotherlife.ui.screen.login.model.buttons

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import com.alife.anotherlife.R
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.alife.anotherlife.ui.screen.login.LoginViewModel
import com.alife.anotherlife.ui.screen.login.model.buttons.text.LoginTextUIAuthModel

data class ContainerLoginUIAuthModel(
    private val loginIn: LoginTextUIAuthModel.LoginIn,
    private val registration: LoginTextUIAuthModel.Registration,
    private val lastLeft: UIAuthModel
) : UIAuthModel {

    @Composable
    override fun Button(viewModel: LoginViewModel, modifier: Modifier) = Column(
        modifier = modifier,
        horizontalAlignment = Alignment.End
    ) {
        registration.Button(viewModel = viewModel, Modifier)
        Spacer(modifier = Modifier.padding(bottom = 5.dp))
        Row(modifier = Modifier) {
            LoginTextUIAuthModel.Authorization(
                R.drawable.ic_inst,
                CornerSize(20.dp)
            ).Button(viewModel = viewModel, Modifier)
            Spacer(modifier = Modifier.padding(start = 5.dp))
            LoginTextUIAuthModel.Authorization(
                R.drawable.ic_facebook,
                CornerSize(20.dp)
            ).Button(viewModel = viewModel, Modifier)
        }
    }
}