package com.example.quizapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.quizapp.model.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer>{

	List<Question> findByQueCat(String queCat);

	@Query(value = "SELECT * FROM question q WHERE q.que_cat= :cat ORDER BY RANDOM() LIMIT :numQ",nativeQuery = true)
	List<Question> findQuestionsByCategory(String cat, int numQ);
	
}
