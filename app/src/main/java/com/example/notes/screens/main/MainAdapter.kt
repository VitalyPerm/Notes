package com.example.notes.screens.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.compose.ui.layout.Layout
import androidx.recyclerview.widget.RecyclerView
import com.example.notes.R
import com.example.notes.model.AppNote

class MainAdapter:RecyclerView.Adapter<MainAdapter.MainHolder>() {

    private var mListNotes = emptyList<AppNote>()


    class MainHolder(view: View):RecyclerView.ViewHolder(view){
        val nameNote:TextView = view.findViewById(R.id.item_note_name)
        val textNote:TextView = view.findViewById(R.id.item_note_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return MainHolder(view)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.textNote.text = mListNotes[position].text
        holder.nameNote.text = mListNotes[position].name
    }

    override fun getItemCount(): Int = mListNotes.size

    fun setList(list:List<AppNote>){
        mListNotes = list
        notifyDataSetChanged()
    }
}