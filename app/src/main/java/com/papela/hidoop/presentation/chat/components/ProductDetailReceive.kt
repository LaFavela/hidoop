package com.papela.hidoop.presentation.chat.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.papela.hidoop.presentation.chat.common.ReceiveChatBubbleSurface

@Composable
fun ProductDetailReceive(
    title: String, content: String, img: String, nutrients: MutableMap<String, String>
) {
    ReceiveChatBubbleSurface {
        Surface(
            modifier = it,
            color = MaterialTheme.colorScheme.surfaceColorAtElevation(1.dp),
        ) {
            Column {
                Text(
                    text = title, fontWeight = FontWeight.Medium
                )
                LoadingImage(data = img)
                Text(
                    text = content,
                )
                Spacer(modifier = Modifier.height(8.dp))
                for (nutrient in nutrients) {
                    FoodNutritionComponent(nutrient.key, nutrient.value)
                    if (nutrient != nutrients.entries.last()) Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}

@Composable
fun FoodNutritionComponent(
    nutrients: String, percentage: String, modifier: Modifier = Modifier
) {
    Row {
        Surface(
            shape = RoundedCornerShape(
                bottomStart = 15.dp,
                topStart = 15.dp,
            ),
            color = MaterialTheme.colorScheme.surfaceColorAtElevation(100.dp),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.surfaceColorAtElevation(100.dp)),
        ) {
            Text(
                text = "$percentage%",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .width(40.dp)
                    .padding(vertical = 8.dp),
                color = MaterialTheme.colorScheme.primary
            )

        }
        Surface(
            shape = RoundedCornerShape(
                topEnd = 15.dp,
                bottomEnd = 15.dp,
            ),
            color = MaterialTheme.colorScheme.surfaceColorAtElevation(1.dp),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.surfaceColorAtElevation(100.dp)),
            modifier = modifier.fillMaxWidth(1f)
        ) {
            Text(
                text = nutrients,
                modifier = Modifier.padding(vertical = 8.dp, horizontal = 10.dp),
            )
        }
    }
}