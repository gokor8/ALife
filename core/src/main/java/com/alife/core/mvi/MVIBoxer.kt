package com.alife.core.mvi

import com.alife.core.mapper.Mapper

interface MVIBoxer<I : MVI.Action, O : MVI.Action> : Mapper<I, O>