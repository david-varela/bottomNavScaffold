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

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry

/**
 * Representation of an option of the bottom navigation bar, a destination of the app.
 *
 * @param route String that identifies each destination, used for navigating
 * @param titleResourceId Resource identifier of the title of the destination in the bottom bar,
 * R.string.section_title
 * @param iconResourceId Resource identifier of the icon of the destination in the bottom bar,
 * R.drawable.section_icon
 * @param iconContentDescription String with the content description {@code iconResourceId}, for
 * accessibility. Null by default
 * @param content Composable to draw in the destination
 * @see <a href="https://material.io/components/bottom-navigation/android">bottom navigation in material.io</a>
 * @see <a href="https://developer.android.com/jetpack/compose/navigation#bottom-nav">Navigating with compose: integration with the bottom nav bar</a>
 * @see <a href="https://developer.android.com/codelabs/jetpack-compose-navigation">Jetpack Compose Navigation codelab</a>
 *
 */
data class BottomNavScreen(
    val route: String,
    @StringRes val titleResourceId: Int,
    @DrawableRes val iconResourceId: Int,
    val iconContentDescription: String? = null,
    val content: @Composable (NavBackStackEntry) -> Unit
)
