package com.db.tojson.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.db.tojson.entity.JsonValues;


@Repository
public interface DbToJsonRepository extends JpaRepository<JsonValues, Integer> {
	 
	 
}
