/*
   Copyright 2021 David González Varela

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package dev.davidvarela.bottomnavscaffold

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material.BackdropScaffold
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.DrawerDefaults
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Snackbar
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.TopAppBar
import androidx.compose.material.contentColorFor
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.Navigation

/**
 * <a href="https://material.io/design/layout/understanding-layout.html" class="external" target="_blank">Material Design layout</a>.
 *
 * BottomNavScaffold implements the basic material design visual layout structure with a bottom
 * navigation bar.
 *
 * This component provides API to put together several material components to construct your
 * screen, by ensuring proper layout strategy for them and collecting necessary data so these
 * components will work together correctly.
 *
 * For similar components that implement different layout structures, see [BackdropScaffold],
 * which uses a backdrop as the centerpiece of the screen, and [BottomSheetScaffold], which uses
 * a persistent bottom sheet as the centerpiece of the screen.
 *
 * @param navHostController [NavHostController] obtained from a navigation host via
 * [NavHost.navController] or by using one of the utility methods on the [Navigation] class.
 * @param screens list of [BottomNavScreen], destinations of the bottom nav bar
 * @param modifier optional Modifier for the root of the [Scaffold]
 * @param startDestination optional String with the [BottomNavScreen.route] of tne initial
 * destination. The first destination of the list is the initial destination by default.
 * @param scaffoldState state of this scaffold widget. It contains the state of the screen, e.g.
 * variables to provide manual control over the drawer behavior, sizes of components, etc
 * @param topBar top app bar of the screen. Consider using [TopAppBar].
 * @param snackbarHost component to host [Snackbar]s that are pushed to be shown via
 * [SnackbarHostState.showSnackbar]. Usually it's a [SnackbarHost]
 * @param floatingActionButton Main action button of your screen. Consider using
 * [FloatingActionButton] for this slot.
 * @param floatingActionButtonPosition position of the FAB on the screen. See [FabPosition] for
 * possible options available.
 * @param isFloatingActionButtonDocked whether [floatingActionButton] should overlap with
 * bottomBar for half a height.
 * @param drawerContent content of the Drawer sheet that can be pulled from the left side (right
 * for RTL).
 * @param drawerGesturesEnabled whether or not drawer (if set) can be interacted with via gestures
 * @param drawerShape shape of the drawer sheet (if set)
 * @param drawerElevation drawer sheet elevation. This controls the size of the shadow
 * below the drawer sheet (if set)
 * @param drawerBackgroundColor background color to be used for the drawer sheet
 * @param drawerContentColor color of the content to use inside the drawer sheet. Defaults to
 * either the matching content color for [drawerBackgroundColor], or, if it is not a color from
 * the theme, this will keep the same value set above this Surface.
 * @param drawerScrimColor color of the scrim that obscures content when the drawer is open
 * @param backgroundColor background of the scaffold body
 * @param contentColor color of the content in scaffold body. Defaults to either the matching
 * content color for [backgroundColor], or, if it is not a color from the theme, this will keep
 * the same value set above this Surface.
 */

@Suppress("unused")
@Composable
fun BottomNavScaffold(
    navHostController: NavHostController,
    screens: List<BottomNavScreen>,
    modifier: Modifier = Modifier,
    startDestination: String = screens.first().route,
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    topBar: @Composable () -> Unit = {},
    snackbarHost: @Composable (SnackbarHostState) -> Unit = { SnackbarHost(it) },
    floatingActionButton: @Composable () -> Unit = {},
    floatingActionButtonPosition: FabPosition = FabPosition.End,
    isFloatingActionButtonDocked: Boolean = false,
    drawerContent: @Composable (ColumnScope.() -> Unit)? = null,
    drawerGesturesEnabled: Boolean = true,
    drawerShape: Shape = MaterialTheme.shapes.large,
    drawerElevation: Dp = DrawerDefaults.Elevation,
    drawerBackgroundColor: Color = MaterialTheme.colors.surface,
    drawerContentColor: Color = contentColorFor(drawerBackgroundColor),
    drawerScrimColor: Color = DrawerDefaults.scrimColor,
    backgroundColor: Color = MaterialTheme.colors.background,
    contentColor: Color = contentColorFor(backgroundColor)
) {
    Scaffold(
        modifier = modifier,
        scaffoldState = scaffoldState,
        topBar = topBar,
        bottomBar = { BottomBar(navHostController, screens) },
        snackbarHost = snackbarHost,
        floatingActionButton = floatingActionButton,
        floatingActionButtonPosition = floatingActionButtonPosition,
        isFloatingActionButtonDocked = isFloatingActionButtonDocked,
        drawerContent = drawerContent,
        drawerGesturesEnabled = drawerGesturesEnabled,
        drawerShape = drawerShape,
        drawerElevation = drawerElevation,
        drawerBackgroundColor = drawerBackgroundColor,
        drawerContentColor = drawerContentColor,
        drawerScrimColor = drawerScrimColor,
        backgroundColor = backgroundColor,
        contentColor = contentColor
    ) { innerPadding ->
        NavHost(navHostController, innerPadding, screens, startDestination)
    }
}
