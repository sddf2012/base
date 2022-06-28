package my.algorithm.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://www.cnblogs.com/onepixel/articles/7674659.html
 *
 * @author liu peng bo
 * @date 2022/6/24 21:57
 */
public class Sort {
    public static void main(String[] args) {
        int order = 1;
        int[] input = randomArray(10, 40);
        System.out.println(Arrays.toString(input));
        int[] output = simpleInsertionSort(order, input);
        System.out.println(Arrays.toString(output));
        elementConsistent(input, output);
        isOrderly(order, output);
    }

    public static int[] randomArray(int minLength, int maxLength) {
        Random random = new Random();
        int length = random.nextInt(maxLength);
        length = Math.max(length, minLength);
        int[] data = new int[length];
        for (int i = 0; i < length; i++) {
            data[i] = random.nextInt(1000);
        }
        return data;
    }

    public static void isOrderly(int order, int[] input) {
        boolean isOrderly = true;
        for (int i = 0; i < input.length - 1; i++) {
            if (order == 0) {
                if (input[i] > input[i + 1]) {
                    isOrderly = false;
                    break;
                }
            } else {
                if (input[i] < input[i + 1]) {
                    isOrderly = false;
                    break;
                }
            }
        }
        System.out.println(isOrderly ? "有序的" : "无序的");
    }

    public static void elementConsistent(int[] a, int[] b) {
        List<Integer> al = Arrays.stream(a).boxed().collect(Collectors.toList());
        for (int i : b) {
            al.remove((Object) i);
        }
        System.out.println(al.size() == 0 && a.length == b.length ? "元素一致" : "元素不一致");
    }

    /**
     * 冒泡排序
     *
     * @param order 0从小到大  1从大到小
     * @param input
     */
    public static int[] bubbleSort(int order, int[] input) {
        boolean isOrderly = true;
        int temp;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length - i - 1; j++) {
                if (order == 0) {
                    if (input[j] > input[j + 1]) {
                        temp = input[j];
                        input[j] = input[j + 1];
                        input[j + 1] = temp;
                        isOrderly = false;
                    }
                } else {
                    if (input[j] < input[j + 1]) {
                        temp = input[j];
                        input[j] = input[j + 1];
                        input[j + 1] = temp;
                        isOrderly = false;
                    }
                }
            }
            if (isOrderly) {
                break;
            }
        }
        return input;
    }

    /**
     * 选择排序
     *
     * @param order
     * @param input
     * @return
     */
    public static int[] selectionSort(int order, int[] input) {
        int temp;
        int tempIndex;
        for (int i = 0; i < input.length; i++) {
            temp = input[i];
            tempIndex = i;
            for (int j = i; j < input.length - 1; j++) {
                if (order == 0) {
                    if (temp > input[j + 1]) {
                        temp = input[j + 1];
                        tempIndex = j + 1;
                    }
                } else {
                    if (temp < input[j + 1]) {
                        temp = input[j + 1];
                        tempIndex = j + 1;
                    }
                }
            }
            if (tempIndex != i) {
                input[tempIndex] = input[i];
                input[i] = temp;
            }
        }
        return input;
    }

    /**
     * 简单插入排序
     *
     * @param order
     * @param input
     * @return
     */
    public static int[] simpleInsertionSort(int order, int[] input) {
        int current;
        for (int i = 0; i < input.length; i++) {
            current = input[i];
            int j = i - 1;
            while (j >= 0 && (order == 0 ? current < input[j] : current > input[j])) {
                input[j + 1] = input[j];
                j--;
            }
            input[j + 1] = current;
        }
        return input;
    }

    public static int[] binaryInsertionSort(int order, int[] input) {
        int current;
        for (int i = 0; i < input.length; i++) {
            current = input[i];
            int j = 0;
            int half=(i-j)/2;
            while (j != (i - j) / 2) {
                if(current>input[half]){

                }else{

                }
                input[j + 1] = input[j];
                j = j / 2;
            }
            input[j + 1] = current;
        }
        return input;
    }


}
