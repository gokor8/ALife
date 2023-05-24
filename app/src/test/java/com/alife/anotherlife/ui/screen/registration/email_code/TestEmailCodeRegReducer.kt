package com.alife.anotherlife.ui.screen.registration.email_code

import com.alife.anotherlife.core.FakeUIStore
import com.alife.anotherlife.core.composable.text.code.model.CodeModel
import com.alife.anotherlife.ui.screen.registration.email_code.mapper.CodeExceptionMapper
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
        emailCodeRegReducer =
            EmailCodeRegReducerBase(fakeUIStore, FakeEmailCodeUseCase(), CodeExceptionMapper())
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
    fun `init state give fill code`() = runTest {
        val testCode = "123456"

        setupReducer(EmailCodeState())

        emailCodeRegReducer.onCode(testCode)

        val actual = fakeUIStore.stateCollector.last().codeModel
        val expected = "123456"

        val stateCollector = fakeUIStore.stateCollector
        val previousExpected = fakeUIStore.stateCollector.lastIndex - 1

        assertTrue(actual is CodeModel.Filled)
        assertEquals(expected, actual.code)
        assertTrue(stateCollector[previousExpected].codeModel is CodeModel.Init)
    }

    @Test
    fun `filling state give not fill code return filling`() = runTest {
        val testCode = "123"

        setupReducer(EmailCodeState(codeModel = CodeModel.Filling("12")))

        emailCodeRegReducer.onCode(testCode)

        val actual = fakeUIStore.stateCollector.last().codeModel
        val expected = "123"

        assertTrue(actual is CodeModel.Filling)
        assertEquals(expected, actual.code)
    }

    @Test
    fun `filling state give less symbol code return filling`() = runTest {
        val testCode = "1"

        setupReducer(EmailCodeState(codeModel = CodeModel.Filling("12")))

        emailCodeRegReducer.onCode(testCode)

        val actual = fakeUIStore.stateCollector.last().codeModel
        val expected = "1"

        assertTrue(actual is CodeModel.Filling)
        assertEquals(expected, actual.code)
    }

    @Test
    fun `filling state give fill code return filled and init`() = runTest {
        val testCode = "1234"
        val startValue = "12"

        setupReducer(EmailCodeState(codeModel = CodeModel.Filling(startValue)))

        emailCodeRegReducer.onCode(testCode)

        val actual = fakeUIStore.stateCollector.last().codeModel
        val expected = "1234"

        val stateCollector = fakeUIStore.stateCollector
        val previousExpected = fakeUIStore.stateCollector.lastIndex - 1

        assertTrue(actual is CodeModel.Filling)
        assertEquals(expected, actual.code)
        assertTrue(stateCollector[previousExpected].codeModel is CodeModel.Filling)
        assertEquals(startValue, stateCollector[previousExpected].codeModel.code)
    }

    @Test
    fun `filled code delete 1 digit`() = runTest {
        val testCode = "12345"
        val startValue = "123456"

        setupReducer(EmailCodeState(codeModel = CodeModel.Filled(startValue)))

        emailCodeRegReducer.onCode(testCode)

        val actual = fakeUIStore.stateCollector.last().codeModel
        val expected = "12345"

        val stateCollector = fakeUIStore.stateCollector
        val previousExpected = fakeUIStore.stateCollector.lastIndex - 1

        assertTrue(actual is CodeModel.Filling)
        assertEquals(expected, actual.code)
        assertTrue(stateCollector[previousExpected].codeModel is CodeModel.Filled)
        assertEquals(startValue, stateCollector[previousExpected].codeModel.code)
    }

    @Test
    fun `filled code add 1 digit`() = runTest {
        val testCode = "1234567"
        val startValue = "123456"

        setupReducer(EmailCodeState(codeModel = CodeModel.Filled(startValue)))

        emailCodeRegReducer.onCode(testCode)

        val actual = fakeUIStore.stateCollector.last().codeModel
        val expected = "123456"

        val stateCollector = fakeUIStore.stateCollector
        val previousExpected = fakeUIStore.stateCollector.lastIndex - 1

        assertTrue(actual is CodeModel.Filled)
        assertEquals(expected, actual.code)
        assertTrue(stateCollector[previousExpected].codeModel is CodeModel.Filled)
        assertEquals(startValue, stateCollector[previousExpected].codeModel.code)
    }

    @Test
    fun `filled code give same code`() = runTest {
        val testCode = "123456"
        val startValue = "123456"

        setupReducer(EmailCodeState(codeModel = CodeModel.Filled(startValue)))

        emailCodeRegReducer.onCode(testCode)

        val actual = fakeUIStore.stateCollector.last().codeModel
        val expected = "123456"

        val stateCollector = fakeUIStore.stateCollector
        val previousExpected = fakeUIStore.stateCollector.lastIndex - 1

        assertTrue(actual is CodeModel.Filled)
        assertEquals(expected, actual.code)
        assertTrue(stateCollector[previousExpected].codeModel is CodeModel.Filled)
        assertEquals(startValue, stateCollector[previousExpected].codeModel.code)
    }
}