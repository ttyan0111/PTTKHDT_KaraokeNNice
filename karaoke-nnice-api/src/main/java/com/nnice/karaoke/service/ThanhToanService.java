package com.nnice.karaoke.service;

import com.nnice.karaoke.dto.request.ThanhToanRequest;
import com.nnice.karaoke.dto.response.ThanhToanResponse;

public interface ThanhToanService {
    // Tạo hóa đơn từ phiếu sử dụng
    ThanhToanResponse taoHoaDon(Integer maPhieuSuDung);
    
    // Tính tổng tiền phòng
    Long tinhTienPhong(Integer maPhieu);
    
    // Tính tiền dịch vụ ăn uống
    Long tinhTienAnUong(Integer maPhieu);
    
    // Tính tiền tiệc
    Long tinhTienTiec(Integer maTiec);
    
    // Tính VAT
    Long tinhVAT(Long tongTien);
    
    // Trừ tiền cọc
    Long truTienCoc(Integer maPhieu, Long tongTien);
    
    // Áp dụng ưu đãi
    Long apDungUuDai(Long tongTien, Integer maUuDai);
    
    // Xử lý thanh toán
    void xuLyThanhToan(Integer maHoaDon, Long soTien, String hinhThuc);
    
    // Xem chi tiết hóa đơn
    ThanhToanResponse xemChiTiet(Integer maHoaDon);
    
    // Tích điểm cho thành viên
    void tichDiem(Integer maKhach, Long tongTien);
}
