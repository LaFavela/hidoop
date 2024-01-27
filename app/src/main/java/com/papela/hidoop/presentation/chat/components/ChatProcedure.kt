package com.papela.hidoop.presentation.chat.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.updateTransition
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
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.papela.hidoop.presentation.chat.common.ReceiveChatBubbleSurface
import com.papela.hidoop.util.DataProcedure
import com.papela.hidoop.util.getScreenWidth

@Composable
fun ChatProcedure (content:String, title:String, data: List<DataProcedure>){
    Column {
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
                    textAlign = androidx.compose.ui.text.style.TextAlign.Start,
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Column {
           data.forEach { data ->
                ProcedureData(
                    data = data,
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
// TODO: Refactor ProcedureData to be within the maximum line length limit (60 lines)
    var isExpanded by remember {
        mutableStateOf(false)
    }
    val transition = updateTransition(targetState = isExpanded, label = "ExpandableCard")
    val heightCardExpand by transition.animateDp(label = "heightCardExpand") { expanded ->
        if (expanded) 330.667.dp else 46.667.dp
    }

    Row(
        modifier = Modifier
            .padding(end = 16.dp)
            .padding(bottom = 16.dp)
            .widthIn(max = (getScreenWidth() * 0.75f).dp),
    ){
        Card(
            modifier = Modifier
                .width(46.667.dp)
                .height(46.667.dp)
                .animateContentSize(),
            shape = RoundedCornerShape(12.dp),
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
                    text = data.number.toString(),
                    fontSize =  12.sp,
                    fontWeight = FontWeight.SemiBold
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
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = data.title,
                    fontSize = if (isExpanded) 12.sp else 10.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(horizontal = 12.dp)
                )
                Spacer(modifier = Modifier.height(6.dp))
                AnimatedVisibility(visible = isExpanded) {
                    Column {
                        Text(
                            text = data.content,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Light,
                            modifier = Modifier.padding(horizontal = 12.dp)
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        LoadingImage(data = data.image)
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun ChatProcedurePreview(){
    ChatProcedure(
        content = "Yoga adalah kegiatan yang dilakukan untuk menguatkan otot dan meningkatkan fleksibilitas tubuh. Berikut Gerakan Yoga :",
        title = "title",
        data = listOf(
            DataProcedure(
                title = "Kayang",
                content = "content ini adalh untuk apa",
                image = "https://res.cloudinary.com/dk0z4ums3/image/upload/v1688958995/attached_image/cara-melakukan-gerakan-kayang-dan-beragam-manfaatnya-untuk-kesehatan.jpg",
                number = 1
            ),
            DataProcedure(
                title = "Plank",
                content = "content ini adalh untuk apa",
                image = "https://cdn-image.hipwee.com/wp-content/uploads/2019/08/hipwee-plank-vs-push-up-min.jpg",
                number = 2
            ),
        )
    )

}



