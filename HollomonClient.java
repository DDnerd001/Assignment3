import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//import javax.netsrv.cim.rhul.ac.uk;

public class HollomonClient {
  private String server;
	private int port;
	Socket socket;
	BufferedWriter writer;
	BufferedReader reader;
	CardInputStream cardcreator;


  public HollomonClient(String server, int port) {
		this.server = server;
		this.port = port;
	}

  public List<Card> login(String username, String password) {
		try {
			socket = new Socket(this.server , this.port);
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			Card card = null;
			List<Card> list = new ArrayList<Card>();
			writer.write(String.format("%s\n%s\n", username, password));
			writer.flush();
			String recievedMessage;

			if ((recievedMessage = reader.readLine()) != null) {
          System.out.println(recievedMessage);
          if (recievedMessage.equals("User "+username+" logged in successfully.")) {
              //return null;
              return list;
          }
      }
      cardcreator = new CardInputStream(socket.getInputStream());
      while ((card = cardcreator.readCard()) !=null) {
        if (card != null) {
                    list.add(card);
        }
      }
      list.sort(null);
      return list;
		} catch (UnknownHostException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}







  public void close(){
		 try {
			socket.close();
			writer.close();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	 }


}
