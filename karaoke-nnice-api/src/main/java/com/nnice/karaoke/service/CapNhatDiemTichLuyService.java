package com.nnice.karaoke.service;

import com.nnice.karaoke.dto.response.ThanhVienResponse;
import java.util.Optional;

public interface CapNhatDiemTichLuyService {
    // Tự động tích điểm sau thanh toán (10,000đ = 1 điểm)
    boolean tichDiem(Integer maThanhVien, Long tongTien);
    
    // Kiểm tra điều kiện nâng hạng
    String kiemTraDieuKienNangHang(Integer diemHienTai);
    
    // Tự động nâng hạng
    void nangHangTuDong(Integer maThanhVien);
    
    // Ghi lịch sử tích điểm
    void ghiLichSuTichDiem(Integer maThanhVien, Long soTienThanhToan, int diemCong);
    
    // Gửi thông báo nâng hạng
    void guiThongBaoNangHang(Integer maThanhVien, String hangMoi);
    
    // Xem thông tin thành viên (điểm, hạng) - trả về DTO
    ThanhVienResponse xemThongTinThanhVien(Integer maThanhVien);
    
    // Xem lịch sử tích điểm
    void xemLichSuTichDiem(Integer maThanhVien);
}
