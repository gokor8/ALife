package com.alife.anotherlife.ui.test.custom_composable

import com.alife.core.mvi.MVI
import com.alife.core.mvi.MVIBoxer

interface TextsBoxer<ACTION : MVI.Action> : MVIBoxer<TextsAction, ACTION>