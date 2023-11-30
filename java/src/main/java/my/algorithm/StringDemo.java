package my.algorithm;

/**
 * @author liu peng bo
 * @date 2023/09/06 16:08
 */
public class StringDemo {
    public static void main(String[] args) {
        char[] a=new char[]{'H','a','n','n','a','h'};
        reverseString(a);
        System.out.println(a);
    }

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * <p>
     * 如果不存在公共前缀，返回空字符串 ""。
     * 输入：strs = ["flower","flow","flight"]
     * 输出："fl"
     * <p>
     * 输入：strs = ["dog","racecar","car"]
     * 输出：""
     * 解释：输入不存在公共前缀。
     */
    public static String longestCommonPrefix(String[] strs) {
        /*int minlength = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            minlength = Math.min(minlength, strs[i].length());
        }
        if (minlength < 1) {
            return "";
        }
        String result = "";
        for (int i = 0; i < minlength; i++) {
            boolean flag = true;
            String temp = strs[0].substring(i, i + 1);
            for (int j = 1; j < strs.length; j++) {
                if (!temp.equals(strs[j].substring(i, i + 1))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result += temp;
            } else {
                break;
            }
        }
        return result;*/
        if (strs == null || strs.length == 0) {
            return "";
        }
        //横向
        /*String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int count = Math.min(prefix.length(), strs[i].length());
            int j = 0;
            for (; j < count; j++) {
                if (prefix.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            if (j == 0) {
                prefix = "";
                break;
            }
            prefix = prefix.substring(0, j);
        }
        return prefix;*/
        //纵向
        int count = strs[0].length();
        int length = strs[0].length();
        for (int i = 0; i < length; i++) {
            char a = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i >= strs[j].length() || a != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }


    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串
     * <p>
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        //反序
        /*int length = s.length();
        char[] chars = new char[length];
        for (int i = 0; i < length; i++) {
            chars[i] = s.charAt(length - i - 1);
        }
        String inverted = new String(chars);

        String result = "";
        for (int i = 0; i < length; i++) {
            char s1 = s.charAt(i);
            for (int j = 0; j < length - i; j++) {
                if (inverted.charAt(j) == s1 && s.substring(i, length - j).equals(inverted.substring(j, length - i))) {
                    result = result.length() >= length - j - i ? result : s.substring(i, length - j);
                    break;
                }
            }
        }
        return result;*/

        int subBegin = 0, subLength = 0;
        for (int i = 0; i < s.length(); i++) {
            int l = i - 1;
            int r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l = l - 1;
                r = r + 1;
            }
            int sl = r - l - 1;
            if (sl > subLength) {
                subLength = sl;
                subBegin = l + 1;
            }

            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l = l - 1;
                r = r + 1;
            }
            sl = r - l > 1 ? r - l - 1 : r - l;
            if (sl > subLength) {
                subLength = sl;
                subBegin = subLength > 1 ? l + 1 : l;
            }
        }
        return s.substring(subBegin, subBegin + subLength);

    }


    /**
     * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
     * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
     * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
     * <p>
     * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
     *
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        if (s == null || s.length() < 1) {
            return s;
        }
        String[] a = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = a.length - 1; i >= 0; i--) {
            if (!a[i].equals("")) {
                result.append(a[i]).append(" ");
            }
        }
        return result.substring(0, result.length() - 1);
    }

    public static void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            char t = s[i];
            s[i] = s[j];
            s[j] = t;
            i++;
            j--;
        }
    }

    public static int arrayPairSum(int[] nums) {
           return 0;
    }
}
