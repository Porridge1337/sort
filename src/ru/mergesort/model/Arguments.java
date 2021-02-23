package ru.mergesort.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Arguments {

	private String sortMode = "-a";
	private String typeData;
	private File outFile;
	private File [] inputFiles;
	private boolean outfull = false;
	
	public Arguments() {
		
	}	
	public Arguments(String [] args){		 		
		if(tryGetFirstArg(args[0]) && tryGetSecondArg(args[1])){
			getFilesArgs(args);
		}else {
			showHelp();				
		}
			
		if(!checkFiles() || !checkExistFiles(inputFiles,outFile)){
			showHelp();			
		}			
	}	
		
	private boolean tryGetFirstArg(String arg){		
		if(arg.equals("-s") || arg.equals("-i")){
			setTypeData(arg);
			return true;
		}return false;
	}
	
	private boolean tryGetSecondArg(String arg){
		if(arg.equals("-a")||arg.equals("-d")) {
			setSortMode(arg);
			return true;
		}else if(arg.endsWith(".txt")){
			setOutFile(new File(arg));
			outfull = true;
			return true;
		}else return false;
	}

	private void getFilesArgs(String args[])
	{
		List <File> input = new ArrayList<File>();
		 int j = 0; //счётчик для input
		
		for(int i = 2; i<args.length; i++) { // i=2 т.к. 1-й и 2-й эллемент уже проверен
			if(args[i].endsWith(".txt")) {				
				if(!outfull) {
					outfull=true;
					setOutFile(new File(args[i]) );
				}else {
					input.add(j++,new File(args[i]) ); 
				}
			}else {
				showHelp();
			}				
		}	
		inputFiles = input.toArray(new File[0]); // в параметр указывается тип возвращаемых данных
	}
	
	private boolean checkFiles() { // проверяет есть ли Output file и хотя бы один input file
		return (outfull && inputFiles != null && inputFiles.length > 0);
	}
	
	private boolean checkExistFiles(File[] input, File output) {//проверяет есть ли файлы в принципе 
		for(File i:input) {
			if (!i.exists()) {
				return false;
			}else if(!output.exists()) {
				return false;
			}
		}
		return true;
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
		
	private void showHelp() {
		System.out.println("-s/-i необходимо указать тип данных.\n"
				   + "-a/-d режим сортировки необязательный, по умолчанию сортируем по возрастанию.\n"
		 		   + "имя выходного файла, обязательное.\n"
				   + "имена входных файлов, не менее одного.\n"
		 		   + "файл должен быть формата .txt \n"
				   + "файлы в принципе должны существовать. \n"
		 		   + "пример запуска программы:\njava -jar sort.jar -s -a out.txt in.txt,\njava -jar sort.jar -s out.txt in1.txt in2.txt in3.txt,\n"
		 		   + "java -jar sort.jar -d -s out.txt in1.txt in2.txt");
		
		System.exit(0);
	}

	
	
}
