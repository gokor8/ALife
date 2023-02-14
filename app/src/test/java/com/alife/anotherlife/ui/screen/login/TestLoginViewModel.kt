package com.alife.anotherlife.ui.screen.login

import com.alife.anotherlife.core.FakeUIStore
import com.alife.anotherlife.core.ViewModelTest
import com.alife.anotherlife.core.ui.state_collector.StateCollector
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.login.model.AuthType
import com.alife.anotherlife.ui.screen.login.reducer.AbstractLoginReducer
import com.alife.anotherlife.ui.screen.login.reducer.LoginReducer
import com.alife.anotherlife.ui.screen.login.state.LoginAction
import com.alife.anotherlife.ui.screen.login.state.LoginState
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
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
        viewModel = LoginViewModel(FakeLoginReducer(reduceCollector))
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
    override fun onAction(reducer: LoginReducer) {}
}

enum class LoginReduce {
    INIT, LOGIN_IN, REGISTRATION, AUTH_SERVICE
}

class FakeLoginReducer(
    private val reduceCollector: MutableList<LoginReduce>,
) : AbstractLoginReducer() {

    // Переписать на интерфейс + интерфейс принимает вью модель
    override val uiStore: UIStore<LoginState, Nothing> = FakeUIStore()

    // Didnt need
    override fun getState(): StateCollector<LoginState> {
        return uiStore.getStateCollector()
    }

    override fun onInit() {
        reduceCollector.add(LoginReduce.INIT)
    }

    override fun onLoginIn() {
        reduceCollector.add(LoginReduce.LOGIN_IN)
    }

    override fun onRegistration() {
        reduceCollector.add(LoginReduce.REGISTRATION)
    }

    override fun onAuthService() {
        reduceCollector.add(LoginReduce.AUTH_SERVICE)
    }
}