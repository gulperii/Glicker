package tr.org.yga.glicker;

public class PhotoListItem {
    private String Url;

    public String getUrl() {
        return Url;
    }

    public String getContent() {
        return content;
    }

    private String content;


    public PhotoListItem(String Url, String content){
        Url=this.Url;
        content= this.content;

    }
}
