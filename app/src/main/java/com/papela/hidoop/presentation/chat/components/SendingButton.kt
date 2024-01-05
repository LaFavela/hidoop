package com.papela.hidoop.presentation.chat.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SendingButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val scaleState = remember { mutableStateOf(1f) }

    Box(
        modifier = modifier
            .size(45.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary)
            .clickable { onClick() }
            .graphicsLayer(scaleX = scaleState.value, scaleY = scaleState.value)
    ) {
        Icon(
            imageVector = Icons.Default.Send,
            contentDescription = "Send",
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 2.dp)
                .padding(vertical = 4.dp)
                .clip(CircleShape)
                .graphicsLayer(
                    scaleX = 0.5f / scaleState.value,
                    scaleY = 0.5f / scaleState.value
                ),
            tint = MaterialTheme.colorScheme.onPrimary
        )
    }
}

@Preview
@Composable
fun PreviewSendButton() {
   SendingButton( onClick = { /*TODO*/ })
}