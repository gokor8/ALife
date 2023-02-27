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

    fun setupReducer(returnState: ChainState) {
        nameReducer = NameRegistrationReducer(
            uiStore,
            FakeNameChainValidator(returnState),
            FakeNameValidationNameRegReducer()
        )
    }

    @Test
    fun `test success text input`() {
        setupReducer(ChainState.Success())
        val testText = TextFieldValue("test text")

        nameReducer.onTextInput(testText)

        assertEquals(2, uiStore.stateCollector.size)
        assertEquals(uiStore.stateCollector.last().textWithErrorModel.textFieldValue.text, testText)
        assertEquals(uiStore.stateCollector.last().textWithErrorModel.errorResId, null)
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
    private val isSuccess: Boolean
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


class FakeNameChainValidator(private val returnState: ChainState) : BaseRegTextChain {

    override fun handle(inputModel: String) = returnState
}

class FakeNameValidationNameRegReducer : BaseValidationRegReducer {

    override fun onContinue() {}

    override fun onValidationError(errorResId: Int) {}
}