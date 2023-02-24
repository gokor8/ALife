package com.alife.core.chain

sealed interface EmptyChainState {

    class Success : EmptyChainState

    class Fail : EmptyChainState
}