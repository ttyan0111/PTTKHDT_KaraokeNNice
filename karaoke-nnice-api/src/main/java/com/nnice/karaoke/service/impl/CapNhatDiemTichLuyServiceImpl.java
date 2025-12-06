package com.nnice.karaoke.service.impl;

import com.nnice.karaoke.dto.response.ThanhVienResponse;
import com.nnice.karaoke.entity.TheThanhVien;
import com.nnice.karaoke.repository.TheThanhVienRepository;
import com.nnice.karaoke.service.CapNhatDiemTichLuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CapNhatDiemTichLuyServiceImpl implements CapNhatDiemTichLuyService {
    
    @Autowired
    private TheThanhVienRepository theThanhVienRepository;
    
    private static final long GIA_TRI_MIEN_PHI = 10000L; // 10,000đ = 1 điểm
    
    @Override
    public boolean tichDiem(Integer maThanhVien, Long tongTien) {
        int diemCong = (int) (tongTien / GIA_TRI_MIEN_PHI);
        Optional<TheThanhVien> thanhVien = theThanhVienRepository.findById(maThanhVien);
        if (thanhVien.isPresent()) {
            TheThanhVien tv = thanhVien.get();
            int diemHienTai = tv.getDiemTichLuy() != null ? tv.getDiemTichLuy() : 0;
            tv.setDiemTichLuy(diemHienTai + diemCong);
            theThanhVienRepository.save(tv);
            return true;
        }
        return false;
    }
    
    @Override
    public String kiemTraDieuKienNangHang(Integer diemHienTai) {
        if (diemHienTai >= 1000) return "Kim cương";
        if (diemHienTai >= 500) return "Vàng";
        if (diemHienTai >= 100) return "Bạc";
        return "Thành viên";
    }
    
    @Override
    public void nangHangTuDong(Integer maThanhVien) {
        Optional<TheThanhVien> thanhVien = theThanhVienRepository.findById(maThanhVien);
        if (thanhVien.isPresent()) {
            TheThanhVien tv = thanhVien.get();
            String hangMoi = kiemTraDieuKienNangHang(tv.getDiemTichLuy() != null ? tv.getDiemTichLuy() : 0);
            tv.setHangThe(hangMoi);
            theThanhVienRepository.save(tv);
        }
    }
    
    @Override
    public void ghiLichSuTichDiem(Integer maThanhVien, Long soTienThanhToan, int diemCong) {
        // TODO: Implement history tracking
    }
    
    @Override
    public void guiThongBaoNangHang(Integer maThanhVien, String hangMoi) {
        // TODO: Implement notification
    }
    
    @Override
    public ThanhVienResponse xemThongTinThanhVien(Integer maThanhVien) {
        Optional<TheThanhVien> thanhVien = theThanhVienRepository.findById(maThanhVien);
        if (thanhVien.isPresent()) {
            TheThanhVien tv = thanhVien.get();
            return ThanhVienResponse.builder()
                    .maThe(tv.getMaThe())
                    .maKH(tv.getMaKH())
                    .hangThe(tv.getHangThe())
                    .diemTichLuy(tv.getDiemTichLuy() != null ? tv.getDiemTichLuy() : 0)
                    .ngayCap(tv.getNgayCap())
                    .build();
        }
        return null; // hoặc throw exception nếu không tìm thấy
    }
    
    @Override
    public void xemLichSuTichDiem(Integer maThanhVien) {
        // TODO: Implement
    }
}
