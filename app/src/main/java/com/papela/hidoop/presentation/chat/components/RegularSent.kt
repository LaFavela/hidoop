package com.papela.hidoop.presentation.chat.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.papela.hidoop.presentation.chat.common.SentChatBubbleSurface

@Composable
fun RegularSent(content: String) {
    SentChatBubbleSurface {
        Text(
            text = content,
            modifier = it
        )
    }
}