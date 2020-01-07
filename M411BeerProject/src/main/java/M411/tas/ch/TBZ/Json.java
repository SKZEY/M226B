package M411.tas.ch.TBZ;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class Json {
	
	String url;
	String key;
	int styleId;
	Gson gson = new Gson();
	
	public Json (String url, String key, int styleId) {
		this.url = url;
		this.key = key;
		this.styleId = styleId;
	}
	
	public Json (String url, String key) {
		this.url = url;
		this.key = key;
	}
	
	private String getAPI () {
		String api;
		api = url+"key=" + key;
		if (styleId != 0){
			api = api +"&styleId="+styleId;
		}
		return api;
	}
	private JsonElement callJson() throws IOException {
        URL url = null;
        JsonElement root = null;
		try {
			url = new URL(getAPI());
	        URLConnection request = url.openConnection();
	        request.connect(); 
	        JsonParser jp = new JsonParser();
	        root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return root;
	}
	
	//Result result = gson.fromJson(root, Result.class);
	public Object createJavaObjectFromJson(Class cl) throws JsonSyntaxException, IOException, ClassNotFoundException {
		Object result = gson.fromJson(callJson(), cl);
		return result;
	}
	
	

}
