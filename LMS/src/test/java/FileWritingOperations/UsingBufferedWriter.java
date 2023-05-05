package FileWritingOperations;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class UsingBufferedWriter {

	public static void main(String[] args) throws IOException {
		
		String Location="BufferedWriter.txt";
		String Content="write the content with Buffered writer!!";
		
		FileWriter fileWriter=new FileWriter(Location);
		BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
		bufferedWriter.write(Content);
		bufferedWriter.close();
		

	}

}
