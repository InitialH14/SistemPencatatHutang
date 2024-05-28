package controller;

import DAO.HutangDAO;
import model.Hutang;
import view.HomePage;
import Session.SessionManager;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class HomePageController {
    private HomePage homePage;
    private HutangDAO daoHutang;

    public HomePageController(HomePage homePage) {
        this.homePage = homePage;
        this.daoHutang = new HutangDAO();
    }

    public void loadHutangData(String nik) {
        List<Hutang> hutangList = daoHutang.getHutangsByKreditur();
        DefaultTableModel model = (DefaultTableModel) homePage.getTabelData().getModel();
        model.setRowCount(0); // Clear existing rows
        for (Hutang hutang : hutangList) {
            model.addRow(new Object[]{
                hutang.getKode_hutang(),
                hutang.getNamaDebitur(),
                hutang.getJumlah_hutang(),
                hutang.getTggl_mulai_hutang(),
                hutang.getTenggat_hutang(),
                hutang.getKeterangan_hutang()
            });
        }
    }
}
