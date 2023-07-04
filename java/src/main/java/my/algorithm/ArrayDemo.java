package my.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author liu peng bo
 * @date 2022/6/19 16:20
 */
public class ArrayDemo {
    public static void main(String[] args) {
        //int[] test = {1, 7, 3, 9, 6, 5, 6, 4, 5};
        //int[] test = {2, 1, -1};
        //int[] test = {1, 2, 3};
        int[][] test = {{4, 5}, {1, 4}, {0, 1}};
        merge(test);
    }

    public static int pivotIndex(int[] nums) {
        /*int l = -1;
        int r = nums.length;
        int ls = 0;
        int rs = 0;
        boolean addr = false;
        boolean addl = false;
        while (true) {
            if (addl) {
                ls = ls + nums[l];
            }
            if (addr) {
                rs = rs + nums[r];
            }
            *//*if ((l > 0 && r == l + 2) || (l == 0 && r == l + 1)) {
                break;
            }*//*
            if (r == l + 2) {
                break;
            }
            if (ls >= rs) {
                r = r - 1;
                addl = false;
                addr = true;
            } else {
                l = l + 1;
                addl = true;
                addr = false;
            }

        }
        if (ls == rs) {
            return l + 1;
        }
        return -1;*/

        /*int lsum=0;
        int rsum=0;
        int[] lnums=new int[nums.length];
        lnums[0]=0;
        int[] rnums=new int[nums.length];
        rnums[nums.length-1]=0;
        for (int i = 1; i < nums.length; i++) {
            lsum=lsum+nums[i-1];
            lnums[i]=lsum;
            rsum=rsum+nums[nums.length-i];
            rnums[nums.length-i-1]=rsum;
        }
        for (int i = 0; i < nums.length; i++) {
            if(lnums[i]==rnums[i]){
                return i;
            }
        }
        return -1;*/

        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total = total + nums[i];
        }
        int ls = 0;
        for (int i = 0; i < nums.length; i++) {
            if (ls == total - ls - nums[i]) {
                return i;
            }
            ls = ls + nums[i];
        }
        return -1;
    }

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * <p>
     * 请必须使用时间复杂度为 O(log n) 的算法。
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        /*int length = nums.length / 2;
        int index = length;
        int value = nums[index];
        while (index >= 0 && index < nums.length) {
            value = nums[index];
            if (value == target) {
                return index;
            }
            length = length / 2;
            length=length==0?1:length;
            if (target > value) {
                index =  index + length;
            } else {
                index = index - length;
            }
            *//*if (index < 0) {
                index = 0;
            } else if (index > nums.length - 1) {
                index = nums.length - 1;
            }*//*
        }
        if (index < 0) {
            index = 0;
        } else if (index >= nums.length) {
            index = nums.length - 1;
        }
        return value >= target ? index : index + 1;*/
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (right + left) >> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    /**
     * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
     * <p>
     * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
     * 输出：[[1,6],[8,10],[15,18]]
     * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     *
     * @param intervals
     * @return
     */
    public static void merge(int[][] intervals) {
        //排序
        /*for (int i = 0; i < intervals.length - 1; i++) {
            for (int j = 0; j < intervals.length - i - 1; j++) {
                if (intervals[j][0] > intervals[j + 1][0] ||
                        (intervals[j][0] == intervals[j + 1][0] && intervals[j][1] > intervals[j + 1][1])) {
                    int[] temp = intervals[j];
                    intervals[j] = intervals[j + 1];
                    intervals[j + 1] = temp;
                }
            }
        }*/
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        //合并
        List<int[]> result = new ArrayList<>();
        int[] temp = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (temp[0] == intervals[i][0]) {
                temp[1] = Math.max(temp[1], intervals[i][1]);
            } else if (temp[1] >= intervals[i][0]) {
                temp[1] = Math.max(temp[1], intervals[i][1]);
            } else {
                result.add(temp);
                temp = intervals[i];
            }
        }
        result.add(temp);
        System.out.println(Arrays.deepToString(result.toArray(new int[result.size()][2])));
    }
}
