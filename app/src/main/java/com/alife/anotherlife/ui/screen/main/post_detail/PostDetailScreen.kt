package com.alife.anotherlife.ui.screen.main.post_detail

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.alife.anotherlife.core.ui.screen.VMScreenLCE

class PostDetailScreen(override val navController: NavController) : VMScreenLCE<PostDetailViewModel>() {

    @Composable
    override fun setupViewModel(): PostDetailViewModel = hiltViewModel()

    @Composable
    override fun SafeContent(modifier: Modifier) {
        
    }
}