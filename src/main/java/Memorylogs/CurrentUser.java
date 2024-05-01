package Memorylogs;

import com.example.addressbook.tammy2.AuthenLog.UserAccount;
import com.example.addressbook.tammy2.AuthenLog.UserAccountDAO;

public class CurrentUser {
    // Method to get the currently logged-in user based on username
    public static UserAccount getCurrentUser(String username) {
        return UserAccountDAO.getByUsername(username);
    }
}
