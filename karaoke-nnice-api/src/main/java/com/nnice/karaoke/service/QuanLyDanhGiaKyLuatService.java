package com.nnice.karaoke.service;

import com.nnice.karaoke.entity.NhanVien;
import java.util.List;


public interface QuanLyDanhGiaKyLuatService {
    // Đánh giá định kỳ nhân viên
    void danhGiaDinhKy(Integer maNhanVien, String thaiDo, String chuyenMon, String kyLuat);
    
    // Khen thưởng nhân viên
    void khenThuong(Integer maNhanVien, String loaiThuong, Long soTien, String ghiChu);
    
    // Kỷ luật nhân viên
    void kyLuat(Integer maNhanVien, String loaiKyLuat, Long soTienPhat, String ghiChu);
    
    // Lưu vào hồ sơ nhân viên
    void luuVaoHoSo(Integer maNhanVien, String noNoi);
    
    // Xem lịch sử khen thưởng/kỷ luật
    List<Object> xemLichSuKhenThuongKyLuat(Integer maNhanVien);
    
    // Ảnh hưởng đến lương
    void capNhatANhHuongLuong(Integer maNhanVien);
    
    // Danh sách nhân viên vi phạm
    List<NhanVien> danhSachNhanVienViPham();
}
