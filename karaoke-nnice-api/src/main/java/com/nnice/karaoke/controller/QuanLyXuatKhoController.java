package com.nnice.karaoke.controller;

import com.nnice.karaoke.service.QuanLyXuatKhoService;
import com.nnice.karaoke.entity.PhieuXuat;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/xuat-kho")
@Tag(name = "Quản Lý Xuất Kho", description = "API quản lý xuất kho hàng hóa")
public class QuanLyXuatKhoController {

    @Autowired
    private QuanLyXuatKhoService quanLyXuatKhoService;

    @PostMapping
    @Operation(summary = "Tạo phiếu xuất mới")
    public ResponseEntity<PhieuXuat> taoPhieuXuat(@RequestBody PhieuXuat phieuXuat) {
        PhieuXuat created = quanLyXuatKhoService.taoPhieuXuat(phieuXuat);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/{maPhieuXuat}")
    @Operation(summary = "Xem chi tiết phiếu xuất")
    public ResponseEntity<PhieuXuat> xemChiTiet(@PathVariable Integer maPhieuXuat) {
        Optional<PhieuXuat> phieu = quanLyXuatKhoService.xemChiTiet(maPhieuXuat);
        return phieu.map(ResponseEntity::ok)
                .orElseThrow(() -> new com.nnice.karaoke.exception.ResourceNotFoundException("Phiếu xuất không tìm thấy"));
    }

    @PutMapping("/{maPhieuXuat}")
    @Operation(summary = "Cập nhật phiếu xuất")
    public ResponseEntity<PhieuXuat> capNhatPhieuXuat(
            @PathVariable Integer maPhieuXuat,
            @RequestBody PhieuXuat phieuXuat) {
        phieuXuat.setMaPhieuXuat(maPhieuXuat);
        PhieuXuat updated = quanLyXuatKhoService.capNhatPhieuXuat(phieuXuat);
        return ResponseEntity.ok(updated);
    }

    @GetMapping
    @Operation(summary = "Danh sách phiếu xuất")
    public ResponseEntity<List<PhieuXuat>> danhSachPhieuXuat() {
        List<PhieuXuat> list = quanLyXuatKhoService.danhSachPhieuXuat();
        return ResponseEntity.ok(list);
    }

    @PostMapping("/xuat-theo-order/{maOrder}")
    @Operation(summary = "Xuất kho theo order")
    public ResponseEntity<Void> xuatKhoTheoOrder(@PathVariable Integer maOrder) {
        quanLyXuatKhoService.xuatKhoTheoOrder(maOrder);
        return ResponseEntity.ok().build();
    }
}
