/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Victus 16
 */
public class Hutang {
    private String kode_hutang;
    private Date tggl_mulai_hutang;
    private Date tenggat_hutang;
    private double jumlah_hutang;
    private String keterangan_hutang;
    private String id_kreditur;
    private String id_debitur;
    private String namaDebitur;    

    /**
     * @return the kode_hutang
     */
    public String getKode_hutang() {
        return kode_hutang;
    }

    /**
     * @param kode_hutang the kode_hutang to set
     */
    public void setKode_hutang(String kode_hutang) {
        this.kode_hutang = kode_hutang;
    }

    /**
     * @return the tggl_mulai_hutang
     */
    public Date getTggl_mulai_hutang() {
        return tggl_mulai_hutang;
    }

    /**
     * @param tggl_mulai_hutang the tggl_mulai_hutang to set
     */
    public void setTggl_mulai_hutang(Date tggl_mulai_hutang) {
        this.tggl_mulai_hutang = tggl_mulai_hutang;
    }

    /**
     * @return the tenggat_hutang
     */
    public Date getTenggat_hutang() {
        return tenggat_hutang;
    }

    /**
     * @param tenggat_hutang the tenggat_hutang to set
     */
    public void setTenggat_hutang(Date tenggat_hutang) {
        this.tenggat_hutang = tenggat_hutang;
    }

    /**
     * @return the jumlah_hutang
     */
    public double getJumlah_hutang() {
        return jumlah_hutang;
    }

    /**
     * @param jumlah_hutang the jumlah_hutang to set
     */
    public void setJumlah_hutang(double jumlah_hutang) {
        this.jumlah_hutang = jumlah_hutang;
    }

    /**
     * @return the keterangan_hutang
     */
    public String getKeterangan_hutang() {
        return keterangan_hutang;
    }

    /**
     * @param keterangan_hutang the keterangan_hutang to set
     */
    public void setKeterangan_hutang(String keterangan_hutang) {
        this.keterangan_hutang = keterangan_hutang;
    }

    /**
     * @return the id_kreditur
     */
    public String getId_kreditur() {
        return id_kreditur;
    }

    /**
     * @param id_kreditur the id_kreditur to set
     */
    public void setId_kreditur(String id_kreditur) {
        this.id_kreditur = id_kreditur;
    }

    /**
     * @return the id_debitur
     */
    public String getId_debitur() {
        return id_debitur;
    }

    /**
     * @param id_debitur the id_debitur to set
     */
    public void setId_debitur(String id_debitur) {
        this.id_debitur = id_debitur;
    }
    
    public String getNamaDebitur() {
        return namaDebitur;
    }

    public void setNamaDebitur(String namaDebitur) {
        this.namaDebitur = namaDebitur;
    }
}
