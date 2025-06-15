package com.example.composeunittestlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeunittestlist.ui.theme.ComposeUnitTestListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeUnitTestListTheme {
                Scaffold { innerPadding ->
                    Sample(innerPadding)
                }
            }
        }
    }
}

data class Item(
    val id: Int,
    val chinese: String,
    val english: String
)

val list = listOf(
    Item(1, "蘋果", "Apple"),
    Item(2, "香蕉", "Banana"),
    Item(3, "橘子", "Orange"),
    Item(4, "葡萄", "Grape"),
    Item(5, "草莓", "Strawberry"),
    Item(6, "梨子", "Pear"),
    Item(7, "桃子", "Peach"),
    Item(8, "櫻桃", "Cherry"),
)


val list = listOf(
    Item(1, "蘋果", "Apple"),
    Item(2, "香蕉", "Banana"),
    Item(3, "橘子", "Orange"),
    Item(4, "葡萄", "Grape"),
    Item(5, "草莓", "Strawberry"),
    Item(6, "梨子", "Pear"),
    Item(7, "桃子", "Peach"),
    Item(8, "櫻桃", "Cherry"),
)

@Composable
fun Sample(padding: PaddingValues) {
    LazyColumn(contentPadding = padding) {
        items(list) {
            Card(modifier = Modifier
                .padding(horizontal = 15.dp, vertical = 8.dp)
                .testTag("card"), elevation = CardDefaults.cardElevation(5.dp)) {
                Row(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        it.chinese,
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                        modifier = Modifier.testTag("chinese")
                    )
                    Text(
                        it.english,
                        fontWeight = FontWeight.Light,
                        modifier = Modifier.testTag("english")
                    )
                }
            }
        }
    }
}