package tr.org.yga.glicker.PhotoInfo;

public class Comments{
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
			"Comments{" + 
			"_content = '" + content + '\'' + 
			"}";
		}
}
