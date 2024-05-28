/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 *
 * @author
 */
public class TabelModelHutang extends AbstractTableModel {
    List<Hutang> lstHutang;

    public TabelModelHutang(List<Hutang> lstHutang) {
        this.lstHutang = lstHutang;
    }

    @Override
    public int getRowCount() {
        return this.lstHutang.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Kode Hutang";
            case 1:
                return "Nama Debitur";
            case 2:
                return "Tanggal Mulai Hutang";
            case 3:
                return "Tenggat Hutang";
            case 4:
                return "Jumlah Hutang";
            case 5:
                return "Keterangan Hutang";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return lstHutang.get(rowIndex).getKode_hutang();
            case 1:
                return lstHutang.get(rowIndex).getId_debitur(); // Anda bisa mengganti ini untuk mendapatkan nama debitur jika diperlukan
            case 2:
                return lstHutang.get(rowIndex).getTggl_mulai_hutang();
            case 3:
                return lstHutang.get(rowIndex).getTenggat_hutang();
            case 4:
                return lstHutang.get(rowIndex).getJumlah_hutang();
            case 5:
                return lstHutang.get(rowIndex).getKeterangan_hutang();
            default:
                return null;
        }
    }
}
