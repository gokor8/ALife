package com.alife.anotherlife.core.composable.addons

import android.content.res.Configuration
import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.alife.anotherlife.R

@Composable
fun AlifeLogo(
    modifier: Modifier = Modifier,
    size: Dp = 24.dp,
) {
    val textSizePx = with(LocalDensity.current) { size.toPx() / 2 }

    val font = LocalContext.current.resources.getFont(R.font.source_code_pro_extralight)
    val paint = Paint().apply {
        textAlign = Paint.Align.CENTER
        textSize = textSizePx
        color = Color(0xFF827f7f).toArgb()
        typeface = font
    }

    Canvas(modifier = modifier.size(size)) {
        drawCircle(Color.White)
        drawContext.canvas.nativeCanvas.drawText("Al", center.x, center.y + (textSizePx / 3), paint)
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, backgroundColor = 0xFF000000)
@Composable
fun AlifeLogoPreview() = Surface {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        AlifeLogo()
    }
}