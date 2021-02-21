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
			
		if(!checkFiles()){
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
		 int j = 0; //������� ��� input
		
		for(int i = 2; i<args.length; i++) { // i=2 �.�. 1-� � 2-� �������� ��� ��������
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
		inputFiles = input.toArray(new File[0]); // � �������� ����������� ��� ������������ ������
	}
	
	private boolean checkFiles() { // ��������� ���� �� Output file � ���� �� ���� input file
		return (outfull && inputFiles != null && inputFiles.length > 0);
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
		System.out.println("-s/-i ���������� ������� ��� ������.\n"
				   + "-a/-d ����� ���������� ��������������, �� ��������� ��������� �� �����������.\n"
		 		   + "��� ��������� �����, ������������.\n"
				   + "����� ������� ������, �� ����� ������.\n"
		 		   + "���� ������ ���� ������� .txt "
		 		   + "������ ������� ���������:\njava -jar sort.jar -s -a out.txt in.txt,\njava -jar sort.jar -s out.txt in1.txt in2.txt in3.txt,\n"
		 		   + "java -jar sort.jar -d -s out.txt in1.txt in2.txt");
		
		System.exit(0);
	}

	
	
}
