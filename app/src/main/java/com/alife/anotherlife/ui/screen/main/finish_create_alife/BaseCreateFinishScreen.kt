package com.alife.anotherlife.ui.screen.main.finish_create_alife

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.modifier.SystemPaddingModifier
import com.alife.anotherlife.core.composable.text.TextBase
import com.alife.anotherlife.core.composable.text.style.Button18
import com.alife.anotherlife.core.composable.text.style.Title28Style
import com.alife.anotherlife.core.ui.screen.VMScreenLCE

abstract class BaseCreateFinishScreen<VM : BaseCreateFinishViewModel<*, *, *, *>>(
    override val navController: NavController
) : VMScreenLCE<VM>(SystemPaddingModifier) {

    override suspend fun onInit() {
        viewModel.reduceFinishAction(BaseCreateFinishAction.Init())
    }

    @Composable
    override fun SafeContent(modifier: Modifier) = Column(modifier) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            TextBase(
                textResId = R.string.horizontal_short_logo,
                style = Title28Style().style()
            )
        }
        Spacer(modifier = Modifier.weight(1f).padding(bottom = 10.dp))

        InnerContent(modifier)

        Spacer(modifier = Modifier
            .weight(1f)
            .padding(bottom = 12.dp))

        Button18(text = R.string.upload) {
            viewModel.reduceFinishAction(BaseCreateFinishAction.Download())
        }
    }

    @Composable
    protected abstract fun InnerContent(modifier: Modifier)
}