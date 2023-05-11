package com.alife.anotherlife.core.composable.text.style

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.button.ButtonBase
import com.alife.anotherlife.core.composable.text.TextBase
import com.alife.anotherlife.theme.Shapes

@Composable
fun Button18(
    @StringRes text: Int,
    modifier: Modifier = Modifier,
    shape: Shape = Shapes.medium,
    onClick: () -> Unit,
) {
    Button18(stringResource(text), modifier, shape, onClick)
}

@Composable
fun Button18(
    text: String,
    modifier: Modifier = Modifier,
    shape: Shape = Shapes.medium,
    onClick: () -> Unit,
) {
    ButtonBase(
        onClick = onClick,
        shape = shape,
        contentPadding = PaddingValues(vertical = 16.dp),
        modifier = modifier.fillMaxWidth()
    ) {
        Text(text = text, fontSize = 18.sp, textAlign = TextAlign.Center)
    }
}


@Preview
@Composable
fun TextButton18Preview() {
    Button18(onClick = { /*TODO*/ }, text = R.string.app_name)
}