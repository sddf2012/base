package my.algorithm.base;

import java.util.Arrays;
import java.util.Random;

/**
 * https://www.cnblogs.com/onepixel/articles/7674659.html
 *
 * @author liu peng bo
 * @date 2022/6/24 21:57
 */
public class Sort {
    public static void main(String[] args) {
        int order = 0;
        int[] input = randomArray(10, 40);
        System.out.println(Arrays.toString(input));
        int[] output = selectionSort(order, input);
        System.out.println(Arrays.toString(output));
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
     * @param order
     * @param input
     * @return
     */
    public static int[] simpleInsertionSort(int order, int[] input){

        for (int i = 0; i < input.length; i++) {

        }


        return input;
    }




}
