package beans;

import java.util.Date;

public class Book {
    private String bookNo=null;
    private String bookName=null;
    private int volumes=1;
    private String author=null;
    private String version=null;
    private double price=0;
    private String BComment=null;
    private String pubHouse=null;
    private Date pubDate=null;

    public Book() {
    }

    public String getBookNo() {
        return bookNo;
    }

    public void setBookNo(String bookNo) {
        this.bookNo = bookNo;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getVolumes() {
        return volumes;
    }

    public void setVolumes(int volumes) {
        this.volumes = volumes;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBComment() {
        return BComment;
    }

    public void setBComment(String BComment) {
        this.BComment = BComment;
    }

    public String getPubHouse() {
        return pubHouse;
    }

    public void setPubHouse(String pubHouse) {
        this.pubHouse = pubHouse;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookNo='" + bookNo + '\'' +
                ", bookName='" + bookName + '\'' +
                ", volumes=" + volumes +
                ", author='" + author + '\'' +
                ", version=" + version + '\'' +
                ", price=" + price +
                ", BComment='" + BComment + '\'' +
                ", pubHouse='" + pubHouse + '\'' +
                ", pubDate=" + pubDate +
                '}';
    }
}
