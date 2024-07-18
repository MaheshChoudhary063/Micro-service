package com.microservices.QuizService.services;

import com.microservices.QuizService.entities.Quiz;

import java.util.List;

public interface QuizServices {

    Quiz add(Quiz quiz);

    List<Quiz> get();

    Quiz get(Long id);
}
