package com.blockchain.core.navigation

import android.content.Context

interface Navigator {
    abstract fun navigateTo(navigationDest: NavigationDest, context: Context)
}


