package com.just.play;

import java.util.Arrays;

public class Sort {
	/**
	 * 冒泡 插入 选择 快速
	 * https://www.cnblogs.com/DxinSir/p/7289902.html
	 */
	public static void main(String[] args) {
		int[] arrays = {26,38,22,77,88,54,11,96,333,24};
		int low = 0;
		int high = arrays.length - 1;
		
		Sort sort = new Sort();
//		sort.bubbleSort(arrays);
//		sort.insertSort(arrays);
//		sort.selectSort(arrays);
		sort.quickSort(arrays, low, high);
		System.out.println("排序后：");
		System.out.println(Arrays.toString(arrays) + "\t");
		
	}
	
	//冒泡两两比较，大的往后移动
    public void bubbleSort(int[] array){
    	int t = 0;
    	for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length -1 -i; j++) {
				if(array[j] > array[j+1]){
					t = array[j];
					array[j] = array[j+1];
					array[j+1] = t;
				}
			}
		}
    }
   
   //插入排序  拿后边的元素与前边的逐一比较   如果比前边小就一直往前挪，知道大于前一个，插入的当前的这个位置
    public void insertSort(int[] array){
    	int temp = 0;
    	for (int i = 1; i < array.length; i++) {
			temp = array[i];
			for (int j = i-1;j>=0 &&array[j]>temp; j--) {
				array[j+1]= array[j];
				array[j] = temp;
			}
		}
    }
   //选择排序   把所有队员扫描一遍，选出最矮的 放到最右边
    public void selectSort(int[] array){
    	int t = 0;
    	for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if(array[i] > array[j]){
					t = array[i];
					array[i] = array[j];
					array[j] = t;
				}
			}
		}
    }
    //分治快速排序 {26,38,22,77,88,54,11,96,333,24}  以两边的数字为基准，-》找大的 《- 找小的  确定中间位置数值
   
    public  void quickSort(int[] arr,int low,int high){
        int i,j,temp,t;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        //temp就是基准位
        temp = arr[low];

        while (i<j) {
            //先看右边，依次往左递减
            while (temp<=arr[j]&&i<j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp>=arr[i]&&i<j) {
                i++;
            }
            //如果满足条件则交换
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
         arr[low] = arr[i];
         arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j-1);
        //递归调用右半数组
        quickSort(arr, j+1, high);
    }
}
