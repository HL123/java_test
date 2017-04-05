package cn.bjut.test1;

/**
 * Created by huanglei on 17/4/5.
 */
public class OddMain {
    public static void main(String[] args) {
        System.out.println("1是奇数么" + isOdd(1));
        System.out.println("2是奇数么" + isOdd(2));
        System.out.println("-1是奇数么" + isOdd(-1));

        System.out.println("============方法一============");
        System.out.println("1是奇数么" + isOdd1(1));
        System.out.println("2是奇数么" + isOdd1(2));
        System.out.println("-1是奇数么" + isOdd1(-1));

        System.out.println("============方法二============");
        System.out.println("1是奇数么" + isOdd2(1));
        System.out.println("2是奇数么" + isOdd2(2));
        System.out.println("-1是奇数么" + isOdd2(-1));
    }

    private static boolean isOdd2(int i) {
        return (i & 1 ) != 0;
    }

    private static boolean isOdd1(int i) {
        return i % 2 != 0;
    }

    private static boolean isOdd(int i) {
        return i % 2 == 1;
    }

    

}
