package com.biggerthannull.plumbbristol.composable

import android.content.Context
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.test.platform.app.InstrumentationRegistry
import com.biggerthannull.plumbbristol.R
import com.biggerthannull.plumbbristol.ui.theme.PlumbBristolTheme
import com.biggerthannull.plumbbristol.ui.views.composables.components.EmployeeGridItemComponent
import org.junit.Rule
import org.junit.Test

class EmployeeGridItemComponentTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private val context: Context = InstrumentationRegistry.getInstrumentation().targetContext

    private val employee = TestData.employee
    private val accessibilityLabel = context.getString(R.string.employee_image_accessibility_label)

    @Test
    fun shouldBuildEmployeeGridItem() {
        composeTestRule.setContent {
            PlumbBristolTheme {
                EmployeeGridItemComponent(employee)
            }
        }

        composeTestRule.onNodeWithText(employee.name).assertIsDisplayed()
        composeTestRule.onNodeWithText(employee.position).assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription(employee.name).assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription(employee.position).assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription(accessibilityLabel).assertIsDisplayed()
    }
}