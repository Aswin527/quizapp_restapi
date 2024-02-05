package com.example.quizapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String queType;
	private String queCat;
	private String queTitle;
	private String opt1;
	private String opt2;
	private String opt3;
	private String opt4;
	private String ansKey;
}
