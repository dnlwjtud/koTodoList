package io.dnlwjtud.koTodoList.todos.application

import io.dnlwjtud.koTodoList.todos.dto.TodoSaveForm

interface TodoService {

    fun save(todoSaveForm: TodoSaveForm): Long?;

    fun findById(id: Long)

}