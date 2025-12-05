package com.nnice.karaoke.service.impl;

import com.nnice.karaoke.entity.HoaDon;
import com.nnice.karaoke.repository.HoaDonRepository;
import com.nnice.karaoke.service.ThanhToanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ThanhToanServiceImpl implements ThanhToanService {
    
    @Autowired
    private HoaDonRepository hoaDonRepository;
    
    private static final double VAT = 0.10; // 10%
    
    @Override
    public HoaDon taoHoaDon(Integer maPhieuSuDung) {
        HoaDon hoaDon = new HoaDon();
        return hoaDonRepository.save(hoaDon);
    }
    
    @Override
    public Long tinhTienPhong(Integer maPhieu) {
        return 0L; // TODO: Implement
    }
    
    @Override
    public Long tinhTienAnUong(Integer maPhieu) {
        return 0L; // TODO: Implement
    }
    
    @Override
    public Long tinhTienTiec(Integer maTiec) {
        return 0L; // TODO: Implement
    }
    
    @Override
    public Long tinhVAT(Long tongTien) {
        return (long) (tongTien * VAT);
    }
    
    @Override
    public Long truTienCoc(Integer maPhieu, Long tongTien) {
        return tongTien; // TODO: Implement coc deduction
    }
    
    @Override
    public Long apDungUuDai(Long tongTien, Integer maUuDai) {
        return tongTien; // TODO: Implement discount
    }
    
    @Override
    public void xuLyThanhToan(Integer maHoaDon, Long soTien, String hinhThuc) {
        // TODO: Implement
    }
    
    @Override
    public Optional<HoaDon> xemChiTiet(Integer maHoaDon) {
        return hoaDonRepository.findById(maHoaDon);
    }
    
    @Override
    public void tichDiem(Integer maKhach, Long tongTien) {
        // TODO: Implement
    }
}
