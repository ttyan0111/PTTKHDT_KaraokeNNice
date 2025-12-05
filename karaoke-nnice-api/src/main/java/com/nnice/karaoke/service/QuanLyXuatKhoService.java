package com.nnice.karaoke.service;

import com.nnice.karaoke.entity.PhieuXuat;
import java.util.List;
import java.util.Optional;

public interface QuanLyXuatKhoService {
    // Tạo phiếu xuất mới
    PhieuXuat taoPhieuXuat(PhieuXuat phieuXuat);
    
    // Xem chi tiết phiếu xuất
    Optional<PhieuXuat> xemChiTiet(Integer maPhieu);
    
    // Cập nhật phiếu xuất
    PhieuXuat capNhatPhieuXuat(PhieuXuat phieuXuat);
    
    // Kiểm tra tồn kho trước khi xuất
    boolean kiemTraTonKho(Integer maMatHang, int soLuong);
    
    // Trừ số lượng tồn kho
    void truTonKho(Integer maMatHang, int soLuong);
    
    // Tự động xuất kho khi order hoàn thành
    void xuatKhoTheoOrder(Integer maOrder);
    
    // Danh sách phiếu xuất
    List<PhieuXuat> danhSachPhieuXuat();
    
    // Danh sách phiếu xuất theo bộ phận
    List<PhieuXuat> danhSachTheoBoPhan(String boPhan);
}
