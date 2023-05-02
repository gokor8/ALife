package com.alife.anotherlife.ui.screen.registration.email_code

import com.alife.anotherlife.core.FakeUIStore
import com.alife.anotherlife.core.composable.text.code.model.CodeModel
import com.alife.anotherlife.ui.screen.registration.email_code.reducer.EmailCodeRegReducerBase
import com.alife.anotherlife.ui.screen.registration.email_code.state.EmailCodeEffect
import com.alife.anotherlife.ui.screen.registration.email_code.state.EmailCodeState
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class TestEmailCodeRegReducer {

    private lateinit var fakeUIStore: FakeUIStore<EmailCodeState, EmailCodeEffect>
    private lateinit var emailCodeRegReducer: EmailCodeRegReducerBase

    private fun setupReducer(emailCodeState: EmailCodeState) {
        fakeUIStore = FakeUIStore(emailCodeState)
        emailCodeRegReducer = EmailCodeRegReducerBase(fakeUIStore)
    }

    @Test
    fun `init state give not fill code return filling`() = runTest {
        val testCode = "123"

        setupReducer(EmailCodeState())

        emailCodeRegReducer.onCode(testCode)

        val actual = fakeUIStore.stateCollector.last().codeModel
        val expected = "123"

        assertTrue(actual is CodeModel.Filling)
        assertEquals(expected, actual.code)
    }

    @Test
    fun `init state give fill code return filled and init`() = runTest {
        val testCode = "1234"

        setupReducer(EmailCodeState())

        emailCodeRegReducer.onCode(testCode)

        val actual = fakeUIStore.stateCollector.last().codeModel
        val expected = "1234"

        val stateCollector = fakeUIStore.stateCollector
        val previousExpected = fakeUIStore.stateCollector.lastIndex - 1

        assertTrue(actual is CodeModel.Init)
        assertEquals("", actual.code)
        assertTrue(stateCollector[previousExpected].codeModel is CodeModel.Filled)
        assertEquals(expected, stateCollector[previousExpected].codeModel.code)
    }

    @Test
    fun `filling state give not fill code return filling`() = runTest {
        val testCode = "123"

        setupReducer(EmailCodeState(CodeModel.Filling("12")))

        emailCodeRegReducer.onCode(testCode)

        val actual = fakeUIStore.stateCollector.last().codeModel
        val expected = "123"

        assertTrue(actual is CodeModel.Filling)
        assertEquals(expected, actual.code)
    }

    @Test
    fun `filling state give less symbol code return filling`() = runTest {
        val testCode = "1"

        setupReducer(EmailCodeState(CodeModel.Filling("12")))

        emailCodeRegReducer.onCode(testCode)

        val actual = fakeUIStore.stateCollector.last().codeModel
        val expected = "1"

        assertTrue(actual is CodeModel.Filling)
        assertEquals(expected, actual.code)
    }

    @Test
    fun `filling state give fill code return filled and init`() = runTest {
        val testCode = "1234"

        setupReducer(EmailCodeState(CodeModel.Filling("12")))

        emailCodeRegReducer.onCode(testCode)

        val actual = fakeUIStore.stateCollector.last().codeModel
        val expected = "1234"

        val stateCollector = fakeUIStore.stateCollector
        val previousExpected = fakeUIStore.stateCollector.lastIndex - 1

        assertTrue(actual is CodeModel.Init)
        assertEquals("", actual.code)
        assertTrue(stateCollector[previousExpected].codeModel is CodeModel.Filled)
        assertEquals(expected, stateCollector[previousExpected].codeModel.code)
    }
}