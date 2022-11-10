package com.example.projecthilt.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.projecthilt.databinding.ActivityAddNoteBinding
import com.example.projecthilt.db.NoteEntity
import com.example.projecthilt.repository.DbRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AddNoteActivity : AppCompatActivity() {
    lateinit var  binding: ActivityAddNoteBinding

    @Inject
    lateinit var repository: DbRepository
    @Inject
    lateinit var noteEntity: NoteEntity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnSave.setOnClickListener {
                val title = edtTitle.text.toString()
                val desc = edtDesc.text.toString()
                if (title.isNotEmpty() || desc.isNotEmpty()){
                    noteEntity = NoteEntity(0,title,desc)
                    repository.saveNote(noteEntity)
                    finish()
                }
                else {
                    Toast.makeText(this@AddNoteActivity,"Title and cannot be empty",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}