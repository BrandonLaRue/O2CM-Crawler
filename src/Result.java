
public class Result {

	public int place;
	public Competitor lead;
	public Competitor follow;
	public Event myEvent;
	
	public Result(int place, Competitor lead, Competitor follow , Event myEvent) {
		// TODO determine how I might deal with a TBA type situation
		if(lead == null || follow == null || myEvent == null) {
			throw new IllegalArgumentException("Must specify lead, follow, and event");
		}
		this.place = place;
		this.lead = lead;
		this.follow = follow;
		this.myEvent = myEvent;
	}
	
	public String toString() {
		return place + ") " + lead + " and " + follow;
	}
}
