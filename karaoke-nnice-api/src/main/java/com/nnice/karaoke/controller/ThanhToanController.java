package com.nnice.karaoke.controller;

import com.nnice.karaoke.dto.request.ThanhToanRequest;
import com.nnice.karaoke.dto.response.ThanhToanResponse;
import com.nnice.karaoke.exception.ResourceNotFoundException;
import com.nnice.karaoke.service.ThanhToanService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/thanh-toan")
@Tag(name = "Quản Lý Thanh Toán", description = "API quản lý thanh toán")
public class ThanhToanController {

    @Autowired
    private ThanhToanService thanhToanService;

    @PostMapping("/hoa-don")
    @Operation(summary = "Tạo hóa đơn từ phiếu sử dụng")
    public ResponseEntity<ThanhToanResponse> taoHoaDon(@RequestParam Integer maPhieuSuDung) {
        ThanhToanResponse hoaDon = thanhToanService.taoHoaDon(maPhieuSuDung);
        return ResponseEntity.ok(hoaDon);
    }

    @GetMapping("/tien-phong")
    @Operation(summary = "Tính tổng tiền phòng")
    public ResponseEntity<Long> tinhTienPhong(@RequestParam Integer maPhieu) {
        Long tienPhong = thanhToanService.tinhTienPhong(maPhieu);
        return ResponseEntity.ok(tienPhong);
    }

    @GetMapping("/tien-an-uong")
    @Operation(summary = "Tính tiền dịch vụ ăn uống")
    public ResponseEntity<Long> tinhTienAnUong(@RequestParam Integer maPhieu) {
        Long tienAnUong = thanhToanService.tinhTienAnUong(maPhieu);
        return ResponseEntity.ok(tienAnUong);
    }

    @GetMapping("/tien-tiec")
    @Operation(summary = "Tính tiền tiệc")
    public ResponseEntity<Long> tinhTienTiec(@RequestParam Integer maTiec) {
        Long tienTiec = thanhToanService.tinhTienTiec(maTiec);
        return ResponseEntity.ok(tienTiec);
    }

    @GetMapping("/vat")
    @Operation(summary = "Tính VAT")
    public ResponseEntity<Long> tinhVAT(@RequestParam Long tongTien) {
        Long vat = thanhToanService.tinhVAT(tongTien);
        return ResponseEntity.ok(vat);
    }

    @GetMapping("/tru-tien-coc")
    @Operation(summary = "Trừ tiền cọc")
    public ResponseEntity<Long> truTienCoc(
            @RequestParam Integer maPhieu,
            @RequestParam Long tongTien) {
        Long result = thanhToanService.truTienCoc(maPhieu, tongTien);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/ap-dung-uu-dai")
    @Operation(summary = "Áp dụng ưu đãi")
    public ResponseEntity<Long> apDungUuDai(
            @RequestParam Long tongTien,
            @RequestParam Integer maUuDai) {
        Long result = thanhToanService.apDungUuDai(tongTien, maUuDai);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/xu-ly-thanh-toan")
    @Operation(summary = "Xử lý thanh toán")
    public ResponseEntity<Void> xuLyThanhToan(@RequestBody ThanhToanRequest request) {
        thanhToanService.xuLyThanhToan(request.getMaHoaDon(), request.getSoTien().longValue(), request.getHinhThuc());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{maHoaDon}")
    @Operation(summary = "Xem chi tiết hóa đơn")
    public ResponseEntity<ThanhToanResponse> xemChiTiet(@PathVariable Integer maHoaDon) {
        ThanhToanResponse hoaDon = thanhToanService.xemChiTiet(maHoaDon);
        return ResponseEntity.ok(hoaDon);
    }

    @PostMapping("/tich-diem")
    @Operation(summary = "Tích điểm cho thành viên")
    public ResponseEntity<Void> tichDiem(
            @RequestParam Integer maKhach,
            @RequestParam Long tongTien) {
        thanhToanService.tichDiem(maKhach, tongTien);
        return ResponseEntity.ok().build();
    }
}
