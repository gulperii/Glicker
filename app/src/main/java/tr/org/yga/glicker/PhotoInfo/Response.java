package tr.org.yga.glicker.PhotoInfo;

public class Response{

	// TODO: 15.10.2018 Response adında bır sey bırakma
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
			"Response{" + 
			"stat = '" + stat + '\'' + 
			",photo = '" + photo + '\'' + 
			"}";
		}
}
