package com.jda.overflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jda.overflow.models.Answer;

public interface AnswerRepo extends CrudRepository<Answer, Long> {

	List<Answer> findAll();
	
}
