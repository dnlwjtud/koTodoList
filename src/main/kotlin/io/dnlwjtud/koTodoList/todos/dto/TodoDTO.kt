package io.dnlwjtud.koTodoList.todos.dto

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class TodoDTO (
    @NotNull
    var id: Long,
    @NotBlank
    var task: String,
    @NotBlank
    var description: String,
    @NotNull
    var isComplete: Boolean
)
