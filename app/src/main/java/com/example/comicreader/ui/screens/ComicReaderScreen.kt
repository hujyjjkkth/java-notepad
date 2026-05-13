package com.example.comicreader.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ComicReaderScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text("漫画阅读器")
    }
}