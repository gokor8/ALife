package com.alife.anotherlife.ui.example.test.custom_composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.alife.anotherlife.core.ui.view_model.BaseViewModel
import com.alife.core.mvi.MVI

@Composable
fun<ACTION : MVI.Action> TextsCompose(
    viewModel: BaseViewModel<ACTION, *, *>,
    actionMVIBoxer: TextsBoxer<ACTION>,
    textsModel: TextsModel
) = Column {

    listOf(
        textsModel.firstText to { text: String -> TextsAction.FirstTextAction(text) },
        textsModel.secondText to { text: String -> TextsAction.SecondTextAction(text) },
        textsModel.thirdText to { text: String -> TextsAction.ThirdTextAction(text) }
    ).forEach { pair ->
        TextField(
            value = pair.first,
            onValueChange = {
                viewModel.reduce(
                    actionMVIBoxer.map(pair.second(it))
                )
            }
        )
        Spacer(modifier = Modifier.padding(top = 10.dp))
    }
}