package com.quiz.controller;

import com.quiz.entities.Quiz;
import com.quiz.services.QuizService;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    private QuizService quizService;

            public QuizController(QuizService quizService){
        this.quizService=quizService;
            }

            //create
            @PostMapping
            public Quiz create(@RequestBody Quiz quiz ){
        return quizService.add(quiz);
            }

//get all
    @GetMapping
    public List<Quiz> get() {
        return quizService.get();
    }

    //get all
    @GetMapping("/{id}")
    public Quiz getOne(@PathVariable Long id) {
        return quizService.get(id);
    }

}
