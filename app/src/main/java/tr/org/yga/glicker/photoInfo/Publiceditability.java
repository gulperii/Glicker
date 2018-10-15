package tr.org.yga.glicker.photoInfo;

public class Publiceditability{
	private int cancomment;
	private int canaddmeta;

	public void setCancomment(int cancomment){
		this.cancomment = cancomment;
	}

	public int getCancomment(){
		return cancomment;
	}

	public void setCanaddmeta(int canaddmeta){
		this.canaddmeta = canaddmeta;
	}

	public int getCanaddmeta(){
		return canaddmeta;
	}

	@Override
 	public String toString(){
		return 
			"Publiceditability{" + 
			"cancomment = '" + cancomment + '\'' + 
			",canaddmeta = '" + canaddmeta + '\'' + 
			"}";
		}
}
