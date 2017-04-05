package cn.bjut.test1;

import java.math.BigDecimal;

/**
 * Created by huanglei on 17/4/5.
 */
public class Change2 {
    public static void main(String[] args) {
        BigDecimal bigDecimal1 = new BigDecimal("2.0");
        BigDecimal bigDecimal2 = new BigDecimal("1.1");
        System.out.println(bigDecimal1.subtract(bigDecimal2));
    }
}
