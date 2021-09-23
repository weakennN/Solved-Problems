package ObjectsAndClasses;

public class ArticlesInfo {

    private String title;
    private String content;
    private String author;

    public ArticlesInfo(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

  /*  public ArticlesInfo(ArticlesInfo a) {
        this.title = a.title;
        this.content = a.content;

    }
   */


    public void setContent(String content) {
        this.content = content;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void rename(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return String.format("%s - %s: %s", this.title, this.content, this.author);
    }


}
