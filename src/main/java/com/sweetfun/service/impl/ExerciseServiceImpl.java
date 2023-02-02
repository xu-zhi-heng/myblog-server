package com.sweetfun.service.impl;

import com.sweetfun.dao.ExerciseDao;
import com.sweetfun.domain.Exercise;
import com.sweetfun.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ExerciseServiceImpl implements ExerciseService {
    @Autowired
    private ExerciseDao exerciseDao;
    @Override
    public List<Exercise> getAllExercises(Integer pageSize, Integer page) {
        return exerciseDao.getAllExercises(pageSize, page);
    }

    @Override
    public List<Exercise> filter(Integer exerciseType, int[] label, Date startTime, Date endTime) {
        return exerciseDao.filter(exerciseType, label, startTime, endTime);
    }

    @Override
    public List<Exercise> findByNumber(Integer number) {
        return exerciseDao.findByNumber(number);
    }

    @Override
    public int count() {
        return exerciseDao.count();
    }

    @Override
    public String[] findLabelName(int[] list) {
        return exerciseDao.findLabelName(list);
    }
}
