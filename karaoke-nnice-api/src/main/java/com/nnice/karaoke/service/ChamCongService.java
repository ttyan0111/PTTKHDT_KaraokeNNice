package com.nnice.karaoke.service;

import com.nnice.karaoke.entity.BangChamCong;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ChamCongService {
    // Check-in: ghi nhận thời gian vào
    BangChamCong checkIn(Integer maNhanVien, LocalDate ngayLamViec);
    
    // Check-out: ghi nhận thời gian ra
    BangChamCong checkOut(Integer maNhanVien, LocalDate ngayLamViec);
    
    // Ghi nhận GPS vị trí
    void ghiNhanGPS(Integer maNhanVien, String viTri);
    
    // So sánh với ca làm việc dự kiến
    String soSanhCaLamViec(Integer maNhanVien, LocalDate ngayLamViec);
    
    // Đánh dấu trạng thái
    void danhDauTrangThai(Integer maNhanVien, LocalDate ngayLamViec, String trangThai);
    
    // Xem bảng chấm công ngày
    Optional<BangChamCong> xemChiTiet(Integer maNhanVien, LocalDate ngayLamViec);
    
    // Danh sách chấm công theo tháng
    List<BangChamCong> danhSachThangLamViec(Integer maNhanVien, int thang, int nam);
    
    // Danh sách chấm công của toàn bộ nhân viên
    List<BangChamCong> danhSachToanBoNhanVien(LocalDate ngayLamViec);
}
