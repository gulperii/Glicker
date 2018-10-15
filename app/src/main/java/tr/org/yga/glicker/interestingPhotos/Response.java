package tr.org.yga.glicker.interestingPhotos;

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
			"interestingPhotos{" +
			"stat = '" + stat + '\'' + 
			",photos = '" + photos + '\'' + 
			"}";
		}
}
