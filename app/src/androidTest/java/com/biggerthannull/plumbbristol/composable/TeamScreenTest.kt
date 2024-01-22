package com.biggerthannull.plumbbristol.composable

import android.content.Context
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.test.platform.app.InstrumentationRegistry
import com.biggerthannull.plumbbristol.R
import com.biggerthannull.plumbbristol.ui.theme.PlumbBristolTheme
import com.biggerthannull.plumbbristol.ui.views.composables.components.TeamOverviewGridComponent
import com.biggerthannull.plumbbristol.ui.views.composables.elements.LOADING_ELEMENT_TEST_TAG
import com.biggerthannull.plumbbristol.ui.views.composables.screens.TeamScreen
import com.biggerthannull.plumbbristol.ui.views.viewmodels.state.TeamUIState
import org.junit.Rule
import org.junit.Test

class TeamScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private val context: Context = InstrumentationRegistry.getInstrumentation().targetContext

    private val employee = TestData.employee
    private val accessibilityLabel = context.getString(R.string.employee_image_accessibility_label)
    private val errorLabel = context.getString(R.string.generic_error_label)

    @Test
    fun verifyListOfEmployees() {
        composeTestRule.setContent {
            PlumbBristolTheme {
                TeamOverviewGridComponent(listOf(employee))
            }
        }

        composeTestRule.onNodeWithText(employee.name).assertIsDisplayed()
        composeTestRule.onNodeWithText(employee.position).assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription(accessibilityLabel).assertIsDisplayed()
    }

    @Test
    fun verifyThatSpinnerIsLoaded() {
        composeTestRule.setContent {
            PlumbBristolTheme {
                TeamScreen(uiState = TeamUIState.Loading)
            }
        }
        composeTestRule.onNodeWithTag(LOADING_ELEMENT_TEST_TAG).assertIsDisplayed()
    }

    @Test
    fun shouldSDisplayAnError() {
        composeTestRule.setContent {
            PlumbBristolTheme {
                TeamScreen(uiState = TeamUIState.Failed)
            }
        }
        composeTestRule.onNodeWithText(errorLabel).assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription(errorLabel).assertIsDisplayed()
    }
}