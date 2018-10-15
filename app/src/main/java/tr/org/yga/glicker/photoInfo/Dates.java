package tr.org.yga.glicker.photoInfo;

public class Dates{
	private String taken;
	private String takengranularity;
	private String lastupdate;
	private String takenunknown;
	private String posted;

	public void setTaken(String taken){
		this.taken = taken;
	}

	public String getTaken(){
		return taken;
	}

	public void setTakengranularity(String takengranularity){
		this.takengranularity = takengranularity;
	}

	public String getTakengranularity(){
		return takengranularity;
	}

	public void setLastupdate(String lastupdate){
		this.lastupdate = lastupdate;
	}

	public String getLastupdate(){
		return lastupdate;
	}

	public void setTakenunknown(String takenunknown){
		this.takenunknown = takenunknown;
	}

	public String getTakenunknown(){
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
