package properties;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Hashtable;

public class Client extends Thread {
  InetAddress host = null;
  Socket socket = null;
  ObjectOutputStream oos = null;
  ObjectInputStream ois = null;

  private static final int PORT = 4444;

  public static void main(String[] args) {
    new Client().start();
  }

  @Override
  public void run() {
    try {
      host = InetAddress.getLocalHost();
      socket = new Socket(host.getHostName(), PORT);
      oos = new ObjectOutputStream(socket.getOutputStream());
      oos.writeObject(System.getProperties());
      ois = new ObjectInputStream(socket.getInputStream());
      Hashtable<String, String> message = (Hashtable<String, String>) ois.readObject();
			for (String key : message.keySet()) {
				System.out.println(key + ": " + message.get(key));
			}
      ois.close();
      oos.close();
      socket.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
