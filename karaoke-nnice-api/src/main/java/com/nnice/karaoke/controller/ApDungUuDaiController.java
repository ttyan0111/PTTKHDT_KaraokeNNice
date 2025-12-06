package com.nnice.karaoke.controller;

import com.nnice.karaoke.dto.request.ApDungUuDaiRequest;
import com.nnice.karaoke.dto.response.ApDungUuDaiResponse;
import com.nnice.karaoke.service.ApDungUuDaiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ap-dung-uu-dai")
@Tag(name = "Áp Dụng Ưu Đãi", description = "API quản lý ưu đãi khách hàng")
public class ApDungUuDaiController {

    @Autowired
    private ApDungUuDaiService apDungUuDaiService;

    @GetMapping("/kiem-tra/{maUuDai}")
    @Operation(summary = "Kiểm tra mã ưu đãi")
    public ResponseEntity<ApDungUuDaiResponse> kiemTraUuDai(@PathVariable String maUuDai) {
        ApDungUuDaiResponse result = apDungUuDaiService.kiemTraUuDai(maUuDai);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/con-han/{maUuDai}")
    @Operation(summary = "Kiểm tra ưu đãi còn hạn")
    public ResponseEntity<Boolean> kiemTraUuDaiConHan(@PathVariable Integer maUuDai) {
        boolean result = apDungUuDaiService.kiemTraUuDaiConHan(maUuDai);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/chua-su-dung/{maUuDai}")
    @Operation(summary = "Kiểm tra mã chưa sử dụng")
    public ResponseEntity<Boolean> kiemTraChuaSuDung(@PathVariable Integer maUuDai) {
        boolean result = apDungUuDaiService.kiemTraChuaSuDung(maUuDai);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/tien-giam")
    @Operation(summary = "Tính tiền giảm")
    public ResponseEntity<Long> tinhTienGiam(
            @RequestParam Long tongTien,
            @RequestParam Integer maUuDai) {
        Long result = apDungUuDaiService.tinhTienGiam(tongTien, maUuDai);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/danh-dau-da-su-dung")
    @Operation(summary = "Đánh dấu mã đã sử dụng")
    public ResponseEntity<Void> danhDauDaSuDung(@RequestParam Integer maUuDai) {
        apDungUuDaiService.danhDauDaSuDung(maUuDai);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/danh-sach-con-han")
    @Operation(summary = "Danh sách ưu đãi còn hiệu lực")
    public ResponseEntity<List<ApDungUuDaiResponse>> danhSachUuDaiConHan() {
        List<ApDungUuDaiResponse> list = apDungUuDaiService.danhSachUuDaiConHan();
        return ResponseEntity.ok(list);
    }

    @PostMapping("/giam-gia-percent")
    @Operation(summary = "Áp dụng giảm giá %")
    public ResponseEntity<Long> apDungGiamGiaPercent(
            @RequestParam Long tongTien,
            @RequestParam Integer phanTram) {
        Long result = apDungUuDaiService.apDungGiamGiaPercent(tongTien, phanTram);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/giam-gia-co-dinh")
    @Operation(summary = "Áp dụng giảm giá cố định")
    public ResponseEntity<Long> apDungGiamGiaCoDinh(
            @RequestParam Long tongTien,
            @RequestParam Long soTienGiam) {
        Long result = apDungUuDaiService.apDungGiamGiaCoDinh(tongTien, soTienGiam);
        return ResponseEntity.ok(result);
    }
}
