package com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home.pager_screens.base_pager_screen.compose

import androidx.constraintlayout.compose.ConstrainedLayoutReference
import com.alife.anotherlife.core.composable.view_group.constraint_layout.ConstraintReferenceModel

class ProfileCardReferenceModel(
    val profileIcon: ConstrainedLayoutReference,
    val username: ConstrainedLayoutReference,
    val timestamp: ConstrainedLayoutReference,
    val alife: ConstrainedLayoutReference
) : ConstraintReferenceModel