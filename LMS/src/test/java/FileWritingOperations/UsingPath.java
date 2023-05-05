package FileWritingOperations;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;



public class UsingPath {

	public static void main(String[] args) throws IOException {
		
		String Location="PATH.txt";
		String Content="write the content with path!!";

		Path path=Paths.get(Location);
		Files.write(path , Content.getBytes());
	}

}
