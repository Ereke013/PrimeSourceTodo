package kz.boot.todolist.todo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "t_todo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "date")
    private Timestamp date;

    @Column(name = "priority")
    private int priority;

    @Column(name = "description")
    private String description;

    @Column(name = "done")
    private int done;
}
