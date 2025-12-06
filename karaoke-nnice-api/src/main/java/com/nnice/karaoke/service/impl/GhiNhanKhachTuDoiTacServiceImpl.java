package com.nnice.karaoke.service.impl;

import com.nnice.karaoke.entity.PhieuDatPhong;
import com.nnice.karaoke.repository.PhieuDatPhongRepository;
import com.nnice.karaoke.service.GhiNhanKhachTuDoiTacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class GhiNhanKhachTuDoiTacServiceImpl implements GhiNhanKhachTuDoiTacService {
    
    @Autowired
    private PhieuDatPhongRepository phieuDatPhongRepository;
    
    @Override
    public void chonDoiTac(Integer maDoiTac) {
        // TODO: Implement
    }
    
    @Override
    public Optional<PhieuDatPhong> nhapThongTinKhach(Integer maDoiTac, String maBooking) {
        return phieuDatPhongRepository.findAll().stream().findFirst();
    }
    
    @Override
    public boolean xacThucVoiDoiTac(Integer maDoiTac, String maBooking) {
        return true; // TODO: Implement API call
    }
    
    @Override
    public Long tinhHoaHong(Long tongTien, Integer maDoiTac) {
        return 0L; // TODO: Implement
    }
    
    @Override
    public PhieuDatPhong taoDonDatPhongTuDoiTac(Integer maDoiTac, PhieuDatPhong phieuDatPhong) {
        phieuDatPhong.setTrangThai("Tu doi tac");
        return phieuDatPhongRepository.save(phieuDatPhong);
    }
    
    @Override
    public void capNhatCongNoDoiTac(Integer maDoiTac, Long soTien) {
        // TODO: Implement
    }
}
