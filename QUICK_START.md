# ⚡ QUICK START GUIDE - KARAOKE NNICE API

## 🚀 Chạy Backend trong 5 phút

### Bước 1: Chuẩn bị Database (2 phút)

```sql
-- Mở MySQL Workbench hoặc Terminal
CREATE DATABASE karaoke_nnice;
USE karaoke_nnice;

-- Import schema
SOURCE d:/VSCodeProjects/PTTTKHDTKaraokeNnice/PTTKHDT_KaraokeNNice/ScriptPTTKHDT.sql;
```

### Bước 2: Cấu hình Database (30 giây)

Mở file: `karaoke-nnice-api/src/main/resources/application.properties`

```properties
# Sửa thông tin kết nối
spring.datasource.url=jdbc:mysql://localhost:3306/karaoke_nnice
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD_HERE  # ⚠️ Đổi password
```

### Bước 3: Build & Run (2 phút)

**Cách 1: Dùng Maven Command**
```bash
cd d:\VSCodeProjects\PTTTKHDTKaraokeNnice\PTTKHDT_KaraokeNNice\karaoke-nnice-api
mvn clean install
mvn spring-boot:run
```

**Cách 2: Dùng VS Code**
1. Mở file `main.java`
2. Nhấn `F5` hoặc Click `Run` button
3. Chọn "Java" environment

**Cách 3: Dùng IntelliJ IDEA**
1. Open project folder `karaoke-nnice-api`
2. Click vào file `main.java`
3. Click nút "Run" (▶️) màu xanh

### Bước 4: Kiểm tra (30 giây)

Mở browser:
```
✅ Application: http://localhost:8080
✅ Swagger UI: http://localhost:8080/swagger-ui.html
✅ API Docs: http://localhost:8080/v3/api-docs
```

Nếu thấy Swagger UI → **THÀNH CÔNG!** 🎉

---

## 🧪 Test API đầu tiên

### Test 1: Tìm phòng trống

**Method:** POST  
**URL:** `http://localhost:8080/api/v1/dat-phong/tim-phong-trong`

**Request Body:**
```json
{
  "soNguoi": 10,
  "thoiGianBatDau": "2025-12-07T18:00:00",
  "thoiGianKetThuc": "2025-12-07T22:00:00",
  "maCoSo": 1
}
```

**Expected Response:**
```json
{
  "success": true,
  "message": "Tìm thấy X phòng trống phù hợp",
  "data": [...]
}
```

### Test 2: Tạo đặt phòng

**Method:** POST  
**URL:** `http://localhost:8080/api/v1/dat-phong`

**Request Body:**
```json
{
  "tenKH": "Test User",
  "sdt": "0901234567",
  "email": "test@email.com",
  "soNguoi": 10,
  "gioDat": "2025-12-07T18:00:00",
  "gioKetThuc": "2025-12-07T22:00:00",
  "maPhong": 1,
  "maCoSo": 1
}
```

---

## ⚠️ Troubleshooting

### Lỗi: Cannot connect to database
```
❌ Error: Access denied for user 'root'@'localhost'

✅ Fix:
1. Kiểm tra MySQL đang chạy
2. Kiểm tra username/password trong application.properties
3. Thử connect bằng MySQL Workbench trước
```

### Lỗi: Port 8080 already in use
```
❌ Error: Port 8080 is already in use

✅ Fix 1: Dừng ứng dụng đang chạy port 8080
✅ Fix 2: Đổi port trong application.properties:
   server.port=8081
```

### Lỗi: Cannot resolve symbol 'Lombok'
```
❌ Error: Cannot find symbol: method builder()

✅ Fix (VS Code):
1. Install "Lombok Annotations Support" extension
2. Reload VS Code

✅ Fix (IntelliJ):
1. Install Lombok plugin
2. Enable "Annotation Processing"
   Settings → Build → Compiler → Annotation Processors
```

### Lỗi: Table doesn't exist
```
❌ Error: Table 'karaoke_nnice.khachhang' doesn't exist

✅ Fix:
1. Chạy lại script SQL
2. Kiểm tra database name trong application.properties
```

---

## 📚 Các Tài Liệu Quan Trọng

| File | Mô tả | Độ ưu tiên |
|------|-------|------------|
| `API_DOCUMENTATION.md` | Chi tiết API (700+ dòng) | ⭐⭐⭐⭐⭐ |
| `IMPLEMENTATION_SUMMARY.md` | Tóm tắt implementation | ⭐⭐⭐⭐⭐ |
| `QUICK_START.md` | File này | ⭐⭐⭐⭐ |
| `ARCHITECTURE.md` | Kiến trúc hệ thống | ⭐⭐⭐ |

---

## 🎯 Test Flow Hoàn Chỉnh

### Scenario: Đặt phòng → Check-in → Order → Check-out → Thanh toán

```
1. POST /api/v1/dat-phong/tim-phong-trong
   → Tìm phòng trống

2. POST /api/v1/dat-phong
   → Tạo đặt phòng (lưu maPhieuDat)

3. POST /api/v1/check-in
   → Check-in (lưu maPhieuSuDung)

4. POST /api/v1/order
   → Gọi đồ ăn/uống

5. PUT /api/v1/order/{id}/trang-thai
   → Cập nhật trạng thái "Hoàn thành"

6. POST /api/v1/check-in/check-out
   → Check-out

7. GET /api/v1/thanh-toan/tinh-toan/{maPhieuSuDung}
   → Xem tổng hóa đơn

8. POST /api/v1/thanh-toan
   → Thanh toán
```

---

## 💡 Tips

### Tip 1: Insert Sample Data
```sql
-- Chèn dữ liệu mẫu để test
INSERT INTO coso (TenCS, DiaChi, SDT) VALUES 
('Karaoke NNice Q1', '123 Nguyễn Huệ, Q1', '0901111111');

INSERT INTO loaiphong (TenLoai, SucChua, GiaTheoGio, MoTa) VALUES 
('VIP', 15, 200000, 'Phòng VIP cao cấp'),
('Standard', 10, 100000, 'Phòng tiêu chuẩn');

INSERT INTO phong (TenPhong, MaLoai, MaCS, TrangThai) VALUES 
('Phòng VIP 01', 1, 1, 'Trống'),
('Phòng VIP 02', 1, 1, 'Trống'),
('Phòng STD 01', 2, 1, 'Trống');
```

### Tip 2: Hot Reload
```properties
# Thêm vào application-dev.properties để auto-reload
spring.devtools.restart.enabled=true
```

### Tip 3: View SQL Queries
```properties
# Xem SQL được execute
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

---

## 📞 Cần Trợ Giúp?

### Các vấn đề thường gặp:

1. **Database connection issues**
   - Check MySQL service đang chạy
   - Verify credentials

2. **Lombok not working**
   - Install Lombok plugin/extension
   - Enable annotation processing

3. **Port already in use**
   - Change port in application.properties
   - Kill process using port 8080

4. **Maven build failed**
   - Check internet connection (download dependencies)
   - Try `mvn clean install -U`

---

## ✅ Checklist Trước Khi Demo

- [ ] MySQL đang chạy
- [ ] Database `karaoke_nnice` đã được tạo
- [ ] Script SQL đã import thành công
- [ ] Application.properties đã config đúng
- [ ] Application chạy thành công (port 8080)
- [ ] Swagger UI mở được
- [ ] Test ít nhất 1 API thành công
- [ ] Có data mẫu trong database

---

**🎉 DONE! Bạn đã sẵn sàng phát triển và demo!**

---

*Quick Start Guide - Karaoke NNice API*  
*Last Updated: December 6, 2025*
