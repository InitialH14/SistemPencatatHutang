package controller;

import DAO.UserDAO;
import DAO.HutangDAO;
import iDAO.IHutangDAO;
import iDAO.IUserDAO;
import model.User;
import view.Login;
import view.SignUp;
import javax.swing.JOptionPane;
import view.HomePage;
import Session.SessionManager;
import java.util.List;
import model.Hutang;
import model.TabelModelHutang;

public class  UserController {
    Login frmUser;
    SignUp frmSup;
    UserDAO daoUser;
    IUserDAO idaoUser;
    IHutangDAO idaohutang;
    SessionManager session;
    List<Hutang> listHutang;
    HomePage homePage;
    
    public UserController(Login frmUser, SignUp frmSup) {
        this.frmUser = frmUser;
        this.frmSup = frmSup;
        this.daoUser = new UserDAO();
        idaoUser = new UserDAO();
        idaohutang = (IHutangDAO) new HutangDAO();
        session = new SessionManager();
    }

    public void login() {
        String nama = frmUser.getTxtNama().getText();
        String password = new String(frmUser.getTxtPassword().getPassword());
        String res = idaohutang.login(session);
        if (res != null) {
            JOptionPane.showMessageDialog(null, "Login Success");
            navigateToHome(nama);
        } else {
            JOptionPane.showMessageDialog(null, "Login Failed");
        }
    }

    public void signup() {
        User user = new User();
        user.setNik(frmSup.getTxtNik().getText());
        user.setNama(frmSup.getTxtNama().getText());
        user.setPassword(new String(frmSup.getTxtPassword().getText()));

        boolean res = idaoUser.signup(user);
        if (res)
            JOptionPane.showMessageDialog(null, "Signup Success");
        else
            JOptionPane.showMessageDialog(null, "Signup Failed");
    }

    public void reset() {
        frmSup.getTxtNik().setText("");
        frmSup.getTxtNama().setText("");
        frmSup.getTxtPassword().setText("");
    }

    private void navigateToHome(String nama) {
        HomePage hp = new HomePage();
        hp.setUser(nama);
        hp.setVisible(true);
        hp.pack();
        hp.setLocationRelativeTo(null);
        frmUser.setVisible(false);
    }
    
    public void toSignup(){
        SignUp sign = new SignUp();
        sign.setVisible(true);
        sign.pack();
        sign.setLocationRelativeTo(null);
        frmUser.dispose();
    }
    
    public void toLogin(){
        Login log = new Login();
        log.setVisible(true);
        log.pack();
        log.setLocationRelativeTo(null);
        frmSup.dispose();
    }
    
    public void isiTable(HomePage homepage) {
        this.homePage = homepage;
        listHutang = idaohutang.getHutangsByKreditur();
        TabelModelHutang tableModel = new TabelModelHutang(listHutang);
        homePage.getTabelData().setModel(tableModel);
    }
}
