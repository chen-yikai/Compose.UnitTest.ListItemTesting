package com.example.composeunittestlist

import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.filterToOne
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onChildren
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Rule

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @get:Rule
    val rule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testList() {
        testList.forEachIndexed { index, item ->
            val cardNode = rule.onAllNodesWithTag("card")[index]
            cardNode.onChildren().filterToOne(hasTestTag("chinese")).assertTextEquals(item.chinese)
            cardNode.onChildren().filterToOne(hasTestTag("english")).assertTextEquals(item.english)
        }
    }
}