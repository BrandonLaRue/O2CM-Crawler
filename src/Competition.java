import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Competition {
	public String name;
	public int year;
	
	public ArrayList<Event> events;
	public ArrayList<Competitor> competitors;
	
	public Competition(String name, int year) {
		if(name == null || year < 1) {
			throw new IllegalArgumentException("Invalid name or year");
		}
		
		this.name = name;
		this.year = year;
	}
	
	public void addEvent(Event e) {
		// TODO Prevent duplicate additions
		if(e == null) {
			throw new IllegalArgumentException("Event may not be null");
		}
		events.add(e);
	}
	
	public void addCompetitor(Competitor c) {
		// TODO Prevent duplicate additions
		if(c == null) {
			throw new IllegalArgumentException("Competition may not be null");
		}
		competitors.add(c);
	}
	
	public void populateCompetitorsFromWebsite(String url) {
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
		}
		catch(Exception e ) {
			
		}
		
		// get competitors
		ArrayList<Competitor> competitors = new ArrayList<Competitor>();
		for(Element e : doc.select("option")) {
			String[] s = e.text().split(", ");
			try {
				if(!s[1].equals("TBA") && !s[0].equals("TBA")) {
					competitors.add(new Competitor(s[1], s[0]));
				}
			}
			catch(IndexOutOfBoundsException ex) {
				
			}
			
		}
		
		this.competitors = competitors;
	}
}
