package com.alife.anotherlife.ui.example.test.screen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import com.alife.anotherlife.ui.example.test.custom_composable.TextsCompose
import com.alife.anotherlife.ui.example.test.screen.boxer.TestScreenBoxer
import com.alife.anotherlife.ui.example.test.screen.state.TestScreenAction

class TestScreen {

    @Composable
    fun savable(save: () -> Unit): () -> Unit = remember { save }

    @Composable
    fun Content(viewModel: TestViewModel) = Column {

        TextsCompose(viewModel, TestScreenBoxer(), viewModel.getUIState().textsModel)

        TextField(
            value = viewModel.getUIState().testScreenText,
            onValueChange = { text: String ->
                viewModel.reduce(TestScreenAction.TestTextAction(text))
                Log.e("Aboba", text)
            }
        )

        Button(onClick = savable {
            viewModel.reduce(TestScreenAction.TestContinueClick())
            Log.e("Aboba", "Clicked")
        }) {
            Text(text = viewModel.getUIState().testScreenText)
        }
    }
}