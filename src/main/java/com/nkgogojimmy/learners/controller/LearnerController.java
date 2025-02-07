package com.nkgogojimmy.learners.controller;

import com.nkgogojimmy.learners.model.LearnerModel;
import com.nkgogojimmy.learners.service.LearnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LearnerController {
    @Autowired
    LearnerService learnerService;

    @GetMapping("/learners/{id}")
    public ResponseEntity <LearnerModel> getLearner(@PathVariable int id) {
        return new ResponseEntity<>(learnerService.getLearner(id), HttpStatus.OK);

    }

    @GetMapping("/learners")
    public List<LearnerModel> getLearners() {
        return learnerService.getLearners();
    }

    @PostMapping( value = "/add-learner")
    public ResponseEntity<String> addLearner(@RequestBody LearnerModel learner) {
        learnerService.createLearner(learner.getId(),learner.getName(),learner.getSurname(),learner.getStudentNumber());
        return new ResponseEntity<String>("Learner is created successfully", HttpStatus.CREATED);
    }
}