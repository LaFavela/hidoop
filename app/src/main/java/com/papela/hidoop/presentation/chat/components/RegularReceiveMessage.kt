package com.papela.hidoop.presentation.chat.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.papela.hidoop.util.getScreenWidth

@Composable
fun RegularReceiveMessage(content: String) {
    Column {
        Surface(
            shape = RoundedCornerShape(
                topStart = 0.dp,
                topEnd = 15.dp,
                bottomEnd = 15.dp,
                bottomStart = 15.dp
            ),
            color = MaterialTheme.colorScheme.surfaceColorAtElevation(1.dp),
            modifier = Modifier.widthIn(max = (getScreenWidth() * 0.75f).dp)
        ) {
            Text(
                text = content,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}