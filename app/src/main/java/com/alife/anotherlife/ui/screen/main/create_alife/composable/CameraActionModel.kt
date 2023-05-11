package com.alife.anotherlife.ui.screen.main.create_alife.composable

import androidx.constraintlayout.compose.ConstraintSetScope
import com.alife.anotherlife.core.composable.view_group.constraint_layout.ConstraintModel

class CameraActionModel(
    val cameraActionsPager: String = "cameraActionsPager",
    val invertCameraButton: String = "invertCameraButton"
) : ConstraintModel<CameraActionsReferenceModel> {

    override fun createRefs(scope: ConstraintSetScope) = with(scope) {
        CameraActionsReferenceModel(
            createRefFor(cameraActionsPager),
            createRefFor(invertCameraButton)
        )
    }
}