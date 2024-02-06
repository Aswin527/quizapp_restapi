package com.example.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.quizapp.model.Question;
import com.example.quizapp.model.QuestionWrapper;
import com.example.quizapp.model.Responses;
import com.example.quizapp.services.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {

	@Autowired
	QuizService quizService;
	
	@PostMapping("create")
	public ResponseEntity<String> createQuiz(@RequestParam String cat,@RequestParam int numQ,@RequestParam String title) {
		return quizService.createQuizByCategory(cat,numQ,title);
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
		return quizService.getQuizQuestion(id);
	}
	
	@PostMapping("submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id,@RequestBody List<Responses> response){
		return quizService.submitQuiz(id,response);
	}
}
