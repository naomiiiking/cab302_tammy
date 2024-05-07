package Memorylogs;

import com.example.addressbook.tammy2.AuthenLog.UserAccount;
import com.example.addressbook.tammy2.AuthenLog.UserAccountDAO;

public class CurrentUser {
    private UserAccountDAO userAccountDAO;

    public CurrentUser(){
        userAccountDAO = new UserAccountDAO();
    }
    // Method to get the currently logged-in user based on username
    public UserAccount getCurrentUser(String username) {
        return userAccountDAO.getByUsername(username);
    }
}
