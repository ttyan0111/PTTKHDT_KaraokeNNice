package com.nnice.karaoke.service;

import com.nnice.karaoke.dto.request.DatPhongRequest;
import com.nnice.karaoke.dto.response.DatPhongResponse;
import com.nnice.karaoke.dto.response.PhongKhaDungResponse;

import java.time.LocalDateTime;
import java.util.List;

public interface QuanLyDatPhongService {
    // Tạo đơn đặt phòng mới
    DatPhongResponse taoPhieuDatPhong(DatPhongRequest request);
    
    // Tìm phòng trống
    List<PhongKhaDungResponse> timPhongTrong(Integer soNguoi, LocalDateTime tuNgay, LocalDateTime denNgay);
    
    // Xem chi tiết đặt phòng
    DatPhongResponse xemPhieuDatPhong(Integer maPhieu);
    
    // Cập nhật đặt phòng
    DatPhongResponse capNhatPhieuDatPhong(Integer maPhieu, DatPhongRequest request);
    
    // Hủy đặt phòng
    void huyPhieuDatPhong(Integer maPhieu, String lyDoHuy);
    
    // Danh sách đặt phòng theo khách hàng
    List<DatPhongResponse> layDanhSachPhieuDatTheoKhach(Integer maKhach);
}
