package com.nnice.karaoke.controller;

import com.nnice.karaoke.dto.request.OrderRequest;
import com.nnice.karaoke.dto.response.OrderResponse;
import com.nnice.karaoke.exception.ResourceNotFoundException;
import com.nnice.karaoke.service.QuanLyOrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
@Tag(name = "Quản Lý Order", description = "API quản lý order ăn uống")
public class QuanLyOrderController {

    @Autowired
    private QuanLyOrderService quanLyOrderService;

    @PostMapping
    @Operation(summary = "Tạo order mới cho bàn/phòng")
    public ResponseEntity<OrderResponse> taoOrder(@RequestBody OrderRequest request) {
        OrderResponse created = quanLyOrderService.taoOrder(request);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/{maOrder}")
    @Operation(summary = "Xem chi tiết order")
    public ResponseEntity<OrderResponse> xemChiTiet(@PathVariable Integer maOrder) {
        OrderResponse don = quanLyOrderService.xemChiTiet(maOrder);
        return ResponseEntity.ok(don);
    }

    @PutMapping("/{maOrder}/trang-thai")
    @Operation(summary = "Cập nhật trạng thái order")
    public ResponseEntity<OrderResponse> capNhatTrangThaiOrder(
            @PathVariable Integer maOrder,
            @RequestParam String trangThai) {
        OrderResponse updated = quanLyOrderService.capNhatTrangThaiOrder(maOrder, trangThai);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{maOrder}")
    @Operation(summary = "Hủy order (chỉ hủy được order chưa xử lý)")
    public ResponseEntity<Void> huyOrder(
            @PathVariable Integer maOrder,
            @RequestParam String lyDo) {
        quanLyOrderService.huyOrder(maOrder, lyDo);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/theo-trang-thai")
    @Operation(summary = "Danh sách order theo trạng thái")
    public ResponseEntity<List<OrderResponse>> danhSachOrderTheoDonGoiMon(@RequestParam String trangThai) {
        List<OrderResponse> list = quanLyOrderService.danhSachOrderTheoDonGoiMon(trangThai);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/phieu/{maPhieu}")
    @Operation(summary = "Danh sách order của phòng/phiếu")
    public ResponseEntity<List<OrderResponse>> danhSachOrderCuaPhieu(@PathVariable Integer maPhieu) {
        List<OrderResponse> list = quanLyOrderService.danhSachOrderCuaPhieu(maPhieu);
        return ResponseEntity.ok(list);
    }
}
