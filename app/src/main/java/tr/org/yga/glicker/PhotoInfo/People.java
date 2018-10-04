package tr.org.yga.glicker.PhotoInfo;

public class People{
	private int haspeople;

	public void setHaspeople(int haspeople){
		this.haspeople = haspeople;
	}

	public int getHaspeople(){
		return haspeople;
	}

	@Override
 	public String toString(){
		return 
			"People{" + 
			"haspeople = '" + haspeople + '\'' + 
			"}";
		}
}
