package ru.mergesort.algorithm;

import java.util.Arrays;

public class Algorithm {
	
	private String method;
	
	public Algorithm() {}
	public Algorithm(String method) {
		this.method=method;
	}

	private int[] merge(int[] arr_1, int[] arr_2) {
		int len_1 = arr_1.length, len_2 = arr_2.length; // длина 1-го и 2-го массива
		int a = 0, b = 0, len = len_1 + len_2; // a, b - счетчики в массивах, len - сумма длин массивов 
		int[] result = new int[len]; 
		
		if(method.equals("-a")) {
		for (int i = 0; i < len; i++) {
			if (b < len_2 && a < len_1) {
				if (arr_1[a] > arr_2[b]) result[i] = arr_2[b++];
				else result[i] = arr_1[a++];
			} else if (b < len_2) {
				result[i] = arr_2[b++];
			} else {
				result[i] = arr_1[a++];
			}
		}
		return result;
		}else if(method.equals("-d")) {
			for (int i = 0; i < len; i++) {
				if (b < len_2 && a < len_1) {
					if (arr_1[a] < arr_2[b]) result[i] = arr_2[b++];
					else result[i] = arr_1[a++];
				} else if (b < len_2) {
					result[i] = arr_2[b++];
				} else {
					result[i] = arr_1[a++];
				}
			}
			return result;
		}
		return null;
	}
	
	
	public  int[] sortMerge(int[] arr) {
		int len = arr.length;
		if (len < 2) return arr; // если в массиве один эллемент то он считается уже отсортированным
		int middle = len / 2;
		return merge(sortMerge(Arrays.copyOfRange(arr, 0, middle)),
		             sortMerge(Arrays.copyOfRange(arr, middle, len)));
	}
}
