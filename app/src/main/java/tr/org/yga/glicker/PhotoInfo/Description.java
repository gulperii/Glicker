package tr.org.yga.glicker.PhotoInfo;

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
