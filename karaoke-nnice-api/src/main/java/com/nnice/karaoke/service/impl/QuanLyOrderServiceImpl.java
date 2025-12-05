package com.nnice.karaoke.service.impl;

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
    public DonGoiMon taoOrder(DonGoiMon donGoiMon) {
        return donGoiMonRepository.save(donGoiMon);
    }
    
    @Override
    public Optional<DonGoiMon> xemChiTiet(Integer maOrder) {
        return donGoiMonRepository.findById(maOrder);
    }
    
    @Override
    public DonGoiMon capNhatTrangThaiOrder(Integer maOrder, String trangThai) {
        Optional<DonGoiMon> order = donGoiMonRepository.findById(maOrder);
        if (order.isPresent()) {
            order.get().setTrangThai(trangThai);
            return donGoiMonRepository.save(order.get());
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
    public List<DonGoiMon> danhSachOrderTheoDonGoiMon(String trangThai) {
        return donGoiMonRepository.findAll().stream()
                .filter(o -> o.getTrangThai().equals(trangThai))
                .toList();
    }
    
    @Override
    public List<DonGoiMon> danhSachOrderCuaPhieu(Integer maPhieu) {
        return donGoiMonRepository.findAll(); // TODO: Filter by phieu
    }
    
    @Override
    public Long tinhTongTienOrder(Integer maOrder) {
        return 0L; // TODO: Implement
    }
}
