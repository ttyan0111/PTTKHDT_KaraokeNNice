package com.nnice.karaoke.controller;

import com.nnice.karaoke.dto.request.TichDiemRequest;
import com.nnice.karaoke.dto.response.ThanhVienResponse;
import com.nnice.karaoke.service.CapNhatDiemTichLuyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tich-luy-diem")
@Tag(name = "Cập Nhật Điểm Tích Lũy", description = "API quản lý tích điểm và nâng hạng thành viên")
public class CapNhatDiemTichLuyController {

    @Autowired
    private CapNhatDiemTichLuyService capNhatDiemTichLuyService;

    @PostMapping("/tich-diem")
    public ResponseEntity<Void> tichDiem(@RequestBody TichDiemRequest request) {
        capNhatDiemTichLuyService.tichDiem(request.getMaThanhVien(), request.getTongTien());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/kiem-tra-dieu-kien-nang-hang")
    @Operation(summary = "Kiểm tra điều kiện nâng hạng")
    public ResponseEntity<String> kiemTraDieuKienNangHang(@RequestParam Integer diemHienTai) {
        String result = capNhatDiemTichLuyService.kiemTraDieuKienNangHang(diemHienTai);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/nang-hang-tu-dong")
    @Operation(summary = "Nâng hạng tự động")
    public ResponseEntity<Void> nangHangTuDong(@RequestParam Integer maThanhVien) {
        capNhatDiemTichLuyService.nangHangTuDong(maThanhVien);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/ghi-lich-su-tich-diem")
    @Operation(summary = "Ghi lịch sử tích điểm")
    public ResponseEntity<Void> ghiLichSuTichDiem(
            @RequestParam Integer maThanhVien,
            @RequestParam Long soTienThanhToan,
            @RequestParam int diemCong) {
        capNhatDiemTichLuyService.ghiLichSuTichDiem(maThanhVien, soTienThanhToan, diemCong);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{maThanhVien}")
    @Operation(summary = "Xem thông tin thành viên (điểm, hạng)")
    public ResponseEntity<ThanhVienResponse> xemThongTinThanhVien(@PathVariable Integer maThanhVien) {
        ThanhVienResponse member = capNhatDiemTichLuyService.xemThongTinThanhVien(maThanhVien);
        return ResponseEntity.ok(member);
    }

    @GetMapping("/lich-su/{maThanhVien}")
    @Operation(summary = "Xem lịch sử tích điểm")
    public ResponseEntity<Void> xemLichSuTichDiem(@PathVariable Integer maThanhVien) {
        capNhatDiemTichLuyService.xemLichSuTichDiem(maThanhVien);
        return ResponseEntity.ok().build();
    }
}
