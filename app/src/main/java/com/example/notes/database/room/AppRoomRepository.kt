package com.example.notes.database.room

import androidx.lifecycle.LiveData
import com.example.notes.R
import com.example.notes.database.DataBaseRepository
import com.example.notes.model.AppNote
import com.example.notes.utilits.APP_ACTIVITY

class AppRoomRepository(private val appRoomDao: AppRoomDao): DataBaseRepository {
    override val allNotes: LiveData<List<AppNote>>
        get() = appRoomDao.getAllNotes()

    override suspend fun insert(note: AppNote, onSuccess: () -> Unit) {
        appRoomDao.insert(note)
        onSuccess()
    }

    override suspend fun delete(note: AppNote, onSuccess: () -> Unit) {
        appRoomDao.delete(note)
        onSuccess()
    }

    override fun signOut() {
        super.signOut()
    }

}