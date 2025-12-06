package com.nnice.karaoke.controller;

import com.nnice.karaoke.dto.request.DatTiecRequest;
import com.nnice.karaoke.dto.response.DatTiecResponse;
import com.nnice.karaoke.exception.ResourceNotFoundException;
import com.nnice.karaoke.service.QuanLyDatTiecService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/dat-tiec")
@Tag(name = "Quản Lý Đặt Tiệc", description = "API quản lý đặt tiệc")
public class QuanLyDatTiecController {

    @Autowired
    private QuanLyDatTiecService quanLyDatTiecService;

    @PostMapping
    @Operation(summary = "Tạo đơn đặt tiệc mới")
    public ResponseEntity<DatTiecResponse> taoDonDatTiec(@RequestBody DatTiecRequest request) {
        DatTiecResponse created = quanLyDatTiecService.taoDonDatTiec(request);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/chi-phi/{maTiec}")
    @Operation(summary = "Tính chi phí tiệc")
    public ResponseEntity<Long> tinhChiPhiTiec(@PathVariable Integer maTiec) {
        Long chiPhi = quanLyDatTiecService.tinhChiPhiTiec(maTiec);
        return ResponseEntity.ok(chiPhi);
    }

    @GetMapping("/tien-coc")
    @Operation(summary = "Tính tiền đặt cọc (20%)")
    public ResponseEntity<Long> tinhTienDatCoc(@RequestParam Long tongChiPhi) {
        Long tienCoc = quanLyDatTiecService.tinhTienDatCoc(tongChiPhi);
        return ResponseEntity.ok(tienCoc);
    }

    @PostMapping("/thanh-toan-coc")
    @Operation(summary = "Xử lý thanh toán cọc")
    public ResponseEntity<Void> xuLyThanhToanCoc(
            @RequestParam Integer maTiec,
            @RequestParam Long soTien,
            @RequestParam String hinhThuc) {
        quanLyDatTiecService.xuLyThanhToanCoc(maTiec, soTien, hinhThuc);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{maTiec}")
    @Operation(summary = "Xem chi tiết đặt tiệc")
    public ResponseEntity<DatTiecResponse> xemChiTiet(@PathVariable Integer maTiec) {
        DatTiecResponse don = quanLyDatTiecService.xemChiTiet(maTiec);
        return ResponseEntity.ok(don);
    }

    @PutMapping("/{maTiec}")
    @Operation(summary = "Cập nhật đặt tiệc")
    public ResponseEntity<DatTiecResponse> capNhatDatTiec(
            @PathVariable Integer maTiec,
            @RequestBody DatTiecRequest request) {
        DatTiecResponse updated = quanLyDatTiecService.capNhatDatTiec(maTiec, request);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{maTiec}")
    @Operation(summary = "Hủy đặt tiệc")
    public ResponseEntity<Void> huyDatTiec(
            @PathVariable Integer maTiec,
            @RequestParam String lyDo) {
        quanLyDatTiecService.huyDatTiec(maTiec, lyDo);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/danh-sach")
    @Operation(summary = "Danh sách đặt tiệc theo trạng thái")
    public ResponseEntity<List<DatTiecResponse>> danhSachDatTiec(@RequestParam String trangThai) {
        List<DatTiecResponse> list = quanLyDatTiecService.danhSachDatTiec(trangThai);
        return ResponseEntity.ok(list);
    }

    @PostMapping("/khopa-hong/{maTiec}")
    @Operation(summary = "Khóa/phá phòng tiệc")
    public ResponseEntity<Void> khoapHongTiec(@PathVariable Integer maTiec) {
        quanLyDatTiecService.khoapHongTiec(maTiec);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/gui-xac-nhan/{maTiec}")
    @Operation(summary = "Gửi xác nhận SMS/Email")
    public ResponseEntity<Void> guiXacNhan(@PathVariable Integer maTiec) {
        quanLyDatTiecService.guiXacNhan(maTiec);
        return ResponseEntity.ok().build();
    }
}
