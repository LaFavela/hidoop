package com.papela.hidoop.presentation.chat.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.papela.hidoop.presentation.chat.common.ReceiveChatBubbleSurface
import com.papela.hidoop.util.getScreenWidth

@Composable
fun DateAssigment(content: String, title: String, cardData: List<CardData>) {
    var isExpanded by remember {
        mutableStateOf(false)
    }
    Column (
        modifier = Modifier.padding(bottom = 45.dp)
    ){
        ReceiveChatBubbleSurface {
            Column {
                Text(
                    text = title,
                    modifier = Modifier.padding(top = 12.dp, start = 12.dp, end = 12.dp),
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = content,
                    modifier = Modifier.padding(vertical = 8.dp, horizontal = 12.dp),
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 16.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .width(96.dp)
                            .height(96.dp)
                            .padding(12.dp)
                            .background(MaterialTheme.colorScheme.primaryContainer, RoundedCornerShape(16.dp)),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = cardData[0].month,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.primary
                        )

                        Text(
                            text = cardData[0].date,
                            fontSize = 34.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )

                    }

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(96.dp)
                            .padding(12.dp),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = cardData[0].title,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Column {
                            Text(
                                text = "${cardData[0].day}, ${cardData[0].month} ${cardData[0].year}",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Light
                            )
                            Spacer(modifier = Modifier.height(6.dp))
                            Text(
                                text = cardData[0].time,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Light
                            )
                        }

                    }

                }
                ClickedText(
                    text = if (isExpanded) "Hide All Task" else "Show All Task",
                    onClick = { isExpanded = !isExpanded },
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    fontSize = 10.sp
                )

            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        AnimatedVisibility(visible = isExpanded) {
            Column {
                cardData.forEach { cardData ->
                    ExpandedCard(
                        cardData = cardData,
                    )
                }
            }
        }
    }
}

@Composable
fun ClickedText(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    color : Color,
    fontSize : TextUnit

) {
    Surface(
        onClick = onClick,
        modifier.padding(horizontal = 12.dp),
        color = MaterialTheme.colorScheme.surfaceColorAtElevation(1.dp),
    ) {
        Text(
            text = text,
            modifier = Modifier
                .padding(horizontal = 12.dp),
            color = color,
            fontSize = fontSize,

            )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExpandedCard(
    cardData: CardData,
) {
    var isExpanded by remember {
        mutableStateOf(false)
    }
    val transition = updateTransition(targetState = isExpanded, label = "ExpandableCard")
    val dateCardExpand by transition.animateDp(label = "dateCardExpand") { expanded ->
        if (expanded) 96.dp else 46.667.dp
    }
    val heightCardExpand by transition.animateDp(label = "heightCardExpand") { expanded ->
        if (expanded) 90.dp else 46.667.dp
    }

    Row(
        modifier = Modifier
            .padding(end = 16.dp)
            .padding(bottom = 16.dp)
            .widthIn(max = (getScreenWidth() * 0.75f).dp),
    ) {
        Card(
            onClick = { isExpanded = !isExpanded },
            modifier = Modifier
                .width(dateCardExpand)
                .height(dateCardExpand)
                .animateContentSize(),
            shape = if (isExpanded) RoundedCornerShape(16.dp) else RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary
            )

        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = cardData.month,
                    fontSize = if (isExpanded) 10.sp else 4.sp,
                    fontWeight = FontWeight.SemiBold
                )

                Text(
                    text = cardData.date,
                    fontSize = if (isExpanded) 34.sp else 12.sp,
                    fontWeight = FontWeight.Bold
                )

            }
        }
        Spacer(modifier = Modifier.width(16.dp))
        Card(
            onClick = { isExpanded = !isExpanded },
            modifier = Modifier
                .fillMaxWidth()
                .height(heightCardExpand)
                .animateContentSize(),
            shape = if (isExpanded) RoundedCornerShape(16.dp) else RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceColorAtElevation(1.dp),
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = cardData.title,
                    fontSize = if (isExpanded) 12.sp else 10.sp,
                    fontWeight = FontWeight.Normal
                )
                Spacer(modifier = Modifier.height(6.dp))
                AnimatedVisibility(visible = isExpanded) {
                    Column {
                        Text(
                            text = "${cardData.day}, ${cardData.month} ${cardData.year}",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Light
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = cardData.time,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Light
                        )
                    }
                }
            }
        }

    }
}

@Preview
@Composable
fun DateAssigmentPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),

        ) {
        DateAssigment(
            content = "This Is your work today :",
            title = "Testing",
            cardData = listOf(
                CardData(
                    date = "12",
                    month = "JAN",
                    day = "Monday",
                    year = "2021",
                    title = "Breakfast With Vegetables",
                    time = "8:00 AM"
                ),
                CardData(
                    date = "13",
                    month = "JAN",
                    day = "Tuesday",
                    year = "2021",
                    title = "Breakfast With Fruit",
                    time = "8:00 AM"
                ),
                CardData(
                    date = "14",
                    month = "JAN",
                    day = "Wednesday",
                    year = "2021",
                    title = "Breakfast With Protein",
                    time = "8:00 AM"
                ),
            )
        )
    }
}

data class CardData(
    val date: String,
    val month: String,
    val day: String,
    val year: String,
    val title: String,
    val time: String
)