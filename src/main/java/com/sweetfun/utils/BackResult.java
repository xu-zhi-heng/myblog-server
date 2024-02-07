package com.sweetfun.utils;

import com.alibaba.fastjson.JSONObject;

public class BackResult {
    public static Object result(int code, String message, Object data) {
        JSONObject jsonObject = new JSONObject();
        if (code == 0) {
            jsonObject.put(Consts.CODE,1);
            jsonObject.put(Consts.MSG,message);
            jsonObject.put(Consts.DATA,null);
        } else {
            jsonObject.put(Consts.CODE,1);
            jsonObject.put(Consts.MSG,message);
            jsonObject.put(Consts.DATA,data);
        }
        return jsonObject;
    }
}
