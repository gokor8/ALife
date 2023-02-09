//package com.example.testnavigation.screens.core.compose_bases.button
//
//import androidx.compose.foundation.layout.PaddingValues
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.padding
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import com.example.testnavigation.R
//import com.alife.anotherlife.core.composable.image.ImageBase
//import com.alife.anotherlife.core.composable.text.TextBase
//import com.example.testnavigation.screens.core.styles.text_style.title.Title18TextStyle
//import com.github.terrakok.modo.stack.StackScreen
//import com.github.terrakok.modo.stack.back
//
//@Composable
//fun BackTransparentButton(
//    containerScreen: StackScreen,
//    textResId: Int = R.string.back,
//    contentPadding: PaddingValues = PaddingValues(start = 12.dp, end = 8.dp)
//) = TransparentButton(
//    onClick = { containerScreen.back() },
//    contentPadding = contentPadding
//) {
//    Row(verticalAlignment = Alignment.CenterVertically) {
//        ImageBase(
//            R.drawable.ic_arrow_left,
//            modifier = Modifier.padding(end = 22.dp)
//        )
//        TextBase(
//            textResId,
//            style = Title18TextStyle()
//        )
//    }
//}