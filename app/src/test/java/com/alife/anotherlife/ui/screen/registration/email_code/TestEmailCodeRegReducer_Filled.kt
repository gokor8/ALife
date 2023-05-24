package com.alife.anotherlife.ui.screen.registration.email_code

import com.alife.anotherlife.core.FakeUIStore
import com.alife.anotherlife.ui.screen.registration.email_code.reducer.EmailCodeRegReducerBase
import com.alife.anotherlife.ui.screen.registration.email_code.state.EmailCodeEffect
import com.alife.anotherlife.ui.screen.registration.email_code.state.EmailCodeState
import junit.framework.TestCase
import kotlinx.coroutines.test.runTest
import org.junit.Test
import java.io.IOException

class TestEmailCodeRegReducer_Filled {


    private lateinit var fakeUIStore: FakeUIStore<EmailCodeState, EmailCodeEffect>
    private lateinit var emailCodeRegReducer: EmailCodeRegReducerBase

    private fun setupReducer(
        emailCodeState: EmailCodeState,
        useCase: FakeEmailCodeUseCase = FakeEmailCodeUseCase()
    ) {
        fakeUIStore = FakeUIStore(emailCodeState)
        emailCodeRegReducer =
            EmailCodeRegReducerBase(fakeUIStore, useCase, FakeCodeExceptionMapper(fakeUIStore))
    }

    @Test
    fun `success send code`() = runTest {
        val code = "123456"

        setupReducer(EmailCodeState())

        emailCodeRegReducer.onCode(code)

        val actual = fakeUIStore.effectCollector.last()

        TestCase.assertTrue(actual is EmailCodeEffect.NavigateTutorial)
    }

    @Test
    fun `fail send code was exception`() = runTest {
        val code = "123456"

        setupReducer(EmailCodeState(), FakeEmailCodeUseCase(IOException()))

        emailCodeRegReducer.onCode(code)

        val actual = fakeUIStore.effectCollector.last()

        TestCase.assertTrue(actual is ExceptionHandledEffect)
    }


    class ExceptionHandledEffect : EmailCodeEffect
}