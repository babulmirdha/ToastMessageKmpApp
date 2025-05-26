package org.babulmirdha.toast_message

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay
import org.babulmirdha.toast_message.utils.ToastMessage
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun App() {
    MaterialTheme {
        Scaffold( topBar = {
            TopAppBar(
                title = { Text("Toast Message Demo") },
            )
        }) {   contentPadding ->

            Box(modifier = androidx.compose.ui.Modifier.padding(contentPadding)){
                MainContent()
            }

        }

    }
}

@Composable
fun MainContent() {

    var isShowToast by remember { mutableStateOf(false) }
    var toastMessage by remember { mutableStateOf("") }

    if (isShowToast && toastMessage.isNotEmpty()) {
        LaunchedEffect(toastMessage) {
            if (toastMessage.isNotEmpty()) {
                delay(3000) // Show for 3 seconds
                isShowToast = false
                toastMessage = ""
            }
        }
    }

    Column(
        modifier = Modifier
            .safeContentPadding()
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        ToastMessage(message = toastMessage)

        Button(onClick = {
            toastMessage = "Max liked limit reached!"
            isShowToast = true
        }) {
            Text("Show Toast Message")
        }


    }
}
