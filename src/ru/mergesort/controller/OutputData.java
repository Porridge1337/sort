package ru.mergesort.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class OutputData {

	public OutputData(int [] num, File location,String typedata ) {
		injectOutputFile(num, location, typedata);
	}
	public OutputData() {
	}
	
	
	public void injectOutputFile (int [] num, File location, String typedata) {	
		
		if(typedata.equals("-i")) {
			try {
				FileWriter writer = new FileWriter(location);
				for(int i = 0; i<num.length; i++) {
					//String n = String.valueOf(num[i]);
					writer.write(String.valueOf(num[i]));
					writer.append('\n');
				}
				writer.close();		
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(typedata.equals("-s")) {
			try {
				FileWriter writer = new FileWriter(location);
				for(int i = 0; i<num.length; i++) {
					//char n = (char) num[i];
					writer.write((char)num[i]);
					writer.append('\n');
				}
				writer.close();		
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
			
		
		
		
		
 	}
	
	
	
	
}
