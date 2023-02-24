package com.alife.anotherlife.ui.screen.registration.name

import com.alife.anotherlife.core.FakeUIStore
import com.alife.anotherlife.core.ui.state.error_text.TextWithErrorModel
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.registration.base.RegistrationReducer
import com.alife.anotherlife.ui.screen.registration.base.model.RegistrationModel
import com.alife.anotherlife.ui.screen.registration.base.state.BaseRegistrationState
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
        val testText = "test text"

        nameReducer.onTextInput(testText)

        assertEquals(uiStore.stateCollector.size, 1)
        assertEquals(uiStore.stateCollector.last().textWithErrorModel.text, testText)
        assertEquals(uiStore.stateCollector.last().textWithErrorModel.errorResId, null)
    }

    @Test
    fun `test success text input, expect fail`() {
        val testText = "test text"

        nameReducer.onTextInput(testText)

        assertEquals(uiStore.stateCollector.size, 1)
        assertEquals(uiStore.stateCollector.last().textWithErrorModel.text, testText)
        assertEquals(uiStore.stateCollector.last().textWithErrorModel.errorResId, null)
    }
}


// Test Realization
data class FakeRegistrationState(
    override val registrationModel: RegistrationModel,
    override val textWithErrorModel: TextWithErrorModel,
    val isSuccess: Boolean,
) : BaseRegistrationState {

    override fun copyBase(registrationModel: RegistrationModel) =
        copy(registrationModel = registrationModel)
    override fun copyBase(textWithErrorModel: TextWithErrorModel) =
        copy(textWithErrorModel = textWithErrorModel)
}

sealed class FakeChainState(
    protected val uiStore: FakeUIStore<BaseRegistrationState, RegistrationEffect>,
    private val isSuccess: Boolean
) : NameChainState {

    override fun onChainResult(reducer: BaseValidationNameRegReducer) {
        uiStore.setState {
            FakeRegistrationState(registrationModel, textWithErrorModel, isSuccess)
        }
    }
}

class FakeSuccessNameChain(
    uiStore: FakeUIStore<BaseRegistrationState, RegistrationEffect>,
    private val isSuccess: Boolean
) : FakeChainState(uiStore, true)

class FakeFailNameChain(
    uiStore: FakeUIStore<BaseRegistrationState, RegistrationEffect>,
) : FakeChainState(uiStore, false)


class FakeNameChainValidator(private val returnState: NameChainState) : BaseNameChainValidator {

    override fun handle(inputModel: String) = returnState
}

class FakeNameValidationNameRegReducer : BaseValidationNameRegReducer {

    override fun onContinue() {}

    override fun onValidationError(errorResId: Int) {}
}