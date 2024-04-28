package com.sweetfun.utils;

import com.alibaba.fastjson.JSONObject;

public class BackResult {
    public static Object result(int code, String message, Object data) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Consts.CODE,code);
        jsonObject.put(Consts.MSG,message);
        jsonObject.put(Consts.DATA,data);
        return jsonObject;
    }
}
