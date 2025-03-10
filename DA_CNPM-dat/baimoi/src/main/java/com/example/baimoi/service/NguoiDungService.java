package com.example.baimoi.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.example.baimoi.model.NguoiDung;
import com.example.baimoi.repository.NguoidungRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class NguoiDungService {
    
    @Autowired
    private NguoidungRepository nguoidungRepository;

    public Optional<NguoiDung> getNguoiDungById(Long mnd) {
        return nguoidungRepository.findById(mnd);
    }

    public NguoiDung getNguoiDungBy(Long id) {
        Assert.notNull(id, "ID must not be null");
        return nguoidungRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    public List<NguoiDung> getAllNguoiDung() {
        return nguoidungRepository.findAll();
    }

    public NguoiDung findByIdND(Long idND) {
        return nguoidungRepository.findById(idND).orElse(null);
    }

    public void saveOrUpdate(NguoiDung nguoiDung) {
        nguoidungRepository.save(nguoiDung);
    }

    public void deleteNguoiDung(Long id) {
        nguoidungRepository.deleteById(id);
    }

    public void updateMapq(Long mand, int newMapq) {
        Optional<NguoiDung> optionalNguoidung = nguoidungRepository.findById(mand);
        if (optionalNguoidung.isPresent()) {
            NguoiDung nguoidung = optionalNguoidung.get();
            nguoidung.setMapq(newMapq);
            nguoidungRepository.save(nguoidung);
        } else {
            // Xử lý khi không tìm thấy người dùng
            throw new RuntimeException("Không tìm thấy người dùng với mã: " + mand);
        }
    }

    public Optional<NguoiDung> findBySdtAndPassword(String sdt, String password) {
        return nguoidungRepository.findBySdtAndPassword(sdt, password);
    }

    public List<NguoiDung> searchByHoten(String hoten) {
        return nguoidungRepository.findByHotenContainingIgnoreCase(hoten);
    }

    // Đổi mật khẩu
    public boolean changePassword(long mand, String oldPassword, String newPassword) {
        NguoiDung nguoiDung = nguoidungRepository.findById(mand).orElse(null);
        if (nguoiDung != null && nguoiDung.getPassword().equals(oldPassword)) {
            nguoiDung.setPassword(newPassword);
            nguoidungRepository.save(nguoiDung);
            return true;
        }
        return false;
    }

    //thống kê
    public Map<Integer, Integer> getUserStatisticsByMonth() {
        List<Object[]> results = nguoidungRepository.countUsersByMonth();
        Map<Integer, Integer> statistics = new HashMap<>();

        // Initialize statistics map with all months
        for (int i = 1; i <= 12; i++) {
            statistics.put(i, 0);
        }

        // Populate statistics map with query results
        for (Object[] result : results) {
            Integer month = (Integer) result[0];
            Long count = (Long) result[1];
            statistics.put(month, count.intValue());
        }

        return statistics;
    }
}
