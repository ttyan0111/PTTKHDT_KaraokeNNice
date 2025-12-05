package com.nnice.karaoke.util;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Tiện ích tính toán giá cả
 */
public class PriceCalculator {
    
    /**
     * Tính tiền thuê phòng theo giờ
     * @param giaGio - Giá mỗi giờ
     * @param thoiGianVao - Thời gian vào
     * @param thoiGianRa - Thời gian ra
     * @return Tổng tiền
     */
    public static double tinhTienPhong(Double giaGio, LocalDateTime thoiGianVao, LocalDateTime thoiGianRa) {
        if (giaGio == null || thoiGianVao == null || thoiGianRa == null) return 0;
        
        long gioSuDung = ChronoUnit.HOURS.between(thoiGianVao, thoiGianRa);
        
        // Nếu không đủ 1 giờ, tính 1 giờ
        if (gioSuDung == 0) {
            gioSuDung = 1;
        }
        
        return gioSuDung * giaGio;
    }
    
    /**
     * Tính tiền với phí dịch vụ
     * @param tienCo - Tiền ban đầu
     * @param phiDichVu - Phí dịch vụ (%)
     * @return Tổng tiền sau phí
     */
    public static double tinhTienVoiPhiDichVu(double tienCo, double phiDichVu) {
        if (phiDichVu < 0) phiDichVu = 0;
        return tienCo + (tienCo * phiDichVu / 100);
    }
    
    /**
     * Tính tiền với thuế
     * @param tienCo - Tiền ban đầu
     * @param thue - Tỷ lệ thuế (%)
     * @return Tổng tiền sau thuế
     */
    public static double tinhTienVoiThue(double tienCo, double thue) {
        if (thue < 0) thue = 0;
        return tienCo + (tienCo * thue / 100);
    }
    
    /**
     * Tính giá vé VIP (tăng thêm %)
     * @param giaBanThuong - Giá bán thường
     * @param phanTramVIP - Phần trăm tăng thêm
     * @return Giá VIP
     */
    public static double tinhGiaVIP(double giaBanThuong, double phanTramVIP) {
        if (phanTramVIP < 0) phanTramVIP = 0;
        return giaBanThuong + (giaBanThuong * phanTramVIP / 100);
    }
    
    /**
     * Tính giá khuyến mãi (giảm %)
     * @param giaBanThuong - Giá bán thường
     * @param phanTramKhuyenMai - Phần trăm giảm
     * @return Giá sau khuyến mãi
     */
    public static double tinhGiaKhuyenMai(double giaBanThuong, double phanTramKhuyenMai) {
        if (phanTramKhuyenMai < 0) phanTramKhuyenMai = 0;
        return giaBanThuong - (giaBanThuong * phanTramKhuyenMai / 100);
    }
    
    /**
     * Tính tiền ghi nợ hàng tháng
     * @param soNgay - Số ngày ghi nợ
     * @param laiSuatNgay - Lãi suất mỗi ngày (%)
     * @param soTienGhiNo - Số tiền ghi nợ
     * @return Tổng tiền lãi
     */
    public static double tinhLaiSuatGhiNo(int soNgay, double laiSuatNgay, double soTienGhiNo) {
        if (laiSuatNgay < 0) laiSuatNgay = 0;
        return soTienGhiNo * laiSuatNgay / 100 * soNgay;
    }
    
    /**
     * Làm tròn tiền đến 2 chữ số thập phân
     */
    public static double roundPrice(double price) {
        return Math.round(price * 100.0) / 100.0;
    }
    
    /**
     * Định dạng tiền tệ (VND)
     */
    public static String formatCurrency(double price) {
        return String.format("%,.0f", price);
    }

    
}
