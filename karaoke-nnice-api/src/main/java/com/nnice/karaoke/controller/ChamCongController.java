package com.nnice.karaoke.controller;

import com.nnice.karaoke.entity.BangChamCong;
import com.nnice.karaoke.exception.ResourceNotFoundException;
import com.nnice.karaoke.service.ChamCongService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cham-cong")
@Tag(name = "Chấm Công", description = "API quản lý chấm công nhân viên")
public class ChamCongController {

    @Autowired
    private ChamCongService chamCongService;

    @PostMapping("/check-in")
    @Operation(summary = "Check-in: ghi nhận thời gian vào")
    public ResponseEntity<BangChamCong> checkIn(
            @RequestParam Integer maNhanVien,
            @RequestParam LocalDate ngayLamViec) {
        BangChamCong bangChamCong = chamCongService.checkIn(maNhanVien, ngayLamViec);
        return ResponseEntity.ok(bangChamCong);
    }

    @PostMapping("/check-out")
    @Operation(summary = "Check-out: ghi nhận thời gian ra")
    public ResponseEntity<BangChamCong> checkOut(
            @RequestParam Integer maNhanVien,
            @RequestParam LocalDate ngayLamViec) {
        BangChamCong bangChamCong = chamCongService.checkOut(maNhanVien, ngayLamViec);
        return ResponseEntity.ok(bangChamCong);
    }

    @PostMapping("/ghi-nhan-gps")
    @Operation(summary = "Ghi nhận GPS vị trí")
    public ResponseEntity<Void> ghiNhanGPS(
            @RequestParam Integer maNhanVien,
            @RequestParam String viTri) {
        chamCongService.ghiNhanGPS(maNhanVien, viTri);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/so-sanh-ca-lam-viec")
    @Operation(summary = "So sánh với ca làm việc dự kiến")
    public ResponseEntity<String> soSanhCaLamViec(
            @RequestParam Integer maNhanVien,
            @RequestParam LocalDate ngayLamViec) {
        String result = chamCongService.soSanhCaLamViec(maNhanVien, ngayLamViec);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/danh-dau-trang-thai")
    @Operation(summary = "Đánh dấu trạng thái")
    public ResponseEntity<Void> danhDauTrangThai(
            @RequestParam Integer maNhanVien,
            @RequestParam LocalDate ngayLamViec,
            @RequestParam String trangThai) {
        chamCongService.danhDauTrangThai(maNhanVien, ngayLamViec, trangThai);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/thang/{maNhanVien}")
    @Operation(summary = "Danh sách chấm công theo tháng")
    public ResponseEntity<List<BangChamCong>> danhSachThangLamViec(
            @PathVariable Integer maNhanVien,
            @RequestParam int thang,
            @RequestParam int nam) {
        List<BangChamCong> list = chamCongService.danhSachThangLamViec(maNhanVien, thang, nam);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/toan-bo")
    @Operation(summary = "Danh sách chấm công toàn bộ nhân viên")
    public ResponseEntity<List<BangChamCong>> danhSachToanBoNhanVien(
            @RequestParam LocalDate ngayLamViec) {
        List<BangChamCong> list = chamCongService.danhSachToanBoNhanVien(ngayLamViec);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{maNhanVien}/{ngayLamViec}")
    @Operation(summary = "Xem chi tiết bảng chấm công ngày")
    public ResponseEntity<BangChamCong> xemChiTiet(
            @PathVariable Integer maNhanVien,
            @PathVariable LocalDate ngayLamViec) {
        Optional<BangChamCong> bangCC = chamCongService.xemChiTiet(maNhanVien, ngayLamViec);
        return bangCC.map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Bảng chấm công không tìm thấy"));
    }
}
