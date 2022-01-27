package io.dnlwjtud.koTodoList.todos.controller

import io.dnlwjtud.koTodoList.todos.application.TodoService
import io.dnlwjtud.koTodoList.todos.dto.TodoSaveForm
import io.dnlwjtud.koTodoList.todos.dto.TodoUpdateForm
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
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

        val todoId = todoService.save(todoSaveForm);

        return "redirect:/";

    }

    @GetMapping(value = [ "/", "/todos" ])
    fun showList(model: Model) :String {

        val todoList = todoService.getList();

        model.addAttribute("todoList", todoList);

        return "todo/list";

    }

    @GetMapping("/todos/edit/{id}")
    fun showUpdate(@PathVariable(name = "id") id :Long, model:Model) :String {

        val findTodo = todoService.getOne(id);
        model.addAttribute("todo", findTodo);

        return "todo/update";

    }

    @PostMapping("/todos/edit/{id}")
    fun doUpdate(@PathVariable(name = "id") id:Long, todoUpdateForm: TodoUpdateForm) :String {

        todoService.update(todoUpdateForm, id);
        return "redirect:/";

    }

    @GetMapping("/todos/delete/{id}")
    fun doDelete(@PathVariable(name = "id") id:Long) :String {

        todoService.delete(id);
        return "redirect:/todos/";

    }

}