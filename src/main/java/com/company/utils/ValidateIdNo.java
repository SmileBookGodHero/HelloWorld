package com.company.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lilei
 * @time 2019-10-09 09:33
 * @description
 */

public class ValidateIdNo {
    // 1-17位相乘因子数组
    private static final int[] FACTOR = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
    // 18位随机码数组
    private static final char[] RANDOM = "10X98765432".toCharArray();
    // 18位身份证号码正则
    private static String ID_CARD_18_REGEX = "^[1-9](\\d{5})(19|20)(\\d{2})((0[1-9])|10|11|12)(([0-2][1-9])|10|20|30|31)(\\d{3})(\\d|X|x)$";
    // 15位身份证号码正则
    private static String ID_CARD_15_REGEX = "^[1-9](\\d{5})(\\d{2})((0[1-9])|10|11|12)(([0-2][1-9])|10|20|30|31)(\\d{3})$";
    // 平年日期正则
    private static String ORDINARY_YEAR_REGEX = "(((0[13578])|10|12)(([0-2][1-9])|10|20|30|31)|(((0[469])|11)(([0-2][1-9])|10|20|30))|(02(([0-2][1-8])|09|19|10|20)))";
    // 闰年日期正则
    private static String LEAP_YEAR_REGEX = "(((0[13578])|10|12)(([0-2][1-9])|10|20|30|31)|(((0[469])|11)(([0-2][1-9])|10|20|30))|(02(([0-2][1-9])|10|20)))";

    public static void main(String[] args) {

        // 输入的身份证号码
        String certnum = "54262219850513339X";

        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = true;

        // 判断第18位校验值
        if (certnum.length() == 18) {
            flag1 = regexValidate(ID_CARD_18_REGEX, certnum);

            // 判断是不是闰年，并匹配日期是否规范
            int year = Integer.parseInt(certnum.substring(6, 10));
            if (year % 4 == 0) {
                flag2 = regexValidate(LEAP_YEAR_REGEX, certnum.substring(10, 14));
            } else {
                flag2 = regexValidate(ORDINARY_YEAR_REGEX, certnum.substring(10, 14));
            }

            char[] charArray = certnum.toCharArray();
            char idCardLast = charArray[17];
            // 计算1-17位与相应因子乘积之和
            int total = 0;
            for (int i = 0; i < 17; i++) {
                total += Character.getNumericValue(charArray[i]) * FACTOR[i];
            }
            // 判断随机码是否相等
            char ch = RANDOM[total % 11];
            // System.out.println(ch);

            if (!String.valueOf(ch).toUpperCase().equals(String.valueOf(idCardLast).toUpperCase())) {
                flag3 = false;
            }
        } else if (certnum.length() == 15) {
            flag1 = regexValidate(ID_CARD_15_REGEX, certnum);
            flag2 = regexValidate(ORDINARY_YEAR_REGEX, certnum.substring(8, 12));
        }

        // System.out.println(flag3);
        if (!flag1 || !flag2 || !flag3) {
            System.out.println("不正确的身份证号格式！");
        } else {
            System.out.println("验证通过！");
        }

    }

    private static boolean regexValidate(String regex, String value) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        return matcher.find();
    }
}
