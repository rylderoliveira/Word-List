package com.impacta.wordlist

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.impacta.wordlist.model.Word

class WordViewHolder(itemView: View) : ViewHolder(itemView) {

    private val textView: TextView = itemView.findViewById(R.id.text_view_item_word)

    fun bind(word: Word) {
        textView.text = word.word
    }
}
