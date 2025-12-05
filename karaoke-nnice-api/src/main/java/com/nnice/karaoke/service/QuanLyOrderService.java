package com.nnice.karaoke.service;

import com.nnice.karaoke.entity.DonGoiMon;
import java.util.List;
import java.util.Optional;

public interface QuanLyOrderService {
    // Tạo order mới cho bàn/phòng
    DonGoiMon taoOrder(DonGoiMon donGoiMon);
    
    // Xem chi tiết order
    Optional<DonGoiMon> xemChiTiet(Integer maOrder);
    
    // Cập nhật trạng thái order
    DonGoiMon capNhatTrangThaiOrder(Integer maOrder, String trangThai);
    
    // Hủy order (chỉ hủy được order chưa xử lý)
    void huyOrder(Integer maOrder, String lyDo);
    
    // Danh sách order theo trạng thái
    List<DonGoiMon> danhSachOrderTheoDonGoiMon(String trangThai);
    
    // Danh sách order của phòng/phiếu
    List<DonGoiMon> danhSachOrderCuaPhieu(Integer maPhieu);
    
    // Tính tổng tiền order
    Long tinhTongTienOrder(Integer maOrder);
}
