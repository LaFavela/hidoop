package com.papela.hidoop.presentation.chat.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.papela.hidoop.util.getScreenWidth

@Composable
fun RegularSentMessage(content: String) {
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
            Text(
                text = content,
                modifier = Modifier
                    .padding(16.dp)
            )
        }
    }
}