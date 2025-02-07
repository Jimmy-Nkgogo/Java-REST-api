package com.nkgogojimmy.learners.service;

import com.nkgogojimmy.learners.model.LearnerModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LearnerService {
    private List<LearnerModel> learners;

    public LearnerService() {
        learners = new ArrayList<>();

        LearnerModel learner1 = new LearnerModel(1,"Jimmy","Nkgogo",1001);
        LearnerModel learner2 = new LearnerModel(2,"Tshiamo","Madisa",1002);
        LearnerModel learner3 = new LearnerModel(3,"Lautrie","Mofustana",1003);

        learners.add(learner1);
        learners.add(learner2);
        learners.add(learner3);
    }

    public LearnerModel getLearner(int id) {
        for(LearnerModel learner: learners) {
            if (learner.getId() == id) {
                return learner;
            }
        }
        return null;
    }

    public List<LearnerModel> getLearners() {
        return learners;
    }

    public void createLearner(int id, String name, String surname, int studentNumber) {
        LearnerModel learner = new LearnerModel(id, name, surname, studentNumber);
        learners.add(learner);

    }
}
