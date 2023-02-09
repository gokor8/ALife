package com.alife.anotherlife.ui.screen.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.view_group.CustomColumn
import com.alife.anotherlife.core.ui.screen.Screen
import com.alife.anotherlife.core.composable.text.TextBase

class LoginScreen : Screen {

    @Composable
    override fun Content() = CustomColumn() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            TextBase(textResId = R.string.pass_login_in)
        }

        val stringIdsItems = remember {
            listOf(
                R.string.login_in,
                R.string.registration,
            )
        }

        LazyHorizontalGrid(
            rows = GridCells.Adaptive(45.dp),
            reverseLayout = true,
            contentPadding = PaddingValues(vertical = 5.dp, horizontal = 5.dp)
        ) {
            item(
                span = { GridItemSpan(maxLineSpan) }
            ) {
                TextBase(
                    textResId = R.string.horizontal_logo,
                    modifier = Modifier.padding(start = 22.dp, end = 21.dp)
                        .height(IntrinsicSize.Max)
                        .width(5.dp)
                )
            }
            item(
                span = { GridItemSpan(0) }
            ) {
                TextBase(textResId = R.string.authorization_type)
                Spacer(modifier = Modifier.padding(bottom = 14.dp))
            }

            items(stringIdsItems.size) {
                Button(onClick = { /*TODO*/ }, modifier = Modifier) {
                    TextBase(textResId = stringIdsItems[it])
                }
            }
        }
    }
}
