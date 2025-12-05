package com.nnice.karaoke.service;

import com.nnice.karaoke.entity.PhieuNhap;
import java.util.List;
import java.util.Optional;

public interface QuanLyNhapKhoService {
    // Tạo phiếu nhập mới
    PhieuNhap taoPhieuNhap(PhieuNhap phieuNhap);
    
    // Xem chi tiết phiếu nhập
    Optional<PhieuNhap> xemChiTiet(Integer maPhieu);
    
    // Cập nhật phiếu nhập
    PhieuNhap capNhatPhieuNhap(PhieuNhap phieuNhap);
    
    // Tính tổng giá trị phiếu nhập
    Long tinhTongGiaTriPhieu(Integer maPhieu);
    
    // Cập nhật tồn kho (cộng số lượng)
    void capNhatTonKho(Integer maMatHang, int soLuong);
    
    // Danh sách phiếu nhập
    List<PhieuNhap> danhSachPhieuNhap();
    
    // Danh sách phiếu nhập theo nhà cung cấp
    List<PhieuNhap> danhSachTheoNhaCungCap(Integer maNhaCungCap);
}
