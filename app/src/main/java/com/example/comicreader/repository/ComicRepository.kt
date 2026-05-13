package com.example.comicreader.repository

import com.example.comicreader.data.ComicChapter
import com.example.comicreader.data.ComicPage
import com.example.comicreader.data.ComicSource

class ComicRepository {
    // 模拟数据源
    private val mockSources = listOf(
        ComicSource(
            id = "source1",
            name = "示例漫画源",
            baseUrl = "https://example.com",
            coverUrl = "https://example.com/cover.jpg",
            chaptersUrl = "https://example.com/chapters.json"
        )
    )

    private val mockChapters = listOf(
        ComicChapter(
            id = "chapter1",
            title = "第一章",
            url = "https://example.com/chapter1.json",
            sourceId = "source1"
        )
    )

    private val mockPages = listOf(
        ComicPage(
            id = "page1",
            imageUrl = "https://example.com/page1.jpg",
            chapterId = "chapter1"
        )
    )

    fun getComicSources(): List<ComicSource> = mockSources

    fun getChapters(sourceId: String): List<ComicChapter> {
        return mockChapters.filter { it.sourceId == sourceId }
    }

    fun getPages(chapterId: String): List<ComicPage> {
        return mockPages.filter { it.chapterId == chapterId }
    }
}