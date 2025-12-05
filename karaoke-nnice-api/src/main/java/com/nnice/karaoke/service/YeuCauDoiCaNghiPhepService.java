package com.nnice.karaoke.service;

import java.time.LocalDate;
import java.util.List;

public interface YeuCauDoiCaNghiPhepService {
    // Yêu cầu đổi ca
    void yeuCauDoiCa(Integer maNhanVien, Integer caCu, Integer caMoi, String lyDo);
    
    // Yêu cầu nghỉ phép
    void yeuCauNghiPhep(Integer maNhanVien, LocalDate ngayBatDau, LocalDate ngayKetThuc, 
                        String loaiPhep, String lyDo);
    
    // Kiểm tra số ngày phép còn lại
    int kiemTraNgayPhepConLai(Integer maNhanVien);
    
    // Kiểm tra ca thay thế không trùng
    boolean kiemTraCaKhongTrung(Integer caMoi, LocalDate ngayLamViec);
    
    // Xem danh sách yêu cầu chờ duyệt
    List<Object> danhSachYeuCauChoDuyet();
    
    // Phê duyệt yêu cầu
    void pheDuyetYeuCau(Integer maYeuCau);
    
    // Từ chối yêu cầu
    void tuChoiYeuCau(Integer maYeuCau, String lyDo);
}
