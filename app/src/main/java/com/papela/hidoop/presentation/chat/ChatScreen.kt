package com.papela.hidoop.presentation.chat

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.papela.hidoop.presentation.chat.components.ChatHeader
import com.papela.hidoop.presentation.chat.components.RegularReceiveMessage
import com.papela.hidoop.presentation.chat.components.RegularSentMessage

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
                modifier = Modifier.padding(16.dp)
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
                RegularSentMessage("Ever")
                RegularSentMessage("Ever")
                RegularSentMessage("Ever")
                RegularSentMessage("Ever")
                RegularSentMessage("Ever")
            }
        }
//        Scaffold(
//            modifier = Modifier
//                .fillMaxWidth()
//        ) {
//            TextMessage("")
//        }
    }
}