package dev.davidvarela.bottomnavscaffold

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

@Composable
internal fun NavHost(
    navController: NavHostController,
    innerPadding: PaddingValues,
    screens: List<BottomNavScreen>,
    startDestination: String
) {
    androidx.navigation.compose.NavHost(
        modifier = Modifier.padding(innerPadding),
        navController = navController,
        startDestination = startDestination
    ) {
        for (screen in screens) {
            composable(screen.route, content = screen.content)
        }
    }
}
