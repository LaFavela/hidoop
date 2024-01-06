package com.papela.hidoop.presentation.chat.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.papela.hidoop.presentation.chat.common.ReceiveChatBubbleSurface

@Composable
fun OptionReceive(title: String, content: String, options: List<String>) {
    var selected by remember { mutableIntStateOf(-1) }
    ReceiveChatBubbleSurface {
        Column {
            Text(
                text = title,
                modifier = Modifier
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp),
                fontWeight = FontWeight.Medium
            )
            Text(
                text = content,
                modifier = Modifier
                    .padding(vertical = 8.dp, horizontal = 16.dp)
            )
            options.forEachIndexed { index, option ->
                RoundedRadioButton(
                    option = option,
                    isSelected = selected == index,
                    onClick = { selected = index }
                )
            }
            Surface(modifier = Modifier.height(8.dp)) {}
        }
    }
}

@Composable
fun RoundedRadioButton(
    option: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val surfaceColor: Color by animateColorAsState(
        if (!isSelected)  MaterialTheme.colorScheme.surfaceColorAtElevation(1.dp) else MaterialTheme.colorScheme.primary,
        label = "Option"
    )
    Surface(
        shape = RoundedCornerShape(
            topStart = 15.dp,
            topEnd = 15.dp,
            bottomEnd = 15.dp,
            bottomStart = 15.dp
        ),
        color = surfaceColor,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp, start = 16.dp, end = 16.dp),
        onClick = onClick
    ) {
        Text(
            text = option,
            modifier = Modifier
                .padding(vertical = 8.dp, horizontal = 16.dp),
        )
    }
}