package com.nnice.karaoke.service;

import com.nnice.karaoke.entity.DonDatTiec;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface QuanLyDatTiecService {
    // Tạo đơn đặt tiệc mới
    DonDatTiec taoDonDatTiec(DonDatTiec donDatTiec);
    
    // Tính tổng chi phí dự kiến
    Long tinhChiPhiTiec(Integer maTiec);
    
    // Tính tiền đặt cọc (20%)
    Long tinhTienDatCoc(Long tongChiPhi);
    
    // Xử lý thanh toán cọc
    void xuLyThanhToanCoc(Integer maTiec, Long soTien, String hinhThuc);
    
    // Xem chi tiết đặt tiệc
    Optional<DonDatTiec> xemChiTiet(Integer maTiec);
    
    // Cập nhật đặt tiệc
    DonDatTiec capNhatDatTiec(DonDatTiec donDatTiec);
    
    // Hủy đặt tiệc (xử lý hoàn cọc theo quy định)
    void huyDatTiec(Integer maTiec, String lyDo);
    
    // Danh sách đặt tiệc
    List<DonDatTiec> danhSachDatTiec(String trangThai);
    
    // Khóa phòng/sảnh tiệc
    void khoapHongTiec(Integer maTiec);
    
    // Gửi xác nhận
    void guiXacNhan(Integer maTiec);
}
