package com.alife.anotherlife.ui.screen.registration.reg_test

import androidx.compose.ui.text.input.TextFieldValue
import com.alife.anotherlife.core.FakeUIStore
import com.alife.anotherlife.ui.screen.registration.base.chain.base.RegChainState
import com.alife.anotherlife.ui.screen.registration.base.model.RegistrationModel
import com.alife.anotherlife.ui.screen.registration.base.reducer.BaseRegistrationReducer
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationEffect
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationState
import com.alife.anotherlife.ui.screen.registration.name.*
import com.alife.anotherlife.ui.screen.registration.reg_test.model.FakeWithInputRegistrationReducer
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test

class TestWithInputRegistrationReducer {

    lateinit var uiStore: FakeUIStore<RegistrationState, RegistrationEffect>
    lateinit var nameReducer:  BaseRegistrationReducer.WithInputChain


    @Before
    fun before() {
        uiStore = FakeUIStore(RegistrationState(RegistrationModel(0, 0)))
    }

    private fun setupReducer(
        onNextClickRegChainState: RegChainState,
        isValid: Boolean,
    ) {
        nameReducer = FakeWithInputRegistrationReducer(
            uiStore,
            FakeNameChainValidator(onNextClickRegChainState),
            FakeNameValidationNameRegReducer(),
            FakeInputRegTextChain(isValid)
        )
    }

    @Test
    fun `test input text expect nothing changed`() {
        setupReducer(FakeSuccessNameRegChain(), false)

        val testText = "test text"

        nameReducer.onTextInput(TextFieldValue(testText))

        val expectedValue = ""
        val storeTextFieldValue = uiStore.stateCollector.last().textErrorModel

        TestCase.assertEquals(1, uiStore.stateCollector.size)
        TestCase.assertEquals(expectedValue, storeTextFieldValue.textFieldValue.text)
        TestCase.assertEquals(null, storeTextFieldValue.errorResId)
    }

    @Test
    fun `test input text expect changed state`() {
        setupReducer(FakeSuccessNameRegChain(), true)

        val testText = "test text"

        nameReducer.onTextInput(TextFieldValue(testText))

        val storeTextFieldValue = uiStore.stateCollector.last().textErrorModel

        TestCase.assertEquals(2, uiStore.stateCollector.size)
        TestCase.assertEquals(testText, storeTextFieldValue.textFieldValue.text)
        TestCase.assertEquals(null, storeTextFieldValue.errorResId)
    }
}