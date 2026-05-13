package com.example.comicreader

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.comicreader.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 临时显示欢迎信息
        binding.root.postDelayed({
            // 这里可以添加实际的漫画阅读逻辑
            // 例如：startComicReader()
        }, 1000)
    }
}