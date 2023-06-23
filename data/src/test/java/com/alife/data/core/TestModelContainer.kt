package com.alife.data.core

class TestModelContainer<M: Any>(
    private var state: M
) {

    fun getState() = state

    fun setState(newState: M.() -> M) {
        state = state.newState()
    }

    fun setState(newState: M) {
        state = newState
    }
}