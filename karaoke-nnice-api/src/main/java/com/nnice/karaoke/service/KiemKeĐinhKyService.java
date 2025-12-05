package com.nnice.karaoke.service;

import com.nnice.karaoke.entity.PhieuKiemKe;
import java.util.List;
import java.util.Optional;

public interface KiemKeĐinhKyService {
    // Tạo phiếu kiểm kê mới
    PhieuKiemKe taoPhieuKiemKe(PhieuKiemKe phieuKiemKe);
    
    // Xem chi tiết phiếu kiểm kê
    Optional<PhieuKiemKe> xemChiTiet(Integer maPhieu);
    
    // Cập nhật phiếu kiểm kê
    PhieuKiemKe capNhatPhieuKiemKe(PhieuKiemKe phieuKiemKe);
    
    // Tính chênh lệch (thực tế - sổ sách)
    int tinhChenhLech(Integer maMatHang, int soLuongThucTe);
    
    // Cảnh báo chênh lệch lớn
    void canhBaoChenhLechLon(Integer maMatHang, int chenhLech);
    
    // Cập nhật tồn kho theo số liệu thực tế
    void capNhatTonKhoTheoThucTe(Integer maMatHang, int soLuongThucTe);
    
    // Cảnh báo hàng sắp hết
    void canhBaoHangSapHet();
    
    // Danh sách phiếu kiểm kê
    List<PhieuKiemKe> danhSachPhieuKiemKe();
}
