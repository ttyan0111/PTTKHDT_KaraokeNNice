package com.nnice.karaoke.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface ThongKeService {
    // Báo cáo doanh thu theo cơ sở
    Map<String, Object> baoCaoDanhThuTheoCoso(LocalDate tuNgay, LocalDate denNgay, Integer maCS);
    
    // Báo cáo doanh thu theo loại dịch vụ
    Map<String, Object> baoCaoDanhThuTheoLoaiDichVu(LocalDate tuNgay, LocalDate denNgay);
    
    // Báo cáo so sánh giữa các kỳ
    Map<String, Object> baoCaoSoSanhKy(int kyTruoc, int kyHienTai);
    
    // Tỷ lệ lấp đầy phòng
    Double tyLeLapDayPhong(LocalDate ngay, Integer maCS);
    
    // Thời gian sử dụng trung bình
    Long thoiGianSuDungTrungBinh(LocalDate tuNgay, LocalDate denNgay);
    
    // Phòng được ưa chuộng
    List<Map<String, Object>> phongUaThuong(int soLuong);
    
    // Món ăn bán chạy
    List<Map<String, Object>> monAnBanChay(int soLuong);
    
    // Khung giờ cao điểm
    List<Map<String, Object>> khungGioCaoDiem();
    
    // Báo cáo khách hàng mới/cũ
    Map<String, Object> baoCaoKhachNewVsOld(LocalDate tuNgay, LocalDate denNgay);
    
    // Top khách chi tiêu cao
    List<Map<String, Object>> topKhachChiTieuCao(int soLuong);
    
    // Tần suất quay lại
    Map<String, Object> tanSuatQuayLai(Integer maKhach);
    
    // Phân tích theo nguồn đối tác
    Map<String, Object> phanTichTheoNguonDoiTac(LocalDate tuNgay, LocalDate denNgay);
    
    // Báo cáo kho
    Map<String, Object> baoCaoKho();
    
    // Báo cáo nhân viên
    Map<String, Object> baoCaoNhanVien(int thang, int nam);
}
