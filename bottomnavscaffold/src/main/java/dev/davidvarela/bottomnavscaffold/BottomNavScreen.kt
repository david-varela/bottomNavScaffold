package dev.davidvarela.bottomnavscaffold

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry

data class BottomNavScreen(
    val route: String,
    @StringRes val titleResourceId: Int,
    @DrawableRes val iconResourceId: Int,
    val iconContentDescription: String? = null,
    val content: @Composable (NavBackStackEntry) -> Unit
)
