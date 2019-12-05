package beans;

import java.util.Date;

public class BorrowRecord {
    private int recordId=1;
    private String bookName = null;
    private String stuNo=null;
    private String username = null;
    private String bookNo=null;
    private int borrowDays=1;
    private Date deadline=null;
    private String BWComment=null;

    public BorrowRecord() {
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public String getStuNo() {
        return stuNo;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getBookNo() {
        return bookNo;
    }

    public void setBookNo(String bookNo) {
        this.bookNo = bookNo;
    }

    public int getBorrowDays() {
        return borrowDays;
    }

    public void setBorrowDays(int borrowDays) {
        this.borrowDays = borrowDays;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getBWComment() {
        return BWComment;
    }

    public void setBWComment(String BWComment) {
        this.BWComment = BWComment;
    }

    @Override
    public String toString() {
        return "BorrowRecord{" +
                "recordId=" + recordId +
                ", bookName='" + bookName + '\'' +
                ", stuNo='" + stuNo + '\'' +
                ", username='" + username + '\'' +
                ", bookNo='" + bookNo + '\'' +
                ", borrowDays=" + borrowDays +
                ", deadline=" + deadline +
                ", BWComment='" + BWComment + '\'' +
                '}';
    }
}
