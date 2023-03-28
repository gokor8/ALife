package com.alife.anotherlife.core.composable.text

import androidx.annotation.StringRes
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alife.anotherlife.core.ui.state.error_text.TextErrorModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HintErrorTextOutlined(
    value: String,
    onValueChange: (String) -> Unit,
    @StringRes placeholderTextRes: Int,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = LocalTextStyle.current,
    label: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    supportingText: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = RoundedCornerShape(4.0.dp),
    colors: TextFieldColors = TextFieldDefaults.outlinedTextFieldColors(),
) {
    OutlinedTextFieldBase(
        value,
        onValueChange,
        modifier,
        enabled,
        readOnly,
        textStyle,
        label,
        {
            TextBase(
                textResId = placeholderTextRes,
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.onBackground
            )
        },
        leadingIcon,
        trailingIcon,
        supportingText,
        isError,
        visualTransformation,
        keyboardOptions,
        keyboardActions,
        singleLine,
        maxLines,
        interactionSource,
        shape,
        colors
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ColumnScope.HintErrorTextOutlined(
    textErrorModel: TextErrorModel,
    onValueChange: (TextFieldValue) -> Unit,
    @StringRes placeholderTextRes: Int,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = LocalTextStyle.current,
    label: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    supportingText: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = RoundedCornerShape(4.0.dp),
    colors: TextFieldColors = TextFieldDefaults.outlinedTextFieldColors(),
) {
    OutlinedTextField(
        textErrorModel.textFieldValue,
        onValueChange,
        modifier,
        enabled,
        readOnly,
        textStyle,
        label,
        {
            TextBase(
                textResId = placeholderTextRes,
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.onBackground
            )
        },
        leadingIcon,
        trailingIcon,
        supportingText,
        textErrorModel.errorResId?.run { true } ?: false,
        visualTransformation,
        keyboardOptions,
        keyboardActions,
        singleLine,
        maxLines,
        interactionSource,
        shape,
        colors
    )
    Text(
        text = textErrorModel.errorResId?.let { stringResource(it) } ?: "",
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.End,
        color = MaterialTheme.colorScheme.error
    )
}