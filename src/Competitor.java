import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class Competitor {
	public String firstName;
	public String lastName;
	public ArrayList<Competition> competitions;
	public ArrayList<Event> events;
	public ArrayList<Result> results;
	
	public Competitor(String first, String last) {
		if(first == null || last == null) {
			throw new IllegalArgumentException("First and last name may not be null");
		}
		firstName = first.trim();
		lastName = last.trim();
		
		competitions = new ArrayList<Competition>();
		events = new ArrayList<Event>();
		results = new ArrayList<Result>();
		
	}
	
	public String toString() {
		return firstName + " " + lastName;
	}
	
	public void addCompetition(Competition c) {
		// TODO Prevent duplicate additions
		if(c == null) {
			throw new IllegalArgumentException("Competition may not be null");
		}
		competitions.add(c);
	}
	
	public void addEvent(Event e) {
		// TODO Prevent duplicate additions
		if(e == null) {
			throw new IllegalArgumentException("Event may not be null");
		}
		events.add(e);
	}
	
	public void addResult(Result r) {
		// TODO Prevent duplicate additions
		if(r == null) {
			throw new IllegalArgumentException("Result may not be null");
		}
		results.add(r);
	}
	
	public String getCompetitorUrl() {
		return "http://results.o2cm.com/individual.asp?szLast=" + lastName + "&szFirst=" + firstName;
	}
	
	public String getResultsOfCompetitor() {
		// retrieve website
		Document doc = null;
		try {
			doc = Jsoup.connect(getCompetitorUrl()).get();
		}
		catch(Exception e) {
			System.out.println("Problem retrieving website");
		}

		// get table rows
		String output = "";
		for(Element e : doc.select("td.t1n")) {
			// if element has children
			if(e.childNodeSize() > 1) {
				// if child isn't a link (is a comp name)
				if(!e.child(0).tagName().equals("a")) {
					output += e.select("b").text() + "\n";
				}
				else {	// if child is a link (in an entry)
					output += e.select("a").text() + "\n";
				}
			}	
		}
		return output;
	}
}
