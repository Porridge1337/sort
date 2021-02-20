package ru.mergesort.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Arguments {

	private String sortMode;
	private String typeData;
	private File outFile;
	private File [] inputFiles;
	//private boolean exitapp = false;
	
	public Arguments() {
		
	}
	
	public Arguments(String [] args){
		 setSortMode("-a");
		 boolean outfull = false;
		 List <File> input = new ArrayList<File>();
		 int j = 0; //счётчик для input
		 
		if(args.length <= 3) 	{
			help();			
			//setExitapp(true);
			return;
		}else {					
			for(int i = 0; i<args.length; i++) {						
				
				if( (args[i].equals("-s")&& i<1) || (args[i].equals("-i") && i<1 )) {
					setTypeData(args[i]);
				}else if( (args[i].equals("-a") && i<2 )||(args[i].equals("-d") && i<2)) {
					setSortMode(args[i]);;
				}else if(args[i].endsWith(".txt") && i>=1) {				
					if(!outfull) {
						outfull=true;
						setOutFile(new File(args[i]) );
					}else {
						input.add(j++,new File(args[i]) ); 
					}
				}else {
					help();
					System.exit(0);
					return;
				}				
			}	
			inputFiles = new File [input.size()];
			for(int i = 0; i<input.size(); i++) {
				inputFiles[i]=input.get(i);
			}
		}	
	}

	
	public String getSortMode() {
		return sortMode;
	}

	public void setSortMode(String sortMode) {
		this.sortMode = sortMode;
	}

	public String getTypeData() {
		return typeData;
	}

	public void setTypeData(String typeData) {
		this.typeData = typeData;
	}

	public File getOutFile() {
		return outFile;
	}

	public void setOutFile(File outFile) {
		this.outFile = outFile;
	}

	public File[] getInputFiles() {
		return inputFiles;
	}

	public void setInputFiles(File[] inputFiles) {
		this.inputFiles = inputFiles;
	}
	
/*	public boolean isExitapp() {
		return exitapp;
	}

	public void setExitapp(boolean exitapp) {
		this.exitapp = exitapp;
	}*/
	
	
	private void help() {
		System.out.println("-s/-i необходимо указать тип данных.\n"
				   + "-a/-d режим сортировки необязательный, по умолчанию сортируем по возрастанию.\n"
		 		   + "имя выходного файла, обязательное.\n"
				   + "имена входных файлов, не менее одного.\n"
		 		   + "файл должен быть формата .txt "
		 		   + "пример запуска программы:\njava -jar sort.jar -s -a out.txt in.txt,\njava -jar sort.jar -s out.txt in1.txt in2.txt in3.txt,\n"
		 		   + "java -jar sort.jar -d -s out.txt in1.txt in2.txt");
	}

	
	
}
