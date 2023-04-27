package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character

        if(!this.password.equals(oldPassword)){
           return;
        }

        int len = newPassword.length();
        boolean uppercase = false;
        boolean lowercase = false;
        boolean onedigit = false;
        boolean special = false;

        for(char ch : newPassword.toCharArray()){
           if(Character.isUpperCase(ch))
               uppercase = true;
           if(Character.isLowerCase(ch))
               lowercase = true;
           if(Character.isDigit(ch))
               onedigit = true;
           if(!Character.isLetterOrDigit(ch))
               special = true;

        }

        if(len < 8 || !uppercase || !lowercase || !onedigit || !special){
            return;
        }

        this.password = newPassword;
    }
}
