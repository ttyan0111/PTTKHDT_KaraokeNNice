package com.nnice.karaoke.controller;

import com.nnice.karaoke.service.ThongKeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/thong-ke")
@Tag(name = "Thống Kê", description = "API thống kê doanh số, báo cáo")
public class ThongKeController {

    @Autowired
    private ThongKeService thongKeService;

    @GetMapping("/doanh-thu-theo-coso")
    @Operation(summary = "Báo cáo doanh thu theo cơ sở")
    public ResponseEntity<Map<String, Object>> baoCaoDanhThuTheoCoso(
            @RequestParam LocalDate tuNgay,
            @RequestParam LocalDate denNgay,
            @RequestParam Integer maCS) {
        Map<String, Object> report = thongKeService.baoCaoDanhThuTheoCoso(tuNgay, denNgay, maCS);
        return ResponseEntity.ok(report);
    }

    @GetMapping("/doanh-thu-theo-loai-dich-vu")
    @Operation(summary = "Báo cáo doanh thu theo loại dịch vụ")
    public ResponseEntity<Map<String, Object>> baoCaoDanhThuTheoLoaiDichVu(
            @RequestParam LocalDate tuNgay,
            @RequestParam LocalDate denNgay) {
        Map<String, Object> report = thongKeService.baoCaoDanhThuTheoLoaiDichVu(tuNgay, denNgay);
        return ResponseEntity.ok(report);
    }

    @GetMapping("/so-sanh-ky")
    @Operation(summary = "Báo cáo so sánh giữa các kỳ")
    public ResponseEntity<Map<String, Object>> baoCaoSoSanhKy(
            @RequestParam int kyTruoc,
            @RequestParam int kyHienTai) {
        Map<String, Object> report = thongKeService.baoCaoSoSanhKy(kyTruoc, kyHienTai);
        return ResponseEntity.ok(report);
    }

    @GetMapping("/ty-le-lap-day-phong")
    @Operation(summary = "Tỷ lệ lấp đầy phòng")
    public ResponseEntity<Double> tyLeLapDayPhong(
            @RequestParam LocalDate ngay,
            @RequestParam Integer maCS) {
        Double rate = thongKeService.tyLeLapDayPhong(ngay, maCS);
        return ResponseEntity.ok(rate);
    }

    @GetMapping("/thoi-gian-trung-binh")
    @Operation(summary = "Thời gian sử dụng trung bình")
    public ResponseEntity<Long> thoiGianSuDungTrungBinh(
            @RequestParam LocalDate tuNgay,
            @RequestParam LocalDate denNgay) {
        Long avgTime = thongKeService.thoiGianSuDungTrungBinh(tuNgay, denNgay);
        return ResponseEntity.ok(avgTime);
    }

    @GetMapping("/phong-ua-thuong")
    @Operation(summary = "Phòng được ưa chuộng")
    public ResponseEntity<List<Map<String, Object>>> phongUaThuong(@RequestParam int soLuong) {
        List<Map<String, Object>> list = thongKeService.phongUaThuong(soLuong);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/mon-an-ban-chay")
    @Operation(summary = "Món ăn bán chạy")
    public ResponseEntity<List<Map<String, Object>>> monAnBanChay(@RequestParam int soLuong) {
        List<Map<String, Object>> list = thongKeService.monAnBanChay(soLuong);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/khung-gio-cao-diem")
    @Operation(summary = "Khung giờ cao điểm")
    public ResponseEntity<List<Map<String, Object>>> khungGioCaoDiem() {
        List<Map<String, Object>> list = thongKeService.khungGioCaoDiem();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/khach-new-vs-old")
    @Operation(summary = "Báo cáo khách hàng mới/cũ")
    public ResponseEntity<Map<String, Object>> baoCaoKhachNewVsOld(
            @RequestParam LocalDate tuNgay,
            @RequestParam LocalDate denNgay) {
        Map<String, Object> report = thongKeService.baoCaoKhachNewVsOld(tuNgay, denNgay);
        return ResponseEntity.ok(report);
    }

    @GetMapping("/top-khach-chi-tieu-cao")
    @Operation(summary = "Top khách chi tiêu cao")
    public ResponseEntity<List<Map<String, Object>>> topKhachChiTieuCao(@RequestParam int soLuong) {
        List<Map<String, Object>> list = thongKeService.topKhachChiTieuCao(soLuong);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/tan-suat-quay-lai")
    @Operation(summary = "Tần suất quay lại")
    public ResponseEntity<Map<String, Object>> tanSuatQuayLai(@RequestParam Integer maKhach) {
        Map<String, Object> report = thongKeService.tanSuatQuayLai(maKhach);
        return ResponseEntity.ok(report);
    }

    @GetMapping("/phan-tich-theo-nguon-doi-tac")
    @Operation(summary = "Phân tích theo nguồn đối tác")
    public ResponseEntity<Map<String, Object>> phanTichTheoNguonDoiTac(
            @RequestParam LocalDate tuNgay,
            @RequestParam LocalDate denNgay) {
        Map<String, Object> report = thongKeService.phanTichTheoNguonDoiTac(tuNgay, denNgay);
        return ResponseEntity.ok(report);
    }

    @GetMapping("/bao-cao-kho")
    @Operation(summary = "Báo cáo kho")
    public ResponseEntity<Map<String, Object>> baoCaoKho() {
        Map<String, Object> report = thongKeService.baoCaoKho();
        return ResponseEntity.ok(report);
    }

    @GetMapping("/bao-cao-nhan-vien")
    @Operation(summary = "Báo cáo nhân viên")
    public ResponseEntity<Map<String, Object>> baoCaoNhanVien(
            @RequestParam int thang,
            @RequestParam int nam) {
        Map<String, Object> report = thongKeService.baoCaoNhanVien(thang, nam);
        return ResponseEntity.ok(report);
    }
}
