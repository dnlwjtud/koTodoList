package io.dnlwjtud.koTodoList.todos.dto

data class TodoSaveForm(
    var task: String,
    var description:String,
    var isComplete:Boolean = false
)


