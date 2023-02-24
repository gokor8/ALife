package com.alife.anotherlife.ui.screen.registration.name

import com.alife.anotherlife.core.FakeUIStore
import com.alife.anotherlife.ui.screen.registration.base.RegistrationReducer
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationEffect
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationState
import com.alife.anotherlife.ui.screen.registration.name.chain.BaseNameChainValidator
import com.alife.anotherlife.ui.screen.registration.name.chain.NameChainState
import com.alife.anotherlife.ui.screen.registration.name.reducer.BaseValidationNameRegReducer
import com.alife.anotherlife.ui.screen.registration.name.reducer.NameRegistrationReducer
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class TestNameRegistrationReducer {

    lateinit var uiStore: FakeUIStore<RegistrationState, RegistrationEffect>
    lateinit var nameReducer: RegistrationReducer


    @Before
    fun before() {
        uiStore = FakeUIStore()
    }

    @Test
    fun setupReducer(returnState: NameChainState) {
        nameReducer = NameRegistrationReducer(
            uiStore,
            FakeNameChainValidator(returnState),
            FakeNameValidationNameRegReducer()
        )
    }

    @Test
    fun `test success text input`() {
        setupReducer(NameChainState.Success())
        val testText = "test text"

        nameReducer.onTextInput(testText)

        assertEquals(uiStore.stateCollector.size, 1)
        assertEquals(uiStore.stateCollector.last().textWithErrorModel.text, testText)
        assertEquals(uiStore.stateCollector.last().textWithErrorModel.errorResId, null)
    }

    @Test
    fun `test on continue click, expect success`() {
        setupReducer(FakeSuccessNameChain(uiStore))
        val testText = "test text"

        nameReducer.onTextInput(testText)

        val expectedValue = "isSuccess: true"

        assertEquals(uiStore.stateCollector.size, 1)
        assertEquals(uiStore.stateCollector.last().textWithErrorModel.text, expectedValue)
        assertEquals(uiStore.stateCollector.last().textWithErrorModel.errorResId, null)
    }

    @Test
    fun `test success text input, expect fail`() {
        setupReducer(FakeFailNameChain(uiStore))
        val testText = "test text"

        nameReducer.onTextInput(testText)

        val expectedValue = "isSuccess: false"

        assertEquals(uiStore.stateCollector.size, 1)
        assertEquals(uiStore.stateCollector.last().textWithErrorModel.text, expectedValue)
        assertEquals(uiStore.stateCollector.last().textWithErrorModel.errorResId, null)
    }
}


// Test Realization
sealed class FakeChainState(
    protected val uiStore: FakeUIStore<RegistrationState, RegistrationEffect>,
    private val isSuccess: Boolean
) : NameChainState {

    override fun onChainResult(reducer: BaseValidationNameRegReducer) {
        uiStore.setState {
            copy(textWithErrorModel = textWithErrorModel.copy(text = "isSuccess: $isSuccess"))
        }
    }
}

class FakeSuccessNameChain(
    uiStore: FakeUIStore<RegistrationState, RegistrationEffect>,
) : FakeChainState(uiStore, true)

class FakeFailNameChain(
    uiStore: FakeUIStore<RegistrationState, RegistrationEffect>,
) : FakeChainState(uiStore, false)


class FakeNameChainValidator(private val returnState: NameChainState) : BaseNameChainValidator {

    override fun handle(inputModel: String) = returnState
}

class FakeNameValidationNameRegReducer : BaseValidationNameRegReducer {

    override fun onContinue() {}

    override fun onValidationError(errorResId: Int) {}
}