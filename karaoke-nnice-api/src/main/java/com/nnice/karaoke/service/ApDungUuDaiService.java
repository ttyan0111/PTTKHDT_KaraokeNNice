package com.nnice.karaoke.service;

import com.nnice.karaoke.entity.CauHinhGia;
import java.util.List;
import java.util.Optional;

public interface ApDungUuDaiService {
    // Kiểm tra mã ưu đãi
    Optional<CauHinhGia> kiemTraUuDai(String maUuDai);
    
    // Kiểm tra ưu đãi còn hạn
    boolean kiemTraUuDaiConHan(Integer maUuDai);
    
    // Kiểm tra mã chưa sử dụng
    boolean kiemTraChuaSuDung(Integer maUuDai);
    
    // Áp dụng giảm giá %
    Long apDungGiamGiaPercent(Long tongTien, Integer phanTram);
    
    // Áp dụng giảm giá cố định
    Long apDungGiamGiaCoDinh(Long tongTien, Long soTienGiam);
    
    // Hiển thị số tiền giảm
    Long tinhTienGiam(Long tongTien, Integer maUuDai);
    
    // Đánh dấu mã đã sử dụng
    void danhDauDaSuDung(Integer maUuDai);
    
    // Danh sách ưu đãi còn hiệu lực
    List<CauHinhGia> danhSachUuDaiConHan();
}
