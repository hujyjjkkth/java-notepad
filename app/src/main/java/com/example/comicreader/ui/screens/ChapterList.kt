package com.example.comicreader.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ChapterList(comicName: String) {
    val chapters = listOf(
        "第1话：开始",
        "第2话：相遇",
        "第3话：战斗"
    )

    Column(modifier = Modifier.fillMaxSize()) {
        Text("$comicName - 章节列表", modifier = Modifier.padding(16.dp))
        LazyColumn {
            items(chapters) { chapter ->
                Text(chapter, modifier = Modifier.padding(16.dp))
            }
        }
    }
}