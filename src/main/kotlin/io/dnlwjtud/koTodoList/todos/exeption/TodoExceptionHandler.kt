package io.dnlwjtud.koTodoList.todos.exeption

import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class TodoExceptionHandler {

    @ExceptionHandler(NoSuchElementException::class)
    fun noItemException(e : Exception, model: Model): String {
        model.addAttribute("err_msg", e.message);
        return "error/404";
    }

    @ExceptionHandler(Exception::class)
    fun commonException(e: Exception, model: Model): String {
        model.addAttribute("err_msg", e.message);
        return "error/400";
    }

}