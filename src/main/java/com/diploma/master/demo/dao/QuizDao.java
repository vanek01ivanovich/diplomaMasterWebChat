package com.diploma.master.demo.dao;

import com.diploma.master.demo.model.Quiz;

public interface QuizDao {
    void createQuiz(Quiz quiz);

    Quiz findQuizByName(String name);

    void publishQuiz();

    void validateQuiz();

    void removeQuiz();

    void deactivateQuiz();

    void editQuiz(Quiz quiz);

    void createQuestions();

    void markFavoriteQuiz();

    void removeFavoriteQuiz();

    void markCompleteQuiz();
}
