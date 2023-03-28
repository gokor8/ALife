package com.alife.anotherlife.core.composable.view_group.constraint_layout

import androidx.compose.runtime.Composable
import androidx.constraintlayout.compose.ConstraintSetScope

interface ConstraintModel<M : ConstraintReferenceModel> {

    fun createRefs(scope: ConstraintSetScope): M
}