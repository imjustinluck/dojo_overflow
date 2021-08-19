package com.jda.overflow.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jda.overflow.models.Answer;
import com.jda.overflow.models.Question;
import com.jda.overflow.models.Tag;
import com.jda.overflow.services.MainService;

@Controller
public class MainController {

	@Autowired
	private MainService service;

//	QUESTIONS ROUTES
//	SHOW ALL
	@GetMapping("/questions")
	public String index(Model model) {
		model.addAttribute("questions", service.allQuestions());
		return "index.jsp";
	}
//	CREATE QUESTION AND TAG
	@GetMapping("/questions/new")
	public String newQuestion(@ModelAttribute("createQuestion") Question question) {
		return "question.jsp";
	}
	@PostMapping("/questions/new")
	public String createQuestion(@Valid @ModelAttribute("createQuestion") Question question,
			BindingResult result, @RequestParam("subject") String subject) {
		if(result.hasErrors()) {
			return "question.jsp";
		}
		else {
			Question quest = service.createQuestion(question);
			Tag t = service.createTag(new Tag(subject));
			
//			Tag list is initially made in model
			quest.getTags().add(t);
			service.updateQuestion(quest);
			
			return "redirect:/questions";
		}
	}
//	SHOW ONE QUESTION
	@GetMapping("/questions/{id}")
	public String newAnswer(@ModelAttribute("createAnswer") Answer answer,
			@PathVariable("id") Long id, Model model) {
		Question question = service.oneQuestion(id);
		if(question == null) {
			return "redirect:/questions";
		}
		else {
			model.addAttribute("question",question);
		}
		return "showQuestion.jsp";
	}
	@PostMapping("/questions/{id}")
	public String createAnswer(@Valid @ModelAttribute("createAnswer") Answer answer, 
			BindingResult result, @PathVariable("id") Long id, Model model) {
		System.out.println(answer.getId());
		System.out.println(answer.getAnswer());
		System.out.println(answer.getQuestion().getQuestion());
		
		if(result.hasErrors()) {
			Question question = service.oneQuestion(id);
			model.addAttribute("question", question);
			return "showQuestion.jsp";
		}
		else {
			answer.setId(null);
//			HERE - Justin: we set Id to null to it stops updating
			service.createAnswer(answer);
			return "redirect:/questions/" + id;
		}
	}
}
