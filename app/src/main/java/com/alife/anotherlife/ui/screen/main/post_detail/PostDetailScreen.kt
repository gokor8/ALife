package com.alife.anotherlife.ui.screen.main.post_detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.icon.IconBase
import com.alife.anotherlife.core.ui.screen.VMScreenLCE
import com.alife.anotherlife.core.ui.state.lce.LCEModel
import com.alife.anotherlife.ui.screen.main.post_detail.model.ErrorLcePostDetailModel
import com.alife.anotherlife.ui.screen.main.post_detail.model.ErrorLcePostDetailModelProvider
import com.alife.anotherlife.ui.screen.main.post_detail.state.PostDetailAction

class PostDetailScreen(
    override val navController: NavController,
    private val username: String
) : VMScreenLCE<PostDetailViewModel>() {

    @Composable
    override fun setupViewModel(): PostDetailViewModel = hiltViewModel()

    override suspend fun onInit() {
        viewModel.reduce(PostDetailAction.Init(username))
    }

    @Composable
    override fun LceStateMap(lceModel: LCEModel, modifier: Modifier) {
        if (lceModel is ErrorLcePostDetailModelProvider) ErrorLcePostDetailModel().ErrorContent {
            navController.popBackStack()
        } else {
            super.LceStateMap(lceModel, modifier)
        }
    }

    @Composable
    override fun SafeContent(modifier: Modifier) {
        val state = viewModel.getUIState().uiPostDetail
        val action = viewModel::reduce

        Column(modifier.padding(horizontal = 20.dp)) {
            Row {
                IconBase(
                    icon = R.drawable.ic_arrow_left,
                    tint = MaterialTheme.colorScheme.onPrimary
                )
                Spacer(modifier = Modifier.weight(1f))
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    TextButton(
                        onClick = {
                            action(PostDetailAction.ClickUsername(username))
                        },
                        contentPadding = PaddingValues(6.dp)
                    ) {
                        Text(text = state.username, fontWeight = FontWeight.Bold)
                    }
                    Text(
                        text = state.timestamp,
                        color = Color.Unspecified.copy(.6f),
                        fontSize = 12.sp
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
            }
            Spacer(modifier = Modifier.height(10.dp))
            state.uiPostMedia.MediaContent(modifier = Modifier.fillMaxSize())
        }
    }
}