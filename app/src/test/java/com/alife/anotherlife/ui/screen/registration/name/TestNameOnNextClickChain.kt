package com.alife.anotherlife.ui.screen.registration.name

import com.alife.anotherlife.ui.screen.registration.base.chain.RegChainValidator
import com.alife.anotherlife.ui.screen.registration.base.chain.base.RegChainState
import com.alife.anotherlife.ui.screen.registration.name.chain.MaxNameTextChain
import com.alife.anotherlife.ui.screen.registration.name.chain.MinNameTextChain
import com.alife.anotherlife.ui.screen.registration.reg_test.model.FakeChainNamRegReducer
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.test.runTest
import org.junit.Test

class TestNameOnNextClickChain {

    private val chainValidator = RegChainValidator.StateValidator(MinNameTextChain(), MaxNameTextChain())
    private val fakeChainNamRegReducer = FakeChainNamRegReducer()

    @Test
    fun `test name chain success`() {
        val testString = "Caliy Oleg"

        val chainState = chainValidator.handle(testString)

        assertTrue(chainState is RegChainState.Success)
    }

    @Test
    suspend fun `test name chain less 4`() {
        val testString = "Ole"

        val chainState = chainValidator.handle(testString)

        chainState.onChainResult(fakeChainNamRegReducer)

        val actual = fakeChainNamRegReducer.resultContainer
        val expected = 2131427340

        assertTrue(chainState is RegChainState.Fail)
        assertEquals(expected, actual)
    }

    @Test
    fun `test name chain more 25`() = runTest {
        val testString = "CCCCCCCCCCCCCCCCCCCCCCCCaliy Oleg"

        val chainState = chainValidator.handle(testString)

        chainState.onChainResult(fakeChainNamRegReducer)

        val actual = fakeChainNamRegReducer.resultContainer
        val expected = 2131427341

        assertTrue(chainState is RegChainState.Fail)
        assertEquals(expected, actual)
    }
}