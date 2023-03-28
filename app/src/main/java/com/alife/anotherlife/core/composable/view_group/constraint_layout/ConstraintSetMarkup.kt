package com.alife.anotherlife.core.composable.view_group.constraint_layout

import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.ConstraintSetScope

interface ConstraintSetMarkup<CL : ConstraintModel<M>, M : ConstraintReferenceModel> {

    fun markup(refsModel: CL): ConstraintSet {
        return ConstraintSet {
            safeMarkup(
                scope = this,
                refsModel = refsModel.createRefs(this)
            )
        }
    }

    fun safeMarkup(scope: ConstraintSetScope, refsModel: M)
}