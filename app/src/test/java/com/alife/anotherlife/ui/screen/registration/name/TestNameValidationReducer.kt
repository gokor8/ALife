package com.alife.anotherlife.ui.screen.registration.name

import com.alife.anotherlife.core.FakeUIStore
import com.alife.anotherlife.core.ui.state.error_text.TextWithErrorModel
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationEffect
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationState
import com.alife.anotherlife.ui.screen.registration.name.reducer.NameValidationRegReducer
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class TestNameValidationReducer {

    lateinit var uiStore: FakeUIStore<RegistrationState, RegistrationEffect>
    lateinit var nameReducer: NameValidationRegReducer


    @Before
    fun before() {
        uiStore = FakeUIStore()
        nameReducer = NameValidationRegReducer(uiStore)
    }

    @Test
    fun `test onContinue`() {
        nameReducer.onContinue()

        val expected = TextWithErrorModel()

        assertEquals(uiStore.getState().textWithErrorModel, expected)
        assertEquals(uiStore.effectCollector.last(), RegistrationEffect.NavigateUsername())
    }

    @Test
    fun `test onValidationError`() {
        nameReducer.onValidationError(0)

        val expected = TextWithErrorModel(errorResId = 0)

        assertEquals(uiStore.effectCollector.size, 0)
        assertEquals(uiStore.getState().textWithErrorModel, expected)
    }
}