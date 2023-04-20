package com.alife.anotherlife.ui.screen.main.create_alife.composable

import androidx.constraintlayout.compose.ConstraintSetScope
import com.alife.anotherlife.core.composable.view_group.constraint_layout.ConstraintSetMarkup

class CameraActionsConstraints : ConstraintSetMarkup<CameraActionModel, CameraActionsReferenceModel> {

    override fun safeMarkup(scope: ConstraintSetScope, refsModel: CameraActionsReferenceModel) {
        with(scope) {
            constrain(refsModel.cameraActionsPager) {
                linkTo(
                    start = parent.start,
                    end = parent.end,
                    top = parent.top,
                    bottom = parent.bottom
                )
            }

            constrain(refsModel.invertCameraButton) {
                start.linkTo(refsModel.cameraActionsPager.end)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            }
        }
    }
}