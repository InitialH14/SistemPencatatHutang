package iDAO;
import model.Hutang;
import view.Login;
import java.util.List;
import Session.SessionManager;

public interface IHutangDAO {
    public List<Hutang> getHutangsByKreditur();
    public boolean insert(Hutang htg);
    public void update(Hutang htg);
    public void delete(int kodeHutang);
    public String login(SessionManager session);
}
