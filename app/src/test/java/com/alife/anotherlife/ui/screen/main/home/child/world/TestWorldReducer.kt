package com.alife.anotherlife.ui.screen.main.home.child.world

import com.alife.anotherlife.core.FakeUIStore
import com.alife.anotherlife.ui.screen.main.home.child.friends.FakeProfileCardUseCase
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.mapper.ProfileCardEntityToUICard
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.UICardModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.UIPlzCreateAlifeCardModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.UIProfileCardModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildState
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.world.WorldReducerBase
import com.alife.domain.core.usecase.UseCaseResult
import com.alife.domain.main.home.child.ProfileCardEntity
import com.alife.domain.main.home.child.ProfileUseCaseEntity
import junit.framework.TestCase
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import java.util.*

class TestWorldReducer {

    private lateinit var uiStore: FakeUIStore<HomeChildState, HomeChildEffect>
    private lateinit var reducer: WorldReducerBase

    @Before
    fun before() {
        uiStore = FakeUIStore(HomeChildState())
    }

    private fun setupReducer(
        useCaseResult: UseCaseResult<ProfileUseCaseEntity>,
        listUICardModel: List<UICardModel>? = null,
    ) {
        listUICardModel?.also {
            uiStore = FakeUIStore(HomeChildState(listUICardModel))
        }
        reducer = WorldReducerBase(
            uiStore,
            ProfileCardEntityToUICard(),
            FakeProfileCardUseCase(useCaseResult)
        )
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `test init usecase result success with data`() = runTest {
        val uiProfileCardModel = testUIProfileCardModel()

        setupReducer(
            UseCaseResult.Success(ProfileUseCaseEntity(emptyList())),
            listOf(uiProfileCardModel)
        )
        reducer.onInit()

        val actual = uiStore.stateCollector.last()

        assertEquals(1, uiStore.stateCollector.size)
        assertEquals(uiProfileCardModel, actual.profileList.last())
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `test init usecase result success empty`() = runTest {
        setupReducer(useCaseResult = UseCaseResult.Success(ProfileUseCaseEntity(emptyList())))
        reducer.onInit()

        val expected = listOf<UICardModel>(UIPlzCreateAlifeCardModel())

        val actual = uiStore.stateCollector.last()

        TestCase.assertEquals(2, uiStore.stateCollector.size)
        TestCase.assertTrue(actual.profileList.last() is UIPlzCreateAlifeCardModel)
        //assertEquals(expected, actual)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `test init usecase result success not empty`() = runTest {
        val profileUseCaseEntity = ProfileUseCaseEntity(testListProfileCardEntity())

        setupReducer(useCaseResult = UseCaseResult.Success(profileUseCaseEntity))
        reducer.onInit()

        val expected =
            UIProfileCardModel("avatar", "frontAlife", "backAlife", Date().toString(), "avatar")

        val actual = uiStore.stateCollector.last()

        TestCase.assertEquals(2, uiStore.stateCollector.size)
        TestCase.assertEquals(1, actual.profileList.size)
        TestCase.assertTrue(actual.profileList.last() is UIProfileCardModel)
        TestCase.assertEquals(expected, actual.profileList.last())
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `test init usecase result fail`() = runTest {
        reducer.onInit()

        // TODO add errors on ui
    }
}


// Test Realizations
fun testListProfileCardEntity() = listOf(
    ProfileCardEntity(
        "avatar",
        "frontAlife",
        "backAlife",
        Date(),
        "avatar"
    )
)

fun testUIProfileCardModel() = UIProfileCardModel(
    "avatar",
    "frontAlife",
    "backAlife",
    Date().toString(),
    "avatar"
)