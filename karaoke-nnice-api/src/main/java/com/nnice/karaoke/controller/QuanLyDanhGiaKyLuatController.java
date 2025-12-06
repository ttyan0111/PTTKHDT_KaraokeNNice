package com.nnice.karaoke.controller;

import com.nnice.karaoke.entity.NhanVien;
import com.nnice.karaoke.service.QuanLyDanhGiaKyLuatService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/quan-ly-danh-gia-ky-luat")
@Tag(name = "Quản Lý Đánh Giá Kỷ Luật", description = "API quản lý đánh giá và kỷ luật nhân viên")
public class QuanLyDanhGiaKyLuatController {

    @Autowired
    private QuanLyDanhGiaKyLuatService quanLyDanhGiaKyLuatService;

    @PostMapping("/danh-gia-dinh-ky/{maNhanVien}")
    @Operation(summary = "Đánh giá định kỳ nhân viên")
    public ResponseEntity<Void> danhGiaDinhKy(
            @PathVariable Integer maNhanVien,
            @RequestParam String thaiDo,
            @RequestParam String chuyenMon,
            @RequestParam String kyLuat) {
        quanLyDanhGiaKyLuatService.danhGiaDinhKy(maNhanVien, thaiDo, chuyenMon, kyLuat);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/khen-thuong/{maNhanVien}")
    @Operation(summary = "Khen thưởng nhân viên")
    public ResponseEntity<Void> khenThuong(
            @PathVariable Integer maNhanVien,
            @RequestParam String loaiThuong,
            @RequestParam Long soTien,
            @RequestParam(required = false) String ghiChu) {
        quanLyDanhGiaKyLuatService.khenThuong(maNhanVien, loaiThuong, soTien, ghiChu);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/ky-luat/{maNhanVien}")
    @Operation(summary = "Kỷ luật nhân viên")
    public ResponseEntity<Void> kyLuat(
            @PathVariable Integer maNhanVien,
            @RequestParam String loaiKyLuat,
            @RequestParam Long soTienPhat,
            @RequestParam(required = false) String ghiChu) {
        quanLyDanhGiaKyLuatService.kyLuat(maNhanVien, loaiKyLuat, soTienPhat, ghiChu);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/luu-vao-ho-so/{maNhanVien}")
    @Operation(summary = "Lưu vào hồ sơ nhân viên")
    public ResponseEntity<Void> luuVaoHoSo(
            @PathVariable Integer maNhanVien,
            @RequestParam String noNoi) {
        quanLyDanhGiaKyLuatService.luuVaoHoSo(maNhanVien, noNoi);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/lich-su-khen-thuong-ky-luat/{maNhanVien}")
    @Operation(summary = "Xem lịch sử khen thưởng/kỷ luật")
    public ResponseEntity<List<Object>> xemLichSuKhenThuongKyLuat(@PathVariable Integer maNhanVien) {
        List<Object> result = quanLyDanhGiaKyLuatService.xemLichSuKhenThuongKyLuat(maNhanVien);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/cap-nhat-anh-huong-luong/{maNhanVien}")
    @Operation(summary = "Cập nhật ảnh hưởng đến lương")
    public ResponseEntity<Void> capNhatANhHuongLuong(@PathVariable Integer maNhanVien) {
        quanLyDanhGiaKyLuatService.capNhatANhHuongLuong(maNhanVien);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/danh-sach-nhan-vien-vi-pham")
    @Operation(summary = "Danh sách nhân viên vi phạm")
    public ResponseEntity<List<NhanVien>> danhSachNhanVienViPham() {
        List<NhanVien> result = quanLyDanhGiaKyLuatService.danhSachNhanVienViPham();
        return ResponseEntity.ok(result);
    }
}
