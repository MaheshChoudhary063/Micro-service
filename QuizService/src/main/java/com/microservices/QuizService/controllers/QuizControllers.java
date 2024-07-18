package com.microservices.QuizService.controllers;

import com.microservices.QuizService.entities.Quiz;
import com.microservices.QuizService.services.QuizServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/quiz")
public class QuizControllers {
    private QuizServices quizServices;

    public QuizControllers(QuizServices quizServices) {
        this.quizServices = quizServices;
    }


    @PostMapping
    public Quiz create(@RequestBody Quiz quiz){
        return quizServices.add(quiz);
    }

    @GetMapping
    public List<Quiz> get(){
        return quizServices.get();
    }

    @GetMapping("{id}")
    public Quiz getOne(@PathVariable Long id){
        return quizServices.get(id);
    }
}
