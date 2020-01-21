<<<<<<< HEAD:Flix-Bus-System/src/TeamRocket/Reader/MainReader.java
package TeamRocket.Reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public abstract class MainReader {
	
	protected  String filePath;
	private   String delimiter;
	
	public MainReader (String filePath,String delimiter) {
		this.filePath = filePath;
		this.delimiter = delimiter;
	}
	
	public abstract ArrayList<Object> getListOfObject();
	
	public void setFilePath (String pathBuilder, String path) {
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
=======
package Reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 *  @author melvin 
 * */
/**
 * The Class MainReader.
 */
public abstract class MainReader {

	/** The file path. */
	protected String filePath;

	/** The delimiter. */
	private String delimiter;

	/**
	 * Instantiates a new main reader.
	 *
	 * @param filePath  the file path
	 * @param delimiter the delimiter
	 */
	public MainReader(String filePath, String delimiter) {
		this.filePath = filePath;
		this.delimiter = delimiter;
	}

	/**
	 * Gets the list of object.
	 *
	 * @return the list of object
	 */
	public abstract ArrayList<Object> getListOfObject();

	/**
	 * Sets the file path.
	 *
	 * @param pathBuilder the path builder
	 * @param path        the path
	 */
	public void setFilePath(String pathBuilder, String path) {
		this.filePath = path;
	}

	/**
	 * Gets the file path.
	 *
	 * @return the file path
	 */
	public String getfilePath() {
		return filePath;
	}

	/**
	 * Gets the delimiter.
	 *
	 * @return the delimiter
	 */
	public String getdelimiter() {
		return delimiter;
	}

	/**
	 * Gets the file lines.
	 *
	 * @return the file lines
	 */
	public ArrayList getFileLines() {
		ArrayList<String> csvList = new ArrayList();
		try {
			File file = new File(filePath);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			String[] tempArr;
			while ((line = br.readLine()) != null) {
				csvList.add(line);
			}
			br.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return csvList;

	}

	/**
	 * Gets the rec count.
	 *
	 * @return the rec count
	 */
	public int getRecCount() {
		int i = 0;
		try {
			File file = new File(filePath);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			while ((br.readLine()) != null) {
				i = i + 1;
			}
			br.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return i - 1;
	}

	/**
	 * Gets the field count.
	 *
	 * @return the field count
	 */
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
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return count;
	}

}
>>>>>>> origin/master:Flix-Bus-System/src/Reader/MainReader.java
