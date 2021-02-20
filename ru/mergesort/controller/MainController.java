package ru.mergesort.controller;


import ru.mergesort.algorithm.Algorithm;
import ru.mergesort.model.Arguments;

public class MainController {

	public static void main (String[] args) {
		
		Arguments arg = new Arguments(args); 
		InputData input = new InputData();
		Algorithm sm = new Algorithm(arg.getSortMode());
		
		if(arg.getTypeData().equals("-i")) {
			int [] nums = input.inputFileContent(arg.getInputFiles(), arg.getTypeData());
			nums=sm.sortMerge(nums);
			new OutputData(nums, arg.getOutFile(), arg.getTypeData());
			System.out.println("Успешноу выполнение сортировки");
		}else if(arg.getTypeData().equals("-s")) {
			int [] chars = input.inputFileContent(arg.getInputFiles(), arg.getTypeData());
			chars = sm.sortMerge(chars);
			new OutputData(chars, arg.getOutFile(), arg.getTypeData());
			System.out.println("Успешноу выполнение сортировки");
		}
		
		
			
	}
	
}
