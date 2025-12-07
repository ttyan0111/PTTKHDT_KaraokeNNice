package com.nnice.karaoke.service.impl;

import com.nnice.karaoke.dto.request.OrderRequest;
import com.nnice.karaoke.dto.response.OrderResponse;
import com.nnice.karaoke.entity.DonGoiMon;
import com.nnice.karaoke.entity.PhieuSuDung;
import com.nnice.karaoke.repository.DonGoiMonRepository;
import com.nnice.karaoke.repository.PhieuSuDungRepository;
import com.nnice.karaoke.service.QuanLyOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class QuanLyOrderServiceImpl implements QuanLyOrderService {
    
    @Autowired
    private DonGoiMonRepository donGoiMonRepository;
    
    @Autowired
    private PhieuSuDungRepository phieuSuDungRepository;
    
    @Override
    public OrderResponse taoOrder(OrderRequest request) {
        if (request == null || request.getMaPhieuSuDung() == null) {
            throw new RuntimeException("OrderRequest and MaPhieuSuDung cannot be null");
        }
        DonGoiMon order = new DonGoiMon();
        
        PhieuSuDung phieuSuDung = phieuSuDungRepository.findById(request.getMaPhieuSuDung())
                .orElseThrow(() -> new RuntimeException("PhieuSuDung not found with id: " + request.getMaPhieuSuDung()));
        order.setPhieuSuDung(phieuSuDung);
        order.setThoiGianGoi(LocalDateTime.now());
        order.setTrangThai("Đang chờ");
        
        DonGoiMon saved = donGoiMonRepository.save(order);
        return convertToResponse(saved);
    }
    
    @Override
    public OrderResponse xemChiTiet(Integer maOrder) {
        if (maOrder == null) {
            throw new RuntimeException("MaOrder cannot be null");
        }
        DonGoiMon order = donGoiMonRepository.findById(maOrder)
                .orElseThrow(() -> new RuntimeException("DonGoiMon not found with id: " + maOrder));
        return convertToResponse(order);
    }
    
    @Override
    public OrderResponse capNhatTrangThaiOrder(Integer maOrder, String trangThai) {
        if (maOrder == null || trangThai == null) {
            throw new RuntimeException("MaOrder and TrangThai cannot be null");
        }
        DonGoiMon order = donGoiMonRepository.findById(maOrder)
                .orElseThrow(() -> new RuntimeException("DonGoiMon not found with id: " + maOrder));
        order.setTrangThai(trangThai);
        DonGoiMon updated = donGoiMonRepository.save(order);
        return convertToResponse(updated);
    }
    
    @Override
    public void huyOrder(Integer maOrder, String lyDo) {
        if (maOrder == null) {
            throw new RuntimeException("MaOrder cannot be null");
        }
        DonGoiMon order = donGoiMonRepository.findById(maOrder)
                .orElseThrow(() -> new RuntimeException("DonGoiMon not found with id: " + maOrder));
        if ("Đang chờ".equals(order.getTrangThai())) {
            order.setTrangThai("Hủy");
            donGoiMonRepository.save(order);
        }
    }
    
    @Override
    public List<OrderResponse> danhSachOrderTheoDonGoiMon(String trangThai) {
        return donGoiMonRepository.findAll().stream()
                .filter(o -> o.getTrangThai().equals(trangThai))
                .map(this::convertToResponse)
                .toList();
    }
    
    @Override
    public List<OrderResponse> danhSachOrderCuaPhieu(Integer maPhieu) {
        return donGoiMonRepository.findAll()
                .stream()
                .filter(o -> o.getPhieuSuDung() != null && o.getPhieuSuDung().getMaPhieuSuDung().equals(maPhieu))
                .map(this::convertToResponse)
                .toList();
    }
    
    @Override
    public Long tinhTongTienOrder(Integer maOrder) {
        return 0L; // TODO: Implement
    }
    
    private OrderResponse convertToResponse(DonGoiMon order) {
        return OrderResponse.builder()
                .maOrder(order.getMaOrder())
                .maPhieuSuDung(order.getPhieuSuDung() != null ? order.getPhieuSuDung().getMaPhieuSuDung() : null)
                .thoiGianGoi(order.getThoiGianGoi())
                .trangThai(order.getTrangThai())
                .build();
    }
}
