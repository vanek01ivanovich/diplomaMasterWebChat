package com.diploma.master.demo.dao.impl;

import com.diploma.master.demo.dao.QuizDao;
import com.diploma.master.demo.model.Quiz;
import org.springframework.stereotype.Repository;

@Repository
public class QuizDaoImpl implements QuizDao {
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
