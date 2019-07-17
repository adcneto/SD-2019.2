package properties;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;

public class Server extends Thread {
  Socket socket = null;
  ObjectInputStream ois = null;
  ObjectOutputStream oos = null;

  private static final int PORT = 4444;

  public static void main(String[] args) {
    new Server().start();
  }

  public Hashtable<String, String> diff(Properties aProp) {
		Properties prop = System.getProperties();
		Hashtable<String, String> res = new Hashtable<String, String>();
		for (Enumeration<?> names = prop.propertyNames(); names.hasMoreElements();) {
			String property = (String) names.nextElement();
			String value1 = prop.getProperty(property);
			String value2 = aProp.getProperty(property);
			if (!value1.equals(value2)) { // add to hashtable
				res.put(property, value1 + " / " + value2);
			}
		}
		return res;
	}

  @Override
  public void run() {
    try {
      ServerSocket server = new ServerSocket(PORT);
      while (true) {
        socket = server.accept();
        ois = new ObjectInputStream(socket.getInputStream());
        Properties message = (Properties) ois.readObject();
        System.out.println("Server Received: " + message);
        oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(diff(message));
        ois.close();
        oos.close();
        socket.close();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
