package com.challange.navigation.utils

import android.content.Context
import android.content.Intent
import android.widget.Toast

internal object IntentUtils {

    private fun getActionsIntent(
        context: Context,
        className: String
    ): Intent {
        return Intent(
            context,
            Class.forName(className)
        )
    }

    fun openFeatureIntent(context: Context, className: String, extras: Intent.() -> Unit = {}) {
        openIntent(context, className, extras) {
            context.startActivity(it)
        }
    }


    private fun openIntent(
        context: Context,
        className: String,
        extras: Intent.() -> Unit = {},
        startActivity: (Intent) -> Unit
    ) {
        try {
            getActionsIntent(context, className)
                .apply(extras)
                .also {
                    startActivity(it)
                }
        } catch (error: Exception) {
            Toast.makeText(context, "Unavailable Feature ", Toast.LENGTH_LONG).show()
        }
    }
}