public class Book{
    private int book_id = 0;
    private String title;
    private String author;
    private String genre;
    private boolean is_borrowed;
    
    public Book(String title, String author,String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.is_borrowed = false;
        this.book_id++;
    }

    public boolean isIs_borrowed() {
        return this.is_borrowed;
    }

    public void setIs_borrowed(boolean is_borrowed) {
        this.is_borrowed = is_borrowed;
    }
    
    public int getBook_id() {
        return book_id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book Id       :" + book_id + "\n" +
               "Book Title    :" + title + "\n" +
               "Author        :" + author + "\n"+
               "Genre         :" + genre + "\n"+
               "Availability  :" + (is_borrowed?"No":"Yes") + "\n" ;
    }
}