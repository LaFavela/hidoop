package com.papela.hidoop.presentation.chat.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.papela.hidoop.presentation.chat.common.SentChatBubbleSurface

@Composable
fun RegularSent(content: String) {
    SentChatBubbleSurface {
        Text(
            text = content,
            modifier = Modifier.padding(16.dp)
        )
    }
}