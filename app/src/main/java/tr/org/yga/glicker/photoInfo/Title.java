package tr.org.yga.glicker.photoInfo;

public class Title{
	private String content;

	public void setContent(String content){
		this.content = content;
	}

	public String getContent(){
		return content;
	}

	@Override
 	public String toString(){
		return 
			"Title{" + 
			"_content = '" + content + '\'' + 
			"}";
		}
}
