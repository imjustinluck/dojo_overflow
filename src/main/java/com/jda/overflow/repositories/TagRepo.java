package com.jda.overflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jda.overflow.models.Tag;

public interface TagRepo extends CrudRepository<Tag, Long> {

	List<Tag> findAll();
	
}
