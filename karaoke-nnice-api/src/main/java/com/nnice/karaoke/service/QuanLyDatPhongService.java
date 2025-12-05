package com.nnice.karaoke.service;

import com.nnice.karaoke.entity.PhieuDatPhong;
import com.nnice.karaoke.entity.Phong;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface QuanLyDatPhongService {
    // Tạo đơn đặt phòng mới
    PhieuDatPhong taoPhieuDatPhong(PhieuDatPhong phieuDatPhong);
    
    // Tra cứu phòng trống
    List<Phong> traCuuPhongTrong(int soNguoi, LocalDateTime tuNgay, LocalDateTime denNgay);
    
    // Tính chi phí dự kiến
    Long tinhChiPhiDuKien(int soGio, LocalDateTime thoiGianBatDau);
    
    // Xem chi tiết đặt phòng
    Optional<PhieuDatPhong> xemChiTiet(Integer maPhieu);
    
    // Cập nhật đặt phòng
    PhieuDatPhong capNhatDatPhong(PhieuDatPhong phieuDatPhong);
    
    // Hủy đặt phòng
    void huydatPhong(Integer maPhieu, String lyDo);
    
    // Danh sách đặt phòng theo trạng thái
    List<PhieuDatPhong> danhSachTheoDatPhong(String trangThai);
    
    // Gửi xác nhận SMS/Email (để tích hợp sau)
    void guiXacNhan(Integer maPhieu);
}
