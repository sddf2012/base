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
        //System.out.println(new BigDecimal("0.0").multiply(new BigDecimal(1000)).setScale(0, RoundingMode.HALF_UP));
        BigDecimal a=new BigDecimal("1.1");
        BigDecimal b=new BigDecimal("2.1");
        BigDecimal c=new BigDecimal("3.1");
        BigDecimal d=new BigDecimal("4.1");
        BigDecimal e=new BigDecimal("5.1");

        BigDecimal sum=a.add(b).add(c).add(d).add(e).add(BigDecimal.ZERO);

        System.out.println(sum);


    }
}
