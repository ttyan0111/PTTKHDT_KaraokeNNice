package com.nnice.karaoke.controller;

import com.nnice.karaoke.dto.request.DatPhongRequest;
import com.nnice.karaoke.dto.response.DatPhongResponse;
import com.nnice.karaoke.service.IQuanLyDatPhongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controller: Tầng API
 * Flow: Client → HTTP Request → Controller → Service → Repository → Database
 *       Client ← HTTP Response ← Controller ← Service ← Repository ← Database
 * 
 * Controller:
 * 1. Nhận HTTP request từ client
 * 2. Gọi Service để xử lý
 * 3. Trả về HTTP response cho client
 */
@RestController
@RequestMapping("/api/dat-phong")
@CrossOrigin(origins = "*", maxAge = 3600)
public class DatPhongController {
    
    @Autowired
    private IQuanLyDatPhongService datPhongService;
    
    /**
     * POST /api/dat-phong
     * Tạo mới đặt phòng
     * Client gửi: { khachHangId: 1, phongId: 5, thoiGianVao: "2024-12-04T14:00:00", thoiGianRaDuKien: "2024-12-04T16:00:00" }
     * Server trả về: { id: 1, khachHangId: 1, phongId: 5, ... }
     */
    @PostMapping
    public ResponseEntity<DatPhongResponse> datPhongMoi(@RequestBody DatPhongRequest request) {
        // Controller chỉ là "nhân viên tiếp nhận" - nhận request từ client
        // Gọi Service xử lý logic
        DatPhongResponse response = datPhongService.datPhongMoi(request);
        
        // Trả về response với status code 201 CREATED
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
    /**
     * GET /api/dat-phong/{id}
     * Lấy chi tiết đặt phòng theo ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<DatPhongResponse> layChiTiet(@PathVariable Long id) {
        DatPhongResponse response = datPhongService.layChiTietDatPhong(id);
        return ResponseEntity.ok(response);
    }
    
    /**
     * GET /api/dat-phong
     * Lấy tất cả đặt phòng
     */
    @GetMapping
    public ResponseEntity<List<DatPhongResponse>> layTatCa() {
        List<DatPhongResponse> list = datPhongService.layTatCaDatPhong();
        return ResponseEntity.ok(list);
    }
    
    /**
     * PUT /api/dat-phong/{id}
     * Cập nhật đặt phòng
     */
    @PutMapping("/{id}")
    public ResponseEntity<DatPhongResponse> capNhat(@PathVariable Long id, 
                                                     @RequestBody DatPhongRequest request) {
        DatPhongResponse response = datPhongService.capNhatDatPhong(id, request);
        return ResponseEntity.ok(response);
    }
    
    /**
     * DELETE /api/dat-phong/{id}
     * Xóa đặt phòng
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> xoa(@PathVariable Long id) {
        datPhongService.xoaDatPhong(id);
        return ResponseEntity.noContent().build();
    }
    
    /**
     * POST /api/dat-phong/{id}/check-in
     * Check-in khách hàng
     */
    @PostMapping("/{id}/check-in")
    public ResponseEntity<DatPhongResponse> checkIn(@PathVariable Long id) {
        DatPhongResponse response = datPhongService.checkIn(id);
        return ResponseEntity.ok(response);
    }
    
    /**
     * POST /api/dat-phong/{id}/check-out
     * Check-out khách hàng
     */
    @PostMapping("/{id}/check-out")
    public ResponseEntity<DatPhongResponse> checkOut(@PathVariable Long id) {
        DatPhongResponse response = datPhongService.checkOut(id);
        return ResponseEntity.ok(response);
    }
}
