package com.example.comicreader

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation

// 漫画源数据类
data class ComicSource(
    val name: String,
    val url: String,
    val chapters: List<Chapter>
)

data class Chapter(
    val title: String,
    val pages: List<String>
)

// 示例漫画源（实际使用时可以从文件或网络加载）
val sampleSources = listOf(
    ComicSource(
        name = "示例漫画",
        url = "https://example.com",
        chapters = listOf(
            Chapter(
                title = "第1话",
                pages = List(10) { "https://example.com/comic/1/${it + 1}.jpg" }
            ),
            Chapter(
                title = "第2话",
                pages = List(8) { "https://example.com/comic/2/${it + 1}.jpg" }
            )
        )
    )
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComicReaderApp()
        }
    }
}

@Composable
fun ComicReaderApp() {
    MaterialTheme {
        Surface(color = Color(0xFFF5F5F5)) {
            Column {
                TopAppBar(
                    title = { Text("漫画阅读器", fontSize = 20.sp) },
                    backgroundColor = Color(0xFF4CAF50),
                    contentColor = Color.White
                )
                ComicSourceList(sources = sampleSources)
            }
        }
    }
}

@Composable
fun ComicSourceList(sources: List<ComicSource>) {
    LazyColumn {
        items(sources) { source ->
            ComicSourceItem(source = source)
        }
    }
}

@Composable
fun ComicSourceItem(source: ComicSource) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = 4.dp
    ) {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(16.dp)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(
                        ImageRequest.Builder(LocalContext.current)
                            .data("https://via.placeholder.com/80")
                            .crossfade(true)
                            .build()
                    ),
                    contentDescription = "漫画封面",
                    modifier = Modifier.size(80.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(source.name, style = TextStyle(fontSize = 18.sp))
                    Text(source.url, style = TextStyle(fontSize = 14.sp, color = Color.Gray))
                }
            }
            ChapterList(chapters = source.chapters)
        }
    }
}

@Composable
fun ChapterList(chapters: List<Chapter>) {
    LazyColumn {
        items(chapters) { chapter ->
            ChapterItem(chapter = chapter)
        }
    }
}

@Composable
fun ChapterItem(chapter: Chapter) {
    Text(
        chapter.title,
        style = TextStyle(fontSize = 16.sp, color = Color(0xFF4CAF50)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}

@Composable
fun ComicReaderScreen(pages: List<String>) {
    Column {
        TopAppBar(
            title = { Text("漫画阅读", fontSize = 20.sp) },
            backgroundColor = Color(0xFF4CAF50),
            contentColor = Color.White
        )
        ComicPageViewer(pages = pages)
    }
}

@Composable
fun ComicPageViewer(pages: List<String>) {
    // 这里简化处理，实际应该实现分页浏览逻辑
    LazyColumn {
        items(pages) { pageUrl ->
            ComicPage(pageUrl = pageUrl)
        }
    }
}

@Composable
fun ComicPage(pageUrl: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = 4.dp
    ) {
        Image(
            painter = rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current)
                    .data(pageUrl)
                    .crossfade(true)
                    .build()
            ),
            contentDescription = "漫画页面",
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(3f / 4f) // 假设漫画页面比例为3:4
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComicReaderApp()
}