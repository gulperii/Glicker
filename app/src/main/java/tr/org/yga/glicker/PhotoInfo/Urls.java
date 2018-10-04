package tr.org.yga.glicker.PhotoInfo;

import java.util.List;

public class Urls{
	private List<UrlItem> url;

	public void setUrl(List<UrlItem> url){
		this.url = url;
	}

	public List<UrlItem> getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"Urls{" + 
			"url = '" + url + '\'' + 
			"}";
		}
}