package acwing.level2.基础算法;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Sort {

    public static void main(String[] args) {
//        Scanner in = new Scanner(new BufferedInputStream(System.in));
//        int n = in.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = in.nextInt();
//        }
        int size = 30;
        int[] arr = new int[]{128,294,133, 295, 175, 8, 232, 248, 241, 164, 11, 60, 238, 133, 291 ,116, 6, 67, 98, 67, 196, 260, 181, 160, 83 ,160 ,90 ,153, 233 ,216};

        quickSort(arr, 0, size - 1);

        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
    }


    /**
     * 快速排序
     * 边界问题测试用例：5,3 1 2 4 5
     */
    private static void quickSort(int q[], int l, int r){
        if (l>=r){
            return;
        }

        int i = l-1;
        int j = r+1;
        int x = q[r];
        while (i<j){
            do {
                i++;
            }while (q[i] < x);
            do {
                j--;
            }while (q[j]>x);
            //这里一定注意，必须判断 i<j ，因为i和j 会先移动一步，再判断条件，所以最后一次dowhile循环，一定会导致 i > j;
            if (i<j){
                swap(q,i,j);
            }
        }
        System.out.println(l+","+i+","+r+","+x);
        quickSort(q,l,i-1);
        quickSort(q,i,r);
    }

    private static void swap(int[] q, int i, int j) {
        int a = q[i];
        q[i] = q[j];
        q[j] = a;
    }
}
