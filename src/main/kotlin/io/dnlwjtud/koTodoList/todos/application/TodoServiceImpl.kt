package io.dnlwjtud.koTodoList.todos.application

import io.dnlwjtud.koTodoList.todos.dao.TodoRepository
import io.dnlwjtud.koTodoList.todos.domain.Todo
import io.dnlwjtud.koTodoList.todos.dto.TodoSaveForm
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
@Transactional(readOnly = true)
class TodoServiceImpl(
    private val todoRepository: TodoRepository
) : TodoService {

    @Transactional
    override fun save(todoSaveForm: TodoSaveForm) : Long? {

        val todo = Todo(
            null,
            todoSaveForm.task,
            todoSaveForm.description,
            todoSaveForm.isComplete
        );

        return todoRepository.save(todo).id;
    }

    override fun findById(id: Long) {
        TODO("Not yet implemented")
    }
}