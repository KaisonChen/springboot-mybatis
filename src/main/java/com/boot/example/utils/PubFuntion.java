package com.boot.example.utils;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class PubFuntion {

    /**
     * 计算传入字符串的 SHA-1 的摘要值
     *
     */
    public static String getSHA(String spara) {
        String sRtn = null;
        try {
            byte[] plainText = spara.getBytes("UTF8");

            // 使用getInstance("算法")来获得消息摘要,这里使用SHA-1的160位算法
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            // 开始使用算法
            messageDigest.update(plainText);
            // 输出算法运算结果
            sRtn = new BASE64Encoder().encode(messageDigest.digest());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return sRtn;
    }

    public static String fieldFormat(String str){

        if(str != null && str.length() >0){
                String regEx = "^\\b\\d{1,}.{1}";
            Pattern pattern = Pattern.compile(regEx);
            Matcher matcher = pattern.matcher(str);
            str = matcher.replaceAll("");
        }

        return str;
    }

    public static String getNowYear(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = new Date();
        return sdf.format(date);
    }

}
