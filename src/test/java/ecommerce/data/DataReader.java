package ecommerce.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
	public List<HashMap<String,String>>  getJsonDataToMap(String path) throws IOException {
		File file = new File(path);
	String jsonContentLocation = FileUtils.readFileToString(file,StandardCharsets.UTF_8);
	
	ObjectMapper mapper = new ObjectMapper();
	List<HashMap<String,String>> datum =mapper.readValue(jsonContentLocation, new TypeReference<List<HashMap<String, String>>>(){});
	return  datum;
	
	}
}

