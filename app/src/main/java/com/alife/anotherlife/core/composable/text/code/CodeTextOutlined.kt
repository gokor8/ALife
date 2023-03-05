package com.alife.anotherlife.core.composable.text.code

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alife.anotherlife.core.composable.clickableNoRipple
import com.alife.anotherlife.core.composable.text.code.model.CodeModel
import com.alife.anotherlife.core.composable.text.code.state.CodeAction

@Composable
fun CodeTextOutlined(
    codeModel: CodeModel,
    codeViewModel: CodeViewModel,
    modifier: Modifier = Modifier
) {
    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current

    Row(
        modifier = modifier
            .clickableNoRipple {
                focusManager.clearFocus()
                focusRequester.requestFocus()
            }
            .padding(20.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        BasicTextField(
            value = codeModel.code,
            onValueChange = { newCode ->
                codeViewModel.map(CodeAction.CodeInput(newCode))
            },
            maxLines = 1,
            textStyle = LocalTextStyle.current.copy(
                textAlign = TextAlign.Start,
                letterSpacing = 5.sp
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .focusRequester(focusRequester)
                .width(IntrinsicSize.Min)
        )
        Text(
            (codeModel.code.length until codeViewModel.limit).joinToString("") {
                codeViewModel.maskSymbol.toString()
            },
            maxLines = 1,
            textAlign = TextAlign.End,
            letterSpacing = 5.sp,
            modifier = Modifier
                .clickableNoRipple {
                    focusManager.clearFocus()
                    focusRequester.requestFocus()
                }
                .width(IntrinsicSize.Min)
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