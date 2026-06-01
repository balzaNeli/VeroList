package com.balzaneli.verolist.ui.feature.addedit

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.balzaneli.verolist.data.TodoRepository

class AddEditViewModel(
    private val repository: TodoRepository,
) : ViewModel() {
    var title by mutableStateOf("")
        private set

    var description by mutableStateOf<String?>(null)
        private set
}