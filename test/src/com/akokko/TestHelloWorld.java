package com.akokko;

public class TestHelloWorld {

    public static void main(String[] args) {

        int arr[] = {33, 56, 36, 86, 90, 20, 50, 35, 66, 93, 105};

        int left = 0, right = arr.length;

        System.out.println(right);

        System.out.println("排序前数组：");

        for (int i = 0; i < right; ++i) {

            System.out.print(arr[i] + " ");

        }

        System.out.println();

        quick_sort(arr, left, right - 1);

        System.out.println("排序后数组：");

        for (int i = 0; i < right; ++i) {

            System.out.print(arr[i] + " ");

        }

    }

    private static void quick_sort(int[] arr, int left, int right) {

        int i = left, j = right, k = (left + right) / 2;

        int pivot = arr[k];

        while (i <= j) {

            while (arr[i] < pivot) {

                i++;

            }

            while (arr[j] > pivot) {

                j--;

            }

            if (i <= j) {

                int temp;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;

            }

        }

        if (i < right) {

            quick_sort(arr, i, right);

        }

        if (left < j) {

            quick_sort(arr, left, j);

        }

    }

}
