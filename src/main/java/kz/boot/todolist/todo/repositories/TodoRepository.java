package kz.boot.todolist.todo.repositories;

import kz.boot.todolist.todo.models.Todos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TodoRepository extends JpaRepository<Todos, Long> {

//    @Query(value = "update t_todo set done=1 where id=(:task_id)", nativeQuery = true)
//    boolean updateTask(@Param("task_id") Long task_id);
}
