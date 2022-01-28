package io.dnlwjtud.koTodoList.todos.api

import io.dnlwjtud.koTodoList.todos.application.TodoService
import io.dnlwjtud.koTodoList.todos.dto.DefaultResponse
import io.dnlwjtud.koTodoList.todos.dto.TodoCheckRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
class TodoApiController (
    private val todoService: TodoService
) {

    @PatchMapping("/api/todos/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun patchTodo(@PathVariable(name = "id")id: Long, @RequestBody todoCheckRequest: TodoCheckRequest): DefaultResponse<String> {

        todoService.changeComplete(id, todoCheckRequest)

        return DefaultResponse(
            "Completely changed !"
        );

    }

}