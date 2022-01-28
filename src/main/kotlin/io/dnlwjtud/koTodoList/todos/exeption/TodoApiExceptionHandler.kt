package io.dnlwjtud.koTodoList.todos.exeption

import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice


@RestControllerAdvice
class TodoApiExceptionHandler {

    @ExceptionHandler(Exception::class)
    fun commonException(e: Exception, model: Model): String {
        model.addAttribute("err_msg", e.message);
        return "error/400";
    }

}