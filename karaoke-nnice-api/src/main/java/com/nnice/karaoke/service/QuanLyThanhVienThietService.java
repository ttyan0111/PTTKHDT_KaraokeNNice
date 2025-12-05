package com.nnice.karaoke.service;

import com.nnice.karaoke.entity.KhachHang;
import com.nnice.karaoke.entity.TheThanhVien;
import java.util.List;
import java.util.Optional;

public interface QuanLyThanhVienThietService {
    // Đăng ký thành viên mới
    TheThanhVien dangKyThanhVienMoi(KhachHang khachHang);
    
    // Tạo mã thành viên duy nhất
    String taoMaThanhVien();
    
    // Tra cứu thông tin thành viên
    Optional<TheThanhVien> traCuuThongTin(Integer maThanhVien);
    
    // Tra cứu theo số điện thoại
    Optional<TheThanhVien> traCuuTheoSDT(String sdt);
    
    // Cập nhật thông tin thành viên
    TheThanhVien capNhatThongTin(TheThanhVien theThanhVien);
    
    // Xem lịch sử (điểm, hạng, ghi chú)
    void xemLichSu(Integer maThanhVien);
    
    // In thẻ thành viên
    void inThe(Integer maThanhVien);
    
    // Gửi SMS mã thành viên
    void guiSMSMaThanhVien(String sdt, String maThanhVien);
    
    // Danh sách thành viên
    List<TheThanhVien> danhSach();
}
