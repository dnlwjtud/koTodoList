package io.dnlwjtud.koTodoList.todos.application

import io.dnlwjtud.koTodoList.todos.domain.Todo
import io.dnlwjtud.koTodoList.todos.dto.TodoDTO
import io.dnlwjtud.koTodoList.todos.dto.TodoSaveForm
import io.dnlwjtud.koTodoList.todos.dto.TodoUpdateForm
import java.util.*

interface TodoService {

    fun save(todoSaveForm: TodoSaveForm): Long?;
    fun findById(id: Long): Optional<Todo>;
    fun getOne(id: Long): TodoDTO;
    fun getList(): List<TodoDTO>;
    fun update(todoUpdateForm: TodoUpdateForm, id: Long);
    fun delete(id: Long);

}