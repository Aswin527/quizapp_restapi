package com.example.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.quizapp.model.Question;
import com.example.quizapp.services.QuestionService;

@RestController
@RequestMapping("questions")
public class QuestionsController {
	
	@Autowired
	QuestionService questionService ;
	
	@GetMapping("getAll")
	public List<Question> getAllQuestions(){
		return questionService.getAllQuestions();
	}
	
	@GetMapping("getByCat/{queCat}")
	public List<Question> getQuestionsByCat(@PathVariable String queCat){
		return questionService.getQuestionsByCat(queCat);
	}
	
	@PostMapping("addQues")
	public String addQues(@RequestBody Question question) {
		return questionService.addQues(question);
	}
}
