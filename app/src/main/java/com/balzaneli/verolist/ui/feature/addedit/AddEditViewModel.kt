package com.balzaneli.verolist.ui.feature.addedit

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.balzaneli.verolist.data.TodoRepository
import kotlinx.coroutines.launch

class AddEditViewModel(
    private val repository: TodoRepository,
) : ViewModel() {
    var title by mutableStateOf("")
        private set

    var description by mutableStateOf<String?>(null)
        private set




    fun onEvent(event: AddEditEvent){
        when (event){
            is AddEditEvent.TitleChanged -> {
                title = event.title
            }
            is AddEditEvent.DescriptionChanged -> {
                description = event.description
            }
            AddEditEvent.Save -> {
                saveTodo()
            }
        }
    }


    private fun saveTodo(){
        viewModelScope.launch {
            repository.insert(title, description)
        }
    }
}