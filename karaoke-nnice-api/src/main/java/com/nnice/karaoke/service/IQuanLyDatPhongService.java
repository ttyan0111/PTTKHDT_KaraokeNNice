package com.nnice.karaoke.service;

import com.nnice.karaoke.dto.request.DatPhongRequest;
import com.nnice.karaoke.dto.response.DatPhongResponse;
import java.util.List;

/**
 * Interface Service định nghĩa các phương thức business logic
 * - Nhận dữ liệu từ Controller dưới dạng Request DTO
 * - Xử lý logic, gọi Repository
 * - Trả về Response DTO
 */
public interface IQuanLyDatPhongService {
    
    /**
     * Tạo mới đặt phòng
     * @param request - DatPhongRequest chứa dữ liệu từ client
     * @return DatPhongResponse - dữ liệu trả về cho client
     */
    DatPhongResponse datPhongMoi(DatPhongRequest request);
    
    /**
     * Lấy chi tiết đặt phòng theo ID
     * @param id - ID của đặt phòng
     * @return DatPhongResponse - thông tin đặt phòng
     */
    DatPhongResponse layChiTietDatPhong(Long id);
    
    /**
     * Lấy tất cả đặt phòng
     * @return List<DatPhongResponse> - danh sách đặt phòng
     */
    List<DatPhongResponse> layTatCaDatPhong();
    
    /**
     * Cập nhật đặt phòng
     * @param id - ID cần cập nhật
     * @param request - dữ liệu cập nhật
     * @return DatPhongResponse - dữ liệu sau cập nhật
     */
    DatPhongResponse capNhatDatPhong(Long id, DatPhongRequest request);
    
    /**
     * Xóa đặt phòng
     * @param id - ID cần xóa
     */
    void xoaDatPhong(Long id);
    
    /**
     * Check-in khách hàng
     * @param datPhongId - ID đặt phòng
     * @return DatPhongResponse - thông tin sau check-in
     */
    DatPhongResponse checkIn(Long datPhongId);
    
    /**
     * Check-out khách hàng
     * @param datPhongId - ID đặt phòng
     * @return DatPhongResponse - thông tin sau check-out
     */
    DatPhongResponse checkOut(Long datPhongId);
}
