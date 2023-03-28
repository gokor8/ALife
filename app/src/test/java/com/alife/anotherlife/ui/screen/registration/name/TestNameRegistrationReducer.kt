package com.alife.anotherlife.ui.screen.registration.name

import androidx.compose.ui.text.input.TextFieldValue
import com.alife.anotherlife.core.FakeUIStore
import com.alife.anotherlife.ui.screen.registration.base.reducer.RegistrationReducer
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationEffect
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationState
import com.alife.anotherlife.ui.screen.registration.base.chain.base.BaseRegTextChain
import com.alife.anotherlife.ui.screen.registration.base.chain.base.RegChainState
import com.alife.anotherlife.ui.screen.registration.base.model.RegistrationModel
import com.alife.anotherlife.ui.screen.registration.base.reducer.BaseValidationRegReducer
import com.alife.anotherlife.ui.screen.registration.name.chain.InputRegTextChain
import com.alife.anotherlife.ui.screen.registration.name.reducer.NameRegistrationReducer
import com.alife.anotherlife.ui.screen.registration.reg_test.model.FakeChainNamRegReducer
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class TestNameRegistrationReducer {

    lateinit var uiStore: FakeUIStore<RegistrationState, RegistrationEffect>
    lateinit var nameReducer: RegistrationReducer
    private lateinit var fakeChainNamRegReducer: FakeChainNamRegReducer

    @Before
    fun before() {
        uiStore = FakeUIStore(RegistrationState(RegistrationModel(0, 0)))
        fakeChainNamRegReducer = FakeChainNamRegReducer()
    }

    private fun setupReducer(
        onNextClickRegChainState: RegChainState,
        isValidOnTextInput: Boolean = true,
    ) {
        // TODO need fix
//        nameReducer = NameRegistrationReducer(
//            uiStore,
//            FakeNameChainValidator(onNextClickRegChainState),
//            fakeChainNamRegReducer,
//            FakeInputRegTextChain(isValidOnTextInput)
//
//        )
    }

    @Test
    fun `test textInput + onClick, expect success`() = runTest {
        setupReducer(FakeSuccessNameRegChain())
        val testText = "test text"

        nameReducer.onTextInput(TextFieldValue(testText))

        nameReducer.onNextClick()

        val expectedValue = 0

        val storeTextFieldValue = uiStore.stateCollector.last().textErrorModel

        assertEquals(2, uiStore.stateCollector.size)
        assertEquals(expectedValue, fakeChainNamRegReducer.resultContainer)
        assertEquals(testText, storeTextFieldValue.textFieldValue.text)
        assertEquals(null, storeTextFieldValue.errorResId)
    }

    @Test
    fun `test textInput + onClick, expect fail`() = runTest {
        setupReducer(FakeFailNameRegChain())
        val testText = "test text"

        nameReducer.onTextInput(TextFieldValue(testText))

        nameReducer.onNextClick()

        val expectedValue = 1

        val storeTextFieldValue = uiStore.stateCollector.last().textErrorModel

        assertEquals(2, uiStore.stateCollector.size)
        assertEquals(expectedValue, fakeChainNamRegReducer.resultContainer)
        assertEquals(testText, storeTextFieldValue.textFieldValue.text)
        assertEquals(null, storeTextFieldValue.errorResId)
    }
}


// Test Realization
sealed class FakeRegChainState(
    private val isSuccess: Boolean,
) : RegChainState {

    override suspend fun onChainResult(reducer: BaseValidationRegReducer) {
        if(isSuccess) reducer.onContinue() else reducer.onValidationError(1)
    }
}

class FakeSuccessNameRegChain: FakeRegChainState(true)

class FakeFailNameRegChain: FakeRegChainState(false)

class FakeInputRegTextChain(private val isValid: Boolean) : InputRegTextChain {
    override fun handle(inputModel: String): Boolean = isValid
}

class FakeNameChainValidator(private val returnState: RegChainState) : BaseRegTextChain {

    override fun handle(inputModel: String) = returnState
}

class FakeNameValidationNameRegReducer : BaseValidationRegReducer {

    override suspend fun onContinue() {}

    override fun onValidationError(errorResId: Int) {}
}