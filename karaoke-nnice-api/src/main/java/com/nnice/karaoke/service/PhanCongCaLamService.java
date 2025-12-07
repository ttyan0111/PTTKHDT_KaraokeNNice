package com.nnice.karaoke.service;


import java.time.LocalDate;
import java.util.List;

public interface PhanCongCaLamService {
    // Phân công nhân viên vào ca
    void phanCongNhanVienVaoCa(Integer maNhanVien, Integer maCa, LocalDate ngayLamViec);
    
    // Kiểm tra không trùng ca
    boolean kiemTraKhongTrungCa(Integer maNhanVien, LocalDate ngayLamViec);
    
    // Kiểm tra nhân viên không nghỉ phép
    boolean kiemTraNhanVienKhongNghiPhep(Integer maNhanVien, LocalDate ngayLamViec);
    
    // Cảnh báo thiếu người
    void canhBaoThieuNguoi(LocalDate ngayLamViec, Integer maCa);
    
    // Xem danh sách phân công theo ngày
    List<Object> xemPhanCongTheoNgay(LocalDate ngayLamViec);
    
    // Xem danh sách phân công theo ca
    List<Object> xemPhanCongTheoCa(Integer maCa, LocalDate ngayLamViec);
    
    // Cập nhật phân công
    void capNhatPhanCong(Integer maNhanVien, Integer caCu, Integer caMoi);
    
    // Xóa phân công
    void xoaPhanCong(Integer maNhanVien, LocalDate ngayLamViec);
}
