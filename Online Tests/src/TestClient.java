import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class TestClient {

	DataInputStream din;
	DataOutputStream dout;
	BufferedReader br;

	public static void readMessage(DataInputStream din) throws Exception {
		String msg = din.readUTF();
		System.out.println("Server says: " + msg);
	}

	public static void sendMessage(DataOutputStream dout, String msg) throws Exception {
		dout.writeUTF(msg);
		dout.flush();
	}

	public static void main(String[] args) throws Exception {
		TestClient client = new TestClient();
		Socket s = new Socket("192.168.0.164", 3333);
		boolean connected = true;
		DataInputStream din = new DataInputStream(s.getInputStream());
		DataOutputStream dout = new DataOutputStream(s.getOutputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = "", str2 = "";
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

		client.dout.close();
		s.close();
	}

}
