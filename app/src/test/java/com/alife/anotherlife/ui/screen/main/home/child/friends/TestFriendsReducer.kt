package com.alife.anotherlife.ui.screen.main.home.child.friends

import com.alife.anotherlife.core.FakeUIStore
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.mapper.ProfileCardEntityToUICard
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildState
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.friends.FriendsReducer
import com.alife.domain.core.usecase.UseCaseResult
import com.alife.domain.main.home.child.BaseProfileCardUseCase
import com.alife.domain.main.home.child.ProfileUseCaseEntity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class TestFriendsReducer {

    private lateinit var uiStore: FakeUIStore<HomeChildState, HomeChildEffect>
    private lateinit var reducer: FriendsReducer

    @Before
    fun before() {
        uiStore = FakeUIStore(HomeChildState())
    }

    private fun setupReducer(useCaseResult: UseCaseResult<ProfileUseCaseEntity>) {
        reducer = FriendsReducer(
            uiStore,
            ProfileCardEntityToUICard(),
            FakeProfileCardUseCase(useCaseResult)
        )
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `test init usecase result success empty`() = runTest {
        reducer.onInit()

        
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `test init usecase result success not empty`() = runTest {
        reducer.onInit()


    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `test init usecase result fail`() = runTest {
        reducer.onInit()


    }

    // Fake Realization
    class FakeProfileCardUseCase(
        private val useCaseResult: UseCaseResult<ProfileUseCaseEntity>
    ) : BaseProfileCardUseCase {
        override suspend fun getProfileCards(): UseCaseResult<ProfileUseCaseEntity> {
            return useCaseResult
        }
    }
}