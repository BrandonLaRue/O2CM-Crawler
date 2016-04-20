import java.util.ArrayList;

public class Event {
	public String name;
	public ArrayList<Result> results;
	public ArrayList<Competitor> competitors;
	public Competition myCompetition;
	
	public Event(String name, Competition myCompetition) {
		if(name == null || myCompetition == null) {
			throw new IllegalArgumentException("Name and Competition may not be null");
		}
		this.name = name;
		this.results = new ArrayList<Result>();
		this.competitors = new ArrayList<Competitor>();
		this.myCompetition = myCompetition;
		
	}
	
	public void addResult(Result r) {
		// TODO Check if competitors or results conflict with existing records
		// add competitors from result
		competitors.add(r.lead);
		competitors.add(r.follow);
		
		// add results to event
		results.add(r);
	}
	
	public void addCompetitors(Competitor c) {
		// TODO Prevent duplicate additions
		if(c == null) {
			throw new IllegalArgumentException("Competitor may not be null");
		}
		competitors.add(c);
	}
}
