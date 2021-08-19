package com.jda.overflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jda.overflow.models.Answer;
import com.jda.overflow.models.Question;
import com.jda.overflow.models.Tag;
import com.jda.overflow.repositories.AnswerRepo;
import com.jda.overflow.repositories.QuestionRepo;
import com.jda.overflow.repositories.TagRepo;

@Service
public class MainService {
	
	@Autowired
	private QuestionRepo questionRepo;
	
	@Autowired
	private AnswerRepo answerRepo;
	
	@Autowired
	private TagRepo tagRepo;

//	QUESTIONS:
//	CREATE
	public Question createQuestion(Question question) {
		return questionRepo.save(question);
	}
//	UPDATE
	public Question updateQuestion(Question question) {
		return questionRepo.save(question);
	}
//	GET ALL
	public List<Question> allQuestions() {
		return questionRepo.findAll();
	}
//	GET ONE
	public Question oneQuestion(Long id) {
		Optional<Question> optional = questionRepo.findById(id);
		if(!optional.isEmpty()) {
			return optional.get();
		}
		else {
			return null;
		}
	}
	
//	ANSWERS:
//	CREATE
	public Answer createAnswer(Answer answer) {
		return answerRepo.save(answer);
	}
	
//	TAGS:
//	CREATE
	public Tag createTag(Tag tag) {
		return tagRepo.save(tag);
	}
	public List<Tag> allTags() {
		return tagRepo.findAll();
	}
//	GET ONE
	public Tag oneTag(Long id) {
		Optional<Tag> optional = tagRepo.findById(id);
		if(!optional.isEmpty()) {
			return optional.get();
		}
		else {
			return null;
		}
	}
}
