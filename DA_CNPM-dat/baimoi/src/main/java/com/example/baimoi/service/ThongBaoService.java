package com.example.baimoi.service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.baimoi.model.ThongBao;
import com.example.baimoi.repository.ThongBaoReponsitory;

@Service
public class ThongBaoService {
    
    @Autowired
    private ThongBaoReponsitory thongBaoReponsitory;

    public List<ThongBao> getThongBaosByUserId(Long mand) {
        return thongBaoReponsitory.findByMand(mand);
    }

    public ThongBao createThongBao(Long userId, String tieude, String noidung) {
        ThongBao thongBao = new ThongBao();
        thongBao.setMand(userId);
        thongBao.setTieude(tieude);
        thongBao.setNoidung(noidung);
        thongBao.setNgaygui(new Date(System.currentTimeMillis()));
        thongBao.setThoigian(new Time(System.currentTimeMillis()));
        return thongBaoReponsitory.save(thongBao);
    }

    public void deleteByNguoiDungMand(Long mand) {
        thongBaoReponsitory.deleteByNguoiDungMand(mand);
    }
    public void deleteThongBao(Long id) {
        thongBaoReponsitory.deleteById(id);
    }
}
