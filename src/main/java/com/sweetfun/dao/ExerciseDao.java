package com.sweetfun.dao;

import com.sweetfun.domain.Exercise;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ExerciseDao {
    public List<Exercise> getAllExercises(@Param("pageSize") Integer pageSize, @Param("page") Integer page);

    public List<Exercise> filter(@Param("exerciseType") Integer exerciseType, @Param("label") int[] label,
                                 @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    public List<Exercise> findByNumber(@Param("number") Integer number);

    public int count();

    public String[] findLabelName(@Param("list") int[] list);
}
