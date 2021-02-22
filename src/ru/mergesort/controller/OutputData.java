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
				
			try {
				FileWriter writer = new FileWriter(location);
				for(int i = 0; i<num.length; i++) {
					if(typedata.equals("-i")) {
						writer.write(String.valueOf(num[i]));
						writer.append('\n');
					}else {
						writer.write((char)num[i]);
						writer.append('\n');
					}					
				}
				writer.close();		
			} catch (IOException e) {
				e.printStackTrace();
			}
		}					
 	}
