package com.alife.anotherlife.core.composable.view_group.constraint_layout

import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.ConstraintSetScope

interface ConstraintMarkup<CL : ConstraintModel<*>> {

    fun markup(refsModel: CL): ConstraintSet


    abstract class Abstract<CL : ConstraintModel<M>, M : ConstraintReferenceModel> :
        ConstraintMarkup<CL> {

        override fun markup(refsModel: CL): ConstraintSet {
            return ConstraintSet {
                safeMarkup(
                    scope = this,
                    refsModel = refsModel.createRefs(this)
                )
            }
        }

        protected abstract fun safeMarkup(scope: ConstraintSetScope, refsModel: M)
    }
}