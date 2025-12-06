package com.nnice.karaoke.controller;

import com.nnice.karaoke.entity.PhieuDatPhong;
import com.nnice.karaoke.service.GhiNhanKhachTuDoiTacService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/ghi-nhan-khach-tu-doi-tac")
@Tag(name = "Ghi Nhận Khách Từ Đối Tác", description = "API ghi nhận khách từ đối tác")
public class GhiNhanKhachTuDoiTacController {

    @Autowired
    private GhiNhanKhachTuDoiTacService ghiNhanKhachTuDoiTacService;

    @PostMapping("/chon-doi-tac")
    @Operation(summary = "Chọn đối tác")
    public ResponseEntity<Void> chonDoiTac(@RequestParam Integer maDoiTac) {
        ghiNhanKhachTuDoiTacService.chonDoiTac(maDoiTac);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/nhap-thong-tin-khach")
    @Operation(summary = "Nhập mã booking từ đối tác")
    public ResponseEntity<PhieuDatPhong> nhapThongTinKhach(
            @RequestParam Integer maDoiTac,
            @RequestParam String maBooking) {
        Optional<PhieuDatPhong> result = ghiNhanKhachTuDoiTacService.nhapThongTinKhach(maDoiTac, maBooking);
        return result.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/xac-thuc-doi-tac")
    @Operation(summary = "Xác thực với hệ thống đối tác")
    public ResponseEntity<Boolean> xacThucVoiDoiTac(
            @RequestParam Integer maDoiTac,
            @RequestParam String maBooking) {
        boolean result = ghiNhanKhachTuDoiTacService.xacThucVoiDoiTac(maDoiTac, maBooking);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/tinh-hoa-hong")
    @Operation(summary = "Tính hoa hồng cho đối tác")
    public ResponseEntity<Long> tinhHoaHong(
            @RequestParam Long tongTien,
            @RequestParam Integer maDoiTac) {
        Long result = ghiNhanKhachTuDoiTacService.tinhHoaHong(tongTien, maDoiTac);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/tao-don-tu-doi-tac")
    @Operation(summary = "Tạo đơn đặt phòng từ đối tác")
    public ResponseEntity<PhieuDatPhong> taoDonDatPhongTuDoiTac(
            @RequestParam Integer maDoiTac,
            @RequestBody PhieuDatPhong phieuDatPhong) {
        PhieuDatPhong result = ghiNhanKhachTuDoiTacService.taoDonDatPhongTuDoiTac(maDoiTac, phieuDatPhong);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/cap-nhat-cong-no")
    @Operation(summary = "Cập nhật công nợ với đối tác")
    public ResponseEntity<Void> capNhatCongNoDoiTac(
            @RequestParam Integer maDoiTac,
            @RequestParam Long soTien) {
        ghiNhanKhachTuDoiTacService.capNhatCongNoDoiTac(maDoiTac, soTien);
        return ResponseEntity.ok().build();
    }
}
