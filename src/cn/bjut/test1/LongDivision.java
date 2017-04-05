package cn.bjut.test1;

/**
 * Created by huanglei on 17/4/5.
 */
public class LongDivision {
    public static void main(String[] args) {
        final long MICEOS_PER_DAY = 24L * 60 * 60 * 1000 * 1000;
        final long MILLIS_PER_DAY = 24L * 60 * 60 * 1000;
        System.out.println(MICEOS_PER_DAY/MILLIS_PER_DAY);
    }
}
