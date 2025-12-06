package com.nnice.karaoke.controller;

import com.nnice.karaoke.entity.CauHinhGia;
import com.nnice.karaoke.exception.ResourceNotFoundException;
import com.nnice.karaoke.service.QuanLyCauHinhHeThongService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cau-hinh-he-thong")
@Tag(name = "Quản Lý Cấu Hình Hệ Thống", description = "API quản lý cấu hình giá hàng hóa, dịch vụ")
public class QuanLyCauHinhHeThongController {

    @Autowired
    private QuanLyCauHinhHeThongService quanLyCauHinhHeThongService;

    @GetMapping("/hien-tai")
    @Operation(summary = "Xem cấu hình hiện tại")
    public ResponseEntity<CauHinhGia> xemCauHinhHienTai(@RequestParam String loaiCauHinh) {
        Optional<CauHinhGia> config = quanLyCauHinhHeThongService.xemCauHinhHienTai(loaiCauHinh);
        return config.map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Cấu hình không tìm thấy"));
    }

    @PostMapping
    @Operation(summary = "Tạo cấu hình mới")
    public ResponseEntity<CauHinhGia> taoCauHinh(@RequestBody CauHinhGia cauHinhGia) {
        CauHinhGia created = quanLyCauHinhHeThongService.capNhatCauHinh(cauHinhGia);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{maCauHinh}")
    @Operation(summary = "Cập nhật cấu hình")
    public ResponseEntity<CauHinhGia> capNhatCauHinh(
            @PathVariable Integer maCauHinh,
            @RequestBody CauHinhGia cauHinhGia) {
        cauHinhGia.setMaCauHinh(maCauHinh);
        CauHinhGia updated = quanLyCauHinhHeThongService.capNhatCauHinh(cauHinhGia);
        return ResponseEntity.ok(updated);
    }

    @GetMapping
    @Operation(summary = "Danh sách cấu hình")
    public ResponseEntity<List<CauHinhGia>> danhSachCauHinh() {
        List<CauHinhGia> list = quanLyCauHinhHeThongService.danhSachCauHinh();
        return ResponseEntity.ok(list);
    }
}
