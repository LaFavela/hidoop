package com.papela.hidoop.presentation.chat

//import com.papela.hidoop.presentation.chat.components.ImageReceiveMessege
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.papela.hidoop.presentation.chat.components.ChatHeader
import com.papela.hidoop.presentation.chat.components.ImageReceiveMessege
import com.papela.hidoop.presentation.chat.components.RegularReceiveMessage
import com.papela.hidoop.presentation.chat.components.RegularSentMessage
import com.papela.hidoop.presentation.chat.components.SendingButton
import com.papela.hidoop.presentation.chat.components.TextInput

@Composable
fun ChatScreen() {
    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column {
            ChatHeader()
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
                    .weight(weight = 1f, fill = false),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                RegularReceiveMessage("Android")
                RegularSentMessage("Jetpack")
                RegularSentMessage("Compose")
                RegularReceiveMessage("Is")
                RegularReceiveMessage("Greatest")
                RegularSentMessage("Ever")
                RegularSentMessage("Ever")
                ImageReceiveMessege(
                    name = "Halo ini adalah tips diet hari ini daasdfas adfacad sdfsf asdfsf sdgg sdfsd fdsf sdf sf dsf dffew  ",
                    title = "Tips Diet",
                    data = "https://awsimages.detik.net.id/community/media/visual/2023/08/11/resep-salad-sayuran-saus-minyak-olive-bawang.jpeg?w=600&q=90"
                )
            }
            Row (
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .padding(start = 16.dp)
            ) {
                TextInput()
                Spacer(modifier = Modifier.width(16.dp))
                SendingButton(onClick = { /*TODO*/ })
            }
        }
    }
}

@Preview
@Composable
fun PreviewChatScreen() {
    ChatScreen()
}