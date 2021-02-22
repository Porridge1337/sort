package ru.mergesort.controller;


import ru.mergesort.algorithm.Algorithm;
import ru.mergesort.model.Arguments;

public class MainController {

	public static void main (String[] args) {
		
		if(args == null) {
			System.out.println("Не указаны аргументы");
			System.exit(0);
		}
		
		Arguments arg = new Arguments(args); 
		InputData input = new InputData(arg.getInputFiles(), arg.getTypeData());
		Algorithm sm = new Algorithm(arg.getSortMode());
		
		int [] nums = input.getResult();
		nums=sm.sortMerge(nums);
		
		new OutputData(nums, arg.getOutFile(), arg.getTypeData());
		System.out.println("Успешное выполнение сортировки");
		
		/*if(arg.getTypeData().equals("-i")) {
			//int [] nums = input.inputFileContent(arg.getInputFiles(), arg.getTypeData());
			int [] nums = input.getResult();
			nums=sm.sortMerge(nums);
			new OutputData(nums, arg.getOutFile(), arg.getTypeData());
			System.out.println("Успешноу выполнение сортировки");
		}else if(arg.getTypeData().equals("-s")) {
			int [] chars = input.inputFileContent(arg.getInputFiles(), arg.getTypeData());
			chars = sm.sortMerge(chars);
			new OutputData(chars, arg.getOutFile(), arg.getTypeData());
			System.out.println("Успешноу выполнение сортировки");
		}*/
		
		
			
	}
	
}
