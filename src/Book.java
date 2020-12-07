import java.io.Serializable;

public class Book implements Serializable {
    @Annotation
    public String authorName;
    @Annotation
    public String authorSurname;
    @Annotation
    public String authorBookEntryDate;
    public String nameBook;

    public Book(String authorName, String authorSurname, String authorBookEntryDate, String nameBook) {
        this.authorName = authorName;
        this.authorSurname = authorSurname;
        this.authorBookEntryDate = authorBookEntryDate;
        this.nameBook = nameBook;
    }

    public Book() {
    }

    public String getAuthorName() {

        return authorName;
    }

    public void setAuthorName(String authorName) {

        this.authorName = authorName;
    }

    public String getAuthorSurname() {

        return authorSurname;
    }

    public void setAuthorSurname(String authorSurname) {

        this.authorSurname = authorSurname;
    }

    public String getAuthorBookEntryDate() {

        return authorBookEntryDate;
    }

    public void setAuthorBookEntryDate(String authorBookEntryDate) {

        this.authorBookEntryDate = authorBookEntryDate;
    }

    public String getNameBook() {

        return nameBook;
    }

    public void setNameBook(String nameBook) {

        this.nameBook = nameBook;
    }

    @Override
    public String toString() {
        return "Book{" +
                "authorName='" + authorName + '\'' +
                ", authorSurname='" + authorSurname + '\'' +
                ", authorBookEntryDate='" + authorBookEntryDate + '\'' +
                ", nameBook='" + nameBook + '\'' +
                '}';
    }
}
