package com.worker.bee.solution;

import java.util.Arrays;

/**
 * @author: JhonZhou
 * @date: 2020/1/3
 * @Description:
 */
public class Demo {
    public static void main(String[] args) {
        new A().demo();
        new B().demo();
        new B().test();
    }
    public static class A{
        public void demo(){
            PrintUtils.println("a parent");
        }
    }
    public static class  B extends A{
        @Override
        public void demo() {
//            super.demo();
            PrintUtils.println("b child");
        }
        public void test(){
            super.demo();
        }
    }
}
