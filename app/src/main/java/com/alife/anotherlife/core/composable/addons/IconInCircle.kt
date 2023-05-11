package com.alife.anotherlife.core.composable.addons

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.image.ImageBase

@Composable
fun IconInCircle(
    @DrawableRes icon: Int,
    tint: Color,
    circleTint: Color,
    modifier: Modifier = Modifier,
    iconPaddingValues: PaddingValues = PaddingValues(18.dp),
) {
    ImageBase(
        resId = icon,
        colorFilter = ColorFilter.tint(tint),
        modifier = modifier
            .size(72.dp)
            .drawBehind { drawCircle(circleTint) }
            .padding(iconPaddingValues)
    )
}

@Preview
@Composable
fun IconInCirclePreview() {
    IconInCircle(
        icon = R.drawable.ic_base_error,
        tint = MaterialTheme.colorScheme.onTertiary,
        circleTint = MaterialTheme.colorScheme.tertiary
    )
}