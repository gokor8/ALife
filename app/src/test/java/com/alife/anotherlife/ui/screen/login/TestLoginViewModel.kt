package com.alife.anotherlife.ui.screen.login

import com.alife.anotherlife.core.EmptyUIStore
import com.alife.anotherlife.core.FakeEffectCollector
import com.alife.anotherlife.core.FakeStateCollector
import com.alife.anotherlife.core.FakeUIStore
import com.alife.anotherlife.core.ViewModelTest
import com.alife.anotherlife.core.ui.reducer.AbstractVMReducer
import com.alife.anotherlife.core.ui.state_collector.EffectCollector
import com.alife.anotherlife.core.ui.state_collector.StateCollector
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.login.model.AuthType
import com.alife.anotherlife.ui.screen.login.reducer.BaseLoginReducerBase
import com.alife.anotherlife.ui.screen.login.reducer.LoginReducer
import com.alife.anotherlife.ui.screen.login.state.LoginAction
import com.alife.anotherlife.ui.screen.login.state.LoginEffect
import com.alife.anotherlife.ui.screen.login.state.LoginState
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class TestLoginViewModel : ViewModelTest() {

    private lateinit var reduceCollector: MutableList<LoginReduce>
    private lateinit var viewModel: LoginViewModel

    @Before
    fun before() {
        reduceCollector = mutableListOf()
        viewModel = LoginViewModel(FakeLoginReducerBase(reduceCollector))
    }

    @Test
    fun `test all valid actions triggered`() = runTest {
        val testActions = listOf(
            LoginAction.InitAction(),
            LoginAction.AuthTypeAction(AuthType.LOGIN_IN),
            LoginAction.AuthTypeAction(AuthType.REGISTRATION),
            LoginAction.AuthTypeAction(AuthType.AUTH_SERVICE),
        )

        testActions.forEach { action ->
            viewModel.reduce(action)
        }

        assertEquals(reduceCollector.size, 4)
        assertEquals(reduceCollector[0], LoginReduce.INIT)
        assertEquals(reduceCollector[1], LoginReduce.LOGIN_IN)
        assertEquals(reduceCollector[2], LoginReduce.REGISTRATION)
        assertEquals(reduceCollector[3], LoginReduce.AUTH_SERVICE)
    }

    @Test
    fun `test not valid action not triggered`() {
        val didntValidAction = DidntValidAction()

        viewModel.reduce(didntValidAction)

        assertEquals(reduceCollector.size, 0)
    }
}


// Test Realizations
class DidntValidAction : LoginAction {

    override suspend fun onAction(reducer: LoginReducer) {

    }
}

enum class LoginReduce {
    INIT, LOGIN_IN, REGISTRATION, AUTH_SERVICE
}

class FakeLoginReducerBase(
    private val reduceCollector: MutableList<LoginReduce>,
) : AbstractVMReducer<LoginState, LoginEffect>(), BaseLoginReducerBase {

    override val uiStore: UIStore<LoginState, LoginEffect> = EmptyUIStore()

    override fun getStateCollector(): StateCollector<LoginState> = FakeStateCollector(emptyList())
    override fun getEffectCollector(): EffectCollector<LoginEffect> = FakeEffectCollector()

    override fun onInit() {
        reduceCollector.add(LoginReduce.INIT)
    }

    override fun onLoginIn() {
        reduceCollector.add(LoginReduce.LOGIN_IN)
    }

    override suspend fun onRegistration() {
        reduceCollector.add(LoginReduce.REGISTRATION)
    }

    override fun onAuthService() {
        reduceCollector.add(LoginReduce.AUTH_SERVICE)
    }
}