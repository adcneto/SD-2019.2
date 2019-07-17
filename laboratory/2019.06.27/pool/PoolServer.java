package pool;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class PoolServer {
	/** Well-known server port. */
	public static int serverPort = 9000;

	/** ThreadPool instance */
	public static ThreadPool threadPool = new ThreadPool(5, 10);

	@SuppressWarnings("resource")
	public static void main(String args[]) throws Exception {
		// Dispatcher socket
		ServerSocket serverSocket = new ServerSocket(serverPort);
		// Waits for a new connection. Accepts connection from multiple clients
		while (true) {
			System.out.println("Waiting for connection at port " + serverPort + ".");
			// Worker socket
			Socket s = serverSocket.accept();
			System.out.println("Connection established from " + s.getInetAddress().getHostAddress() + ", local port: "
					+ s.getLocalPort() + ", remote port: " + s.getPort() + ".");

			threadPool.execute(() -> {
				try {
					// Create a BufferedReader object to read strings from the socket.
					// (read strings FROM CLIENT)
					BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
					String input = br.readLine();
					// Create output stream to write to/send TO CLIENT
					DataOutputStream output = new DataOutputStream(s.getOutputStream());
					// Keep repeating until the command "quit" is read.
					while (!input.equals("quit")) {
						// Convert input to upper case and echo back to client.
						System.out.println(
								"From client " + s.getInetAddress().getHostAddress() + ":" + s.getPort() + ": " + input);
						output.writeBytes(input.toUpperCase() + "\n");
						input = br.readLine();
					}
					System.out
							.println("Connection closed from " + s.getInetAddress().getHostAddress() + ":" + s.getPort());
					// Close current connection
					br.close();
					output.close();
					s.close();
				} catch (IOException e) {
					// Print exception info
					e.printStackTrace();
				}
			});
		}
	}
}
