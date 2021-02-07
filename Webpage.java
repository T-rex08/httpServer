package networking;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Webpage {
	public String source;
	public String path;
	public Webpage(String source, String path) {
		File file = new File(source); 
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} 
		String st;
		String total = "";
		try {
			while ((st = br.readLine()) != null) {
			  total+=st;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.source = total;
		this.path = path;
	}
	public String load() {
		return source;
	}
}