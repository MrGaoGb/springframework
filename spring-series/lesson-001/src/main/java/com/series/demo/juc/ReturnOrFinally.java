package com.series.demo.juc;

/**
 * @author Mr.Gao
 * @date 2022/12/16 16:26
 * @apiNote:
 */
public class ReturnOrFinally {
    public static void main(String[] args) {

        int print = func2();
        System.out.println(print);
    }


    /**
     * finally语句是在return语句执行之后，return语句返回之前执行的
     * <p>
     * a > 10,a=20的结果说明了return a += 10已经执行了，但是没有直接返回，而是先去执行finally语句的内容，然后再去返回结果
     * </p>
     *
     * @return
     */
    public static int func() {
        int a = 10;
        try {
            System.out.println("try中的代码块");
            return a += 10;
        } catch (Exception e) {
            System.out.println("catch中的代码块");
        } finally {
            System.out.println("finally中的代码块");
            if (a > 10) {
                System.out.println("a > 10," + "a=" + a);
            }
        }
        return a += 50;
    }

    /**
     * 2.覆盖问题
     * 2.1finally块中的return语句会覆盖try块的return返回
     * <p>
     * （1）如果try中有return语句，finally中也有return语句，最终执行的是finally中的return语句
     * （2）如果finally代码块中写了return语句，那么finally之后的return语句就变成不可到达的语句，需要注释掉，否则编译不过
     * </p>
     *
     * @return
     */
    public static int func1() {
        int a = 10;
        try {
            System.out.println("try中的代码块");
            return a += 10;
        } catch (Exception e) {
            System.out.println("catch中的代码块");
        } finally {
            System.out.println("finally中的代码块");
            if (a > 10) {
                System.out.println("a>10," + "a=" + a);
            }
            return 100;
        }
    }

    /**
     * 如果finally语句没有return语句覆盖返回值，那么原来的返回值可能因为finally里的修改而改变也有可能不变
     *
     * @return
     */
    public static int func2() {
        int a = 10;
        try {
            System.out.println("try中的代码块");
            return a += 20;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("catch中的代码块");
        } finally {
            System.out.println("finally中的代码块");
            a += 20;
            if (a > 10) {
                System.out.println("a > 10,a=" + a);
            }
            a += 20;
        }
        return 200;
    }
}
