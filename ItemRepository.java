package com.example.Task31.repositoryies;

import com.example.Task31.entity.Item;
import com.example.Task31.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long>{
}
