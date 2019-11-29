package beans;

public class Info {
    private String stuNo=null;
    private String grade=null;
    private String academy=null;
    private String majorClass=null;
    private int BWNum=0;
    private String userComment=null;
    public Info() {
    }

    public Info(String stuNo, String grade, String academy, String majorClass) {
        this.stuNo = stuNo;
        this.grade = grade;
        this.academy = academy;
        this.majorClass = majorClass;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getMajorClass() {
        return majorClass;
    }

    public void setMajorClass(String majorClass) {
        this.majorClass = majorClass;
    }

    public int getBWNum() {
        return BWNum;
    }

    public void setBWNum(int BWNum) {
        this.BWNum = BWNum;
    }

    public String getUserComment() {
        return userComment;
    }

    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }

    @Override
    public String toString() {
        return "Info{" +
                "stuNo='" + stuNo + '\'' +
                ", grade='" + grade + '\'' +
                ", academy='" + academy + '\'' +
                ", majorClass='" + majorClass + '\'' +
                ", BWNum=" + BWNum +
                ", userComment='" + userComment + '\'' +
                '}';
    }
}
