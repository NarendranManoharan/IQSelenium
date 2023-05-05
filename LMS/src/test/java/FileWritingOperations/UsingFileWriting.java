package FileWritingOperations;

import java.io.FileWriter;
import java.io.IOException;

public class UsingFileWriting {

	public static void main(String[] args) throws IOException {
		
		String location="Filewriter.txt";
	    String content="Avengers!!!! Assemble";
	    
	    FileWriter fileWriter=new FileWriter(location);
	    fileWriter.write(content);
	    fileWriter.close();

	}

}
