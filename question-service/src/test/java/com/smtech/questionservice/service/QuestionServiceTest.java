package com.smtech.questionservice.service;

import com.smtech.questionservice.Dao.QuestionDao;
import com.smtech.questionservice.model.Question;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class QuestionServiceTest {

    // Mocking the QuestionDao
    private QuestionDao questionDao = mock(QuestionDao.class);
    private QuestionService questionService = new QuestionService(questionDao);

    @Test
    public void testGetAllQuestions() {
        // Mocking behavior of questionDao.findAll()
        List<Question> mockQuestions = new ArrayList<>();
        when(questionDao.findAll()).thenReturn(mockQuestions);

        // Testing getAllQuestions method
        ResponseEntity<List<Question>> responseEntity = questionService.getAllQuestions();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockQuestions, responseEntity.getBody());
    }

    @Test
    public void testGetQuestionsByCategory() {
        // Mocking behavior of questionDao.findByCategory()
        String category = "TestCategory";
        List<Question> mockQuestions = new ArrayList<>();
        when(questionDao.findByCategory(category)).thenReturn(mockQuestions);

        // Testing getQuestionsByCategory method
        ResponseEntity<List<Question>> responseEntity = questionService.getQuestionsByCategory(category);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockQuestions, responseEntity.getBody());
    }
}