package com.geekaca.d4.regx;

public class TestRegexDemo3 {
    /**
     * 校验是否符合手机号码格式
     * 1开头
     * 总共11位
     * 2位 + 9位
     * 手机号码
     * 邮箱
     * 电话号码
     */
    public static void main(String[] args) {
        System.out.println(checkMobilePhone("2333333333333"));
        System.out.println(checkMobilePhone("18773294571"));
        System.out.println(checkMobilePhone("11028452245"));
        System.out.println("============");
        System.out.println(checkEmail("@qq.com"));
        System.out.println(checkEmail("a@com"));
        System.out.println(checkEmail("test@216.com"));
        System.out.println(checkEmail("test@216.com.cn"));
        System.out.println("===========");
        System.out.println(checkTel("023-213414123412"));
        System.out.println(checkTel("023-213414123412#"));

    }

    public static boolean checkMobilePhone(String phoneNumber){
        //固定1开头 \\d代表任意单个数字 {9}重复9次
        String rule = "1[3-9]\\d{9}";
        return phoneNumber.matches(rule);
    }

    /**
     * 判断邮箱格式
     */
    public static boolean checkEmail(String email){
        /**
         * 限制前边名字 限制1-30位
         * @固定
         * 域名 字母 数字组合 位数限制2-20位
         * 。 原样 需要加转义字符
         * 。后面 字母数字的组合
         */
        String rule = "\\w{1,30}@[a-zA-Z0-9]{2,20}(\\.[a-zA-z0-9]{2,20}){1,2}";
        return  email.matches(rule);
    }

    /**
     * 010-213456789
     *  固话0开头
     *  区号 2-6
     */
    public static boolean checkTel(String tel){
        //-?代表 出现一次 或者不出现
        String rule = "0\\d{2,6}-?\\d{5,20}";
        return tel.matches(rule);
    }
}
