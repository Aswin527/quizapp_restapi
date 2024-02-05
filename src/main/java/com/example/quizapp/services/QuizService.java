package com.example.quizapp.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.quizapp.dao.QuestionDao;
import com.example.quizapp.dao.QuizDao;
import com.example.quizapp.model.Question;
import com.example.quizapp.model.QuestionWrapper;
import com.example.quizapp.model.Quiz;

@Service
public class QuizService {

	@Autowired
	QuizDao quizDao;
	@Autowired
	QuestionDao questionDao;
	
	public ResponseEntity<String> createQuizByCategory(String cat, int numQ, String title) {
		
		List<Question> queList=questionDao.findQuestionsByCategory(cat,numQ);
		
		Quiz quiz=new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(queList);
		
		quizDao.save(quiz);
		
		return new ResponseEntity<>("Sucess",HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Integer id) {
		Optional<Quiz> quiz=quizDao.findById(id);
		List<Question> questionsFromDB=quiz.get().getQuestions();
		List<QuestionWrapper> questionsForUser=new ArrayList<QuestionWrapper>();
		
		for (Question q:questionsFromDB) {
			QuestionWrapper qw=new QuestionWrapper(q.getId(), q.getQueTitle(), q.getOpt1(), q.getOpt2(), q.getOpt3(), q.getOpt4());
			questionsForUser.add(qw);
		}
		return new ResponseEntity<List<QuestionWrapper>>(questionsForUser,HttpStatus.OK);
	}

	
}
