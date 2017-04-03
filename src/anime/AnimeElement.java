package anime;

import org.w3c.dom.Node;

public class AnimeElement {
	private Node id, title, english, synonyms, episodes, score, type, status, start_date, end_date, synopsis;

	/*
	 * Because of the way the XML value from the API is returned it is just
	 * easier to hard code these values..
	 */
	public AnimeElement(Node animeEntry) {
		id = animeEntry.getChildNodes().item(1);
		title = animeEntry.getChildNodes().item(3);
		english = animeEntry.getChildNodes().item(5);
		synonyms = animeEntry.getChildNodes().item(7);
		episodes = animeEntry.getChildNodes().item(9);
		score = animeEntry.getChildNodes().item(11);
		type = animeEntry.getChildNodes().item(13);
		status = animeEntry.getChildNodes().item(15);
		start_date = animeEntry.getChildNodes().item(17);
		end_date = animeEntry.getChildNodes().item(19);
		synopsis = animeEntry.getChildNodes().item(21);
	}

	public String getValue(Node n) {
		return n.getFirstChild() == null ? "" : n.getFirstChild().getNodeValue();
	}

	/****************** GETTERS ********************/
	public String getId() {
		return getValue(id);
	}

	public String getTitle() {
		return getValue(title);
	}

	public String getEnglish() {
		return getValue(english);
	}

	public String getSynonyms() {
		return getValue(synonyms);
	}

	public String getEpisodes() {
		return getValue(episodes);
	}

	public String getScore() {
		return getValue(score);
	}

	public String getType() {
		return getValue(type);
	}

	public String getStatus() {
		return getValue(status);
	}

	public String getStart() {
		return getValue(start_date);
	}

	public String getEnd() {
		return getValue(end_date);
	}

	public String getSynopsis() {
		return getValue(synopsis);
	}

	/*
	 * Pretty print an anime element
	 */
	public void readElement() {
		System.out.println(getId() + " " + getTitle() + " " + getEpisodes() + " " + getScore() + " " + getType() + " "
				+ getStatus() + " " + getStart() + " " + getEnd());
	}
}