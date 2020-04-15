package cn.baizhi.test;

import org.junit.Test;

public class TestGitHub {
    public static void main(String[] args) {
        System.out.println("args = " + args);
    }

    @Test
    public void test(){
        int a =10;
        int b =20;
        int c =a+b;
        System.out.println("a = " + a);
        System.out.println("c = " + c);
    }
    @Test
    public void testDev(){}
}
