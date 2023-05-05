package jsonOperations;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonWritingExample {

	public static void main(String[] args) throws IOException {
	
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("Name", "Naren");
		jsonObject.put("age", 23);
		
		JSONArray array=new JSONArray();
		array.add("jsonreading");
		array.add("jsonreading");
		
		jsonObject.put("Operations", array);
		
		
		FileWriter fw=new FileWriter("Jsonwriter.json");
		fw.write(jsonObject.toJSONString());
		fw.close();

	}

}


