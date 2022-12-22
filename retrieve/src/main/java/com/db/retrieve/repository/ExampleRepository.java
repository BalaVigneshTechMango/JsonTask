package com.db.retrieve.repository;

import java.util.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.db.retrieve.entity.ExampleFiles;
@Repository
public interface ExampleRepository extends JpaRepository<Map, Integer>{

}
