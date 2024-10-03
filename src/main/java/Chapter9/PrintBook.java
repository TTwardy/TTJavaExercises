package Chapter9;

public class PrintBook extends Book{
    String publisher;
    int isbn;

    public PrintBook(String title, String author, int publicationYear, String publisher, int isbn){
        super(title, author, publicationYear);
        this.publisher=publisher;
        this.isbn=isbn;
    }

    @Override
    public String toString(){
        return String.format("%s \nPublisher:%s \nISBN:%d",super.toString(), publisher, isbn);
    }
}
