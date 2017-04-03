package anime;

import java.util.ArrayList;

import org.w3c.dom.NodeList;

public class AnimeEntries {
	private ArrayList<AnimeElement> entries = new ArrayList<AnimeElement>();

	public AnimeEntries(NodeList animeObj) {
		for (int i = 0; i < animeObj.getLength(); i++) {
			if (!animeObj.item(i).getNodeName().equals("#text")) {
				AnimeElement ae = new AnimeElement(animeObj.item(i));
				entries.add(ae);
			}
		}
	}

	public ArrayList<AnimeElement> getEntries() {
		return entries;
	}

	public void readEntry(AnimeElement entry) {
		entry.readElement();
	}

}
