package com.example.comicreader.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "source_list") {
        composable("source_list") {
            ComicSourceList()
        }
        composable("chapter_list/{comicName") { backStackEntry ->
            val comicName = backStackEntry.arguments?.getString("comicName") ?: ""
            ChapterList(comicName)
        }
        composable("page_viewer/{chapterName") { backStackEntry ->
            val chapterName = backStackEntry.arguments?.getString("chapterName") ?: ""
            ComicPageViewer(chapterName)
        }
    }
}