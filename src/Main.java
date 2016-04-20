import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {
	public static void main(String[] args) {
		// make new competitor
		Competitor brandon = new Competitor("Brandon", "LaRue");
		
		// print competitor results
		System.out.println("Results of " + brandon);
		System.out.println(brandon.getResultsOfCompetitor() + "\n");
		
		// make new competition
		Competition midAtlantic = new Competition("Mid-Atlantic", 2016);
		midAtlantic.populateCompetitorsFromWebsite("http://results.o2cm.com/event3.asp?event=ser16&bclr=#FFFFFF&tclr=#000000");
	
		// print competitors
		System.out.println("Competitors from " + midAtlantic.name + " - " + midAtlantic.year);
		for(Competitor c : midAtlantic.competitors) {
			System.out.println(c);
		}
	}
	
	

/*
	// returns the placements of all competitors within a competition, however it does not break it down by event
	// TODO update to parse results by event and make competitor objects
	public static ArrayList<Result> getUndifferentiatedResultsFromCompetition(String compUrl) {
		// get document from site
		Document doc = null;
		try {
			// Mid-Atlantic http://results.o2cm.com/event3.asp?event=ser16&bclr=#FFFFFF&tclr=#000000
			doc = Jsoup.connect(compUrl).get();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// get info from website and populate results
		ArrayList<Result> results = new ArrayList<Result>();
		Elements nameList = doc.select("td.t2n");
		for(Element e : nameList) {
			// data needed to create result
			//int place;
			//String lead;
			//String follow;

			// check to see if element is actually an entry	
			int indexOfEnd = e.text().indexOf(")");
			if(indexOfEnd != -1) {
				// get place
				place = Integer.parseInt(e.text().substring(0, indexOfEnd));

				// get lead and follow
				String[] splitString = e.text().split(" ");
				lead = splitString[2] + " " + splitString[3];
				follow = splitString[5] + " " + splitString[6];

				// make result entry
				//results.add(new Result(place, lead, follow));
			}
		}

		
		// return results
		return results;
	}
	*/
}
