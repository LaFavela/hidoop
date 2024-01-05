package com.papela.hidoop.presentation.chat.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.papela.hidoop.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInput() {
    Box() {
        var inputText by remember { mutableStateOf("") }
        TextField(
            modifier = Modifier
                .width(300.dp),
            value = inputText,
            onValueChange = { inputText = it },
            placeholder = { Text("Type a message") },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = MaterialTheme.colorScheme.surfaceColorAtElevation(1.dp),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,

                ),
            shape = RoundedCornerShape(50.dp),
            trailingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_keyboard_voice_24),
                        contentDescription = "Send"
                    )
                }
            }

        )
    }
}

@Preview
@Composable
fun TextInputPreview() {
    TextInput()
}