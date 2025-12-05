package com.nnice.karaoke.service;

import com.nnice.karaoke.entity.NhanVien;
import java.util.List;
import java.util.Optional;

public interface QuanLyTaiKhoanNhanVienService {
    // Tạo tài khoản nhân viên mới
    NhanVien taoTaiKhoan(NhanVien nhanVien, String username, String password);
    
    // Xem thông tin tài khoản
    Optional<NhanVien> xemThongTin(Integer maNhanVien);
    
    // Cập nhật thông tin tài khoản
    NhanVien capNhatThongTin(NhanVien nhanVien);
    
    // Xóa/vô hiệu hóa tài khoản
    void voHieuHoaTaiKhoan(Integer maNhanVien);
    
    // Thiết lập quyền truy cập theo vai trò
    void thietLapQuyenTruCap(Integer maNhanVien, String vaiTro);
    
    // Đặt lại mật khẩu
    void datLaiMatKhau(Integer maNhanVien, String matKhauMacDinh);
    
    // Danh sách tài khoản
    List<NhanVien> danhSachTaiKhoan();
    
    // Danh sách theo vai trò
    List<NhanVien> danhSachTheoVaiTro(String vaiTro);
}
