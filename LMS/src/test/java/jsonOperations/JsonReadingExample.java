package jsonOperations;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReadingExample {

	public static void main(String[] args) throws IOException, ParseException {
		
		JSONParser jsonParser=new JSONParser();
		
		FileReader fileReader=new FileReader("Jsonwriter.json");
		Object object=jsonParser.parse(fileReader);
		
		JSONObject jsonObject=(JSONObject) object;
		
		String name=(String)jsonObject.get("Name");
		long age=(long) jsonObject.get("age");
		JSONArray array=  (JSONArray) jsonObject.get("Operations");
		
		Iterator iterator= array.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next()); 
		}
		
		System.out.println(name);
		System.out.println(age);
		//System.out.println(array);
	}

}
