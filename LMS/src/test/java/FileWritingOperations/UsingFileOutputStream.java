package FileWritingOperations;


import java.io.FileOutputStream;
import java.io.IOException;

public class UsingFileOutputStream {

	public static void main(String[] args) throws IOException {
		
		String Location="FOS.txt";
		String Content="write the content with FOS!!";
		
		FileOutputStream outputStream=new FileOutputStream(Location);
	
		byte[] writethis=Content.getBytes();
		
		outputStream.write(writethis);
		outputStream.close();
	}

}
