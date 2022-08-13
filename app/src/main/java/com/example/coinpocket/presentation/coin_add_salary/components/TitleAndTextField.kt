package com.example.coinpocket.presentation.coin_add_salary.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import org.w3c.dom.Text

@Composable
fun TitleAndTextField(
    @StringRes title: Int,
    text:String,
    modifier: Modifier = Modifier,
    keyboardType: KeyboardType = KeyboardType.Text,
    onValueChange: (String) -> Unit,
    textStyle: TextStyle = TextStyle(),
    singleLine: Boolean = false,
) {
    Row(
        modifier
    ) {
        Text(text = stringResource(id = title))
        Spacer(modifier = modifier.width(6.dp))
        BasicTextField(
            value = text,
            onValueChange = onValueChange,
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),
            singleLine = singleLine,
            textStyle = textStyle,
            modifier = Modifier
                .fillMaxWidth()
        )
       
    }
}