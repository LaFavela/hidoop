package com.papela.hidoop.presentation.chat.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.papela.hidoop.presentation.chat.common.ReceiveChatBubbleSurface

@Composable
fun ImageReceiveMessage(name: String, title: String, data: String) {
    ReceiveChatBubbleSurface {
        Column {
            Text(
                text = title,
                modifier = Modifier
                    .padding(start = 16.dp)
                    .padding(end = 25.dp)
                    .padding(top = 16.5.dp),
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = name,
                modifier = Modifier
                    .padding(start = 16.dp)
                    .padding(end = 25.dp)
                    .padding(top = 16.dp)
            )
            LoadingImage(data = data)
        }
    }
}
@Composable
fun LoadingImage(data: String) {
    Box(
        modifier = Modifier
            .height(300.dp)
            .width(350.dp)
            .padding(start = 16.dp)
            .padding(end = 25.dp)
            .padding(top = 16.dp)
            .padding(bottom = 30.dp)
            .background(
                color = MaterialTheme.colorScheme.surfaceColorAtElevation(1.dp),
                shape = RoundedCornerShape(20.dp)
            ),

        ) {
        val painter = rememberAsyncImagePainter(
            ImageRequest
                .Builder(LocalContext.current)
                .data(data)
                .build()
        )
        val painterState = painter.state
        Image(
            painter = painter,
            contentDescription = "image",
            modifier = Modifier
                .fillMaxSize() // Ensure the Image fills the entire Box
                .clip(RoundedCornerShape(20.dp)),
            contentScale = ContentScale.Crop,
        )
        if (painterState is AsyncImagePainter.State.Loading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .align(alignment = androidx.compose.ui.Alignment.Center),
                color = MaterialTheme.colorScheme.primary
            )
        }

    }
}

@Preview
@Composable
fun MessegePreview() {
    ImageReceiveMessage(
        name = "Tips diet adalah makan dan minum yang sehat dabfadf cadffdf adfafad adfadfafd afafadfa adfa",
        title = "Testing",
        data = "https://awsimages.detik.net.id/community/media/visual/2023/08/11/resep-salad-sayuran-saus-minyak-olive-bawang.jpeg?w=600&q=90"
    )

}