package com.sweetfun.utils;
import java.security.SecureRandom;
public class UniqueKeyGenerator {
    public static String generateUniqueKey() {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        while (sb.length() < 11) {
            int num = random.nextInt(10); // 生成0-9之间的随机数
            sb.append(num);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String uniqueKey = generateUniqueKey();
        System.out.println("Unique key: " + uniqueKey);
    }
}
