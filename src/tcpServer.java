import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class tcpServer {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println(timeChk.getTime() + "Server Start!");
		/* CSV File Path */
		String uri = " ";
		
		List<String> LineList = new ArrayList<String>();
		LineList = csvFileRoad.Road(uri);

		try {
			ServerSocket serverSocket = null;

			serverSocket = new ServerSocket(5000); // Socket Number
			while (true) {
				Socket socket = serverSocket.accept(); // Socket Create

				if (socket != null) {
					Thread thread = new Thread(new acceptThread(socket, LineList)); // Socket Thread Create
					thread.start(); 
				}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
