package io.dnlwjtud.koTodoList.todos.domain

import io.dnlwjtud.koTodoList.todos.dto.TodoUpdateForm
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Todo(

    @Id
    @Column(name = "todo_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,
    var task: String,
    var description: String,
    var isComplete: Boolean,
    var regDate: LocalDateTime = LocalDateTime.now(),
    var updateDate: LocalDateTime = LocalDateTime.now()

) {

    fun updateTodo(todoUpdateForm: TodoUpdateForm) {

        this.task = todoUpdateForm.task;
        this.description = todoUpdateForm.description;
        this.isComplete = todoUpdateForm.isComplete;

        this.updateDate = LocalDateTime.now();

    }

}