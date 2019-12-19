package beans;

import java.util.Date;

/**
 * @description: 用户借阅记录bean
 * @author: YG
 * @date: 2019/12/19 17:37
 */
public class UserBR {
    private int bookNo=1;
    private String bookName;
    private String author;
    private String version;
    private Date deadline;
    private int brDays;
    private String bCmt;
    private double price;

    public UserBR() {
    }

    public int getBookNo() {
        return bookNo;
    }

    public void setBookNo(int bookNo) {
        this.bookNo = bookNo;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
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

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public int getBrDays() {
        return brDays;
    }

    public void setBrDays(int brDays) {
        this.brDays = brDays;
    }

    public String getbCmt() {
        return bCmt;
    }

    public void setbCmt(String bCmt) {
        this.bCmt = bCmt;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "UserBR{" +
                "bookNo=" + bookNo +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", version='" + version + '\'' +
                ", deadline=" + deadline +
                ", brDays=" + brDays +
                ", bCmt='" + bCmt + '\'' +
                ", price=" + price +
                '}';
    }
}
