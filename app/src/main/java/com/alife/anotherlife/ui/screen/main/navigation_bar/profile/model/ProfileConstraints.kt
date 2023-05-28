package com.alife.anotherlife.ui.screen.main.navigation_bar.profile.model

import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import androidx.constraintlayout.compose.ConstraintSetScope
import androidx.constraintlayout.compose.Dimension
import com.alife.anotherlife.core.composable.view_group.constraint_layout.ConstraintModel
import com.alife.anotherlife.core.composable.view_group.constraint_layout.ConstraintReferenceModel
import com.alife.anotherlife.core.composable.view_group.constraint_layout.ConstraintMarkup

class ProfileReferenceModel(
    val topBar: ConstrainedLayoutReference,
    val image: ConstrainedLayoutReference,
    val preBottom: ConstrainedLayoutReference,
    val bottom: ConstrainedLayoutReference,
) : ConstraintReferenceModel

class ProfileConstraintModel(
    val topBar: String = "topBar",
    val image: String = "image",
    val preBottom: String = "preBottom",
    val bottom: String = "bottom"
) : ConstraintModel<ProfileReferenceModel> {

    override fun createRefs(scope: ConstraintSetScope) = with(scope) {
        ProfileReferenceModel(
            createRefFor(topBar),
            createRefFor(image),
            createRefFor(preBottom),
            createRefFor(bottom),
        )
    }
}

class ProfileConstraints :
    ConstraintMarkup.Abstract<ProfileConstraintModel, ProfileReferenceModel>() {

    override fun safeMarkup(scope: ConstraintSetScope, refsModel: ProfileReferenceModel) {
        with(scope) {
            constrain(refsModel.topBar) {
                width = Dimension.matchParent
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }

            constrain(refsModel.image) {
                width = Dimension.matchParent
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(parent.top)
            }

            constrain(refsModel.preBottom) {
                width = Dimension.matchParent
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(refsModel.image.bottom)
            }

            constrain(refsModel.bottom) {
                width = Dimension.matchParent
                //height = Dimension.matchParent
                linkTo(
                    start = parent.start,
                    end = parent.end,
                    top = refsModel.image.bottom,
                    bottom = parent.bottom,
                    verticalBias = 0f
                )
            }
        }
    }
}