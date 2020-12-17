package com.example.administrator;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/2.
 */

public class SpSave {
    public static boolean saveUserInfo(Context context, String name, String password) {
        SharedPreferences sp = context.getSharedPreferences("data.txt",Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putString("name",name);
        edit.putString("password",password);
        edit.commit();
        return true;
    }
    public static Map<String,String> getUserInfo(Context context)
    {
        SharedPreferences sp = context.getSharedPreferences("data.txt",Context.MODE_PRIVATE);
        String name = sp.getString("name",null);
        String password = sp.getString("password",null);
        Map<String,String> userMap = new HashMap<String, String>();
        userMap.put("name",name);
        userMap.put("password",password);
        return userMap;
    }
}
