package tr.org.yga.glicker.PhotoInfo;

public class Usage{
	private int canshare;
	private int canprint;
	private int canblog;
	private int candownload;

	public void setCanshare(int canshare){
		this.canshare = canshare;
	}

	public int getCanshare(){
		return canshare;
	}

	public void setCanprint(int canprint){
		this.canprint = canprint;
	}

	public int getCanprint(){
		return canprint;
	}

	public void setCanblog(int canblog){
		this.canblog = canblog;
	}

	public int getCanblog(){
		return canblog;
	}

	public void setCandownload(int candownload){
		this.candownload = candownload;
	}

	public int getCandownload(){
		return candownload;
	}

	@Override
 	public String toString(){
		return 
			"Usage{" + 
			"canshare = '" + canshare + '\'' + 
			",canprint = '" + canprint + '\'' + 
			",canblog = '" + canblog + '\'' + 
			",candownload = '" + candownload + '\'' + 
			"}";
		}
}
