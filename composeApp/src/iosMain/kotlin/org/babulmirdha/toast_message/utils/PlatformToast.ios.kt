package org.babulmirdha.toast_message.utils


import platform.UIKit.UIAlertController
import platform.UIKit.UIAlertControllerStyleAlert
import platform.UIKit.UIApplication
import platform.UIKit.UIViewController
import platform.darwin.DISPATCH_TIME_NOW
import platform.darwin.NSEC_PER_SEC
import platform.darwin.dispatch_after
import platform.darwin.dispatch_get_main_queue
import platform.darwin.dispatch_time

actual fun showToast(message: String) {
    // Get top most UIViewController
    val rootViewController = UIApplication.sharedApplication.keyWindow?.rootViewController
        ?: return

    val topController = getTopViewController(rootViewController)

    // Create alert controller
    val alert = UIAlertController.alertControllerWithTitle(
        title = null,
        message = message,
        preferredStyle = UIAlertControllerStyleAlert
    )

    topController.presentViewController(alert, animated = true, completion = null)

    // Dismiss after 2 seconds (simulate toast behavior)
    val dispatchTime = dispatch_time(DISPATCH_TIME_NOW, 2 * NSEC_PER_SEC.toLong())
    dispatch_after(dispatchTime, dispatch_get_main_queue()) {
        alert.dismissViewControllerAnimated(true, completion = null)
    }
}

// Helper function to get the topmost view controller
private fun getTopViewController(root: UIViewController): UIViewController {
    var top = root
    while (top.presentedViewController != null) {
        top = top.presentedViewController!!
    }
    return top
}
