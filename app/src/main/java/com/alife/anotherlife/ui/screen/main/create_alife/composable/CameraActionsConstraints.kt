package com.alife.anotherlife.ui.screen.main.create_alife.composable

import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintSetScope
import com.alife.anotherlife.core.composable.view_group.constraint_layout.ConstraintMarkup

class CameraActionsConstraints : ConstraintMarkup.Abstract<CameraActionModel, CameraReferenceModel>() {

    override fun safeMarkup(scope: ConstraintSetScope, refsModel: CameraReferenceModel) {
        with(scope) {
            constrain(refsModel.cameraActionsPager) {
                linkTo(
                    start = parent.start,
                    end = parent.end,
                    top = parent.top,
                    bottom = parent.bottom,
                    endMargin = 92.dp
                )
            }

            constrain(refsModel.invertCameraButton) {
                start.linkTo(refsModel.cameraActionsPager.end, margin = 32.dp)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            }
        }
    }
}