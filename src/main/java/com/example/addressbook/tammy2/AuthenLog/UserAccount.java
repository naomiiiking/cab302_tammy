package com.example.addressbook.tammy2.AuthenLog;

public class UserAccount {
    private int ID;
    private int id;
    private String username;
    private String email;
    private String password;
    private int credits;

    /**
     * User account contructor
     * @param id user's ID
     * @param username username
     * @param email user's email
     * @param password user's hashed password
     */
    public UserAccount(int id, String username, String email, String password, int credits){
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.credits = credits;
    }

    /**
     * User account contructor without ID
     * @param username username
     * @param email user's email
     * @param password user's hashed password
     */
    public UserAccount( String username, String email, String password){
        // id is auto-incremented - have created a construct with and without it
        this.username = username;
        this.email = email;
        this.password = password;
        credits = 0;
    }

    /**
     * Get user ID
     * @return user's ID
     */
    public int getID() {
        return ID;
    }

    public void setID(int id) {
        this.ID = id;
    }
    public void setId(int id) {this.id = id;}
    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCredits(){return credits;}

    public void setCredits(int Credits){this.credits = Credits;}

    public void addCredits(int Credits){this.credits += Credits;}

    public void minusCredits(int Credits){this.credits -= Credits;}

    @Override
    public String toString() {
        return "UserAccount{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password=" + password +
                '}';
    }

}
