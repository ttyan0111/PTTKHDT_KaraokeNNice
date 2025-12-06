package com.nnice.karaoke.controller;

import com.nnice.karaoke.service.PhanCongCaLamService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/phan-cong-ca-lam")
@Tag(name = "Phân Công Ca Làm", description = "API quản lý phân công ca làm việc")
public class PhanCongCaLamController {

    @Autowired
    private PhanCongCaLamService phanCongCaLamService;

    @PostMapping("/phan-cong")
    @Operation(summary = "Phân công nhân viên vào ca")
    public ResponseEntity<Void> phanCongNhanVienVaoCa(
            @RequestParam Integer maNhanVien,
            @RequestParam Integer maCa,
            @RequestParam LocalDate ngayLamViec) {
        phanCongCaLamService.phanCongNhanVienVaoCa(maNhanVien, maCa, ngayLamViec);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/kiem-tra-trung-ca/{maNhanVien}")
    @Operation(summary = "Kiểm tra không trùng ca")
    public ResponseEntity<Boolean> kiemTraKhongTrungCa(
            @PathVariable Integer maNhanVien,
            @RequestParam LocalDate ngayLamViec) {
        boolean result = phanCongCaLamService.kiemTraKhongTrungCa(maNhanVien, ngayLamViec);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/kiem-tra-khong-nghi-phep/{maNhanVien}")
    @Operation(summary = "Kiểm tra nhân viên không nghỉ phép")
    public ResponseEntity<Boolean> kiemTraNhanVienKhongNghiPhep(
            @PathVariable Integer maNhanVien,
            @RequestParam LocalDate ngayLamViec) {
        boolean result = phanCongCaLamService.kiemTraNhanVienKhongNghiPhep(maNhanVien, ngayLamViec);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/canh-bao-thieu-nguoi")
    @Operation(summary = "Cảnh báo thiếu người")
    public ResponseEntity<Void> canhBaoThieuNguoi(
            @RequestParam LocalDate ngayLamViec,
            @RequestParam Integer maCa) {
        phanCongCaLamService.canhBaoThieuNguoi(ngayLamViec, maCa);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/xem-theo-ngay/{ngayLamViec}")
    @Operation(summary = "Xem danh sách phân công theo ngày")
    public ResponseEntity<List<Object>> xemPhanCongTheoNgay(@PathVariable LocalDate ngayLamViec) {
        List<Object> result = phanCongCaLamService.xemPhanCongTheoNgay(ngayLamViec);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/xem-theo-ca/{maCa}")
    @Operation(summary = "Xem danh sách phân công theo ca")
    public ResponseEntity<List<Object>> xemPhanCongTheoCa(
            @PathVariable Integer maCa,
            @RequestParam LocalDate ngayLamViec) {
        List<Object> result = phanCongCaLamService.xemPhanCongTheoCa(maCa, ngayLamViec);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/cap-nhat")
    @Operation(summary = "Cập nhật phân công")
    public ResponseEntity<Void> capNhatPhanCong(
            @RequestParam Integer maNhanVien,
            @RequestParam Integer caCu,
            @RequestParam Integer caMoi) {
        phanCongCaLamService.capNhatPhanCong(maNhanVien, caCu, caMoi);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/xoa")
    @Operation(summary = "Xóa phân công")
    public ResponseEntity<Void> xoaPhanCong(
            @RequestParam Integer maNhanVien,
            @RequestParam LocalDate ngayLamViec) {
        phanCongCaLamService.xoaPhanCong(maNhanVien, ngayLamViec);
        return ResponseEntity.ok().build();
    }
}
