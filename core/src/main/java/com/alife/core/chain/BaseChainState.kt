package com.alife.core.chain

interface BaseChainState {

    interface Success : BaseChainState

    interface Fail : BaseChainState
}