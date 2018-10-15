package tr.org.yga.glicker.photoInfo;

public class Visibility{
	private int ispublic;
	private int isfriend;
	private int isfamily;

	public void setIspublic(int ispublic){
		this.ispublic = ispublic;
	}

	public int getIspublic(){
		return ispublic;
	}

	public void setIsfriend(int isfriend){
		this.isfriend = isfriend;
	}

	public int getIsfriend(){
		return isfriend;
	}

	public void setIsfamily(int isfamily){
		this.isfamily = isfamily;
	}

	public int getIsfamily(){
		return isfamily;
	}

	@Override
 	public String toString(){
		return 
			"Visibility{" + 
			"ispublic = '" + ispublic + '\'' + 
			",isfriend = '" + isfriend + '\'' + 
			",isfamily = '" + isfamily + '\'' + 
			"}";
		}
}
