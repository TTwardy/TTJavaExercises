package Chapter9;

public class Book {
    String title;
    String author;
    int publicationYear;

    public Book (String title, String author, int publicationYear){
        this.title=title;
        this.author=author;
        this.publicationYear=publicationYear;
    };

    @Override
    public String toString(){
        return String.format("Title:%s\n Author:%s\n Year of publication:%d",title, author, publicationYear);
    }
}
