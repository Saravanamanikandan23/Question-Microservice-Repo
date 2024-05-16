package com.smtech.questionservice.controller;

import com.smtech.questionservice.model.Question;
import com.smtech.questionservice.model.QuestionWrapper;
import com.smtech.questionservice.model.Responce;
import com.smtech.questionservice.service.QuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class QuestionControllerTest {

    private QuestionService questionService = mock(QuestionService.class);
    private QuestionController questionController = new QuestionController(questionService);

    @Test
    public void testGetAllQuestions() {
        List<Question> mockQuestions = new ArrayList<>();
        when(questionService.getAllQuestions()).thenReturn(new ResponseEntity<>(mockQuestions, HttpStatus.OK));

        ResponseEntity<List<Question>> responseEntity = questionController.getAllQuestions();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockQuestions, responseEntity.getBody());
    }

    @Test
    public void testGetQuestionsByCategory() {
        String category = "TestCategory";
        List<Question> mockQuestions = new ArrayList<>();
        when(questionService.getQuestionsByCategory(category)).thenReturn(new ResponseEntity<>(mockQuestions, HttpStatus.OK));

        ResponseEntity<List<Question>> responseEntity = questionController.getQuestionsByCategory(category);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockQuestions, responseEntity.getBody());
    }

    @Test
    public void testAddQuestion() {
        Question mockQuestion = new Question();
        when(questionService.addQuestion(mockQuestion)).thenReturn(new ResponseEntity<>("success", HttpStatus.CREATED));

        ResponseEntity<String> responseEntity = questionController.addQuestion(mockQuestion);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals("success", responseEntity.getBody());
    }

    @Test
    public void testGetQuestionsForQuiz() {
        String categoryName = "TestCategory";
        int numQuestions = 5;
        List<Integer> mockQuestionIds = new ArrayList<>();
        when(questionService.getQuestionForQuiz(categoryName, numQuestions)).thenReturn(new ResponseEntity<>(mockQuestionIds, HttpStatus.OK));

        ResponseEntity<List<Integer>> responseEntity = questionController.getQuestionsForQuiz(categoryName, numQuestions);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockQuestionIds, responseEntity.getBody());
    }

    @Test
    public void testGetQuestionsFromId() {
        List<Integer> questionIds = new ArrayList<>();
        List<QuestionWrapper> mockWrappers = new ArrayList<>();
        when(questionService.getQuestionsFromId(questionIds)).thenReturn(new ResponseEntity<>(mockWrappers, HttpStatus.OK));

        ResponseEntity<List<QuestionWrapper>> responseEntity = questionController.getQuestionsFromId(questionIds);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockWrappers, responseEntity.getBody());
    }

    @Test
    public void testGetScore() {
        List<Responce> responces = new ArrayList<>();
        int mockScore = 5;
        when(questionService.getScore(responces)).thenReturn(new ResponseEntity<>(mockScore, HttpStatus.OK));

        ResponseEntity<Integer> responseEntity = questionController.getScore(responces);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockScore, responseEntity.getBody().intValue());
    }

}