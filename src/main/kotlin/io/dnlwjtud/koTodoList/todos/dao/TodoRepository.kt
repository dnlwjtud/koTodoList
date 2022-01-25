package io.dnlwjtud.koTodoList.todos.dao

import io.dnlwjtud.koTodoList.todos.domain.Todo
import org.springframework.data.jpa.repository.JpaRepository

interface TodoRepository : JpaRepository<Todo, Long> {



}