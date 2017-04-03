import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Base64;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import Anime.AnimeElement;
import Anime.AnimeEntries;

public class MALSearch {
	// Change the following values to your MAL username and password to use the searchMAL method
	private final static String USER = "user";
	private final static String PASS = "pass";

	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
		MALSearch s = new MALSearch();
		// Just to show it works I've left this test search, can be changed later.
		s.searchMAL("one punch");
	}

	MALSearch(){
	}

	public void searchMAL(String search) throws IOException, ParserConfigurationException, SAXException {
		// Create the search term and append it to the search api call
		String uri = "https://myanimelist.net/api/anime/search.xml?q=" + search.replaceAll(" ", "+");
		URL url = new URL(uri);
		URLConnection connection = url.openConnection();
		
		// In order to call the API you must provide authorization
		connection.setRequestProperty("Authorization", "Basic " + encodeCreds());
		connection.connect();
		
		// Get the XML value returned from the API
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document d = db.parse(connection.getInputStream());
		
		// Get each entry under the 'anime' element
		NodeList children = d.getDocumentElement().getChildNodes();
		AnimeEntries ae = new AnimeEntries(children);
		ArrayList<AnimeElement> element = ae.getEntries();
		for (AnimeElement a : element) {
			a.readElement();
		}
	}

	private static String encodeCreds() {
		String userpass = USER + ":" + PASS;
		return Base64.getEncoder().encodeToString(userpass.getBytes());
	}
}
