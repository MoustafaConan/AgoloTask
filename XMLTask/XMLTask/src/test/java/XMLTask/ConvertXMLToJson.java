package XMLTask;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class ConvertXMLToJson {

	public static void main(String[] args) throws Exception {

		// our XML file for this example
		File xmlFile = new File("websites.xml");

		Reader fileReader = new FileReader(xmlFile);
		BufferedReader bufReader = new BufferedReader(fileReader);

		StringBuilder sb = new StringBuilder();
		String line = bufReader.readLine();
		while( line != null){
			sb.append(line).append("\n");
			line = bufReader.readLine();
		}
		String xmlString = sb.toString();
		System.out.println("XML to String using BufferedReader : ");
		System.out.println(xmlString);

		// Convert XML to a Map structure
		XmlMapper xmlMapper = new XmlMapper();
		LinkedHashMap<String, Object> websiteMap = (LinkedHashMap<String, Object>) xmlMapper.readValue(xmlString, Map.class);

		// Convert Map to JSON using ObjectMapper
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(websiteMap);

		System.out.println(jsonString);
	}

}
