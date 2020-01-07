package Reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import MainObjects.Bus;

public abstract class MainReader {
	
	protected  String filePath;
	private   String delimiter;
	
	public MainReader (String filePath,String delimiter) {
		this.filePath = filePath;
		this.delimiter = delimiter;
	}
	
	public abstract ArrayList<Object> getListOfObject();
	
	public void setFilePath (String path) {
		this.filePath = path;
	}
	
	public String getfilePath () {
		return filePath;
	}
	
	public String getdelimiter () {
		return delimiter;
	}
	public  ArrayList getFileLines() {
		ArrayList<String> csvList = new ArrayList();
		try {
	         File file = new File(filePath);
	         FileReader fr = new FileReader(file);
	         BufferedReader br = new BufferedReader(fr);
	         String line = "";
	         String[] tempArr;
	         while((line = br.readLine()) != null) {
	        	 csvList.add(line); 
	         }
	         br.close();
	         } catch(IOException ioe) {
	            ioe.printStackTrace();
	         }
		return csvList;
		
	}
	
	public int getRecCount() {
		 int i = 0;
		try {
	         File file = new File(filePath);
	         FileReader fr = new FileReader(file);
	         BufferedReader br = new BufferedReader(fr);
	         while((br.readLine()) != null) {
	        	 i=i+1;
	         }
	         br.close();
	         } catch(IOException ioe) {
	            ioe.printStackTrace();
	         }
		return i-1;	
	}
	
	public int getFieldCount() {
		 int count = 0;
		 String line;
		 String[] tempArr;
			try {
		         File file = new File(filePath);
		         FileReader fr = new FileReader(file);
		         BufferedReader br = new BufferedReader(fr);
		         line = br.readLine();
		         tempArr = line.split(delimiter);
		         count = tempArr.length;
		         br.close();
		         } catch(IOException ioe) {
		            ioe.printStackTrace();
		         }
			return count;	
	}
	

}
