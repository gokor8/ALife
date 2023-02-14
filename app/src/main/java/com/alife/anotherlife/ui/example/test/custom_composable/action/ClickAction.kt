package com.alife.anotherlife.ui.example.test.custom_composable.action

import com.alife.anotherlife.ui.example.test.custom_composable.TextsModel
import com.alife.anotherlife.ui.example.test.custom_composable.reduce.ClickReduce

interface ClickAction : CustomAction {

    suspend fun onClick(textsModel: TextsModel, clickReduce: ClickReduce)

    class ContinueClick() : ClickAction {
        override suspend fun onClick(textsModel: TextsModel, clickReduce: ClickReduce) {
            if (textsModel.isNotEmpty())
                clickReduce.onContinueClick()
        }
    }

}