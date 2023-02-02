package com.sweetfun.service;

import com.sweetfun.domain.Exercise;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ExerciseService {
    public List<Exercise> getAllExercises(Integer pageSize, Integer page);
    public List<Exercise> filter(Integer exerciseType, int[] label, Date startTime, Date endTime);
    public List<Exercise> findByNumber(Integer number);
    public int count();

    public String[] findLabelName(int[] list);
}
