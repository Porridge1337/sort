package ru.mergesort.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class InputData {

	public InputData() {
	}
	
	public int [] inputFileContent (File[] input, String datatype) {
		
		if(datatype.equals("-i")) { // запись int
			
		List<String> nums = new ArrayList<String>();
		BufferedReader br;
		int j = 0; //счётчик
		
		try {
		for(int i = 0; i<input.length; i++) {
			br = new BufferedReader(new FileReader(input[i]));
			String s;
			while((s = br.readLine())!=null) {	
				nums.add(j++,s);				
			}	
		  }			
				
		int[] result= new int [nums.size()];			
		for(int i = 0; i<result.length;i++) {
			result[i]=Integer.parseInt(nums.get(i));
		}
			return result;
		} catch (Exception e) {
			System.out.println("Неправильно указанный тип данных " + datatype + " когда нужен -s");
			 System.exit(0);
			}
		
			
		
		}else if(datatype.equals("-s")) { // запись char
			
			List<Integer> chars = new ArrayList<Integer>();			
			BufferedReader br;
			int j = 0; //счётчик
			
			try {
			for(int i = 0; i<input.length; i++) {
				br = new BufferedReader(new FileReader(input[i]));
				int s;
				while((s = br.read())!=-1) {	
					if(s!=10 && s!=13) {
						chars.add(s);
						//System.out.println((char)s);
					}				
				}	
			  }						
			
			int[] result= new int[chars.size()];			
			for(int i = 0; i<result.length;i++) {
				int n = chars.get(i);
				result[i]= (char)n;
				//System.out.println(n);
			}
			
			return result;
			} catch (IOException e) {
				System.out.println("Неправильно указанный тип данных");
				 System.exit(0);
				}											
		} 
		return null;
	}
	
}
