package com.example.addressbook.tammy2.AuthenLog;

public class UserAccount {
    private static int ID;
    private int id;
    private static String username;
    private static String email;
    private static String password;

    /**
     * User account contructor
     * @param id user's ID
     * @param username username
     * @param email user's email
     * @param password user's hashed password
     */
    public UserAccount(int id, String username, String email, String password){
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
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
    }

    /**
     * Get user ID
     * @return user's ID
     */
    public static int getID() {
        return ID;
    }

    public static void setID(int id) {
        UserAccount.ID = id;
    }

    public int getId() {
        return id;
    }

    public static String getUsername() {
        return username;
    }

    public static String getEmail() {
        return email;
    }

    public static String getPassword() {
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
