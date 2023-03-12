import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class CardInputStream extends InputStream{
	BufferedReader reader;

	public CardInputStream(InputStream input) {
		this.reader = new BufferedReader(new InputStreamReader(input));
	}

	//@Override
	public void close() {
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


    public Card readCard(){
        String readedInput;
        Long id=null;
        String name=null;
        Rank rank=null;
        Long price = null;
        try {
					while ((readedInput=reader.readLine()) != null){
			    	if (readedInput.equals("CARD")){
			        if((readedInput=reader.readLine())!=null){
								//readedInput=reader.readLine();
			        	id = Long.parseLong(readedInput);
			        }
			        if((readedInput=reader.readLine())!=null){
								//readedInput=reader.readLine();
			           name = readedInput;
			        }
			        if((readedInput=reader.readLine())!=null){
								//readedInput=reader.readLine();
			          rank = Rank.valueOf(readedInput.toUpperCase());
			        }
			        if((readedInput=reader.readLine())!=null){
								//readedInput=reader.readLine();
			        	price = Long.parseLong(readedInput);
			        }
			        Card card = new Card(id,name,rank);
			        card.setPrice(price);
			        return card;
			    	}else if (readedInput.equals("OK")){
			        return null;
						}
					}
				} catch (NumberFormatException | IOException e) {
					System.out.println("an error inside CARDREADER() happened");
					return null;
				}
				return null;
			}

    /*
     * it reads the entire information held in the bufferedReader, stores it in a String variable and ultimately return the String
     */
	public String readResponse() throws IOException {
		String fullMessage = "";
		String receivedMessage;
		while ((receivedMessage = reader.readLine()) != null) {
            fullMessage += receivedMessage;
		}
		return fullMessage;
	}

	@Override
	public int read() throws IOException {
		return 0;
	}

}
