package Utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

public class DataReader {
	
	public List<HashMap<String, String>> getJsonData(String filePath)
	        throws IOException {
		String jsonContent =
		        Files.readString(Paths.get(filePath));
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data =
		        mapper.readValue(
		            jsonContent,
		            new TypeReference<List<HashMap<String, String>>>() {}
		        );
		return data;
		

	}		
	}


