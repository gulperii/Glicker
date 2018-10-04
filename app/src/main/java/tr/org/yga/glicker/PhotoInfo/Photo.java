package tr.org.yga.glicker.PhotoInfo;

public class Photo{
	private Owner owner;
	private String server;
	private String dateuploaded;
	private Comments comments;
	private Notes notes;
	private Visibility visibility;
	private Publiceditability publiceditability;
	private int safetyLevel;
	private int rotation;
	private Usage usage;
	private Description description;
	private Dates dates;
	private String secret;
	private String media;
	private Title title;
	private People people;
	private Tags tags;
	private int license;
	private Urls urls;
	private Editability editability;
	private int farm;
	private int isfavorite;
	private String id;
	private String views;

	public void setOwner(Owner owner){
		this.owner = owner;
	}

	public Owner getOwner(){
		return owner;
	}

	public void setServer(String server){
		this.server = server;
	}

	public String getServer(){
		return server;
	}

	public void setDateuploaded(String dateuploaded){
		this.dateuploaded = dateuploaded;
	}

	public String getDateuploaded(){
		return dateuploaded;
	}

	public void setComments(Comments comments){
		this.comments = comments;
	}

	public Comments getComments(){
		return comments;
	}

	public void setNotes(Notes notes){
		this.notes = notes;
	}

	public Notes getNotes(){
		return notes;
	}

	public void setVisibility(Visibility visibility){
		this.visibility = visibility;
	}

	public Visibility getVisibility(){
		return visibility;
	}

	public void setPubliceditability(Publiceditability publiceditability){
		this.publiceditability = publiceditability;
	}

	public Publiceditability getPubliceditability(){
		return publiceditability;
	}

	public void setSafetyLevel(int safetyLevel){
		this.safetyLevel = safetyLevel;
	}

	public int getSafetyLevel(){
		return safetyLevel;
	}

	public void setRotation(int rotation){
		this.rotation = rotation;
	}

	public int getRotation(){
		return rotation;
	}

	public void setUsage(Usage usage){
		this.usage = usage;
	}

	public Usage getUsage(){
		return usage;
	}

	public void setDescription(Description description){
		this.description = description;
	}

	public Description getDescription(){
		return description;
	}

	public void setDates(Dates dates){
		this.dates = dates;
	}

	public Dates getDates(){
		return dates;
	}

	public void setSecret(String secret){
		this.secret = secret;
	}

	public String getSecret(){
		return secret;
	}

	public void setMedia(String media){
		this.media = media;
	}

	public String getMedia(){
		return media;
	}

	public void setTitle(Title title){
		this.title = title;
	}

	public Title getTitle(){
		return title;
	}

	public void setPeople(People people){
		this.people = people;
	}

	public People getPeople(){
		return people;
	}

	public void setTags(Tags tags){
		this.tags = tags;
	}

	public Tags getTags(){
		return tags;
	}

	public void setLicense(int license){
		this.license = license;
	}

	public int getLicense(){
		return license;
	}

	public void setUrls(Urls urls){
		this.urls = urls;
	}

	public Urls getUrls(){
		return urls;
	}

	public void setEditability(Editability editability){
		this.editability = editability;
	}

	public Editability getEditability(){
		return editability;
	}

	public void setFarm(int farm){
		this.farm = farm;
	}

	public int getFarm(){
		return farm;
	}

	public void setIsfavorite(int isfavorite){
		this.isfavorite = isfavorite;
	}

	public int getIsfavorite(){
		return isfavorite;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setViews(String views){
		this.views = views;
	}

	public String getViews(){
		return views;
	}

	@Override
 	public String toString(){
		return 
			"Photo{" + 
			"owner = '" + owner + '\'' + 
			",server = '" + server + '\'' + 
			",dateuploaded = '" + dateuploaded + '\'' + 
			",comments = '" + comments + '\'' + 
			",notes = '" + notes + '\'' + 
			",visibility = '" + visibility + '\'' + 
			",publiceditability = '" + publiceditability + '\'' + 
			",safety_level = '" + safetyLevel + '\'' + 
			",rotation = '" + rotation + '\'' + 
			",usage = '" + usage + '\'' + 
			",description = '" + description + '\'' + 
			",dates = '" + dates + '\'' + 
			",secret = '" + secret + '\'' + 
			",media = '" + media + '\'' + 
			",title = '" + title + '\'' + 
			",people = '" + people + '\'' + 
			",tags = '" + tags + '\'' + 
			",license = '" + license + '\'' + 
			",urls = '" + urls + '\'' + 
			",editability = '" + editability + '\'' + 
			",farm = '" + farm + '\'' + 
			",isfavorite = '" + isfavorite + '\'' + 
			",id = '" + id + '\'' + 
			",views = '" + views + '\'' + 
			"}";
		}
}
