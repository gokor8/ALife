package com.alife.anotherlife.ui.example.test.custom_composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.alife.anotherlife.core.ui.view_model.AbstractViewModel
import com.alife.anotherlife.ui.example.test.custom_composable.action.TextCustomAction
import com.alife.core.mvi.MVI

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <ACTION : MVI.Action> CustomCompose(
    viewModel: AbstractViewModel<ACTION, *, *>,
    actionMVIBoxer: TextsBoxer<ACTION>,
    textsModel: TextsModel,
) = Column {

    listOf(
        textsModel.firstText to { text: String -> TextCustomAction.FirstTextAction(text) },
        textsModel.secondText to { text: String -> TextCustomAction.SecondTextAction(text) },
        textsModel.thirdText to { text: String -> TextCustomAction.ThirdTextAction(text) }
    ).forEach { pair ->
        TextField(
            value = pair.first,
            onValueChange = {
//                viewModel.reduce(
//                    actionMVIBoxer.map(pair.second(it))
//                )
            }
        )
        Spacer(modifier = Modifier.padding(top = 10.dp))
    }

    Button(onClick = {
//        viewModel.reduce(
//            actionMVIBoxer.map(ClickAction.ContinueClick())
//        )
    }) { Text("Continue") }
}