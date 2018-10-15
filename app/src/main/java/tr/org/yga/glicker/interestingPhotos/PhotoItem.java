package tr.org.yga.glicker.interestingPhotos;

public class PhotoItem{
	// TODO: 15.10.2018 json parse ıcın moshı ya da gson kullan
	private String owner;
	private String server;
	private int ispublic;
	private int isfriend;
	private int farm;
	private String id;
	private String secret;
	private String title;
	private int isfamily;

	public String getOwner(){
		return owner;
	}

	public String getServer(){
		return server;
	}

	public int getIspublic(){
		return ispublic;
	}

	public int getIsfriend(){
		return isfriend;
	}

	public int getFarm(){
		return farm;
	}

	public String getId(){
		return id;
	}

	public String getSecret(){
		return secret;
	}

	public String getTitle(){
		return title;
	}

	public int getIsfamily(){
		return isfamily;
	}

	@Override
 	public String toString(){
		return 
			"PhotoItem{" + 
			"owner = '" + owner + '\'' + 
			",server = '" + server + '\'' + 
			",ispublic = '" + ispublic + '\'' + 
			",isfriend = '" + isfriend + '\'' + 
			",farm = '" + farm + '\'' + 
			",id = '" + id + '\'' + 
			",secret = '" + secret + '\'' + 
			",title = '" + title + '\'' + 
			",isfamily = '" + isfamily + '\'' + 
			"}";
		}
}
