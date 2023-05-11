package com.alife.anotherlife.ui.screen.registration.reg_test

import com.alife.anotherlife.core.FakeUIStore
import com.alife.anotherlife.ui.screen.registration.base.chain.base.RegChainState
import com.alife.anotherlife.ui.screen.registration.base.model.RegistrationModel
import com.alife.anotherlife.ui.screen.registration.base.reducer.BaseRegistrationReducer
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationEffect
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationState
import com.alife.anotherlife.ui.screen.registration.name.*
import com.alife.anotherlife.ui.screen.registration.reg_test.model.FakeChainNamRegReducer
import junit.framework.TestCase
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test


class TestAbstractRegistrationReducer {

    private lateinit var uiStore: FakeUIStore<RegistrationState, RegistrationEffect>
    private lateinit var abstractRegistrationReducer: BaseRegistrationReducer.Abstract
    private lateinit var fakeChainNamRegReducer: FakeChainNamRegReducer

    @Before
    fun before() {
        uiStore = FakeUIStore(RegistrationState(RegistrationModel(0, 0)))
        fakeChainNamRegReducer = FakeChainNamRegReducer()
    }

    private fun setupReducer(
        onNextClickRegChainState: RegChainState,
    ) {
        // TODO Fix it
//        abstractRegistrationReducer = FakeAbstractRegistrationReducer(
//            uiStore,
//            FakeNameChainValidator(onNextClickRegChainState),
//            fakeChainNamRegReducer,
//        )
    }

    @Test
    fun `test on continue click expect nothing changed`() = runTest {
        setupReducer(FakeFailNameRegChain())

        abstractRegistrationReducer.onNextClick()

        TestCase.assertEquals(1, uiStore.stateCollector.size)
        TestCase.assertTrue(fakeChainNamRegReducer.resultContainer != 0)
    }

    @Test
    fun `test on continue click expect changed state`() = runTest {
        setupReducer(FakeSuccessNameRegChain())

        abstractRegistrationReducer.onNextClick()

        val expectedValue = 0

        TestCase.assertEquals(1, uiStore.stateCollector.size)
        TestCase.assertEquals(expectedValue, fakeChainNamRegReducer.resultContainer)
    }
}