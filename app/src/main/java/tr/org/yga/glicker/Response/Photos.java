package tr.org.yga.glicker.Response;

import java.util.List;

public class Photos{
	private int perpage;
	private String total;
	private int pages;
	private List<PhotoItem> photo;
	private int page;

	public int getPerpage(){
		return perpage;
	}

	public String getTotal(){
		return total;
	}

	public int getPages(){
		return pages;
	}

	public List<PhotoItem> getPhoto(){
		return photo;
	}

	public int getPage(){
		return page;
	}

	@Override
 	public String toString(){
		return 
			"Photos{" + 
			"perpage = '" + perpage + '\'' + 
			",total = '" + total + '\'' + 
			",pages = '" + pages + '\'' + 
			",photo = '" + photo + '\'' + 
			",page = '" + page + '\'' + 
			"}";
		}
}