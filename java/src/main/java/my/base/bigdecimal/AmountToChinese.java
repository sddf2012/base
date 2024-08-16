package my.base.bigdecimal;

import java.math.BigDecimal;

public class AmountToChinese {

    public static String convertToChinese(BigDecimal amount) {
        String[] numChinese = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
        String[] unitChinese1 = {"元", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟"};
        String[] unitChinese2 = {"角", "分"};


        String amountStr = amount.toString();
        String integerPart = amountStr.split("\\.")[0];
        String decimalPart = amountStr.split("\\.")[1];

        StringBuilder result = new StringBuilder();

        // 处理整数部分
        for (int i = 0; i < integerPart.length(); i++) {
            int digit = integerPart.charAt(i) - '0';
            if (digit != 0) {
                result.append(numChinese[digit]).append(unitChinese1[integerPart.length() - i - 1]);
            } else {
                if (i != 0 && integerPart.charAt(i - 1) - '0' != 0) {
                    result.append(numChinese[digit]);
                }
            }
        }
        // 处理小数部分
        for (int i = 0; i < decimalPart.length(); i++) {
            int digit = decimalPart.charAt(i) - '0';
            if (digit != 0) {
                result.append(numChinese[digit]).append(unitChinese2[i]);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        BigDecimal amount = new BigDecimal("12005.02");
        System.out.println(convertToChinese(amount));
    }
}
