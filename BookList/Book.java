package BookList;

public class Book {
    private String bookName;
    private int numberOfPages;
    private String authorName;
    private String publishDate;

    public Book(String bookName, int numberOfPages, String authorName, String publishDate) {
        this.bookName = bookName;
        this.numberOfPages = numberOfPages;
        this.authorName = authorName;
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Book name : ");
        sb.append(bookName); sb.append("\n");
        sb.append("Number of pages : ");
        sb.append(numberOfPages); sb.append("\n");
        sb.append("author name : ");
        sb.append(authorName); sb.append("\n");
        sb.append("publish date : ");
        sb.append(publishDate); sb.append("\n");
        return sb.toString();
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }
}
