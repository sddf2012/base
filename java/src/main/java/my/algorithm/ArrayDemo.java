package my.algorithm;

import java.util.*;

/**
 * @author liu peng bo
 * @date 2022/6/19 16:20
 */
public class ArrayDemo {
    public static void main(String[] args) {
        //int[] test = {1, 7, 3, 9, 6, 5, 6, 4, 5};
        //int[] test = {2, 1, -1};
        //int[] test = {1, 2, 3};
        //int[][] test = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        //int[][] test = {{1,2}, {3,4}};
        //int[][] test = {{1,2,3}, {4,5,6}};
        //int[][] test = {{1, 2}, {3, 4}, {5, 6}};
        int[][] test = {{1}, {2}};
        //int[][] test = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        findDiagonalOrder(test);
    }

    /**
     * 寻找数组的中心索引
     * 给你一个整数数组nums ，请计算数组的 中心下标 。
     * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
     * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
     * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1
     */
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
     * 搜索插入位置
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * <p>
     * 请必须使用时间复杂度为 O(log n) 的算法。
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
     * 合并区间
     * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
     * <p>
     * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
     * 输出：[[1,6],[8,10],[15,18]]
     * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
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


    /**
     * 旋转矩阵
     * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
     * <p>
     * 不占用额外内存空间能否做到？
     */
    public static void rotate(int[][] matrix) {
        /*int length = matrix.length;
        int[][] result = new int[length][length];
        for (int i = 0; i < matrix.length; i++) {
            int second = length - i - 1;
            for (int j = 0; j < matrix.length; j++) {
                result[j][second] = matrix[i][j];
            }
        }
        System.out.println(Arrays.deepToString(result));*/
        /*Set<Integer> set = new HashSet<>();
        int length = matrix.length;
        int first;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                set.add(i * 10 + j);
                first = j;
                int second = length - i - 1;
                if (first != i && !set.contains(first * 10 + second)) {
                    while (first != i || second != j) {
                        set.add(first * 10 + second);
                        int temp = matrix[first][second];
                        matrix[first][second] = matrix[i][j];
                        matrix[i][j] = temp;

                        temp = first;
                        first = second;
                        second = length - temp - 1;
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(matrix));*/

        int length = matrix.length;
        for (int i = 0; i < length / 2; i++) {
            for (int j = 0; j < (length + 1) / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[length - j - 1][i];
                matrix[length - j - 1][i] = matrix[length - i - 1][length - j - 1];
                matrix[length - i - 1][length - j - 1] = matrix[j][length - i - 1];
                matrix[j][length - i - 1] = temp;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }

    /**
     * 零矩阵
     * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
     * <p>
     * 输入：
     * [
     * [1,1,1],
     * [1,0,1],
     * [1,1,1]
     * ]
     * 输出：
     * [
     * [1,0,1],
     * [0,0,0],
     * [1,0,1]
     * ]
     */
    public static void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }
        for (Integer row : rows) {
            Arrays.fill(matrix[row], 0);
        }
        for (Integer column : columns) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][column] = 0;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }

    /**
     * 给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
     * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[1,2,4,7,5,3,6,8,9]
     */
    public static void findDiagonalOrder(int[][] mat) {
        /*int m = mat.length;
        int n = mat[0].length;
        int size = m * n;
        int i = 0, j = 0;
        int k = 0;
        boolean up = false;
        int[] result = new int[size];
        while (k < size) {
            result[k] = mat[i][j];
            //向右
            if (i == 0 && j < n - 1 && j % 2 == 0) {
                j++;
                up = false;
            } else if (i == m - 1 && j < n - 1 && !up) {
                //向右
                j++;
                up = true;
            } else if (i < m - 1 && n == 1) {
                //向下
                i++;
                up = true;
            } else if (j == 0 && i < m - 1 && i % 2 == 1) {
                //向下
                i++;
                up = true;
            } else if (j == n - 1 && i < m - 1 && up) {
                //向下
                i++;
                up = false;
            } else if (up) {
                //右上
                i--;
                j++;
            } else {
                //左下
                i++;
                j--;
            }
            k++;
        }
        System.out.println(Arrays.toString(result));*/
        /*int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m * n];
        boolean up = false;
        int i, j, k = 0;
        for (int line = 0; line < m + n - 1; line++) {
            up = !up;
            if (up) {
                for (i = m - 1; i >= 0; i--) {
                    j = line - i;
                    if (j >= 0 && j < n) {
                        result[k] = mat[i][j];
                        k++;
                    }
                }
            } else {
                for (i = 0; i < m; i++) {
                    j = line - i;
                    if (j >= 0 && j < n) {
                        result[k] = mat[i][j];
                        k++;
                    }
                }
            }
        }*/

        int m = mat.length;
        int n = mat[0].length;
        int[] res = new int[m * n];
        int pos = 0;
        for (int i = 0; i < m + n - 1; i++) {
            if (i % 2 == 1) {
                int x = i < n ? 0 : i - n + 1;
                int y = i < n ? i : n - 1;
                while (x < m && y >= 0) {
                    res[pos] = mat[x][y];
                    pos++;
                    x++;
                    y--;
                }
            } else {
                int x = i < m ? i : m - 1;
                int y = i < m ? 0 : i - m + 1;
                while (x >= 0 && y < n) {
                    res[pos] = mat[x][y];
                    pos++;
                    x--;
                    y++;
                }
            }
        }
        System.out.println(Arrays.toString(res));
    }
}
