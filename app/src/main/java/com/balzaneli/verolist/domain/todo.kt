package com.balzaneli.verolist.domain

data class Todo (
    val id: Long,
    val title: String,
    val description: String?,
    val isCompleted: Boolean,
    val dueDate: Long? = null,
    val attachments: List<String> = emptyList(),
)


val todo1 = Todo(
    id = 1,
    title = "Todo 1",
    description = "Description for todo1",
    isCompleted = false,
)

val todo2 = Todo(
    id = 2,
    title = "Todo 2",
    description = "Description for todo2",
    isCompleted = true,
)

val todo3 = Todo(
    id = 3,
    title = "Todo 3",
    description = "Description for todo3",
    isCompleted = false,
)