package com.example.comicreader.ui.source

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.comicreader.data.ComicSource
import com.example.comicreader.databinding.ItemComicSourceBinding

class ComicSourceAdapter(
    private val sources: List<ComicSource>,
    private val onItemClick: (ComicSource) -> Unit
) : RecyclerView.Adapter<ComicSourceAdapter.SourceViewHolder>() {

    class SourceViewHolder(private val binding: ItemComicSourceBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(source: ComicSource) {
            binding.sourceName.text = source.name
            binding.root.setOnClickListener {
                // 处理点击事件
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SourceViewHolder {
        val binding = ItemComicSourceBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return SourceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SourceViewHolder, position: Int) {
        val source = sources[position]
        holder.bind(source)
        holder.itemView.setOnClickListener { onItemClick(source) }
    }

    override fun getItemCount(): Int = sources.size
}