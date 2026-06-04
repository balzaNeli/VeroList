package com.balzaneli.verolist.ui.feature.addedit

sealed interface AddEditEvent {
    data class TitleChanged(val title: String) : AddEditEvent
    data class DescriptionChanged(val description: String) : AddEditEvent
    data class DueDateChanged(val dueDate: Long?) : AddEditEvent
    data class AttachmentsChanged(val attachments: List<String>) : AddEditEvent
    data object Save : AddEditEvent
}