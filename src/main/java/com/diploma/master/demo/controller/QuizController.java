package com.diploma.master.demo.controller;

import com.diploma.master.demo.model.Quiz;
import com.diploma.master.demo.service.QuizService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/quiz")
@RestController
public class QuizController {

    private QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/find/{quizName}")
    public Quiz findQuizByName(@PathVariable String quizName){
        return null;
    }

    @PostMapping("/create")
    public void createQuiz(@RequestBody Quiz quiz){

    }

    @PostMapping("/publish")
    public void publishQuiz(){

    }

    @PostMapping("/validate")
    public void validateQuiz(){

    }

    @PostMapping("/remove/{quizId}")
    public void removeQuiz(@PathVariable Integer quizId){

    }

    @PostMapping("/deactivate/{quizId}")
    public void deactivateQuiz(@PathVariable Integer quizId){

    }

    @PostMapping("/edit")
    public void editQuiz(@RequestBody Quiz quiz){

    }

    //todo mark as favorite/completed quiz

}
