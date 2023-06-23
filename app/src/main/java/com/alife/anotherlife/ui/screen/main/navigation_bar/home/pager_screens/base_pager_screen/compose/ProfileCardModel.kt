package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.compose

import androidx.constraintlayout.compose.ConstraintSetScope
import com.alife.anotherlife.core.composable.view_group.constraint_layout.ConstraintModel

class ProfileCardModel(
    val profileIcon: String = "profileIcon",
    val username: String = "username",
    val timestamp: String = "timestamp",
    val alife: String = "alife"
) : ConstraintModel<ProfileCardReferenceModel> {

    override fun createRefs(scope: ConstraintSetScope) = with(scope) {
        ProfileCardReferenceModel(
            createRefFor(profileIcon),
            createRefFor(username),
            createRefFor(timestamp),
            createRefFor(alife)
        )
    }
}