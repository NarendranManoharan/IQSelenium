package FileReading;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UsingBufferedReader {

	public static void main(String[] args) throws IOException {
		
		String location= "BufferedWriter.txt";
		
		FileReader fileReader=new FileReader(location);
		BufferedReader bufferedReader=new BufferedReader(fileReader);
		
		String text=bufferedReader.readLine();
		System.out.println(text);
		bufferedReader.close();
		
	}

}
