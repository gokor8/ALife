package com.alife.anotherlife.ui.screen.registration.name

import androidx.compose.ui.text.input.TextFieldValue
import com.alife.anotherlife.core.FakeUIStore
import com.alife.anotherlife.ui.screen.registration.base.reducer.RegistrationReducer
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationEffect
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationState
import com.alife.anotherlife.ui.screen.registration.base.chain.base.BaseRegTextChain
import com.alife.anotherlife.ui.screen.registration.base.chain.base.ChainState
import com.alife.anotherlife.ui.screen.registration.base.model.RegistrationModel
import com.alife.anotherlife.ui.screen.registration.base.reducer.BaseValidationRegReducer
import com.alife.anotherlife.ui.screen.registration.name.chain.NameRegTextChain
import com.alife.anotherlife.ui.screen.registration.name.reducer.NameRegistrationReducer
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class TestNameRegistrationReducer {

    lateinit var uiStore: FakeUIStore<RegistrationState, RegistrationEffect>
    lateinit var nameReducer: RegistrationReducer


    @Before
    fun before() {
        uiStore = FakeUIStore(RegistrationState(RegistrationModel(0, 0)))
    }

    private fun setupReducer(
        onNextClickChainState: ChainState,
        isValidOnTextInput: Boolean = true,
    ) {
        nameReducer = NameRegistrationReducer(
            uiStore,
            FakeNameChainValidator(onNextClickChainState),
            FakeNameValidationNameRegReducer(),
            FakeNameRegTextChain(isValidOnTextInput)
        )
    }

    @Test
    fun `test valid text input`() {
        setupReducer(ChainState.Success(), true)
        val testText = TextFieldValue("test text")

        nameReducer.onTextInput(testText)

        val state = uiStore.stateCollector.last().textWithErrorModel

        assertEquals(2, uiStore.stateCollector.size)
        assertEquals(testText, state.textFieldValue)
        assertEquals(null, state.errorResId)
    }

    @Test
    fun `test not valid text input`() {
        setupReducer(ChainState.Success(), false)
        val testText = TextFieldValue("test text")

        nameReducer.onTextInput(testText)

        val expected = ""

        val state = uiStore.stateCollector.last().textWithErrorModel

        assertEquals(1, uiStore.stateCollector.size)
        assertEquals(expected, state.textFieldValue.text)
    }

    @Test
    fun `test on continue click, with empty text`() {
        setupReducer(FakeSuccessNameChain(uiStore))

        nameReducer.onNextClick()

        val expectedValue = "isSuccess: true"

        val storeTextFieldValue = uiStore.stateCollector.last().textWithErrorModel

        assertEquals(2, uiStore.stateCollector.size)
        assertEquals(expectedValue, storeTextFieldValue.textFieldValue.text)
        assertEquals(null, storeTextFieldValue.errorResId)
    }

    @Test
    fun `test on continue click, expect success`() {
        setupReducer(FakeSuccessNameChain(uiStore))
        val testText = TextFieldValue("test text")

        nameReducer.onTextInput(testText)

        nameReducer.onNextClick()

        val expectedValue = "isSuccess: true"

        val storeTextFieldValue = uiStore.stateCollector.last().textWithErrorModel

        assertEquals(3, uiStore.stateCollector.size)
        assertEquals(expectedValue, storeTextFieldValue.textFieldValue.text)
        assertEquals(null, storeTextFieldValue.errorResId)
    }

    @Test
    fun `test success text input, expect fail`() {
        setupReducer(FakeFailNameChain(uiStore))
        val testText = TextFieldValue("test text")

        nameReducer.onTextInput(testText)

        nameReducer.onNextClick()

        val expectedValue = "isSuccess: false"

        val storeTextFieldValue = uiStore.stateCollector.last().textWithErrorModel

        assertEquals(3, uiStore.stateCollector.size)
        assertEquals(expectedValue, storeTextFieldValue.textFieldValue.text)
        assertEquals(null, storeTextFieldValue.errorResId)
    }
}


// Test Realization
sealed class FakeChainState(
    protected val uiStore: FakeUIStore<RegistrationState, RegistrationEffect>,
    private val isSuccess: Boolean,
) : ChainState {

    override fun onChainResult(reducer: BaseValidationRegReducer) {
        uiStore.setState {
            copy(
                textWithErrorModel = textWithErrorModel.copy(
                    textFieldValue = TextFieldValue("isSuccess: $isSuccess")
                )
            )
        }
    }
}

class FakeSuccessNameChain(
    uiStore: FakeUIStore<RegistrationState, RegistrationEffect>,
) : FakeChainState(uiStore, true)

class FakeFailNameChain(
    uiStore: FakeUIStore<RegistrationState, RegistrationEffect>,
) : FakeChainState(uiStore, false)

class FakeNameRegTextChain(private val isValid: Boolean) : NameRegTextChain {
    override fun handle(inputModel: String): Boolean = isValid
}

class FakeNameChainValidator(private val returnState: ChainState) : BaseRegTextChain {

    override fun handle(inputModel: String) = returnState
}

class FakeNameValidationNameRegReducer : BaseValidationRegReducer {

    override fun onContinue() {}

    override fun onValidationError(errorResId: Int) {}
}