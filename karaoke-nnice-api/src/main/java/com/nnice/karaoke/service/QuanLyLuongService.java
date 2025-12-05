package com.nnice.karaoke.service;

import com.nnice.karaoke.entity.BangLuong;
import java.util.List;
import java.util.Optional;

public interface QuanLyLuongService {
    // Tự động tính lương cho nhân viên
    BangLuong tinhLuongNhanVien(Integer maNhanVien, int thang, int nam);
    
    // Tính lương cơ bản
    Long tinhLuongCoBan(Integer maNhanVien, int soCa);
    
    // Tính thưởng doanh thu
    Long tinhThuongDoanhThu(Integer maNhanVien, Long doanhThuCoso);
    
    // Tính phụ cấp (ca đêm, chuyên cần)
    Long tinhPhuCap(Integer maNhanVien, int thang, int nam);
    
    // Tính các khoản trừ (BHXH, BHYT, phạt)
    Long tinhKhoanTru(Integer maNhanVien, int thang, int nam);
    
    // Tính tổng lương
    Long tinhTongLuong(Integer maNhanVien, int thang, int nam);
    
    // Xem chi tiết bảng lương
    Optional<BangLuong> xemChiTiet(Integer maNhanVien, int thang, int nam);
    
    // Cập nhật/điều chỉnh lương
    BangLuong capNhatLuong(BangLuong bangLuong);
    
    // Phê duyệt bảng lương
    void pheDuyetBangLuong(Integer maNhanVien, int thang, int nam);
    
    // In phiếu lương
    void inPhieuLuong(Integer maNhanVien, int thang, int nam);
    
    // Danh sách lương tháng
    List<BangLuong> danhSachLuongThang(int thang, int nam);
}
