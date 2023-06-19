package com.alife.anotherlife.core.composable.text.code

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alife.anotherlife.core.composable.clickableNoRipple
import com.alife.anotherlife.core.composable.text.code.model.CodeModel
import com.alife.anotherlife.core.composable.text.code.model.FocusBorderMapper
import com.alife.anotherlife.core.composable.text.code.state.CodeAction
import com.alife.anotherlife.theme.Shapes

@Composable
fun CodeTextOutlined(
    codeModel: CodeModel,
    codeViewModel: CodeViewModel,
    modifier: Modifier = Modifier,
    contentPaddingValues: PaddingValues = PaddingValues(),
) {
    val focusRequester = remember { FocusRequester() }
    val focusModifier = Modifier.focusRequester(focusRequester)
    val focusManager = LocalFocusManager.current

    val isFocused = rememberSaveable { mutableStateOf(false) }

    Row(
        modifier = modifier
            .then(focusModifier)
            .border(
                FocusBorderMapper().map(value = isFocused.value),
                shape = Shapes.small
            )
            .onFocusChanged { state ->
                isFocused.value = state.hasFocus
            }
            .padding(20.dp)
            .padding(paddingValues = contentPaddingValues)
            .clickableNoRipple {
                focusManager.clearFocus()
                focusRequester.requestFocus()
            },
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        BasicTextField(
            value = codeModel.code,
            cursorBrush = SolidColor(Color.Unspecified),
            onValueChange = { newCode ->
                codeViewModel.map(CodeAction.CodeInput(newCode))
            },
            maxLines = 1,
            textStyle = LocalTextStyle.current.copy(
                textAlign = TextAlign.Start,
                letterSpacing = 5.sp
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = focusModifier.width(IntrinsicSize.Min)
        )
        Text(
            (codeModel.code.length until codeViewModel.limit).joinToString("") {
                codeViewModel.maskSymbol.toString()
            },
            maxLines = 1,
            textAlign = TextAlign.End,
            letterSpacing = 5.sp,
            modifier = focusModifier
                .width(IntrinsicSize.Min)
                .clickableNoRipple {
                    focusManager.clearFocus()
                    focusRequester.requestFocus()
                }
        )
    }
}

@Preview
@Composable
fun CodeTextOutlinedPreview() {
    CodeTextOutlined(codeModel = CodeModel.Init(), codeViewModel =
    object : CodeViewModel {
        override val limit: Int = 6
        override val maskSymbol: Char = '*'

        override fun map(inputModel: CodeAction) {}
    }
    )
}