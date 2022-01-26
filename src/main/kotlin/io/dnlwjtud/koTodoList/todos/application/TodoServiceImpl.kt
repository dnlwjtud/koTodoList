package io.dnlwjtud.koTodoList.todos.application

import io.dnlwjtud.koTodoList.todos.dao.TodoRepository
import io.dnlwjtud.koTodoList.todos.domain.Todo
import io.dnlwjtud.koTodoList.todos.dto.TodoDTO
import io.dnlwjtud.koTodoList.todos.dto.TodoSaveForm
import io.dnlwjtud.koTodoList.todos.dto.TodoUpdateForm
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*
import kotlin.NoSuchElementException
import kotlin.streams.toList


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

    override fun findById(id: Long) : Optional<Todo> {
        return todoRepository.findById(id)
    }

    override fun getOne(id: Long): TodoDTO {

        return todoRepository.findById(id)
            .get()
            .let {
                t ->
                t.id?.let { TodoDTO(it, t.task, t.description, t.isComplete) }
            }
            ?: throw NoSuchElementException("해당 할일은 존재하지 않습니다.")

    }

    override fun getList(): List<TodoDTO> {

        return todoRepository.findAll()
            .stream()
            .map {
                t ->
                t.id?.let { TodoDTO(it,t.task,t.description,t.isComplete) }
            }
            .toList();

    }

    @Transactional
    override fun update(todoUpdateForm: TodoUpdateForm, id: Long) {

        todoRepository.findById(id)
            .get()
            .updateTodo(
                todoUpdateForm
            )
            ?: throw NoSuchElementException("해당 할일은 존재하지 않습니다.")

    }

    @Transactional
    override fun delete(id: Long) {
        todoRepository.delete(findById(id).get());
    }

}