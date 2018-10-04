package tr.org.yga.glicker.Response;

public class Response{
	private String stat;
	private Photos photos;

	public String getStat(){
		return stat;
	}

	public Photos getPhotos(){
		return photos;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"stat = '" + stat + '\'' + 
			",photos = '" + photos + '\'' + 
			"}";
		}
}
