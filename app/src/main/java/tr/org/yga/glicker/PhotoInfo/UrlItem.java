package tr.org.yga.glicker.PhotoInfo;

public class UrlItem{
	private String type;
	private String content;

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setContent(String content){
		this.content = content;
	}

	public String getContent(){
		return content;
	}

	@Override
 	public String toString(){
		return 
			"UrlItem{" + 
			"type = '" + type + '\'' + 
			",_content = '" + content + '\'' + 
			"}";
		}
}
