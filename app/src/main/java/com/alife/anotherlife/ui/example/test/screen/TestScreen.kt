package com.alife.anotherlife.ui.example.test.screen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.alife.anotherlife.ui.example.test.custom_composable.CustomCompose
import com.alife.anotherlife.ui.example.test.screen.boxer.TestScreenBoxer
import com.alife.anotherlife.ui.example.test.screen.state.TestScreenAction

class TestScreen {

    @Composable
    fun savable(save: () -> Unit): () -> Unit = remember { save }

    @Composable
    fun Content(viewModel: TestViewModel) = Column {

        CustomCompose(viewModel, TestScreenBoxer(), viewModel.getUIState().textsModel)

        Spacer(modifier = Modifier.weight(1f))
        
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