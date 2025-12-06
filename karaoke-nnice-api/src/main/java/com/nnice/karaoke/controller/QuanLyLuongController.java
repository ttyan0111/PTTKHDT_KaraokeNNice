package com.nnice.karaoke.controller;

import com.nnice.karaoke.entity.BangLuong;
import com.nnice.karaoke.service.QuanLyLuongService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/quan-ly-luong")
@Tag(name = "Quản Lý Lương", description = "API quản lý lương nhân viên")
public class QuanLyLuongController {

    @Autowired
    private QuanLyLuongService quanLyLuongService;

    @PostMapping("/tinh-luong-nhan-vien/{maNhanVien}")
    @Operation(summary = "Tính lương nhân viên")
    public ResponseEntity<BangLuong> tinhLuongNhanVien(
            @PathVariable Integer maNhanVien,
            @RequestParam int thang,
            @RequestParam int nam) {
        BangLuong result = quanLyLuongService.tinhLuongNhanVien(maNhanVien, thang, nam);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/tinh-luong-co-ban/{maNhanVien}")
    @Operation(summary = "Tính lương cơ bản")
    public ResponseEntity<Long> tinhLuongCoBan(
            @PathVariable Integer maNhanVien,
            @RequestParam int soCa) {
        Long result = quanLyLuongService.tinhLuongCoBan(maNhanVien, soCa);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/tinh-thuong-doanh-thu/{maNhanVien}")
    @Operation(summary = "Tính thưởng doanh thu")
    public ResponseEntity<Long> tinhThuongDoanhThu(
            @PathVariable Integer maNhanVien,
            @RequestParam Long doanhThuCoso) {
        Long result = quanLyLuongService.tinhThuongDoanhThu(maNhanVien, doanhThuCoso);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/tinh-phu-cap/{maNhanVien}")
    @Operation(summary = "Tính phụ cấp")
    public ResponseEntity<Long> tinhPhuCap(
            @PathVariable Integer maNhanVien,
            @RequestParam int thang,
            @RequestParam int nam) {
        Long result = quanLyLuongService.tinhPhuCap(maNhanVien, thang, nam);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/tinh-khoan-tru/{maNhanVien}")
    @Operation(summary = "Tính các khoản trừ")
    public ResponseEntity<Long> tinhKhoanTru(
            @PathVariable Integer maNhanVien,
            @RequestParam int thang,
            @RequestParam int nam) {
        Long result = quanLyLuongService.tinhKhoanTru(maNhanVien, thang, nam);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/xem-chi-tiet/{maNhanVien}")
    @Operation(summary = "Xem chi tiết bảng lương")
    public ResponseEntity<BangLuong> xemChiTiet(
            @PathVariable Integer maNhanVien,
            @RequestParam int thang,
            @RequestParam int nam) {
        Optional<BangLuong> result = quanLyLuongService.xemChiTiet(maNhanVien, thang, nam);
        return result.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/danh-sach/{thang}/{nam}")
    @Operation(summary = "Danh sách lương tháng")
    public ResponseEntity<List<BangLuong>> danhSachLuongThang(
            @PathVariable int thang,
            @PathVariable int nam) {
        List<BangLuong> result = quanLyLuongService.danhSachLuongThang(thang, nam);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
