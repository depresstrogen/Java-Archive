import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TestServer {
	


	public static void readMessage(DataInputStream din) throws Exception {
		String msg = din.readUTF();
		System.out.println("From Laptop" + msg);
	}

	public static void sendMessage(DataOutputStream dout, String msg) throws Exception {
		dout.writeUTF(msg);
		dout.flush();
	}

	public static void main(String[] args) throws Exception {
		boolean connected = true;
		TestServer server = new TestServer();
		ServerSocket ss = new ServerSocket(3333);
		Socket s = ss.accept();
		DataInputStream din = new DataInputStream(s.getInputStream());
		DataOutputStream dout = new DataOutputStream(s.getOutputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Thread sendThread = new Thread() {
			public void run() {
				while (connected) {
					try {
						sendMessage(dout, br.readLine());
					} catch (Exception e) {

					}
				}
			}
		};
		sendThread.start();

		Thread readThread = new Thread() {
			public void run() {
				while (connected) {
					try {
						readMessage(din);
					} catch (Exception e) {

					}
				}
			}
		};
		readThread.start();

		while (connected) {

		}
		s.close();
		ss.close();
	}

}
