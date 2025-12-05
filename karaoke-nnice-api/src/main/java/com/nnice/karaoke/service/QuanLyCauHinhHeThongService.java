package com.nnice.karaoke.service;

import com.nnice.karaoke.entity.CauHinhGia;
import java.util.List;
import java.util.Optional;

public interface QuanLyCauHinhHeThongService {
    // Cấu hình giá phòng (ngày/đêm)
    CauHinhGia cauHinhGiaPhong(Long giaNgay, Long giaDem);
    
    // Cấu hình dịch vụ
    void cauHinhDichVu(String tenDichVu, Long giaDichVu);
    
    // Cấu hình chấm công
    void cauHinhChamCong(String cauHinh, Object giaTriCauHinh);
    
    // Cấu hình thành viên
    void cauHinhThanhVien(String cauHinh, Object giaTriCauHinh);
    
    // Cấu hình thanh toán
    void cauHinhThanhToan(String hinhThucThanhToan, boolean active);
    
    // Xem cấu hình hiện tại
    Optional<CauHinhGia> xemCauHinhHienTai(String loaiCauHinh);
    
    // Cập nhật cấu hình
    CauHinhGia capNhatCauHinh(CauHinhGia cauHinhGia);
    
    // Danh sách cấu hình
    List<CauHinhGia> danhSachCauHinh();
}
