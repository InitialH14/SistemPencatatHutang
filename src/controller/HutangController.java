package controller;

import DAO.HutangDAO;
import DAO.UserDAO;
import Session.SessionManager;
import iDAO.IHutangDAO;
import model.Hutang;
import model.TabelModelHutang;
import view.HomePage;
import view.TambahHutang;
import javax.swing.JOptionPane;
import java.util.List;
import view.Login;

public class HutangController {
    HomePage homePage;
    IHutangDAO idaoHutang;
    List<Hutang> listHutang;
    UserDAO daoUser;
    Login frmUser;

    public HutangController(HomePage homePage) {
        this.homePage = homePage;
        idaoHutang = (IHutangDAO) new HutangDAO();
    }

    public void isiTable() {
        listHutang = idaoHutang.getHutangsByKreditur();
        TabelModelHutang tableModel = new TabelModelHutang(listHutang);
        homePage.getTabelData().setModel(tableModel);
    }
}