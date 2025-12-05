package com.nnice.karaoke.service.impl;

import com.nnice.karaoke.entity.PhieuKiemKe;
import com.nnice.karaoke.repository.PhieuKiemKeRepository;
import com.nnice.karaoke.service.KiemKeĐinhKyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class KiemKeĐinhKyServiceImpl implements KiemKeĐinhKyService {
    
    @Autowired
    private PhieuKiemKeRepository phieuKiemKeRepository;
    
    @Override
    public PhieuKiemKe taoPhieuKiemKe(PhieuKiemKe phieuKiemKe) {
        return phieuKiemKeRepository.save(phieuKiemKe);
    }
    
    @Override
    public Optional<PhieuKiemKe> xemChiTiet(Integer maPhieu) {
        return phieuKiemKeRepository.findById(maPhieu);
    }
    
    @Override
    public PhieuKiemKe capNhatPhieuKiemKe(PhieuKiemKe phieuKiemKe) {
        return phieuKiemKeRepository.save(phieuKiemKe);
    }
    
    @Override
    public int tinhChenhLech(Integer maMatHang, int soLuongThucTe) {
        return 0; // TODO: Implement
    }
    
    @Override
    public void canhBaoChenhLechLon(Integer maMatHang, int chenhLech) {
        // TODO: Implement
    }
    
    @Override
    public void capNhatTonKhoTheoThucTe(Integer maMatHang, int soLuongThucTe) {
        // TODO: Implement
    }
    
    @Override
    public void canhBaoHangSapHet() {
        // TODO: Implement
    }
    
    @Override
    public List<PhieuKiemKe> danhSachPhieuKiemKe() {
        return phieuKiemKeRepository.findAll();
    }
}
