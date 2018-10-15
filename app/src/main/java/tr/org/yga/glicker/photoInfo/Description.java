package tr.org.yga.glicker.photoInfo;

public class Description{
	private String _content;


	public String getContent(){
		return _content;
	}

	@Override
 	public String toString(){
		return 
			"Description{" + 
			"_content = '" + _content + '\'' +
			"}";
		}
}
