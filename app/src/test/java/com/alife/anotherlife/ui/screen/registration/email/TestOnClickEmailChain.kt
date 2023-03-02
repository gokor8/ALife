package com.alife.anotherlife.ui.screen.registration.email

import com.alife.anotherlife.ui.screen.registration.base.chain.EmptyTextChain
import com.alife.anotherlife.ui.screen.registration.base.chain.RegChainValidator
import com.alife.anotherlife.ui.screen.registration.base.chain.base.RegChainState
import com.alife.anotherlife.ui.screen.registration.email.chain.EmailRegTextChain
import junit.framework.TestCase
import junit.framework.TestCase.assertTrue
import org.junit.Test

class TestOnClickEmailChain {

    private val emailChain = RegChainValidator(
        EmptyTextChain(),
        EmailRegTextChain()
    )

    @Test
    fun `test success chain`() {
        val testData = listOf("aboba@bk.ri", "Aboba1@bk.riiii", "abobaaaa123@aaaaaa.aaa")

        testData.forEach { testString ->
            val actual = emailChain.handle(testString)
            
            assertTrue(actual is RegChainState.Success)
        }
    }

    @Test
    fun `test fail chain`() {
        val testData = listOf("", " aboba", "1aboba", "aboba ", ".aboba", "aboba@a")

        testData.forEach { testString ->
            val actual = emailChain.handle(testString)

            assertTrue(actual is RegChainState.Fail)
        }
    }
}