package com.nnice.karaoke.service;

import com.nnice.karaoke.dto.request.OrderRequest;
import com.nnice.karaoke.dto.response.OrderResponse;
import java.util.List;

public interface QuanLyOrderService {
    // Tạo order mới cho bàn/phòng
    OrderResponse taoOrder(OrderRequest request);
    
    // Xem chi tiết order
    OrderResponse xemChiTiet(Integer maOrder);
    
    // Cập nhật trạng thái order
    OrderResponse capNhatTrangThaiOrder(Integer maOrder, String trangThai);
    
    // Hủy order (chỉ hủy được order chưa xử lý)
    void huyOrder(Integer maOrder, String lyDo);
    
    // Danh sách order theo trạng thái
    List<OrderResponse> danhSachOrderTheoDonGoiMon(String trangThai);
    
    // Danh sách order của phòng/phiếu
    List<OrderResponse> danhSachOrderCuaPhieu(Integer maPhieu);
    
    // Tính tổng tiền order
    Long tinhTongTienOrder(Integer maOrder);
}
