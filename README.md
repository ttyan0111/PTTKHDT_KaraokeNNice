# Karaoke NNice - Backend API

Hệ thống quản lý Karaoke NNice được phát triển với Spring Boot, áp dụng các nguyên lý OOP và các design patterns phổ biến.

## 📋 Mục lục

- [Tổng quan](#tổng-quan)
- [Kiến trúc hệ thống](#kiến-trúc-hệ-thống)
- [Công nghệ sử dụng](#công-nghệ-sử-dụng)
- [Cài đặt và chạy](#cài-đặt-và-chạy)
- [Cấu trúc dự án](#cấu-trúc-dự-án)
- [API Endpoints](#api-endpoints)
- [Database Schema](#database-schema)
- [Use Cases](#use-cases)

## 🎯 Tổng quan

Hệ thống Karaoke NNice là một ứng dụng quản lý toàn diện cho chuỗi cơ sở karaoke, bao gồm các chức năng:

- **Quản lý đặt phòng & check-in/check-out**
- **Quản lý đặt tiệc và order đồ ăn/uống**
- **Quản lý kho và kiểm kê**
- **Quản lý nhân viên, chấm công và lương**
- **Quản lý khách hàng và thành viên thân thiết**
- **Thanh toán và áp dụng ưu đãi**
- **Báo cáo thống kê**

## 🏗️ Kiến trúc hệ thống

### Layered Architecture

```
┌─────────────────────────────────────┐
│      Presentation Layer             │
│    (REST Controllers)               │
├─────────────────────────────────────┤
│      Business Logic Layer           │
│    (Services & Use Cases)           │
├─────────────────────────────────────┤
│      Data Access Layer              │
│    (Repositories & JPA)             │
├─────────────────────────────────────┤
│      Database Layer                 │
│    (MySQL Database)                 │
└─────────────────────────────────────┘
```

### Nguyên tắc OOP được áp dụng

1. **Encapsulation**: Các entity và DTO sử dụng Lombok để tự động sinh getter/setter
2. **Abstraction**: Service interfaces và implementations riêng biệt
3. **Inheritance**: Exception hierarchy (BusinessException, ResourceNotFoundException)
4. **Polymorphism**: JPA relationships và dependency injection

### Design Patterns

- **Repository Pattern**: Tách biệt logic truy cập dữ liệu
- **DTO Pattern**: Tách biệt entity và presentation layer
- **Service Layer Pattern**: Tập trung business logic
- **Dependency Injection**: Sử dụng Spring IoC container
- **Builder Pattern**: Tạo đối tượng phức tạp (với Lombok @Builder)

## 🛠️ Công nghệ sử dụng

### Backend Framework
- **Java 21**: Ngôn ngữ lập trình
- **Spring Boot 3.2.12**: Framework chính
- **Spring Data JPA**: ORM và data access
- **Spring Security**: Bảo mật và authentication
- **Maven**: Build tool

### Database
- **MySQL 8.0**: Relational database

### Libraries
- **Lombok**: Giảm boilerplate code
- **SpringDoc OpenAPI**: API documentation (Swagger UI)
- **SLF4J**: Logging

### Tools
- **Postman**: API testing
- **MySQL Workbench**: Database management

## 🚀 Cài đặt và chạy

### Yêu cầu hệ thống

- Java 21 hoặc cao hơn
- Maven 3.6+
- MySQL 8.0+
- IDE: IntelliJ IDEA, Eclipse, hoặc VS Code

### Bước 1: Clone repository

```bash
git clone <repository-url>
cd karaoke-nnice-api
```

### Bước 2: Cấu hình database

Tạo database MySQL:

```sql
CREATE DATABASE karaoke_nnice CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

Chạy script SQL để tạo tables:

```bash
mysql -u root -p karaoke_nnice < ScriptPTTKHDT.sql
```

### Bước 3: Cấu hình application.properties

Mở file `src/main/resources/application-dev.properties` và cập nhật:

```properties
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/karaoke_nnice?useSSL=false&serverTimezone=UTC&characterEncoding=UTF-8
spring.datasource.username=root
spring.datasource.password=your_password

# JPA Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

# Server Configuration
server.port=8080

# Logging
logging.level.com.nnice.karaoke=DEBUG
```

### Bước 4: Build project

```bash
mvn clean install
```

### Bước 5: Chạy application

```bash
mvn spring-boot:run
```

Hoặc từ IDE: Run `main.java`

### Bước 6: Truy cập Swagger UI

Mở browser và truy cập:

```
http://localhost:8080/swagger-ui.html
```

## 📁 Cấu trúc dự án

```
karaoke-nnice-api/
├── src/
│   ├── main/
│   │   ├── java/com/nnice/karaoke/
│   │   │   ├── config/              # Cấu hình Spring
│   │   │   │   ├── DatabaseConfig.java
│   │   │   │   ├── SecurityConfig.java
│   │   │   │   └── SwaggerConfig.java
│   │   │   ├── controller/          # REST Controllers
│   │   │   │   ├── DatPhongController.java
│   │   │   │   ├── CheckInController.java
│   │   │   │   ├── OrderController.java
│   │   │   │   ├── KhoController.java
│   │   │   │   └── NhanVienController.java
│   │   │   ├── dto/                 # Data Transfer Objects
│   │   │   │   ├── request/
│   │   │   │   │   ├── DatPhongRequest.java
│   │   │   │   │   ├── CheckInRequest.java
│   │   │   │   │   └── OrderRequest.java
│   │   │   │   └── response/
│   │   │   │       ├── DatPhongResponse.java
│   │   │   │       └── PhongKhaDungResponse.java
│   │   │   ├── entity/              # JPA Entities
│   │   │   │   ├── Phong.java
│   │   │   │   ├── PhieuDatPhong.java
│   │   │   │   ├── KhachHang.java
│   │   │   │   ├── NhanVien.java
│   │   │   │   └── ...
│   │   │   ├── exception/           # Exception Handling
│   │   │   │   ├── BusinessException.java
│   │   │   │   ├── ResourceNotFoundException.java
│   │   │   │   └── GlobalExceptionHandler.java
│   │   │   ├── repository/          # Data Access Layer
│   │   │   │   ├── PhongRepository.java
│   │   │   │   ├── PhieuDatPhongRepository.java
│   │   │   │   └── ...
│   │   │   ├── service/             # Business Logic
│   │   │   │   ├── impl/
│   │   │   │   │   ├── QuanLyDatPhongServiceImpl.java
│   │   │   │   │   ├── ThucHienCheckInServiceImpl.java
│   │   │   │   │   └── ...
│   │   │   │   ├── QuanLyDatPhongService.java
│   │   │   │   └── ...
│   │   │   └── util/                # Utilities
│   │   │       └── DateTimeUtil.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── application-dev.properties
│   └── test/                        # Unit Tests
└── pom.xml
```

## 🌐 API Endpoints

### 1. Quản lý Đặt Phòng

#### Tìm phòng trống
```http
GET /api/phong/tim-trong?soNguoi={soNguoi}&gioDat={gioDat}&gioKetThuc={gioKetThuc}&maCoSo={maCoSo}
```

Response:
```json
[
  {
    "maPhong": 1,
    "tenPhong": "VIP 01",
    "trangThai": "Trống",
    "maLoai": 1,
    "tenLoai": "VIP",
    "sucChua": 10,
    "moTa": "Phòng VIP có karaoke cao cấp",
    "giaMoiGio": 200000,
    "giaTheoKhungGio": 400000,
    "maCoSo": 1,
    "tenCoSo": "Karaoke NNice Quận 1"
  }
]
```

#### Tạo phiếu đặt phòng
```http
POST /api/dat-phong
Content-Type: application/json

{
  "tenKH": "Nguyễn Văn A",
  "sdt": "0901234567",
  "email": "nguyenvana@email.com",
  "soNguoi": 8,
  "gioDat": "2024-12-10T18:00:00",
  "gioKetThuc": "2024-12-10T22:00:00",
  "maPhong": 1,
  "maCoSo": 1
}
```

Response:
```json
{
  "maPhieuDat": 1,
  "maDatPhong": "DP000001",
  "tenKH": "Nguyễn Văn A",
  "sdt": "0901234567",
  "email": "nguyenvana@email.com",
  "maPhong": 1,
  "tenPhong": "VIP 01",
  "loaiPhong": "VIP",
  "ngayDat": "2024-12-05T10:30:00",
  "gioDat": "2024-12-10T18:00:00",
  "gioKetThuc": "2024-12-10T22:00:00",
  "chiPhiDuKien": 800000,
  "tienCoc": 240000,
  "trangThai": "Đã đặt",
  "tenCoSo": "Karaoke NNice Quận 1",
  "diaChiCoSo": "123 Nguyễn Huệ, Q.1, TP.HCM"
}
```

#### Xem chi tiết phiếu đặt
```http
GET /api/dat-phong/{maPhieuDat}
```

#### Cập nhật phiếu đặt
```http
PUT /api/dat-phong/{maPhieuDat}
Content-Type: application/json

{
  "gioDat": "2024-12-10T19:00:00",
  "gioKetThuc": "2024-12-10T23:00:00"
}
```

#### Hủy phiếu đặt
```http
DELETE /api/dat-phong/{maPhieuDat}
```

### 2. Check-in

```http
POST /api/check-in
Content-Type: application/json

{
  "maPhieuDat": 1,
  "soNguoiThucTe": 8,
  "cmnd": "079123456789"
}
```

### 3. Quản lý Order

#### Tạo order
```http
POST /api/order
Content-Type: application/json

{
  "maPhong": 1,
  "danhSachMon": [
    {
      "maMatHang": 10,
      "soLuong": 2,
      "ghiChu": "Ít đá"
    },
    {
      "maMatHang": 15,
      "soLuong": 1
    }
  ]
}
```

#### Xem danh sách order
```http
GET /api/order/phong/{maPhong}
```

#### Cập nhật trạng thái order
```http
PUT /api/order/{maOrder}/trang-thai
Content-Type: application/json

{
  "trangThai": "Đang làm"
}
```

### 4. Thanh toán

```http
POST /api/thanh-toan
Content-Type: application/json

{
  "maPhieuDat": 1,
  "phuongThucThanhToan": "TIEN_MAT",
  "maUuDai": "DISCOUNT20",
  "maTheThanhVien": "TV000123"
}
```

### 5. Quản lý Nhân viên

#### Chấm công
```http
POST /api/cham-cong
Content-Type: application/json

{
  "maNV": 1,
  "loaiChamCong": "VAO"
}
```

#### Phân công ca làm
```http
POST /api/phan-cong-ca
Content-Type: application/json

{
  "maNV": 1,
  "maCa": 2,
  "ngayLam": "2024-12-10"
}
```

## 🗄️ Database Schema

### Các bảng chính

#### 1. Phong (Phòng)
- MaPhong (PK)
- TenPhong
- TrangThai (Trống, Đã đặt, Đang sử dụng, Bảo trì)
- MaCS (FK → CoSo)
- MaLoai (FK → LoaiPhong)

#### 2. PhieuDatPhong (Phiếu Đặt Phòng)
- MaPhieuDat (PK)
- MaKH (FK → KhachHang)
- MaDT (FK → DoiTac)
- NgayDat
- GioDat
- GioKetThuc
- TienCoc
- TrangThai

#### 3. KhachHang (Khách Hàng)
- MaKH (PK)
- TenKH
- SDT (Unique)
- Email
- LoaiKhach

#### 4. NhanVien (Nhân Viên)
- MaNV (PK)
- HoTen
- ChucVu
- HeSoLuong
- MaCS (FK → CoSo)

#### 5. DonGoiMon (Đơn Gọi Món)
- MaOrder (PK)
- MaPhong (FK → Phong)
- ThoiGianGoi
- TrangThai

### Relationships

```
KhachHang 1---* PhieuDatPhong
PhieuDatPhong 1---* PhieuSuDung
Phong 1---* PhieuSuDung
Phong 1---* DonGoiMon
DonGoiMon 1---* ChiTietGoiMon
MatHang 1---* ChiTietGoiMon
```

## 📖 Use Cases

### UC1: QuanLyDatPhong (Quản lý Đặt Phòng)

**Actor**: Tiếp tân

**Dòng sự kiện chính**:
1. Tiếp tân chọn chức năng "Đặt phòng"
2. Hệ thống hiển thị form nhập thông tin
3. Tiếp tân nhập thông tin khách hàng và yêu cầu
4. Tiếp tân chọn "Tìm phòng phù hợp"
5. Hệ thống hiển thị danh sách phòng trống
6. Tiếp tân chọn phòng
7. Hệ thống tính chi phí dự kiến
8. Tiếp tân xác nhận đặt phòng
9. Hệ thống tạo mã đặt phòng và gửi xác nhận

**Implementation**:
- Service: `QuanLyDatPhongServiceImpl`
- Controller: `DatPhongController`
- DTO: `DatPhongRequest`, `DatPhongResponse`

### UC2: ThucHienCheckIn (Thực hiện Check-in)

**Actor**: Tiếp tân

**Dòng sự kiện chính**:
1. Tiếp tân chọn chức năng "Check-in"
2. Tiếp tân tra cứu thông tin đặt phòng
3. Hệ thống hiển thị thông tin đặt phòng
4. Tiếp tân xác nhận thông tin khách
5. Tiếp tân bàn giao chìa khóa
6. Hệ thống cập nhật trạng thái phòng thành "Đang sử dụng"

**Implementation**:
- Service: `ThucHienCheckInServiceImpl`
- Controller: `CheckInController`

### UC3: ThanhToan (Thanh toán)

**Actor**: Tiếp tân, Hệ thống thanh toán

**Extensions**:
- ApDungUuDai (extend)
- CapNhatDiemTichLuy (extend)

**Implementation**:
- Service: `ThanhToanServiceImpl`, `ApDungUuDaiService`, `CapNhatDiemTichLuyService`
- Controller: `ThanhToanController`

## 🧪 Testing

### Chạy unit tests

```bash
mvn test
```

### Test với Postman

1. Import Postman collection từ `docs/postman/`
2. Cấu hình environment variables:
   - `base_url`: http://localhost:8080
   - `token`: JWT token (sau khi login)

## 📊 Logging

Application sử dụng SLF4J với Logback. Log files được lưu tại:

```
logs/
├── karaoke-nnice.log          # All logs
├── karaoke-nnice-error.log    # Error logs only
```

## 🔐 Security

### Authentication

Hệ thống sử dụng JWT (JSON Web Token) cho authentication:

```http
POST /api/auth/login
Content-Type: application/json

{
  "username": "tieptan01",
  "password": "password123"
}
```

Response:
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "type": "Bearer",
  "username": "tieptan01",
  "roles": ["TIEP_TAN"]
}
```

### Authorization

Các role trong hệ thống:
- `TIEP_TAN`: Tiếp tân
- `PHUC_VU`: Nhân viên phục vụ
- `BEP_BAR`: Nhân viên bếp/bar
- `KHO`: Nhân viên kho
- `KE_TOAN`: Kế toán
- `QUAN_LY`: Quản lý

## 🎓 OOP Principles

### 1. Encapsulation

```java
@Entity
@Getter
@Setter
public class Phong {
    @Id
    private Integer maPhong;
    private String tenPhong;
    private String trangThai;
    
    @ManyToOne
    private CoSo coSo;
}
```

### 2. Inheritance

```java
public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}

public class ResourceNotFoundException extends BusinessException {
    public ResourceNotFoundException(String resource) {
        super("Không tìm thấy " + resource);
    }
}
```

### 3. Abstraction

```java
public interface QuanLyDatPhongService {
    DatPhongResponse taoPhieuDatPhong(DatPhongRequest request);
    List<PhongKhaDungResponse> timPhongTrong(Integer soNguoi, ...);
}

@Service
public class QuanLyDatPhongServiceImpl implements QuanLyDatPhongService {
    @Override
    public DatPhongResponse taoPhieuDatPhong(DatPhongRequest request) {
        // Implementation
    }
}
```

### 4. Polymorphism

```java
@Service
public class ThanhToanService {
    private final PaymentStrategy paymentStrategy;
    
    public void thanhToan(ThanhToanRequest request) {
        // Polymorphic behavior based on payment method
        paymentStrategy.process(request);
    }
}
```

## 📚 Tài liệu tham khảo

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Lombok](https://projectlombok.org/)
- [MySQL Documentation](https://dev.mysql.com/doc/)
