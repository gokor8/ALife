package com.alife.core.chain

sealed interface ChainStates<M> {

    //class Success<M>(val inputModel: M) : ChainStates<M>
    class Success<M> : ChainStates<M>

    class Fail<M> : ChainStates<M>
}