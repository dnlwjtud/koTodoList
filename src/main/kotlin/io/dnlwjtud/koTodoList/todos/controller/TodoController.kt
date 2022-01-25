package io.dnlwjtud.koTodoList.todos.controller

import io.dnlwjtud.koTodoList.todos.application.TodoService
import io.dnlwjtud.koTodoList.todos.dto.TodoSaveForm
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller
class TodoController(
    private val todoService: TodoService
) {

    @GetMapping("/todos/add")
    fun showAdd(model: Model) :String{

        return "todo/add";
    }

    @PostMapping("/todos/add")
    fun doAdd(todoSaveForm: TodoSaveForm) :String{

        val todoId = todoService.save(todoSaveForm)

        return "redirect:/todos/$todoId";

    }


}