package com.nnice.karaoke.service.impl;

import com.nnice.karaoke.service.YeuCauDoiCaNghiPhepService;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class YeuCauDoiCaNghiPhepServiceImpl implements YeuCauDoiCaNghiPhepService {
    
    @Override
    public void yeuCauDoiCa(Integer maNhanVien, Integer caCu, Integer caMoi, String lyDo) {
        // TODO: Implement
    }
    
    @Override
    public void yeuCauNghiPhep(Integer maNhanVien, LocalDate ngayBatDau, LocalDate ngayKetThuc, 
                               String loaiPhep, String lyDo) {
        // TODO: Implement
    }
    
    @Override
    public int kiemTraNgayPhepConLai(Integer maNhanVien) {
        return 0; // TODO: Implement
    }
    
    @Override
    public boolean kiemTraCaKhongTrung(Integer caMoi, LocalDate ngayLamViec) {
        return true; // TODO: Implement
    }
    
    @Override
    public List<Object> danhSachYeuCauChoDuyet() {
        return new ArrayList<>(); // TODO: Implement
    }
    
    @Override
    public void pheDuyetYeuCau(Integer maYeuCau) {
        // TODO: Implement
    }
    
    @Override
    public void tuChoiYeuCau(Integer maYeuCau, String lyDo) {
        // TODO: Implement
    }
}
