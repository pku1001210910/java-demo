package top.moonstar.array;

/**
 * Link:
 * https://leetcode.cn/problems/merge-sorted-array/?envType=study-plan-v2&envId=top-interview-150
 * 
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m
 * 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 * 
 */
public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = new int[] { 1 };
        int[] arr2 = new int[] {};

        merge(arr1, 1, arr2, arr2.length);
        print(arr1);
    }

    public static void print(int[] array) {
        System.out.print("Result: ");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    public static void merge(int[] arr1, int m, int[] arr2, int n) {
        int index = n + m - 1;
        m--;
        n--;

        while (index >= 0) {
            if (n < 0) {
                break;
            }

            if (m < 0) {
                arr1[index--] = arr2[n--];
            } else {
                arr1[index--] = arr1[m] > arr2[n] ? arr1[m--] : arr2[n--];
            }
        }
        return;
    }
}