package com.alife.core.chain

sealed interface DefaultChainState : BaseChainState {

    class Success : DefaultChainState, BaseChainState.Success

    class Fail : DefaultChainState, BaseChainState.Fail
}