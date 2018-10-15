package tr.org.yga.glicker.photoInfo;

public class TagItem{
	private String author;
	private int machineTag;
	private String authorname;
	private String raw;
	private String id;
	private String content;

	public void setAuthor(String author){
		this.author = author;
	}

	public String getAuthor(){
		return author;
	}

	public void setMachineTag(int machineTag){
		this.machineTag = machineTag;
	}

	public int getMachineTag(){
		return machineTag;
	}

	public void setAuthorname(String authorname){
		this.authorname = authorname;
	}

	public String getAuthorname(){
		return authorname;
	}

	public void setRaw(String raw){
		this.raw = raw;
	}

	public String getRaw(){
		return raw;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
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
			"TagItem{" + 
			"author = '" + author + '\'' + 
			",machine_tag = '" + machineTag + '\'' + 
			",authorname = '" + authorname + '\'' + 
			",raw = '" + raw + '\'' + 
			",id = '" + id + '\'' + 
			",_content = '" + content + '\'' + 
			"}";
		}
}
