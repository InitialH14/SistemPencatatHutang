/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Session;
import model.User;
/**
 *
 * @author hp
 */
public class SessionManager {
    private static User user = null;
    
    public void saveLogin(User user){
        user = user;
    }
 
    public User currentLogin(){
        return user;
    }
    
    
}
