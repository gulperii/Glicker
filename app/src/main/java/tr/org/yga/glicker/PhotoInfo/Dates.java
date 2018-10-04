package tr.org.yga.glicker.PhotoInfo;

public class Dates{
	private String taken;
	private int takengranularity;
	private String lastupdate;
	private int takenunknown;
	private String posted;

	public void setTaken(String taken){
		this.taken = taken;
	}

	public String getTaken(){
		return taken;
	}

	public void setTakengranularity(int takengranularity){
		this.takengranularity = takengranularity;
	}

	public int getTakengranularity(){
		return takengranularity;
	}

	public void setLastupdate(String lastupdate){
		this.lastupdate = lastupdate;
	}

	public String getLastupdate(){
		return lastupdate;
	}

	public void setTakenunknown(int takenunknown){
		this.takenunknown = takenunknown;
	}

	public int getTakenunknown(){
		return takenunknown;
	}

	public void setPosted(String posted){
		this.posted = posted;
	}

	public String getPosted(){
		return posted;
	}

	@Override
 	public String toString(){
		return 
			"Dates{" + 
			"taken = '" + taken + '\'' + 
			",takengranularity = '" + takengranularity + '\'' + 
			",lastupdate = '" + lastupdate + '\'' + 
			",takenunknown = '" + takenunknown + '\'' + 
			",posted = '" + posted + '\'' + 
			"}";
		}
}
