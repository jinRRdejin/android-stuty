package com.just.play;

import java.util.Arrays;

public class Sort {
	/**
	 * ð�� ���� ѡ�� ����
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
		System.out.println("�����");
		System.out.println(Arrays.toString(arrays) + "\t");
		
	}
	
	//ð�������Ƚϣ���������ƶ�
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
   
   //��������  �ú�ߵ�Ԫ����ǰ�ߵ���һ�Ƚ�   �����ǰ��С��һֱ��ǰŲ��֪������ǰһ��������ĵ�ǰ�����λ��
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
   //ѡ������   �����ж�Աɨ��һ�飬ѡ����� �ŵ����ұ�
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
    //���ο������� {26,38,22,77,88,54,11,96,333,24}  �����ߵ�����Ϊ��׼��-���Ҵ�� ��- ��С��  ȷ���м�λ����ֵ
   
    public  void quickSort(int[] arr,int low,int high){
        int i,j,temp,t;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        //temp���ǻ�׼λ
        temp = arr[low];

        while (i<j) {
            //�ȿ��ұߣ���������ݼ�
            while (temp<=arr[j]&&i<j) {
                j--;
            }
            //�ٿ���ߣ��������ҵ���
            while (temp>=arr[i]&&i<j) {
                i++;
            }
            //������������򽻻�
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        //��󽫻�׼Ϊ��i��j���λ�õ����ֽ���
         arr[low] = arr[i];
         arr[i] = temp;
        //�ݹ�����������
        quickSort(arr, low, j-1);
        //�ݹ�����Ұ�����
        quickSort(arr, j+1, high);
    }
}
