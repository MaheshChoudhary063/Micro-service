package com.microservices.QuizService.services.impl;

import com.microservices.QuizService.entities.Quiz;
import com.microservices.QuizService.repositories.QuizRepository;
import com.microservices.QuizService.services.QuestionClient;
import com.microservices.QuizService.services.QuizServices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class QuizServiceImpl implements QuizServices {

    private QuizRepository quizRepository;
    private QuestionClient questionClient;

    public QuizServiceImpl(QuizRepository quizRepository, QuestionClient questionClient) {
        this.quizRepository = quizRepository;
        this.questionClient = questionClient;
    }

    @Override
    public Quiz add(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> get() {
        List<Quiz> quizzes =quizRepository.findAll();
        List<Quiz> newQuizList=quizzes.stream().map(quiz -> {
            quiz.setQuestions(questionClient.getQuestionofQuiz(quiz.getId()));
            return quiz;
        }).collect(Collectors.toList());
        return newQuizList;
    }

    @Override
    public Quiz get(Long id) {
        Quiz quiz=quizRepository.findById(id).orElseThrow(()->new RuntimeException("Not Found"));
        quiz.setQuestions(questionClient.getQuestionofQuiz(quiz.getId()));
        return quiz;
    }
}
