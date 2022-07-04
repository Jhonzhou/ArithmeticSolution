package com.worker.bee.solution;

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

        testSwitch(1);
    }

    private static void testSwitch(int a) {
        switch (a) {
            case 0:
                System.out.println(" switch 0");
                break;
            case 1:
                System.out.println(" switch 1");
        }
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
