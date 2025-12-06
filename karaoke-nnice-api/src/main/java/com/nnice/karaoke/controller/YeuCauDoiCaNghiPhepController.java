package com.nnice.karaoke.controller;

import com.nnice.karaoke.service.YeuCauDoiCaNghiPhepService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/yeu-cau-doi-ca-nghi-phep")
@Tag(name = "Yêu Cầu Đổi Ca Nghỉ Phép", description = "API quản lý yêu cầu đổi ca và nghỉ phép")
public class YeuCauDoiCaNghiPhepController {

    @Autowired
    private YeuCauDoiCaNghiPhepService yeuCauDoiCaNghiPhepService;

    @PostMapping("/yeu-cau-doi-ca")
    @Operation(summary = "Yêu cầu đổi ca")
    public ResponseEntity<Void> yeuCauDoiCa(
            @RequestParam Integer maNhanVien,
            @RequestParam Integer caCu,
            @RequestParam Integer caMoi,
            @RequestParam String lyDo) {
        yeuCauDoiCaNghiPhepService.yeuCauDoiCa(maNhanVien, caCu, caMoi, lyDo);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/yeu-cau-nghi-phep")
    @Operation(summary = "Yêu cầu nghỉ phép")
    public ResponseEntity<Void> yeuCauNghiPhep(
            @RequestParam Integer maNhanVien,
            @RequestParam LocalDate ngayBatDau,
            @RequestParam LocalDate ngayKetThuc,
            @RequestParam String loaiPhep,
            @RequestParam String lyDo) {
        yeuCauDoiCaNghiPhepService.yeuCauNghiPhep(maNhanVien, ngayBatDau, ngayKetThuc, loaiPhep, lyDo);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/kiem-tra-ngay-phep-con-lai/{maNhanVien}")
    @Operation(summary = "Kiểm tra số ngày phép còn lại")
    public ResponseEntity<Integer> kiemTraNgayPhepConLai(@PathVariable Integer maNhanVien) {
        int result = yeuCauDoiCaNghiPhepService.kiemTraNgayPhepConLai(maNhanVien);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/kiem-tra-ca-khong-trung")
    @Operation(summary = "Kiểm tra ca thay thế không trùng")
    public ResponseEntity<Boolean> kiemTraCaKhongTrung(
            @RequestParam Integer caMoi,
            @RequestParam LocalDate ngayLamViec) {
        boolean result = yeuCauDoiCaNghiPhepService.kiemTraCaKhongTrung(caMoi, ngayLamViec);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/danh-sach-yeu-cau-cho-duyet")
    @Operation(summary = "Xem danh sách yêu cầu chờ duyệt")
    public ResponseEntity<List<Object>> danhSachYeuCauChoDuyet() {
        List<Object> result = yeuCauDoiCaNghiPhepService.danhSachYeuCauChoDuyet();
        return ResponseEntity.ok(result);
    }

    @PostMapping("/phe-duyet-yeu-cau/{maYeuCau}")
    @Operation(summary = "Phê duyệt yêu cầu")
    public ResponseEntity<Void> pheDuyetYeuCau(@PathVariable Integer maYeuCau) {
        yeuCauDoiCaNghiPhepService.pheDuyetYeuCau(maYeuCau);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/tu-choi-yeu-cau/{maYeuCau}")
    @Operation(summary = "Từ chối yêu cầu")
    public ResponseEntity<Void> tuChoiYeuCau(
            @PathVariable Integer maYeuCau,
            @RequestParam String lyDo) {
        yeuCauDoiCaNghiPhepService.tuChoiYeuCau(maYeuCau, lyDo);
        return ResponseEntity.ok().build();
    }
}
