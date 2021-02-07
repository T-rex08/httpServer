package networking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.imageio.ImageIO;

public class ConnectionHandler {
	public void run(Webpage[] pages,Webimage[] images,Webpage error404) throws IOException {
	    int port = 80;
	    @SuppressWarnings("resource")
		ServerSocket serverSocket = new ServerSocket(port);

	    while (true) {
	        Socket clientSocket = serverSocket.accept();

	        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
	        String s;
	        String path = null;
	        while ((s = in.readLine()) != null) {
	        	if(s.contains("GET")) {
	        		path=s;
	        		path=path.split("/")[1];
	        		path=path.replace(" HTTP", "");
	        		path="/"+path;
	        	}
	            System.out.println(s);
	            if (s.isEmpty()) {
	                break;
	            }
	        }

	        out.write("HTTP/1.0 200 OK\r\n");
	        out.write("Content-Type: text/html\r\n");
	        out.write("\r\n");
	        boolean founded=false;
	        for(Webpage data : pages) {
	        	System.out.println(path);
	        	if(data.path.equals(path)) {
	        		out.write(data.load());
	        		founded=true;
	        	}
	        }
	        for(Webimage data : images) {
	        	System.out.println(data.path);
	        	System.out.println(path);
	        	if(data.path.equals(path)) {
	        		System.out.println("worked");
	        		ImageIO.write(data.source, "png", clientSocket.getOutputStream());
	        		founded=true;
	        	}
	        }
	        if(!founded) {
	        	out.write(error404.load());
	        }
	        out.close();
	        in.close();
	        clientSocket.close();
	    }
	}
}