package com.nnice.karaoke.controller;

import com.nnice.karaoke.dto.request.CheckInRequest;
import com.nnice.karaoke.dto.request.CheckOutRequest;
import com.nnice.karaoke.dto.response.CheckInResponse;
import com.nnice.karaoke.dto.response.CheckOutResponse;
import com.nnice.karaoke.exception.ResourceNotFoundException;
import com.nnice.karaoke.service.ThucHienCheckInService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/check-in")
@Tag(name = "Thực Hiện Check In", description = "API thực hiện check in khách")
public class ThucHienCheckInController {

    @Autowired
    private ThucHienCheckInService thucHienCheckInService;

    @GetMapping("/tra-cuu/{maDat}")
    @Operation(summary = "Tra cứu đơn đặt phòng để check-in")
    public ResponseEntity<CheckInResponse> traCuuPhieuDatPhong(@PathVariable String maDat) {
        CheckInResponse phieu = thucHienCheckInService.traCuuPhieuDatPhong(maDat);
        return ResponseEntity.ok(phieu);
    }

    @PostMapping("/xac-nhan-khach")
    @Operation(summary = "Xác nhận thông tin khách (CMND/CCCD, số người)")
    public ResponseEntity<Void> xacNhanThongTinKhach(
            @RequestParam Integer maPhieu,
            @RequestParam String soCMND,
            @RequestParam int soNguoiThuc) {
        thucHienCheckInService.xacNhanThongTinKhach(maPhieu, soCMND, soNguoiThuc);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/check-in")
    @Operation(summary = "Check-in: ghi nhận thời gian vào")
    public ResponseEntity<CheckInResponse> thucHienCheckIn(@RequestBody CheckInRequest request) {
        CheckInResponse phieu = thucHienCheckInService.thucHienCheckIn(request);
        return ResponseEntity.ok(phieu);
    }

    @PostMapping("/check-out")
    @Operation(summary = "Check-out: ghi nhận thời gian ra")
    public ResponseEntity<CheckOutResponse> thucHienCheckOut(@RequestBody CheckOutRequest request) {
        CheckOutResponse phieu = thucHienCheckInService.thucHienCheckOut(request);
        return ResponseEntity.ok(phieu);
    }
}
