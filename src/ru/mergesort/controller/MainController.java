package ru.mergesort.controller;


import ru.mergesort.algorithm.Algorithm;
import ru.mergesort.model.Arguments;

public class MainController {

	public static void main (String[] args) {
		
		if(args == null) {
			System.out.println("�� ������� ���������");
			System.exit(0);
		}
		
		Arguments arg = new Arguments(args); 
		InputData input = new InputData(arg.getInputFiles(), arg.getTypeData());
		Algorithm sm = new Algorithm(arg.getSortMode());
		
		int [] nums = input.getResult();
		nums=sm.sortMerge(nums);
		
		new OutputData(nums, arg.getOutFile(), arg.getTypeData());
		System.out.println("�������� ���������� ����������");										
	}
	
}
