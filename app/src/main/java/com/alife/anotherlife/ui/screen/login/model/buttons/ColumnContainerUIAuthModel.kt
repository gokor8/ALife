package com.alife.anotherlife.ui.screen.login.model.buttons

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.alife.anotherlife.ui.screen.login.LoginViewModel

data class ColumnContainerUIAuthModel(
    private val firstUIAuthModel: UIAuthModel,
    private val secondUIAuthModel: UIAuthModel? = null
) : UIAuthModel {
    
    @Composable
    override fun Button(viewModel: LoginViewModel, modifier: Modifier) = Column {
        firstUIAuthModel.Button(viewModel = viewModel, modifier)
        Spacer(modifier = Modifier.padding(bottom = 5.dp))
        secondUIAuthModel?.Button(viewModel = viewModel, modifier)
    }
}