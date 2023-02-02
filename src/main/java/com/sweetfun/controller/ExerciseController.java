package com.sweetfun.controller;

import com.alibaba.fastjson.JSONObject;
import com.sweetfun.domain.Exercise;
import com.sweetfun.domain.vo.ExerciseVo;
import com.sweetfun.service.ExerciseService;
import com.sweetfun.utils.Consts;
import com.sweetfun.utils.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RequestMapping("/exercise")
@RestController
public class ExerciseController {
    @Autowired
    private ExerciseService exerciseService;
    private SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @RequestMapping(value = "/getAllExercise", method = RequestMethod.GET)
    public Object getAllExercises(@RequestParam Integer pageSize, @RequestParam Integer pageNum) {
        JSONObject jsonObject = new JSONObject();
        try {
            List<Exercise> allExercises = exerciseService.getAllExercises(pageSize, pageSize * (pageNum - 1));
            List<ExerciseVo> list = new ArrayList<>();
            if(!allExercises.isEmpty()) {
                list = findLabelName(allExercises);
            }
            int count = exerciseService.count();
            if(!list.isEmpty()) {
                jsonObject.put(Consts.CODE, 1);
                jsonObject.put(Consts.DATA, list);
                jsonObject.put("total", count);
                jsonObject.put(Consts.MSG, "查询成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put(Consts.CODE, 0);
            jsonObject.put(Consts.DATA, null);
            jsonObject.put(Consts.MSG, e.getMessage());
        }
        return jsonObject;
    }

    @RequestMapping(value = "filter", method = RequestMethod.GET)
    public Object filter(@RequestParam(required = false) Integer exerciseType, @RequestParam(required = false) String[] label,
                         @RequestParam(required = false) String startTime, @RequestParam(required = false) String endTime) throws ParseException {

        // 将String类型数组变为int类型
        int[] ints = Arrays.asList(label).stream().mapToInt(Integer::parseInt).toArray();

        if(ints.length == 0) {
            ints = null;
        }
        if(startTime.equals("undefined")) {
            startTime = null;
        }
        if(endTime.equals("undefined")) {
            endTime = null;
        }

        JSONObject jsonObject = new JSONObject();

        try {
            List<Exercise> filter = exerciseService.filter(exerciseType, ints,
                    startTime == null ? null : DateUtils.str2Date(startTime),
                    endTime == null ? null : DateUtils.str2Date(endTime));
            List<ExerciseVo> labelName = new ArrayList<>();
            if(!filter.isEmpty()) {
                labelName = findLabelName(filter);
            }
            jsonObject.put(Consts.CODE, 1);
            jsonObject.put(Consts.DATA, labelName);
            jsonObject.put(Consts.MSG, "筛选成功");
        } catch (Exception e) {
            jsonObject.put(Consts.CODE, 0);
            jsonObject.put(Consts.DATA, null);
            jsonObject.put(Consts.MSG, e.getMessage());
            e.printStackTrace();
        }
        return jsonObject;
    }

    @RequestMapping(value = "/findByNumber", method = RequestMethod.GET)
    public Object findByNumber(@RequestParam(required = true) Integer number) {
        JSONObject jsonObject = new JSONObject();
        try {
            List<Exercise> byNumber = exerciseService.findByNumber(number);
            if (!byNumber.isEmpty()) {
                jsonObject.put(Consts.CODE, 1);
                jsonObject.put(Consts.DATA, byNumber);
                jsonObject.put(Consts.MSG, "筛选成功");
            }
         } catch (Exception e) {
            jsonObject.put(Consts.CODE, 0);
            jsonObject.put(Consts.DATA, null);
            jsonObject.put(Consts.MSG, e.getMessage());
            e.printStackTrace();
        }
        return jsonObject;
    }

    public List<ExerciseVo> findLabelName(List<Exercise> list) {
        List<ExerciseVo> fullList = new ArrayList<>();
        for (Exercise allExercise : list) {
            ExerciseVo exerciseVo = new ExerciseVo();
            BeanUtils.copyProperties(allExercise, exerciseVo);      // 将父对象的值赋给子对象
            if (allExercise.getLabel() != null) {
                String[] labelName = exerciseService.findLabelName(Arrays.stream(allExercise.getLabel().split(",")).mapToInt(Integer::parseInt).toArray());
                exerciseVo.setLabelName(labelName);
            }
            fullList.add(exerciseVo);
        }
        return fullList;
    }
}
