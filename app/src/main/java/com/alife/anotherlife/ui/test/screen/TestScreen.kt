package com.alife.anotherlife.ui.test.screen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import com.alife.anotherlife.ui.test.custom_composable.TextsCompose
import com.alife.anotherlife.ui.test.screen.boxer.TestScreenBoxer
import com.alife.anotherlife.ui.test.screen.state.TestScreenAction

class TestScreen {

    @Composable
    fun Content(viewModel: TestViewModel) = Column {

        TextsCompose(viewModel, TestScreenBoxer(), viewModel.getUIState().textsModel)

        TextField(value = "", onValueChange = remember {
            val callback = { string: String ->
                viewModel
                Log.e("Aboba", string)
                Unit
            }
            Log.e("Aboba", "Callback Info $callback")

            callback
        })

        Button(onClick = savable {
            viewModel
            Log.e("Aboba", "Clicked")
            Unit
        }) {//{ viewModel.reduce(TestScreenAction.TestContinueClick()) }) {
            Text(text = viewModel.getUIState().testScreenText)
        }
    }
}

@Composable
fun savable(save: () -> Unit): () -> Unit = remember { save }

//@Composable
//fun<O> wrap(save: () -> O): () -> O = remember { save }