package ru.mergesort.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class InputData {

	private int [] result;
		
	public InputData() {
	}
	
	public InputData(File[] input, String datatype) {
		getValues(fillUp(input), datatype);
	}
	
	
	
	private  List <String> fillUp (File [] file) {
		List<String> nums = new ArrayList<String>();
		
		try {			
		BufferedReader br;
		for(int i = 0; i<file.length; i++) {
				br = new BufferedReader(new FileReader(file[i]));
				String s;
				while((s = br.readLine())!=null) {	
					nums.add(s);				
				}	
			}
		
		} catch (IOException e) {
				e.printStackTrace();
			}
							
		return nums;
	}
	
	private  int [] getValues(List<String>nums, String type) {
		result = new int [nums.size()];
			for(int i = 0; i<result.length;i++) {
				if(type.equals("-i")) {
					if(Character.isLetter(nums.get(i).charAt(0))) {
						System.out.println("ќшибка. ¬ходные данные не €вл€ютс€ типом integer");
						System.exit(0);
					}
					result[i]=Integer.parseInt(nums.get(i));
				}else {
					if(Character.isDigit(nums.get(i).charAt(0))){
					System.out.println("ќшибка. ¬ходные данные не €вл€ютс€ типом string");
					System.exit(0);
				}else if(Character.isLetter(nums.get(i).charAt(0))) {
					result[i]=(( nums.get(i).charAt(0)));
				}
			}
		}
			return result;						
	}
		
	public int[] getResult() {
		return result;
	}

	public void setResult(int[] result) {
		this.result = result;
	}						
}
