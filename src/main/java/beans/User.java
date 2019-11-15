package beans;

public class User {
    private String stuNo;
    private String username;
    private String password;

    public User() {
    }

    public User(String stuNo, String password) {
        this.stuNo = stuNo;
        this.password = password;
    }

    public User(String stuNo, String username, String password) {
        this.stuNo = stuNo;
        this.username = username;
        this.password = password;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "stuNo='" + stuNo + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
