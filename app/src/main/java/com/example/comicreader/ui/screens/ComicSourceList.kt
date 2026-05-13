package com.example.comicreader.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ComicSourceList() {
    val sources = listOf(
        "漫画人",
        "动漫之家",
        "腾讯动漫"
    )

    Column(modifier = Modifier.fillMaxSize()) {
        Text("漫画源列表", modifier = Modifier.padding(16.dp))
        LazyColumn {
            items(sources) { source ->
                Text(source, modifier = Modifier.padding(16.dp))
            }
        }
    }
}