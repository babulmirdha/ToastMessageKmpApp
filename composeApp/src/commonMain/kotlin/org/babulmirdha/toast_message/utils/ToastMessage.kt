package org.babulmirdha.toast_message.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

@Composable
fun ToastMessage(message: String?) {
    if (!message.isNullOrEmpty()) {
        LaunchedEffect(message) {
            showToast(message)
        }
    }
}