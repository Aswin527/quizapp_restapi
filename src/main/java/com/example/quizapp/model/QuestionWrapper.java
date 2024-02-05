package com.example.quizapp.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QuestionWrapper {
	private int id;
	private String queTitle;
	private String opt1;
	private String opt2;
	private String opt3;
	private String opt4;
}
