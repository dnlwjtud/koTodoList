package io.dnlwjtud.koTodoList.todos.dto

data class TodoUpdateForm(
    val task: String,
    val description: String,
    val isComplete: Boolean
)
