package iDAO;
import model.User;

public interface IUserDAO {
    public boolean login(String nama, String password);
    public String getNikByName(String nama);
    public boolean signup(User usr);
}