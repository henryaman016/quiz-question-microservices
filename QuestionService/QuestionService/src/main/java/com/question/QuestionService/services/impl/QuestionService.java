package com.question.QuestionService.services.impl;

import com.question.QuestionService.entities.Question;
import com.question.QuestionService.repositories.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService implements com.question.QuestionService.services.QuestionService {

    private QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question create(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> get() {
        return questionRepository.findAll();
    }

    @Override
    public Question getOne(Long id) {
        return questionRepository.findById(id).orElseThrow(()->new RuntimeException("Question not found"));
    }

    @Override
    public List<Question> getQuestionsOfQuiz(Long quizId) {
        return questionRepository.findByQuizId(quizId);
    }
}
