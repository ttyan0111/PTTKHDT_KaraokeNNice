package com.nnice.karaoke.service.impl;

import com.nnice.karaoke.dto.request.OrderRequest;
import com.nnice.karaoke.dto.response.OrderResponse;
import com.nnice.karaoke.entity.DonGoiMon;
import com.nnice.karaoke.repository.DonGoiMonRepository;
import com.nnice.karaoke.service.QuanLyOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class QuanLyOrderServiceImpl implements QuanLyOrderService {
    
    @Autowired
    private DonGoiMonRepository donGoiMonRepository;
    
    @Override
    public OrderResponse taoOrder(OrderRequest request) {
        DonGoiMon order = new DonGoiMon();
        order.setMaPhieuSuDung(request.getMaPhieuSuDung());
        order.setTrangThai("Đang chờ");
        
        DonGoiMon saved = donGoiMonRepository.save(order);
        return convertToResponse(saved);
    }
    
    @Override
    public OrderResponse xemChiTiet(Integer maOrder) {
        Optional<DonGoiMon> order = donGoiMonRepository.findById(maOrder);
        return order.map(this::convertToResponse).orElse(null);
    }
    
    @Override
    public OrderResponse capNhatTrangThaiOrder(Integer maOrder, String trangThai) {
        Optional<DonGoiMon> order = donGoiMonRepository.findById(maOrder);
        if (order.isPresent()) {
            order.get().setTrangThai(trangThai);
            DonGoiMon updated = donGoiMonRepository.save(order.get());
            return convertToResponse(updated);
        }
        return null;
    }
    
    @Override
    public void huyOrder(Integer maOrder, String lyDo) {
        Optional<DonGoiMon> order = donGoiMonRepository.findById(maOrder);
        if (order.isPresent() && "Đang chờ".equals(order.get().getTrangThai())) {
            order.get().setTrangThai("Hủy");
            donGoiMonRepository.save(order.get());
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
                .filter(o -> o.getMaPhieuSuDung().equals(maPhieu))
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
                .maPhieuSuDung(order.getMaPhieuSuDung())
                .thoiGianGoi(order.getThoiGianGoi())
                .trangThai(order.getTrangThai())
                .build();
    }
}
