package tr.org.yga.glicker.photoInfo;

public class Response{

	private String stat;
	private Photo photo;

	public void setStat(String stat){
		this.stat = stat;
	}

	public String getStat(){
		return stat;
	}

	public void setPhoto(Photo photo){
		this.photo = photo;
	}

	public Photo getPhoto(){
		return photo;
	}

	@Override
 	public String toString(){
		return 
			"interestingPhotos{" +
			"stat = '" + stat + '\'' + 
			",photo = '" + photo + '\'' + 
			"}";
		}
}
