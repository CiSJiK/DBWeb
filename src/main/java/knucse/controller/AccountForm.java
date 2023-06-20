package knucse.controller;

public class AccountForm {
    private String id,pw,check;
    public String getId(){
        return id;
    }
    public String getPw(){
        return pw;
    }
    public String getCheck(){
        return check;
    }
    public void setId(String id){
        this.id = id;
    }
    public void setPw(String pw){
        this.pw = pw;
    }
    public void setCheck(String check)
    {
        this.check = check;
    }
}
