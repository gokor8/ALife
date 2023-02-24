package com.alife.anotherlife.ui.screen.registration.name

import com.alife.anotherlife.ui.screen.registration.base.chain.base.ChainState
import com.alife.anotherlife.ui.screen.registration.base.chain.RegTextTextChain
import com.alife.anotherlife.ui.screen.registration.base.reducer.BaseValidationRegReducer
import com.alife.anotherlife.ui.screen.registration.name.chain.MaxNameTextChain
import com.alife.anotherlife.ui.screen.registration.name.chain.MinNameTextChain
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.junit.Test

class TestNameChain {

    private val chainValidator = RegTextTextChain(MinNameTextChain(), MaxNameTextChain())
    private val fakeChainNamRegReducer = FakeChainNamRegReducer()

    @Test
    fun `test name chain success`() {
        val testString = "Caliy Oleg"

        val chainState = chainValidator.handle(testString)

        assertTrue(chainState is ChainState.Success)
    }

    @Test
    fun `test name chain less 4`() {
        val testString = "Ole"

        val chainState = chainValidator.handle(testString)

        assertTrue(chainState is ChainState.Fail)
        chainState.onChainResult(fakeChainNamRegReducer)
        assertEquals(fakeChainNamRegReducer, 1/*need watch value*/)
    }

    @Test
    fun `test name chain more 25`() {
        val testString = "CCCCCCCCCCCCCCCCCCCCCCCCaliy Oleg"

        val chainState = chainValidator.handle(testString)

        assertTrue(chainState is ChainState.Fail)
        chainState.onChainResult(fakeChainNamRegReducer)
        assertEquals(fakeChainNamRegReducer, 1/*need watch value*/)
    }
}


// Test Realization
class FakeChainNamRegReducer : BaseValidationRegReducer {

    var resultContainer: Int = 0

    override fun onContinue() {
        resultContainer = 0
    }

    override fun onValidationError(errorResId: Int) {
        resultContainer = errorResId
    }
}