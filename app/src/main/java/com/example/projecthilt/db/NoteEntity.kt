package com.example.projecthilt.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.projecthilt.utils.Constants.NOTE_TABLE

@Entity(tableName = NOTE_TABLE)
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val noteId : Int = 0,
    @ColumnInfo(name = "note_title")
    val noteTitle : String = "",
    @ColumnInfo(name ="note_desc")
    val noteDescription : String = ""
)