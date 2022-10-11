package com.diploma.master.demo.service.serviceImpl;

import com.diploma.master.demo.dao.QuizDao;
import com.diploma.master.demo.model.Quiz;
import com.diploma.master.demo.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizServiceImpl implements QuizService {

    public QuizDao quizDao;

    @Autowired
    public QuizServiceImpl(QuizDao quizDao) {
        this.quizDao = quizDao;
    }

    @Override
    public void createQuiz(Quiz quiz) {

    }

    @Override
    public Quiz findQuizByName(String name) {
        return null;
    }

    @Override
    public void publishQuiz() {

    }

    @Override
    public void validateQuiz() {

    }

    @Override
    public void removeQuiz() {

    }

    @Override
    public void deactivateQuiz() {

    }

    @Override
    public void editQuiz(Quiz quiz) {

    }

    @Override
    public void createQuestions() {

    }

    @Override
    public void markFavoriteQuiz() {

    }

    @Override
    public void removeFavoriteQuiz() {

    }

    @Override
    public void markCompleteQuiz() {

    }
}
