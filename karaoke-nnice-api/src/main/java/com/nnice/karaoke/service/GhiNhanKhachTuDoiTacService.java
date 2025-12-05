package com.nnice.karaoke.service;

import com.nnice.karaoke.entity.PhieuDatPhong;
import java.util.Optional;

public interface GhiNhanKhachTuDoiTacService {
    // Chọn đối tác từ danh sách
    void chonDoiTac(Integer maDoiTac);
    
    // Nhập mã booking từ đối tác
    Optional<PhieuDatPhong> nhapThongTinKhach(Integer maDoiTac, String maBooking);
    
    // Xác thực với hệ thống đối tác (nếu có API)
    boolean xacThucVoiDoiTac(Integer maDoiTac, String maBooking);
    
    // Tính hoa hồng/phí cho đối tác
    Long tinhHoaHong(Long tongTien, Integer maDoiTac);
    
    // Tạo đơn đặt phòng gắn nhãn "Từ đối tác"
    PhieuDatPhong taoDonDatPhongTuDoiTac(Integer maDoiTac, PhieuDatPhong phieuDatPhong);
    
    // Cập nhật công nợ với đối tác
    void capNhatCongNoDoiTac(Integer maDoiTac, Long soTien);
}
