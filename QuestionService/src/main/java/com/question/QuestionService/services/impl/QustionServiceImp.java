package com.question.QuestionService.services.impl;

import com.question.QuestionService.entities.Question;
import com.question.QuestionService.repositories.QuestionRepo;
import com.question.QuestionService.services.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QustionServiceImp implements QuestionService {

    private QuestionRepo questionRepo;

    public QustionServiceImp(QuestionRepo questionRepo) {
        this.questionRepo = questionRepo;
    }


    @Override
    public Question create(Question question) {
        return questionRepo.save(question);
    }

    @Override
    public List<Question> get() {
        return questionRepo.findAll();
    }

    @Override
    public Question getOne(Long id) {
        return questionRepo.findById(id).orElseThrow(()->new RuntimeException("Not found Question"));
    }

    @Override
    public List<Question> getQuestionOfQuiz(Long quizId) {
        return questionRepo.findByQuizId(quizId);
    }
}
