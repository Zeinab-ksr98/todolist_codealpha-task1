package com.dgpad.thyme.Repository;

import com.dgpad.thyme.Model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface todoRepository extends JpaRepository<Todo, Integer> {


}