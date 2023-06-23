package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.compose

import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintSetScope
import com.alife.anotherlife.core.composable.view_group.constraint_layout.ConstraintMarkup

class ProfileCardConstraints :
    ConstraintMarkup.Abstract<ProfileCardModel, ProfileCardReferenceModel>() {

    override fun safeMarkup(scope: ConstraintSetScope, refsModel: ProfileCardReferenceModel) {
        with(scope) {
            constrain(refsModel.profileIcon) {
                linkTo(
                    top = parent.top,
                    bottom = refsModel.timestamp.bottom,
                    bias = 0.5f,
                )
            }

            val rightBarrier = createEndBarrier(refsModel.profileIcon, margin = 6.dp)

            constrain(refsModel.username) {
                start.linkTo(rightBarrier)
                linkTo(
                    top = parent.top,
                    bottom = refsModel.timestamp.top,
                    bottomMargin = 1.dp
                )
            }

            constrain(refsModel.timestamp) {
                start.linkTo(rightBarrier)
                top.linkTo(refsModel.username.bottom)
            }

            constrain(refsModel.alife) {
                top.linkTo(refsModel.profileIcon.bottom, margin = 26.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            }
        }
    }
}