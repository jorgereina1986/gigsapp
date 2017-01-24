package com.jorgereina.gigs.model;

public class User {

    private String userName;
    private String email;
    private String password;
    private String occupation;
    private String profilePic;
    private String userId;

    public User() {
    }

    public User(String userName, String profilePic, String userId) {
        this.userName = userName;
        this.profilePic = profilePic;
        this.userId = userId;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
