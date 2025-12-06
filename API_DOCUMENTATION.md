# 📚 KARAOKE NNICE - API DOCUMENTATION
# Tài liệu API Backend cho Đồ Án Phân Tích Thiết Kế Hướng Đối Tượng

**Version:** 1.0.0  
**Last Updated:** December 6, 2025  
**Backend:** Java Spring Boot 3.2.12  
**Database:** MySQL  
**Author:** PTT Karaoke NNice Team

---

## 📋 MỤC LỤC

1. [Tổng quan hệ thống](#1-tổng-quan-hệ-thống)
2. [Kiến trúc hệ thống](#2-kiến-trúc-hệ-thống)
3. [API Endpoints chi tiết](#3-api-endpoints-chi-tiết)
4. [Use Cases Implementation](#4-use-cases-implementation)
5. [Database Schema](#5-database-schema)
6. [Hướng dẫn chạy project](#6-hướng-dẫn-chạy-project)
7. [Testing Guide](#7-testing-guide)

---

## 1. TỔNG QUAN HỆ THỐNG

### 1.1. Mô tả hệ thống
Hệ thống Quản Lý Karaoke NNice là một ứng dụng web toàn diện phục vụ việc quản lý các hoạt động kinh doanh của chuỗi karaoke, bao gồm:

- ✅ **Quản lý đặt phòng & check-in/check-out**
- ✅ **Quản lý đặt tiệc & gói tiệc**
- ✅ **Quản lý order đồ ăn/uống**
- ✅ **Quản lý kho (nhập/xuất/kiểm kê)**
- ✅ **Quản lý nhân viên (chấm công, lương, ca làm)**
- ✅ **Quản lý khách hàng & thành viên thân thiết**
- ✅ **Hệ thống thanh toán & ưu đãi**
- ✅ **Báo cáo thống kê doanh thu**

### 1.2. Tech Stack

**Backend:**
- Java 21
- Spring Boot 3.2.12
- Spring Data JPA
- Spring Security
- MySQL Connector
- Lombok
- Swagger/OpenAPI 3.0

**Database:**
- MySQL 8.0+

**Tools:**
- Maven
- Git

---

## 2. KIẾN TRÚC HỆ THỐNG

### 2.1. Layered Architecture (Kiến trúc phân tầng)

```
┌─────────────────────────────────────────────┐
│          FRONTEND (React)                   │
│         (Chưa implement)                    │
└──────────────────┬──────────────────────────┘
                   │ HTTP/REST API
┌──────────────────▼──────────────────────────┐
│     CONTROLLER LAYER (REST Controllers)     │
│  - DatPhongController                       │
│  - CheckInController                        │
│  - OrderController                          │
│  - ...                                      │
└──────────────────┬──────────────────────────┘
                   │
┌──────────────────▼──────────────────────────┐
│     SERVICE LAYER (Business Logic)          │
│  - QuanLyDatPhongService                    │
│  - ThucHienCheckInService                   │
│  - QuanLyOrderService                       │
│  - ...                                      │
└──────────────────┬──────────────────────────┘
                   │
┌──────────────────▼──────────────────────────┐
│     REPOSITORY LAYER (Data Access)          │
│  - PhieuDatPhongRepository                  │
│  - PhongRepository                          │
│  - KhachHangRepository                      │
│  - ...                                      │
└──────────────────┬──────────────────────────┘
                   │ JPA/Hibernate
┌──────────────────▼──────────────────────────┐
│          DATABASE (MySQL)                   │
│  - Tables: khachhang, phong, ...            │
└─────────────────────────────────────────────┘
```

### 2.2. Package Structure

```
com.nnice.karaoke/
├── config/               # Cấu hình (Security, Swagger, DB)
│   ├── DatabaseConfig.java
│   ├── SecurityConfig.java
│   └── SwaggerConfig.java
├── controller/           # REST Controllers
│   ├── DatPhongController.java
│   ├── CheckInController.java
│   └── ...
├── dto/                  # Data Transfer Objects
│   ├── request/
│   │   ├── DatPhongRequest.java
│   │   ├── CheckInRequest.java
│   │   └── ...
│   └── response/
│       ├── DatPhongResponse.java
│       ├── CheckInResponse.java
│       └── ...
├── entity/               # JPA Entities (Models)
│   ├── KhachHang.java
│   ├── Phong.java
│   ├── PhieuDatPhong.java
│   └── ...
├── repository/           # Spring Data JPA Repositories
│   ├── KhachHangRepository.java
│   ├── PhongRepository.java
│   └── ...
├── service/              # Service Interfaces
│   ├── QuanLyDatPhongService.java
│   └── ...
├── service/impl/         # Service Implementations
│   ├── QuanLyDatPhongServiceImpl.java
│   └── ...
├── exception/            # Custom Exceptions
│   ├── BusinessException.java
│   ├── ResourceNotFoundException.java
│   └── GlobalExceptionHandler.java
└── util/                 # Utility Classes
```

### 2.3. Design Patterns Áp dụng

1. **Layered Architecture Pattern** - Phân tầng rõ ràng (Controller → Service → Repository)
2. **Repository Pattern** - Trừu tượng hóa data access
3. **DTO Pattern** - Tách biệt API contract và entity
4. **Builder Pattern** - Xây dựng objects (sử dụng Lombok @Builder)
5. **Dependency Injection** - Spring IoC Container
6. **Exception Handling Pattern** - Global exception handler

---

## 3. API ENDPOINTS CHI TIẾT

### 3.1. Module: QUẢN LÝ ĐẶT PHÒNG

Base URL: `/api/v1/dat-phong`

#### 3.1.1. Tìm Phòng Trống

**Endpoint:** `POST /api/v1/dat-phong/tim-phong-trong`

**Use Case:** UC_QuanLyDatPhong - Bước tìm phòng phù hợp

**Description:** Tìm kiếm các phòng trống phù hợp với yêu cầu của khách (số người, thời gian, loại phòng)

**Request Body:**
```json
{
  "soNguoi": 10,
  "thoiGianBatDau": "2025-12-06T18:00:00",
  "thoiGianKetThuc": "2025-12-06T22:00:00",
  "maCoSo": 1,
  "maLoaiPhong": null
}
```

**Response 200 OK:**
```json
{
  "success": true,
  "message": "Tìm thấy 3 phòng trống phù hợp",
  "data": [
    {
      "maPhong": 5,
      "tenPhong": "Phòng VIP 01",
      "trangThai": "Trống",
      "maLoaiPhong": 1,
      "tenLoaiPhong": "VIP",
      "sucChua": 15,
      "giaTheoGio": 200000,
      "maCoSo": 1,
      "tenCoSo": "Karaoke NNice Quận 1",
      "diaChiCoSo": "123 Nguyễn Huệ, Q1, HCM",
      "chiPhiDuKien": 800000,
      "soGioDuKien": 4.0,
      "moTa": "Phòng VIP - Sức chứa 15 người"
    }
  ]
}
```

**Response 404 Not Found:**
```json
{
  "success": false,
  "message": "Không tìm thấy phòng trống phù hợp",
  "error": "NO_ROOM_AVAILABLE"
}
```

---

#### 3.1.2. Tạo Phiếu Đặt Phòng

**Endpoint:** `POST /api/v1/dat-phong`

**Use Case:** UC_QuanLyDatPhong - Tạo đặt phòng mới

**Description:** Tiếp tân tạo phiếu đặt phòng cho khách hàng

**Request Body:**
```json
{
  "tenKH": "Nguyễn Văn A",
  "sdt": "0901234567",
  "email": "nguyenvana@email.com",
  "soNguoi": 10,
  "gioDat": "2025-12-06T18:00:00",
  "gioKetThuc": "2025-12-06T22:00:00",
  "maPhong": 5,
  "maCoSo": 1,
  "ghiChu": "Khách yêu cầu trang trí sinh nhật",
  "maDoiTac": null,
  "maKhach": null
}
```

**Response 201 Created:**
```json
{
  "success": true,
  "message": "Đặt phòng thành công",
  "data": {
    "maPhieuDat": 123,
    "maDatPhongString": "DP2025000123",
    "maKhachHang": 45,
    "tenKhachHang": "Nguyễn Văn A",
    "soDienThoai": "0901234567",
    "email": "nguyenvana@email.com",
    "maPhong": 5,
    "tenPhong": "Phòng VIP 01",
    "tenLoaiPhong": "VIP",
    "ngayDat": "2025-12-06T14:30:00",
    "thoiGianBatDau": "2025-12-06T18:00:00",
    "thoiGianKetThuc": "2025-12-06T22:00:00",
    "soGioDuKien": 4.0,
    "chiPhiDuKien": 800000,
    "tienCoc": 240000,
    "trangThai": "Đã đặt",
    "ghiChu": "Khách yêu cầu trang trí sinh nhật",
    "tenDoiTac": null,
    "thongBao": "Đặt phòng thành công. SMS xác nhận đã được gửi đến 0901234567"
  }
}
```

**Response 400 Bad Request:**
```json
{
  "success": false,
  "message": "Phòng đã được đặt trong khoảng thời gian này",
  "error": "ROOM_ALREADY_BOOKED"
}
```

---

#### 3.1.3. Xem Chi Tiết Đặt Phòng

**Endpoint:** `GET /api/v1/dat-phong/{maPhieuDat}`

**Description:** Xem thông tin chi tiết phiếu đặt phòng

**Response 200 OK:**
```json
{
  "success": true,
  "data": {
    "maPhieuDat": 123,
    "maDatPhongString": "DP2025000123",
    "tenKhachHang": "Nguyễn Văn A",
    "soDienThoai": "0901234567",
    "tenPhong": "Phòng VIP 01",
    "trangThai": "Đã đặt",
    ...
  }
}
```

---

#### 3.1.4. Cập Nhật Đặt Phòng

**Endpoint:** `PUT /api/v1/dat-phong/{maPhieuDat}`

**Description:** Cập nhật thông tin đặt phòng (chỉ khi chưa check-in)

**Request Body:**
```json
{
  "tenKH": "Nguyễn Văn A",
  "sdt": "0901234567",
  "soNguoi": 12,
  "gioDat": "2025-12-06T19:00:00",
  "gioKetThuc": "2025-12-06T23:00:00",
  "ghiChu": "Thay đổi giờ đến"
}
```

---

#### 3.1.5. Hủy Đặt Phòng

**Endpoint:** `DELETE /api/v1/dat-phong/{maPhieuDat}`

**Query Params:** `lyDoHuy` (string, required)

**Example:** `DELETE /api/v1/dat-phong/123?lyDoHuy=Khach huy dot xuat`

**Response 200 OK:**
```json
{
  "success": true,
  "message": "Đã hủy phiếu đặt phòng thành công",
  "data": {
    "maPhieuDat": 123,
    "trangThai": "Đã hủy",
    "tienHoanCoc": 240000,
    "ghiChu": "Khách hủy đột xuất"
  }
}
```

---

#### 3.1.6. Tra Cứu Đặt Phòng Theo SĐT

**Endpoint:** `GET /api/v1/dat-phong/tra-cuu`

**Query Params:** `sdt` (string, required)

**Example:** `GET /api/v1/dat-phong/tra-cuu?sdt=0901234567`

**Response 200 OK:**
```json
{
  "success": true,
  "message": "Tìm thấy 2 phiếu đặt phòng",
  "data": [
    {
      "maPhieuDat": 123,
      "tenKhachHang": "Nguyễn Văn A",
      "tenPhong": "Phòng VIP 01",
      "thoiGianBatDau": "2025-12-06T18:00:00",
      "trangThai": "Đã đặt"
    },
    {
      "maPhieuDat": 98,
      "tenKhachHang": "Nguyễn Văn A",
      "tenPhong": "Phòng Standard 05",
      "thoiGianBatDau": "2025-11-20T20:00:00",
      "trangThai": "Đã hoàn thành"
    }
  ]
}
```

---

### 3.2. Module: CHECK-IN / CHECK-OUT

Base URL: `/api/v1/check-in`

#### 3.2.1. Check-in Khách Hàng

**Endpoint:** `POST /api/v1/check-in`

**Use Case:** UC_ThucHienCheckIn

**Description:** Tiếp tân thực hiện check-in cho khách hàng khi họ đến cơ sở

**Request Body:**
```json
{
  "maPhieuDat": 123,
  "soDienThoai": "0901234567",
  "cmndCccd": "079123456789",
  "soNguoiThucTe": 10,
  "maNhanVien": 5,
  "ghiChu": "Khách đến đúng giờ"
}
```

**Response 200 OK:**
```json
{
  "success": true,
  "message": "Check-in thành công",
  "data": {
    "maPhieuSuDung": 456,
    "maPhieuDat": 123,
    "tenKhachHang": "Nguyễn Văn A",
    "soDienThoai": "0901234567",
    "maPhong": 5,
    "tenPhong": "Phòng VIP 01",
    "trangThaiPhong": "Đang sử dụng",
    "thoiGianCheckIn": "2025-12-06T18:05:00",
    "thoiGianDuKienCheckOut": "2025-12-06T22:00:00",
    "maNhanVien": 5,
    "tenNhanVien": "Trần Thị B",
    "trangThai": "Đang sử dụng",
    "thongBao": "Check-in thành công. Chìa khóa phòng VIP 01 đã được bàn giao.",
    "maThePhong": "VIP01"
  }
}
```

**Response 404 Not Found:**
```json
{
  "success": false,
  "message": "Không tìm thấy thông tin đặt phòng",
  "error": "BOOKING_NOT_FOUND"
}
```

**Response 400 Bad Request:**
```json
{
  "success": false,
  "message": "Số lượng khách vượt quá quy định phòng (tối đa 15 người)",
  "error": "EXCEED_ROOM_CAPACITY"
}
```

---

#### 3.2.2. Check-out Khách Hàng

**Endpoint:** `POST /api/v1/check-in/check-out`

**Description:** Kết thúc sử dụng phòng và tính toán chi phí thực tế

**Request Body:**
```json
{
  "maPhieuSuDung": 456,
  "maNhanVien": 5,
  "ghiChu": "Khách ra đúng giờ"
}
```

**Response 200 OK:**
```json
{
  "success": true,
  "message": "Check-out thành công",
  "data": {
    "maPhieuSuDung": 456,
    "maPhong": 5,
    "tenPhong": "Phòng VIP 01",
    "thoiGianCheckIn": "2025-12-06T18:05:00",
    "thoiGianCheckOut": "2025-12-06T22:10:00",
    "tongThoiGian": 4.08,
    "chiPhiPhong": 816000,
    "trangThai": "Đã kết thúc",
    "thongBao": "Vui lòng đến quầy thanh toán"
  }
}
```

---

### 3.3. Module: QUẢN LÝ ORDER (ĐỒ ĂN/UỐNG)

Base URL: `/api/v1/order`

#### 3.3.1. Tạo Order Mới

**Endpoint:** `POST /api/v1/order`

**Use Case:** UC_QuanLyOrder (CRUD)

**Description:** Nhân viên phục vụ tạo order đồ ăn/uống cho khách

**Request Body:**
```json
{
  "maPhong": 5,
  "maPhieuSuDung": 456,
  "maNhanVien": 8,
  "danhSachMonAn": [
    {
      "maMatHang": 10,
      "soLuong": 2,
      "ghiChu": "Ít đường"
    },
    {
      "maMatHang": 25,
      "soLuong": 1,
      "ghiChu": ""
    }
  ]
}
```

**Response 201 Created:**
```json
{
  "success": true,
  "message": "Đã tạo order thành công",
  "data": {
    "maDonGoiMon": 789,
    "maPhong": 5,
    "tenPhong": "Phòng VIP 01",
    "ngayGoiMon": "2025-12-06T19:30:00",
    "tongTien": 350000,
    "trangThai": "Đang chờ xử lý",
    "danhSachMonAn": [
      {
        "maMatHang": 10,
        "tenMatHang": "Coca Cola",
        "soLuong": 2,
        "donGia": 25000,
        "thanhTien": 50000,
        "ghiChu": "Ít đường"
      },
      {
        "maMatHang": 25,
        "tenMatHang": "Mì xào hải sản",
        "soLuong": 1,
        "donGia": 300000,
        "thanhTien": 300000,
        "ghiChu": ""
      }
    ]
  }
}
```

---

#### 3.3.2. Cập Nhật Trạng Thái Order (Bếp/Bar)

**Endpoint:** `PUT /api/v1/order/{maDonGoiMon}/trang-thai`

**Description:** Nhân viên bếp/bar cập nhật trạng thái order

**Request Body:**
```json
{
  "trangThai": "Hoàn thành",
  "maNhanVien": 12
}
```

**Possible Status Values:**
- `"Đang chờ xử lý"`
- `"Đang làm"`
- `"Hoàn thành"`
- `"Đã hủy"`

---

#### 3.3.3. Xem Danh Sách Order Theo Phòng

**Endpoint:** `GET /api/v1/order/phong/{maPhong}`

**Response 200 OK:**
```json
{
  "success": true,
  "data": [
    {
      "maDonGoiMon": 789,
      "ngayGoiMon": "2025-12-06T19:30:00",
      "tongTien": 350000,
      "trangThai": "Hoàn thành"
    }
  ]
}
```

---

### 3.4. Module: QUẢN LÝ KHO

Base URL: `/api/v1/kho`

#### 3.4.1. Tạo Phiếu Nhập Kho

**Endpoint:** `POST /api/v1/kho/nhap`

**Use Case:** UC_QuanLyNhapKho

**Request Body:**
```json
{
  "maNhaCungCap": 3,
  "maNhanVien": 15,
  "nguoiGiaoHang": "Nguyễn Văn C",
  "danhSachMatHang": [
    {
      "maMatHang": 50,
      "soLuong": 100,
      "donGia": 15000,
      "hanSuDung": "2026-12-31"
    }
  ]
}
```

---

#### 3.4.2. Tạo Phiếu Xuất Kho

**Endpoint:** `POST /api/v1/kho/xuat`

**Use Case:** UC_QuanLyXuatKho

---

#### 3.4.3. Kiểm Kê Định Kỳ

**Endpoint:** `POST /api/v1/kho/kiem-ke`

**Use Case:** UC_KiemKeĐinhKy

---

### 3.5. Module: THANH TOÁN

Base URL: `/api/v1/thanh-toan`

#### 3.5.1. Tính Tổng Hóa Đơn

**Endpoint:** `GET /api/v1/thanh-toan/tinh-toan/{maPhieuSuDung}`

**Response 200 OK:**
```json
{
  "success": true,
  "data": {
    "maPhieuSuDung": 456,
    "chiPhiPhong": 816000,
    "chiPhiDoAnUong": 350000,
    "chiPhiDichVu": 0,
    "tongTienChuaGiam": 1166000,
    "giamGia": 0,
    "tongTienSauGiam": 1166000,
    "tienCocDaTra": 240000,
    "conPhaiTra": 926000
  }
}
```

---

#### 3.5.2. Thanh Toán Hóa Đơn

**Endpoint:** `POST /api/v1/thanh-toan`

**Use Case:** UC_ThanhToan

**Request Body:**
```json
{
  "maPhieuSuDung": 456,
  "phuongThucThanhToan": "Tiền mặt",
  "maMaUuDai": "NNICE50",
  "maNhanVien": 5
}
```

**Possible Payment Methods:**
- `"Tiền mặt"`
- `"Chuyển khoản"`
- `"Thẻ tín dụng"`
- `"Ví điện tử"`

---

### 3.6. Module: NHÂN VIÊN

Base URL: `/api/v1/nhan-vien`

#### 3.6.1. Chấm Công

**Endpoint:** `POST /api/v1/nhan-vien/cham-cong`

**Use Case:** UC_ChamCong

**Request Body:**
```json
{
  "maNhanVien": 8,
  "loaiChamCong": "Vào ca",
  "viTri": "Cơ sở Quận 1"
}
```

---

#### 3.6.2. Yêu Cầu Đổi Ca / Nghỉ Phép

**Endpoint:** `POST /api/v1/nhan-vien/yeu-cau-doi-ca`

**Use Case:** UC_YeuCauDoiCa/NghiPhep

---

### 3.7. Module: BÁO CÁO THỐNG KÊ

Base URL: `/api/v1/bao-cao`

#### 3.7.1. Báo Cáo Doanh Thu

**Endpoint:** `GET /api/v1/bao-cao/doanh-thu`

**Query Params:**
- `tuNgay` (date, required)
- `denNgay` (date, required)
- `maCoSo` (integer, optional)

**Use Case:** UC_ThongKe

---

## 4. USE CASES IMPLEMENTATION

### 4.1. Use Case: QuanLyDatPhong

**Service Class:** `QuanLyDatPhongServiceImpl`

**Main Methods:**
1. `taoPhieuDatPhong(DatPhongRequest)` → `DatPhongResponse`
2. `timPhongTrong(TimPhongTrongRequest)` → `List<PhongTrongResponse>`
3. `xemPhieuDatPhong(Integer)` → `DatPhongResponse`
4. `capNhatPhieuDatPhong(Integer, DatPhongRequest)` → `DatPhongResponse`
5. `huyPhieuDatPhong(Integer, String)` → `void`

**Business Logic Flow:**
```
1. Kiểm tra thông tin khách hàng (tạo mới nếu chưa tồn tại)
2. Tìm phòng phù hợp (nếu chưa chọn sẵn)
3. Kiểm tra phòng trống trong khoảng thời gian
4. Tính chi phí dự kiến
5. Tạo phiếu đặt phòng
6. Cập nhật trạng thái phòng
7. Gửi SMS/Email xác nhận (nếu có)
```

---

### 4.2. Use Case: ThucHienCheckIn

**Service Class:** `ThucHienCheckInServiceImpl`

**Main Methods:**
1. `checkIn(CheckInRequest)` → `CheckInResponse`
2. `timPhieuDatPhong(Integer, String)` → `PhieuDatPhong`

**Business Logic Flow:**
```
1. Tìm phiếu đặt phòng (theo mã hoặc SĐT)
2. Xác thực thông tin khách hàng
3. Kiểm tra số người thực tế
4. Tạo phiếu sử dụng
5. Cập nhật trạng thái phòng: "Đang sử dụng"
6. Bàn giao chìa khóa/thẻ phòng
7. Ghi nhận thời gian check-in
```

---

### 4.3. Use Case: QuanLyOrder

**Service Class:** `QuanLyOrderServiceImpl`

**Main Methods:**
1. `taoOrder(OrderRequest)` → `OrderResponse`
2. `capNhatTrangThai(Integer, String)` → `OrderResponse`
3. `xoaOrder(Integer)` → `void`

**Business Logic Flow (Tạo Order):**
```
1. Kiểm tra phòng đang sử dụng
2. Kiểm tra món còn hàng
3. Tạo đơn gọi món
4. Gửi thông báo đến bếp/bar
5. Cập nhật trạng thái: "Đang chờ xử lý"
```

**Business Logic Flow (Hoàn Thành Order):**
```
1. Cập nhật trạng thái: "Hoàn thành"
2. Gọi UC QuanLyXuatKho
3. Tự động trừ nguyên vật liệu tồn kho
4. Tính tiền vào hóa đơn
```

---

## 5. DATABASE SCHEMA

### 5.1. Các Bảng Chính

#### `khachhang` (Khách Hàng)
```sql
CREATE TABLE khachhang (
  MaKH INT PRIMARY KEY AUTO_INCREMENT,
  TenKH VARCHAR(100) NOT NULL,
  SDT VARCHAR(15) UNIQUE,
  Email VARCHAR(100),
  LoaiKhach VARCHAR(50)
);
```

#### `phong` (Phòng)
```sql
CREATE TABLE phong (
  MaPhong INT PRIMARY KEY AUTO_INCREMENT,
  TenPhong VARCHAR(50) NOT NULL,
  MaLoai INT,
  MaCS INT,
  TrangThai VARCHAR(50) NOT NULL,
  FOREIGN KEY (MaLoai) REFERENCES loaiphong(MaLoai),
  FOREIGN KEY (MaCS) REFERENCES coso(MaCS)
);
```

#### `phieudatphong` (Phiếu Đặt Phòng)
```sql
CREATE TABLE phieudatphong (
  MaPhieuDat INT PRIMARY KEY AUTO_INCREMENT,
  MaKH INT,
  MaPhong INT,
  MaDT INT,
  NgayDat DATETIME,
  ThoiGianBatDau DATETIME,
  ThoiGianKetThuc DATETIME,
  SoNguoi INT,
  TienCoc DECIMAL(18,2),
  TrangThai VARCHAR(50),
  GhiChu VARCHAR(500),
  FOREIGN KEY (MaKH) REFERENCES khachhang(MaKH),
  FOREIGN KEY (MaPhong) REFERENCES phong(MaPhong),
  FOREIGN KEY (MaDT) REFERENCES doitac(MaDT)
);
```

#### `phieusudung` (Phiếu Sử Dụng - Check-in/Check-out)
```sql
CREATE TABLE phieusudung (
  MaPhieuSuDung INT PRIMARY KEY AUTO_INCREMENT,
  MaPhong INT,
  MaPhieuDat INT,
  MaNV INT,
  GioBatDau DATETIME,
  GioKetThuc DATETIME,
  TongThoiGian FLOAT,
  TrangThai VARCHAR(50),
  FOREIGN KEY (MaPhong) REFERENCES phong(MaPhong),
  FOREIGN KEY (MaPhieuDat) REFERENCES phieudatphong(MaPhieuDat),
  FOREIGN KEY (MaNV) REFERENCES nhanvien(MaNV)
);
```

#### `dongoimon` (Đơn Gọi Món)
```sql
CREATE TABLE dongoimon (
  MaDonGoiMon INT PRIMARY KEY AUTO_INCREMENT,
  MaPhong INT,
  MaPhieuSuDung INT,
  NgayGoiMon DATETIME,
  TongTien DECIMAL(18,2),
  TrangThai VARCHAR(50),
  FOREIGN KEY (MaPhong) REFERENCES phong(MaPhong),
  FOREIGN KEY (MaPhieuSuDung) REFERENCES phieusudung(MaPhieuSuDung)
);
```

### 5.2. Relationships (Mối quan hệ)

```
KhachHang (1) ─── (N) PhieuDatPhong
Phong (1) ─── (N) PhieuDatPhong
Phong (1) ─── (N) PhieuSuDung
PhieuDatPhong (1) ─── (1) PhieuSuDung
PhieuSuDung (1) ─── (N) DonGoiMon
NhanVien (1) ─── (N) PhieuSuDung
MatHang (1) ─── (N) ChiTietGoiMon
```

---

## 6. HƯỚNG DẪN CHẠY PROJECT

### 6.1. Prerequisites (Yêu cầu)

- **Java JDK 21** trở lên
- **Maven 3.8+**
- **MySQL 8.0+**
- **IDE:** IntelliJ IDEA hoặc VS Code (với Java Extension Pack)

### 6.2. Cấu Hình Database

1. **Tạo database MySQL:**
```sql
CREATE DATABASE karaoke_nnice;
USE karaoke_nnice;
```

2. **Import schema:** Chạy file `ScriptPTTKHDT.sql`

3. **Cấu hình kết nối:** Sửa file `application.properties`

```properties
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/karaoke_nnice
spring.datasource.username=root
spring.datasource.password=yourpassword

# JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

### 6.3. Build & Run

**Bước 1: Clone repository**
```bash
cd d:\VSCodeProjects\PTTTKHDTKaraokeNnice\PTTKHDT_KaraokeNNice\karaoke-nnice-api
```

**Bước 2: Build project**
```bash
mvn clean install
```

**Bước 3: Run application**
```bash
mvn spring-boot:run
```

Hoặc chạy trực tiếp từ IDE:
- IntelliJ: Run `main.java`
- VS Code: Run và debug từ `main.java`

**Bước 4: Kiểm tra**
```
Application sẽ chạy tại: http://localhost:8080
Swagger UI: http://localhost:8080/swagger-ui.html
```

---

## 7. TESTING GUIDE

### 7.1. Test với Swagger UI

1. Truy cập: `http://localhost:8080/swagger-ui.html`
2. Chọn endpoint cần test
3. Click "Try it out"
4. Nhập request body
5. Click "Execute"

### 7.2. Test với Postman

**Import Postman Collection:**
- File: `Karaoke_NNice_API.postman_collection.json` (sẽ tạo riêng)

**Test Flow Đặt Phòng:**

1. **Tìm phòng trống**
   - Method: POST
   - URL: `http://localhost:8080/api/v1/dat-phong/tim-phong-trong`
   - Body: JSON request

2. **Tạo đặt phòng**
   - Method: POST
   - URL: `http://localhost:8080/api/v1/dat-phong`

3. **Check-in**
   - Method: POST
   - URL: `http://localhost:8080/api/v1/check-in`

4. **Tạo order**
   - Method: POST
   - URL: `http://localhost:8080/api/v1/order`

5. **Check-out**
   - Method: POST
   - URL: `http://localhost:8080/api/v1/check-in/check-out`

6. **Thanh toán**
   - Method: POST
   - URL: `http://localhost:8080/api/v1/thanh-toan`

---

## 8. ERROR CODES

| Error Code | HTTP Status | Description |
|-----------|-------------|-------------|
| `BOOKING_NOT_FOUND` | 404 | Không tìm thấy phiếu đặt phòng |
| `ROOM_ALREADY_BOOKED` | 400 | Phòng đã được đặt |
| `EXCEED_ROOM_CAPACITY` | 400 | Vượt quá sức chứa phòng |
| `PAYMENT_FAILED` | 500 | Thanh toán thất bại |
| `INVALID_COUPON` | 400 | Mã ưu đãi không hợp lệ |

---

## 9. CONTACT & SUPPORT

**Team:** PTT Karaoke NNice  
**Project:** Đồ Án Môn Phân Tích Thiết Kế Hướng Đối Tượng  
**Email:** [your-email@example.com]  
**Repository:** [GitHub URL]

---

**📌 LƯU Ý:**
- Document này được tạo cho đồ án môn học
- API đang trong giai đoạn development
- Frontend React sẽ được implement sau
- Swagger documentation được cập nhật tự động

**🎯 NEXT STEPS:**
1. ✅ Hoàn thiện các Use Cases còn lại
2. ✅ Implement Security & Authentication (JWT)
3. ✅ Unit Testing & Integration Testing
4. ✅ Deploy to Production Server
5. ✅ Integrate with React Frontend

---

*Last Updated: December 6, 2025*
