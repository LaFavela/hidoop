package com.papela.hidoop.presentation.chat.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.papela.hidoop.presentation.chat.common.ReceiveChatBubbleSurface

@Composable
fun RegularReceive(content: String) {
    ReceiveChatBubbleSurface {
        Text(
            text = content,
            modifier = it
        )
    }
}