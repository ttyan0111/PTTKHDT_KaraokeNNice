package com.nnice.karaoke.controller;

import com.nnice.karaoke.dto.request.DatPhongRequest;
import com.nnice.karaoke.dto.response.DatPhongResponse;
import com.nnice.karaoke.dto.response.PhongKhaDungResponse;
import com.nnice.karaoke.service.impl.QuanLyDatPhongServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * REST Controller cho Quản lý Đặt Phòng
 * Use Case: QuanLyDatPhong, TraCuuPhongTrong
 */
@RestController
@RequestMapping("/api/dat-phong")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Quản lý Đặt Phòng", description = "APIs quản lý đặt phòng karaoke")
public class QuanLyDatPhongController {
    
    private final QuanLyDatPhongServiceImpl datPhongService;
    
    /**
     * Endpoint test đơn giản
     */
    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("API is working!");
    }
    
    /**
     * Tìm phòng trống phù hợp với yêu cầu
     * UC: TraCuuPhongTrong
     */
    @GetMapping("/tim-phong-trong")
    @Operation(summary = "Tìm phòng trống", 
               description = "Tìm kiếm các phòng khả dụng dựa trên số người và thời gian")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Tìm thấy phòng trống"),
        @ApiResponse(responseCode = "400", description = "Thông tin không hợp lệ"),
        @ApiResponse(responseCode = "404", description = "Không tìm thấy phòng phù hợp")
    })
    public ResponseEntity<List<PhongKhaDungResponse>> timPhongTrong(
            @Parameter(description = "Số người", required = false)
            @RequestParam(required = false) Integer soNguoi,
            
            @Parameter(description = "Giờ đặt (yyyy-MM-dd'T'HH:mm:ss)", required = false)
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime gioDat,
            
            @Parameter(description = "Giờ kết thúc (yyyy-MM-dd'T'HH:mm:ss)", required = false)
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime gioKetThuc,
            
            @Parameter(description = "Mã cơ sở", required = false)
            @RequestParam(required = false) Integer maCoSo) {
        
        log.info("Request tìm phòng trống - Số người: {}, Từ: {}, Đến: {}, Cơ sở: {}", 
                 soNguoi, gioDat, gioKetThuc, maCoSo);
        
        try {
            List<PhongKhaDungResponse> phongTrong = datPhongService.timPhongTrong(
                    soNguoi, gioDat, gioKetThuc);
            
            return ResponseEntity.ok(phongTrong);
        } catch (Exception e) {
            log.error("Lỗi khi tìm phòng: ", e);
            throw e;
        }
    }
    
    /**
     * Tạo phiếu đặt phòng mới
     * UC: QuanLyDatPhong - Tạo mới
     */
    @PostMapping
    @Operation(summary = "Tạo phiếu đặt phòng", 
               description = "Tạo phiếu đặt phòng mới cho khách hàng")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Tạo phiếu đặt thành công"),
        @ApiResponse(responseCode = "400", description = "Thông tin không hợp lệ"),
        @ApiResponse(responseCode = "409", description = "Phòng đã được đặt")
    })
    public ResponseEntity<DatPhongResponse> taoPhieuDatPhong(
            @Parameter(description = "Thông tin đặt phòng", required = true)
            @RequestBody DatPhongRequest request) {
        
        log.info("Request tạo phiếu đặt phòng - Khách: {}, SĐT: {}", 
                 request.getTenKH(), request.getSdt());
        
        DatPhongResponse response = datPhongService.taoPhieuDatPhong(request);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
    /**
     * Xem chi tiết phiếu đặt phòng
     * UC: QuanLyDatPhong - Xem
     */
    @GetMapping("/{maPhieuDat}")
    @Operation(summary = "Xem chi tiết phiếu đặt", 
               description = "Lấy thông tin chi tiết phiếu đặt phòng theo mã")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lấy thông tin thành công"),
        @ApiResponse(responseCode = "404", description = "Không tìm thấy phiếu đặt")
    })
    public ResponseEntity<DatPhongResponse> xemPhieuDatPhong(
            @Parameter(description = "Mã phiếu đặt", required = true)
            @PathVariable Integer maPhieuDat) {
        
        log.info("Request xem phiếu đặt - Mã: {}", maPhieuDat);
        
        DatPhongResponse response = datPhongService.xemPhieuDatPhong(maPhieuDat);
        
        return ResponseEntity.ok(response);
    }
    
    /**
     * Cập nhật phiếu đặt phòng
     * UC: QuanLyDatPhong - Cập nhật
     */
    @PutMapping("/{maPhieuDat}")
    @Operation(summary = "Cập nhật phiếu đặt", 
               description = "Cập nhật thông tin phiếu đặt phòng")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cập nhật thành công"),
        @ApiResponse(responseCode = "400", description = "Thông tin không hợp lệ"),
        @ApiResponse(responseCode = "404", description = "Không tìm thấy phiếu đặt")
    })
    public ResponseEntity<DatPhongResponse> capNhatPhieuDatPhong(
            @Parameter(description = "Mã phiếu đặt", required = true)
            @PathVariable Integer maPhieuDat,
            
            @Parameter(description = "Thông tin cập nhật", required = true)
            @RequestBody DatPhongRequest request) {
        
        log.info("Request cập nhật phiếu đặt - Mã: {}", maPhieuDat);
        
        DatPhongResponse response = datPhongService.capNhatPhieuDatPhong(maPhieuDat, request);
        
        return ResponseEntity.ok(response);
    }
    
    /**
     * Hủy phiếu đặt phòng
     * UC: QuanLyDatPhong - Hủy
     */
    @DeleteMapping("/{maPhieuDat}")
    @Operation(summary = "Hủy phiếu đặt", 
               description = "Hủy phiếu đặt phòng và giải phóng phòng")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Hủy thành công"),
        @ApiResponse(responseCode = "404", description = "Không tìm thấy phiếu đặt"),
        @ApiResponse(responseCode = "409", description = "Không thể hủy phiếu đặt")
    })
    public ResponseEntity<Void> huyPhieuDatPhong(
            @Parameter(description = "Mã phiếu đặt", required = true)
            @PathVariable Integer maPhieuDat) {
        
        log.info("Request hủy phiếu đặt - Mã: {}", maPhieuDat);
        
        datPhongService.huyPhieuDatPhong(maPhieuDat, "Hủy theo yêu cầu khách hàng");
        
        return ResponseEntity.noContent().build();
    }
    
    /**
     * Tra cứu phiếu đặt theo SĐT khách hàng
     */
    @GetMapping("/tra-cuu")
    @Operation(summary = "Tra cứu phiếu đặt", 
               description = "Tra cứu phiếu đặt phòng theo số điện thoại hoặc mã đặt phòng")
    public ResponseEntity<List<DatPhongResponse>> traCuuPhieuDat(
            @Parameter(description = "Số điện thoại khách hàng")
            @RequestParam(required = false) String sdt,
            
            @Parameter(description = "Mã đặt phòng")
            @RequestParam(required = false) String maDatPhong) {
        
        log.info("Request tra cứu phiếu đặt - SĐT: {}, Mã: {}", sdt, maDatPhong);
        
        // TODO: Implement tra cứu logic
        
        return ResponseEntity.ok(List.of());
    }
}
