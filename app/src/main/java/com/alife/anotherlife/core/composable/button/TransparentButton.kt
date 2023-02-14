//package com.example.testnavigation.screens.core.compose_bases.button
//
//import androidx.compose.foundation.BorderStroke
//import androidx.compose.foundation.interaction.MutableInteractionSource
//import androidx.compose.foundation.layout.PaddingValues
//import androidx.compose.foundation.layout.RowScope
//import androidx.compose.material.Button
//import androidx.compose.material.ButtonColors
//import androidx.compose.material.ButtonDefaults
//import androidx.compose.material.ButtonElevation
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.Shape
//import com.example.testnavigation.ui.theme.Shapes
//
//@Composable
//fun TransparentButton(
//    onClick: () -> Unit,
//    modifier: Modifier = Modifier,
//    enabled: Boolean = true,
//    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
//    elevation: ButtonElevation? = null,
//    shape: Shape = Shapes.small,
//    border: BorderStroke? = null,
//    colors: ButtonColors = ButtonDefaults.buttonColors(
//        backgroundColor = Color.Transparent,
//        disabledBackgroundColor = Color.Transparent,
//    ),
//    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
//    content: @Composable RowScope.() -> Unit
//) {
//    Button(
//        onClick = onClick,
//        elevation = elevation,
//        colors = colors,
//        enabled = enabled,
//        interactionSource = interactionSource,
//        shape = shape,
//        border = border,
//        contentPadding = contentPadding,
//        modifier = modifier,
//        content = content
//    )
//}