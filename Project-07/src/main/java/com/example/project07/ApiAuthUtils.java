package com.example.project07;

import cn.hutool.crypto.SecureUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ApiAuthUtils {

    public static String generateNonce(Map<String,String> body, String appsecret) {
        List<String> sortedKeys = new ArrayList<>(body.keySet());
        Collections.sort(sortedKeys);
        // 拼接键值对成字符串s1
        StringBuilder s1Builder = new StringBuilder();
        for (String key : sortedKeys) {
            String value = body.get(key);
            if (value != null && !value.isEmpty()) {
                if (s1Builder.length() > 0) {
                    s1Builder.append("&");
                }
                s1Builder.append(key).append("=").append(value);
            }
        }
        String s1 = s1Builder.toString();
        String s2 = s1 + appsecret;
        String md5Sign = SecureUtil.md5(s2);
        return md5Sign.toLowerCase();
    }

}