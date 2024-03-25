package my.base.bigdecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author liu peng bo
 * @date 2023-1-9 14:28
 */
public class BigDecimalDemo {
    public static void main(String[] args) {
        //System.out.println(new BigDecimal("12.64").intValue());
        System.out.println(new BigDecimal("0.0").multiply(new BigDecimal(1000)).setScale(0, RoundingMode.HALF_UP));
    }
}
