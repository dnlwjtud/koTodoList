package io.dnlwjtud.koTodoList.todos.application

import io.dnlwjtud.koTodoList.todos.dao.TodoRepository
import io.dnlwjtud.koTodoList.todos.dto.TodoSaveForm
import io.dnlwjtud.koTodoList.todos.dto.TodoUpdateForm
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class TodoServiceImplTest {

    @Autowired
    private lateinit var todoService: TodoService;

    @Autowired
    private lateinit var todoRepository: TodoRepository;

    @Test
    @DisplayName("할일 생성 테스트")
    fun saveTest(){

        // given
        val todoSaveForm = TodoSaveForm("할일 1", "정말 재밌어", false);
        todoService.save(todoSaveForm);

        // when
        val findTodo = todoService.getOne(1L);

        // then
        assertEquals(findTodo.task, "할일 1")

    }

    @Test
    @DisplayName("할일 리스트 테스트")
    fun listTest() {

        // given
        for ( i: Int in 1..10) {

            val todoSaveForm = TodoSaveForm("할일 $i", "정말 재밌어", false);
            todoService.save(todoSaveForm);

        }

        // when
        val todoList = todoService.getList();

        // then
        assertEquals(todoList.size, 10);

    }

    @Test
    @DisplayName("할일 수정 테스트")
    fun updateTest() {

        // given
        val todoSaveForm = TodoSaveForm("할일 1", "정말 재밌어", false);
        todoService.save(todoSaveForm);

        val todoUpdateForm = TodoUpdateForm("수정된 할일", "정말 대단해", true);

        todoRepository.flush()

        // when
        todoService.update(todoUpdateForm, 1L);

        todoRepository.flush()

        val findTodo = todoService.getOne(1L);

        // then
        assertEquals(findTodo.task, "수정된 할일")

    }

    @Test
    @DisplayName("할일 삭제 테스트")
    fun deleteTest() {

        // given
        for ( i: Int in 1..10) {

            val todoSaveForm = TodoSaveForm("할일 $i", "정말 재밌어", false);
            todoService.save(todoSaveForm);

        }

        // when
        todoService.delete(1L)

        val todoList = todoService.getList();



        // then
        assertEquals(todoList.size, 9);


    }

}