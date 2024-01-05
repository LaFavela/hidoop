package com.papela.hidoop.presentation.chat.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.papela.hidoop.util.getScreenWidth

@Composable
fun ReceiveChatBubbleSurface(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.End
    ) {
        Surface(
            shape = RoundedCornerShape(
                topStart = 15.dp,
                topEnd = 0.dp,
                bottomEnd = 15.dp,
                bottomStart = 15.dp
            ),
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.widthIn(max = (getScreenWidth() * 0.75f).dp)
        ) {
            content()
        }
    }
}

@Composable
fun SentChatBubbleSurface(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
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
            content()
        }
    }
}