import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class acceptThread implements Runnable {
	private Socket socket;
	private OutputStream out;
	private DataOutputStream dos;
	List<String> lists = new ArrayList<String>();

	public acceptThread(Socket socket, List<String> list) {
		this.socket = socket;
		this.lists = list;
	}

	@Override
	public void run() {
		System.out.println(timeChk.getTime() + socket.getInetAddress() + " Connection");
		try {
			System.out.println(timeChk.getTime() + " Socket Create");
			out = socket.getOutputStream();
			dos = new DataOutputStream(out);
			
			while (true) {
				for (String list : lists) {
					System.out.println(timeChk.getTime() + "Value // " + list);
					dos.writeUTF("@"+list+"$&");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		} catch (IOException e) {
			try {
				out.close();
				dos.close();
				System.out.println(timeChk.getTime() + " Socket Close");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} 
	}
}
