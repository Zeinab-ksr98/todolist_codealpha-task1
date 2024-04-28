package com.dgpad.thyme.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Todo {
    @Id
    @Column(name = "todo_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String title;
    private String description;
    private boolean completed;

}
