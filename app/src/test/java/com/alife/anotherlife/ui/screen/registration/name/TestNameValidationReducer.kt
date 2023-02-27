package com.alife.anotherlife.ui.screen.registration.name

import com.alife.anotherlife.core.FakeUIStore
import com.alife.anotherlife.core.ui.state.error_text.TextWithErrorModel
import com.alife.anotherlife.ui.screen.registration.base.model.RegistrationModel
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationEffect
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationState
import com.alife.anotherlife.ui.screen.registration.name.reducer.NameValidationRegReducer
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.junit.Before
import org.junit.Test

class TestNameValidationReducer {

    lateinit var uiStore: FakeUIStore<RegistrationState, RegistrationEffect>
    lateinit var nameReducer: NameValidationRegReducer


    @Before
    fun before() {
        uiStore = FakeUIStore(RegistrationState(RegistrationModel(0, 0)))
        nameReducer = NameValidationRegReducer(uiStore)
    }

    @Test
    fun `test onContinue`() {
        nameReducer.onContinue()

        val expected = TextWithErrorModel()

        assertEquals(expected, uiStore.getState().textWithErrorModel)
        assertTrue(uiStore.effectCollector.last() is RegistrationEffect.NavigateUsername)
    }

    @Test
    fun `test onValidationError`() {
        nameReducer.onValidationError(0)

        val expected = TextWithErrorModel(errorResId = 0)

        assertEquals(0, uiStore.effectCollector.size)
        assertEquals(expected, uiStore.getState().textWithErrorModel,)
    }
}