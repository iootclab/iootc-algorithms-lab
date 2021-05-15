package com.iootc.lab.freedom;

/**
 * 字符串常量
 *
 * <p>
 *
 * @author Johnathon Yuan
 * @since 2021-05-15 23:46
 */
public class StringPoolCase {

    public static void main(String[] args) {
        String toTheMoon = new StringBuilder("To").append(" the ").append("moon").toString();
        System.out.println(toTheMoon);
        System.out.println(toTheMoon.intern());
        System.out.println(toTheMoon == toTheMoon.intern());

        System.out.println();

        String lunaBase = new StringBuilder("Luna").append("base").toString();
        System.out.println(lunaBase);
        System.out.println(lunaBase.intern());
        System.out.println(lunaBase == lunaBase.intern());

        System.out.println();

        String java = new StringBuilder("ja").append("va").toString();
        System.out.println(java);
        System.out.println(java.intern());

        /** 有一个 JDK 初始化自带的 java 字符串，在加载 sum.misc.Version 这个类的时候进去常量池 */
        System.out.println(java == java.intern());

        // private static final String launcher_name = "java";
        // private static final String java_version = "1.8.0_221";
        // private static final String java_runtime_name = "Java(TM) SE Runtime Environment";
        // private static final String java_profile_name = "";
        // private static final String java_runtime_version = "1.8.0_221-b11";

        // 详见 sun.misc.Version.init();



    }
}
