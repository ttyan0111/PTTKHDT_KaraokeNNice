package com.nnice.karaoke.service.impl;

import com.nnice.karaoke.entity.DonDatTiec;
import com.nnice.karaoke.repository.DonDatTiecRepository;
import com.nnice.karaoke.service.QuanLyDatTiecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class QuanLyDatTiecServiceImpl implements QuanLyDatTiecService {
    
    @Autowired
    private DonDatTiecRepository donDatTiecRepository;
    
    private static final double TY_LE_COC = 0.20; // 20%
    
    @Override
    public DonDatTiec taoDonDatTiec(DonDatTiec donDatTiec) {
        return donDatTiecRepository.save(donDatTiec);
    }
    
    @Override
    public Long tinhChiPhiTiec(Integer maTiec) {
        return 0L; // TODO: Implement
    }
    
    @Override
    public Long tinhTienDatCoc(Long tongChiPhi) {
        return (long) (tongChiPhi * TY_LE_COC);
    }
    
    @Override
    public void xuLyThanhToanCoc(Integer maTiec, Long soTien, String hinhThuc) {
        // TODO: Implement
    }
    
    @Override
    public Optional<DonDatTiec> xemChiTiet(Integer maTiec) {
        return donDatTiecRepository.findById(maTiec);
    }
    
    @Override
    public DonDatTiec capNhatDatTiec(DonDatTiec donDatTiec) {
        return donDatTiecRepository.save(donDatTiec);
    }
    
    @Override
    public void huyDatTiec(Integer maTiec, String lyDo) {
        Optional<DonDatTiec> don = donDatTiecRepository.findById(maTiec);
        if (don.isPresent()) {
            don.get().setTrangThai("Hủy");
            donDatTiecRepository.save(don.get());
        }
    }
    
    @Override
    public List<DonDatTiec> danhSachDatTiec(String trangThai) {
        return donDatTiecRepository.findAll().stream()
                .filter(d -> d.getTrangThai().equals(trangThai))
                .toList();
    }
    
    @Override
    public void khoapHongTiec(Integer maTiec) {
        // TODO: Implement
    }
    
    @Override
    public void guiXacNhan(Integer maTiec) {
        // TODO: Implement SMS/Email service
    }
}
