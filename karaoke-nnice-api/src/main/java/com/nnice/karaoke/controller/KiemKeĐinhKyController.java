package com.nnice.karaoke.controller;

import com.nnice.karaoke.entity.PhieuKiemKe;
import com.nnice.karaoke.exception.ResourceNotFoundException;
import com.nnice.karaoke.service.KiemKeĐinhKyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/kiem-ke")
@Tag(name = "Kiểm Kê Định Kỳ", description = "API quản lý kiểm kê hàng hóa")
public class KiemKeĐinhKyController {

    @Autowired
    private KiemKeĐinhKyService kiemKeĐinhKyService;

    @PostMapping
    @Operation(summary = "Tạo phiếu kiểm kê mới")
    public ResponseEntity<PhieuKiemKe> taoPhieuKiemKe(@RequestBody PhieuKiemKe phieuKiemKe) {
        PhieuKiemKe created = kiemKeĐinhKyService.taoPhieuKiemKe(phieuKiemKe);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/{maPhieu}")
    @Operation(summary = "Xem chi tiết phiếu kiểm kê")
    public ResponseEntity<PhieuKiemKe> xemChiTiet(@PathVariable Integer maPhieu) {
        Optional<PhieuKiemKe> phieu = kiemKeĐinhKyService.xemChiTiet(maPhieu);
        return phieu.map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Phiếu kiểm kê không tìm thấy"));
    }

    @PutMapping("/{maPhieu}")
    @Operation(summary = "Cập nhật phiếu kiểm kê")
    public ResponseEntity<PhieuKiemKe> capNhatPhieuKiemKe(
            @PathVariable Integer maPhieu,
            @RequestBody PhieuKiemKe phieuKiemKe) {
        phieuKiemKe.setMaKiemKe(maPhieu);
        PhieuKiemKe updated = kiemKeĐinhKyService.capNhatPhieuKiemKe(phieuKiemKe);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/chenh-lech")
    @Operation(summary = "Tính chênh lệch (thực tế - sổ sách)")
    public ResponseEntity<Integer> tinhChenhLech(
            @RequestParam Integer maMatHang,
            @RequestParam int soLuongThucTe) {
        int chenhLech = kiemKeĐinhKyService.tinhChenhLech(maMatHang, soLuongThucTe);
        return ResponseEntity.ok(chenhLech);
    }

    @PostMapping("/canh-bao-chenh-lech")
    @Operation(summary = "Cảnh báo chênh lệch lớn")
    public ResponseEntity<Void> canhBaoChenhLechLon(
            @RequestParam Integer maMatHang,
            @RequestParam int chenhLech) {
        kiemKeĐinhKyService.canhBaoChenhLechLon(maMatHang, chenhLech);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    @Operation(summary = "Danh sách phiếu kiểm kê")
    public ResponseEntity<List<PhieuKiemKe>> danhSach() {
        List<PhieuKiemKe> list = kiemKeĐinhKyService.danhSachPhieuKiemKe();
        return ResponseEntity.ok(list);
    }
}
