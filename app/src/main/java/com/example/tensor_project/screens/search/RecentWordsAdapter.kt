package com.example.tensor_project.screens.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.tensor_project.R

class RecentWordsAdapter(val clickListener: Listener) : RecyclerView.Adapter<RecentWordsAdapter.WordViewHolder>() {
    private val wordsList: MutableList<String> = mutableListOf()

    interface Listener {
        fun onClick(word: String)
    }

    inner class WordViewHolder(item: View): RecyclerView.ViewHolder(item) {
        val word: TextView = item.findViewById(R.id.saved_word_text)
        val wordItem: ConstraintLayout = item.findViewById(R.id.saved_word_item)
        init {
            wordItem.setOnClickListener {
                clickListener.onClick(word.text.toString())
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.saved_list_item, parent, false)
        return WordViewHolder(view)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.word.text = wordsList[position]
    }

    override fun getItemCount(): Int {
        return wordsList.size
    }

    fun reload(newList: MutableList<String>) {
        wordsList.clear()
        wordsList.addAll(newList)
        notifyDataSetChanged()
    }


}