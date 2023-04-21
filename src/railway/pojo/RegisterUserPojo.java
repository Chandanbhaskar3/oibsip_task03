/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package railway.pojo;

/**
 *
 * @author ck835
 */
public class RegisterUserPojo {
    
    
    public RegisterUserPojo(){
    
    }
    public RegisterUserPojo(String userName, String mobileNo, String loginId, String password) {
        this.userName = userName;
        this.mobileNo = mobileNo;
        this.loginId = loginId;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    private String userName;
    private String mobileNo;
    private String loginId;
    private String password;
    
    
}
