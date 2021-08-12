package dev.davidvarela.bottomnavscaffold

import android.content.Context
import androidx.compose.material.Text
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.rememberNavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BottomNavScaffoldTest {
    companion object {
        private val context: Context = getInstrumentation().targetContext

        val OK = context.getString(android.R.string.ok)
        const val ADD_CONTENT_DESCRIPTION = "add"
        const val FIRST = "first"

        val CANCEL = context.getString(android.R.string.cancel)
        const val DELETE_CONTENT_DESCRIPTION = "cancel"
        const val SECOND = "second"

        val screens = listOf(
            BottomNavScreen(
                "first",
                android.R.string.ok,
                android.R.drawable.ic_input_add,
                ADD_CONTENT_DESCRIPTION
            ) { Text(text = FIRST) },
            BottomNavScreen(
                "second",
                android.R.string.cancel,
                android.R.drawable.ic_input_delete,
                DELETE_CONTENT_DESCRIPTION
            ) { Text(text = SECOND) }
        )

    }

    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun bottomNavShouldContainTwoDestinations() {
        composeRule.setContent {
            BottomNavScaffold(navHostController = rememberNavController(), screens = screens)
        }
        composeRule.onNodeWithText(OK).assertExists()
        composeRule.onNodeWithContentDescription(ADD_CONTENT_DESCRIPTION).assertExists()

        composeRule.onNodeWithText(CANCEL).assertExists()
        composeRule.onNodeWithContentDescription(DELETE_CONTENT_DESCRIPTION).assertExists()

        composeRule.onNodeWithText(FIRST).assertExists()
        composeRule.onNodeWithText(SECOND).assertDoesNotExist()
    }

    @Test
    fun bottomNavShouldNavigateBetweenDestinations() {

        composeRule.setContent {
            BottomNavScaffold(navHostController = rememberNavController(), screens = screens)
        }
        composeRule.onNodeWithText(FIRST).assertExists()
        composeRule.onNodeWithText(SECOND).assertDoesNotExist()

        composeRule.onNodeWithText(CANCEL).performClick()

        composeRule.onNodeWithText(FIRST).assertDoesNotExist()
        composeRule.onNodeWithText(SECOND).assertExists()
    }
}

