package org.babulmirdha.toast_message.utils

import android.content.Context
import android.widget.Toast

actual fun showToast(message: String) {
    Toast.makeText(ContextHolder.current, message, Toast.LENGTH_SHORT).show()
}