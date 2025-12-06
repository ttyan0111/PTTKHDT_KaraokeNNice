# 🎓 OOP PRINCIPLES IN KARAOKE NNICE PROJECT
## Giải Thích Nguyên Lý Hướng Đối Tượng Trong Đồ Án

**Môn học:** Phân Tích Thiết Kế Hướng Đối Tượng  
**Project:** Karaoke NNice Management System

---

## 📚 MỤC LỤC

1. [4 Trụ Cột OOP](#1-bốn-trụ-cột-oop)
2. [SOLID Principles](#2-solid-principles)
3. [Design Patterns](#3-design-patterns)
4. [Class Relationships](#4-mối-quan-hệ-giữa-các-lớp)
5. [Code Examples](#5-ví-dụ-code-cụ-thể)

---

## 1. BỐN TRỤ CỘT OOP

### 1.1. ENCAPSULATION (Đóng Gói) ✅

**Định nghĩa:** Che giấu thông tin nội bộ của object, chỉ expose những gì cần thiết qua public methods.

**Ví dụ trong project:**

```java
@Entity
@Table(name = "KhachHang")
@Getter  // Lombok tạo getters
@Setter  // Lombok tạo setters
public class KhachHang {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maKhach;  // ❌ Private - không thể truy cập trực tiếp
    
    private String tenKH;
    private String sdt;
    private String email;
    
    // ✅ Public methods để truy cập
    // getMaKhach(), getTenKH(), setSdt(), etc.
}
```

**Lợi ích:**
- ✅ Bảo vệ dữ liệu khỏi thay đổi trực tiếp
- ✅ Dễ maintain và debug
- ✅ Có thể thêm validation trong setter

**Ví dụ nâng cao - Custom Setter với Validation:**

```java
@Entity
public class PhieuDatPhong {
    
    private Integer soNguoi;
    private BigDecimal tienCoc;
    
    // Custom setter với validation
    public void setSoNguoi(Integer soNguoi) {
        if (soNguoi <= 0) {
            throw new BusinessException("Số người phải lớn hơn 0");
        }
        this.soNguoi = soNguoi;
    }
    
    public void setTienCoc(BigDecimal tienCoc) {
        if (tienCoc.compareTo(BigDecimal.ZERO) < 0) {
            throw new BusinessException("Tiền cọc không được âm");
        }
        this.tienCoc = tienCoc;
    }
}
```

---

### 1.2. ABSTRACTION (Trừu Tượng Hóa) ✅

**Định nghĩa:** Ẩn đi implementation details, chỉ hiển thị functionality quan trọng.

**Ví dụ trong project:**

```java
// ✅ Interface - Chỉ định nghĩa "cái gì" chứ không phải "làm thế nào"
public interface QuanLyDatPhongService {
    
    // Abstract methods - chỉ khai báo, không implement
    DatPhongResponse taoPhieuDatPhong(DatPhongRequest request);
    List<PhongTrongResponse> timPhongTrong(TimPhongTrongRequest request);
    DatPhongResponse xemPhieuDatPhong(Integer maPhieu);
    void huyPhieuDatPhong(Integer maPhieu, String lyDoHuy);
}

// ✅ Implementation - Chi tiết "làm thế nào"
@Service
public class QuanLyDatPhongServiceImpl implements QuanLyDatPhongService {
    
    @Override
    public DatPhongResponse taoPhieuDatPhong(DatPhongRequest request) {
        // Chi tiết implementation ở đây
        // 1. Validate input
        // 2. Kiểm tra phòng trống
        // 3. Tạo khách hàng nếu chưa có
        // 4. Tính tiền cọc
        // 5. Lưu database
        // 6. Return response
    }
}
```

**Lợi ích:**
- ✅ Client code không cần biết implementation details
- ✅ Dễ thay đổi implementation mà không ảnh hưởng client
- ✅ Có thể có nhiều implementations khác nhau

**Ví dụ Abstraction trong Controller:**

```java
@RestController
@RequestMapping("/api/v1/dat-phong")
public class DatPhongController {
    
    // ✅ Phụ thuộc vào INTERFACE, không phải concrete class
    private final QuanLyDatPhongService datPhongService;
    
    @PostMapping
    public ResponseEntity<?> datPhong(@RequestBody DatPhongRequest request) {
        // Controller không cần biết Service được implement thế nào
        // Chỉ cần gọi method và nhận kết quả
        DatPhongResponse response = datPhongService.taoPhieuDatPhong(request);
        return ResponseEntity.ok(response);
    }
}
```

---

### 1.3. INHERITANCE (Kế Thừa) ✅

**Định nghĩa:** Class con kế thừa properties và methods từ class cha.

**Ví dụ trong project:**

#### Example 1: Repository Inheritance

```java
// ✅ Tất cả repositories kế thừa từ JpaRepository
public interface PhongRepository extends JpaRepository<Phong, Integer> {
    // Kế thừa các methods:
    // - save(Phong entity)
    // - findById(Integer id)
    // - findAll()
    // - deleteById(Integer id)
    // - count()
    // ... và nhiều methods khác
    
    // Thêm custom methods
    List<Phong> findByTrangThai(String trangThai);
}

public interface KhachHangRepository extends JpaRepository<KhachHang, Integer> {
    // Cũng kế thừa tất cả methods từ JpaRepository
    Optional<KhachHang> findBySdt(String sdt);
}
```

#### Example 2: Exception Hierarchy

```java
// ✅ Base Exception
public class BaseException extends RuntimeException {
    private String errorCode;
    private String message;
    
    public BaseException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.message = message;
    }
}

// ✅ Specific Exceptions kế thừa từ BaseException
public class ResourceNotFoundException extends BaseException {
    public ResourceNotFoundException(String message) {
        super("NOT_FOUND", message);
    }
}

public class BusinessException extends BaseException {
    public BusinessException(String message) {
        super("BUSINESS_ERROR", message);
    }
}

public class ValidationException extends BaseException {
    public ValidationException(String message) {
        super("VALIDATION_ERROR", message);
    }
}
```

**Lợi ích:**
- ✅ Tái sử dụng code
- ✅ Tạo hierarchy rõ ràng
- ✅ Dễ mở rộng

---

### 1.4. POLYMORPHISM (Đa Hình) ✅

**Định nghĩa:** Cùng một interface/method có thể có nhiều implementations khác nhau.

**Ví dụ trong project:**

#### Example 1: Interface Polymorphism

```java
// ✅ Một interface, nhiều implementations
public interface ThanhToanService {
    HoaDonResponse thanhToan(ThanhToanRequest request);
}

// Implementation 1: Thanh toán tiền mặt
@Service("tienMatService")
public class ThanhToanTienMatServiceImpl implements ThanhToanService {
    
    @Override
    public HoaDonResponse thanhToan(ThanhToanRequest request) {
        // Logic thanh toán tiền mặt
        System.out.println("Thanh toán bằng tiền mặt");
        // Không cần verify payment gateway
        // Tạo hóa đơn ngay
        return createHoaDon(request);
    }
}

// Implementation 2: Thanh toán chuyển khoản
@Service("chuyenKhoanService")
public class ThanhToanChuyenKhoanServiceImpl implements ThanhToanService {
    
    @Override
    public HoaDonResponse thanhToan(ThanhToanRequest request) {
        // Logic thanh toán chuyển khoản
        System.out.println("Thanh toán bằng chuyển khoản");
        // Verify với ngân hàng
        verifyBankTransfer(request.getMaGiaoDich());
        return createHoaDon(request);
    }
}

// Implementation 3: Thanh toán thẻ tín dụng
@Service("theTinDungService")
public class ThanhToanTheTinDungServiceImpl implements ThanhToanService {
    
    @Override
    public HoaDonResponse thanhToan(ThanhToanRequest request) {
        // Logic thanh toán thẻ
        System.out.println("Thanh toán bằng thẻ tín dụng");
        // Call payment gateway API
        callPaymentGateway(request);
        return createHoaDon(request);
    }
}

// ✅ Sử dụng Polymorphism
@RestController
public class ThanhToanController {
    
    @Autowired
    @Qualifier("tienMatService")  // Chọn implementation cụ thể
    private ThanhToanService tienMatService;
    
    @Autowired
    @Qualifier("chuyenKhoanService")
    private ThanhToanService chuyenKhoanService;
    
    @PostMapping("/thanh-toan")
    public ResponseEntity<?> thanhToan(@RequestBody ThanhToanRequest request) {
        
        ThanhToanService service;
        
        // Chọn service dựa trên phương thức thanh toán
        switch (request.getPhuongThuc()) {
            case "Tiền mặt":
                service = tienMatService;
                break;
            case "Chuyển khoản":
                service = chuyenKhoanService;
                break;
            default:
                service = tienMatService;
        }
        
        // ✅ Gọi cùng một method nhưng có behavior khác nhau
        HoaDonResponse response = service.thanhToan(request);
        return ResponseEntity.ok(response);
    }
}
```

#### Example 2: Method Overriding

```java
@Entity
public class NhanVien {
    private Integer maNV;
    private String tenNV;
    private String chucVu;
    
    // ✅ Override method từ Object class
    @Override
    public String toString() {
        return "NhanVien{" +
                "maNV=" + maNV +
                ", tenNV='" + tenNV + '\'' +
                ", chucVu='" + chucVu + '\'' +
                '}';
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        NhanVien nhanVien = (NhanVien) obj;
        return Objects.equals(maNV, nhanVien.maNV);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(maNV);
    }
}
```

**Lợi ích:**
- ✅ Flexibility - Dễ thay đổi implementation
- ✅ Extensibility - Dễ thêm implementations mới
- ✅ Maintainability - Code dễ maintain

---

## 2. SOLID PRINCIPLES

### 2.1. Single Responsibility Principle (SRP) ✅

**Định nghĩa:** Mỗi class chỉ nên có một lý do để thay đổi (một trách nhiệm).

**❌ Vi phạm SRP:**

```java
// BAD: Class này làm quá nhiều việc
public class PhongService {
    
    // Quản lý phòng
    public void taoPhong() { }
    public void xoaPhong() { }
    
    // Tính giá (nên ở GiaService)
    public BigDecimal tinhGiaPhong() { }
    
    // Gửi email (nên ở EmailService)
    public void guiEmailXacNhan() { }
    
    // Tạo báo cáo (nên ở BaoCaoService)
    public void taoBaoCaoPhong() { }
}
```

**✅ Tuân thủ SRP:**

```java
// GOOD: Mỗi class một trách nhiệm

// 1. Quản lý phòng
@Service
public class QuanLyPhongService {
    public void taoPhong(PhongRequest request) { }
    public void xoaPhong(Integer maPhong) { }
    public PhongResponse layThongTinPhong(Integer maPhong) { }
}

// 2. Tính giá
@Service
public class TinhGiaService {
    public BigDecimal tinhGiaPhong(Phong phong, LocalDateTime batDau, LocalDateTime ketThuc) { }
    public BigDecimal tinhGiaDichVu(DichVu dichVu, Integer soLuong) { }
}

// 3. Gửi thông báo
@Service
public class ThongBaoService {
    public void guiEmail(String email, String subject, String content) { }
    public void guiSMS(String sdt, String message) { }
}

// 4. Báo cáo
@Service
public class BaoCaoService {
    public BaoCaoResponse taoBaoCaoPhong(Integer maPhong) { }
    public BaoCaoResponse taoBaoCaoDoanhThu() { }
}
```

---

### 2.2. Open/Closed Principle (OCP) ✅

**Định nghĩa:** Class nên mở cho mở rộng (extension) nhưng đóng cho sửa đổi (modification).

**✅ Ví dụ trong project:**

```java
// ✅ Interface - Đóng cho modification
public interface TinhTienService {
    BigDecimal tinhTongTien(PhieuSuDung phieuSuDung);
}

// ✅ Implementation 1 - Mở rộng bằng cách tạo class mới
@Service
public class TinhTienTheoGioServiceImpl implements TinhTienService {
    
    @Override
    public BigDecimal tinhTongTien(PhieuSuDung phieuSuDung) {
        // Tính theo giờ
        float soGio = tinhSoGio(phieuSuDung);
        BigDecimal giaTheoGio = phieuSuDung.getPhong().getLoaiPhong().getGiaTheoGio();
        return giaTheoGio.multiply(BigDecimal.valueOf(soGio));
    }
}

// ✅ Implementation 2 - Thêm logic mới KHÔNG SỬA code cũ
@Service
public class TinhTienTheoGioVaKhungGioServiceImpl implements TinhTienService {
    
    @Override
    public BigDecimal tinhTongTien(PhieuSuDung phieuSuDung) {
        // Tính theo giờ + Khung giờ vàng (17h-21h tăng 20%)
        float soGio = tinhSoGio(phieuSuDung);
        BigDecimal giaTheoGio = phieuSuDung.getPhong().getLoaiPhong().getGiaTheoGio();
        BigDecimal tongTien = giaTheoGio.multiply(BigDecimal.valueOf(soGio));
        
        // Kiểm tra khung giờ vàng
        if (laKhungGioVang(phieuSuDung.getGioBatDau())) {
            tongTien = tongTien.multiply(BigDecimal.valueOf(1.2)); // Tăng 20%
        }
        
        return tongTien;
    }
    
    private boolean laKhungGioVang(LocalDateTime thoiGian) {
        int gio = thoiGian.getHour();
        return gio >= 17 && gio <= 21;
    }
}
```

---

### 2.3. Liskov Substitution Principle (LSP) ✅

**Định nghĩa:** Objects của subclass phải có thể thay thế objects của superclass mà không làm sai chương trình.

**✅ Ví dụ:**

```java
// Base interface
public interface PaymentProcessor {
    PaymentResult processPayment(BigDecimal amount);
}

// Implementation 1
@Service
public class CashPaymentProcessor implements PaymentProcessor {
    @Override
    public PaymentResult processPayment(BigDecimal amount) {
        // Xử lý thanh toán tiền mặt
        return new PaymentResult(true, "SUCCESS", "Thanh toán tiền mặt thành công");
    }
}

// Implementation 2
@Service
public class CardPaymentProcessor implements PaymentProcessor {
    @Override
    public PaymentResult processPayment(BigDecimal amount) {
        // Xử lý thanh toán thẻ
        return new PaymentResult(true, "SUCCESS", "Thanh toán thẻ thành công");
    }
}

// ✅ Client code - Có thể thay thế bất kỳ implementation nào
public class PaymentService {
    
    public void executePayment(PaymentProcessor processor, BigDecimal amount) {
        // Có thể truyền bất kỳ implementation nào của PaymentProcessor
        PaymentResult result = processor.processPayment(amount);
        
        if (result.isSuccess()) {
            System.out.println("Payment successful");
        }
    }
}
```

---

### 2.4. Interface Segregation Principle (ISP) ✅

**Định nghĩa:** Không nên ép client phải implement những methods mà nó không dùng.

**❌ Vi phạm ISP:**

```java
// BAD: Interface quá lớn
public interface NhanVienService {
    void chamCong();
    void nghiPhep();
    void doiCa();
    void tinhLuong();        // Chỉ dành cho kế toán
    void phanCongCa();       // Chỉ dành cho quản lý
    void danhGiaNhanVien();  // Chỉ dành cho quản lý
}

// NhanVienTheoDoiServiceImpl phải implement tất cả, kể cả methods không dùng
public class NhanVienTheoDoi ServiceImpl implements NhanVienService {
    // Phải implement tất cả methods kể cả không cần
}
```

**✅ Tuân thủ ISP:**

```java
// GOOD: Tách thành nhiều interfaces nhỏ

// Interface cho nhân viên thường
public interface ChamCongService {
    void chamCongVao();
    void chamCongRa();
}

public interface YeuCauNghiPhepService {
    void yeuCauNghiPhep(NghiPhepRequest request);
    void yeuCauDoiCa(DoiCaRequest request);
}

// Interface cho kế toán
public interface QuanLyLuongService {
    BangLuong tinhLuong(Integer thang, Integer nam);
    void xuatBangLuong();
}

// Interface cho quản lý
public interface QuanLyNhanVienService {
    void phanCongCa(PhanCongRequest request);
    void danhGiaNhanVien(DanhGiaRequest request);
}

// ✅ Class chỉ implement những gì nó cần
@Service
public class NhanVienServiceImpl implements ChamCongService, YeuCauNghiPhepService {
    // Chỉ implement 4 methods cần thiết
    @Override
    public void chamCongVao() { }
    
    @Override
    public void chamCongRa() { }
    
    @Override
    public void yeuCauNghiPhep(NghiPhepRequest request) { }
    
    @Override
    public void yeuCauDoiCa(DoiCaRequest request) { }
}
```

---

### 2.5. Dependency Inversion Principle (DIP) ✅

**Định nghĩa:** 
- High-level modules không nên phụ thuộc vào low-level modules. Cả hai nên phụ thuộc vào abstractions.
- Abstractions không nên phụ thuộc vào details. Details nên phụ thuộc vào abstractions.

**❌ Vi phạm DIP:**

```java
// BAD: Controller phụ thuộc trực tiếp vào concrete class
@RestController
public class DatPhongController {
    
    // ❌ Phụ thuộc vào implementation cụ thể
    private QuanLyDatPhongServiceImpl datPhongService;
    
    public DatPhongController() {
        // ❌ Tạo object trực tiếp
        this.datPhongService = new QuanLyDatPhongServiceImpl();
    }
}
```

**✅ Tuân thủ DIP:**

```java
// GOOD: Phụ thuộc vào interface

// 1. Abstraction (Interface)
public interface QuanLyDatPhongService {
    DatPhongResponse taoPhieuDatPhong(DatPhongRequest request);
}

// 2. Implementation
@Service
public class QuanLyDatPhongServiceImpl implements QuanLyDatPhongService {
    @Override
    public DatPhongResponse taoPhieuDatPhong(DatPhongRequest request) {
        // Implementation
    }
}

// 3. Controller phụ thuộc vào Interface
@RestController
@RequiredArgsConstructor  // Lombok tự động inject qua constructor
public class DatPhongController {
    
    // ✅ Phụ thuộc vào INTERFACE, không phải concrete class
    private final QuanLyDatPhongService datPhongService;
    
    @PostMapping("/dat-phong")
    public ResponseEntity<?> datPhong(@RequestBody DatPhongRequest request) {
        DatPhongResponse response = datPhongService.taoPhieuDatPhong(request);
        return ResponseEntity.ok(response);
    }
}
```

**Lợi ích:**
- ✅ Dễ test (có thể mock interface)
- ✅ Dễ thay đổi implementation
- ✅ Loose coupling

---

## 3. DESIGN PATTERNS

### 3.1. Repository Pattern ✅

**Mục đích:** Trừu tượng hóa data access layer.

```java
// Interface
public interface PhongRepository extends JpaRepository<Phong, Integer> {
    List<Phong> findByTrangThai(String trangThai);
    List<Phong> findByCoSo_MaCS(Integer maCoSo);
}

// Usage
@Service
public class QuanLyPhongService {
    
    private final PhongRepository phongRepository;
    
    public List<Phong> layPhongTrong() {
        return phongRepository.findByTrangThai("Trống");
    }
}
```

---

### 3.2. DTO Pattern ✅

**Mục đích:** Transfer data giữa layers mà không expose entities.

```java
// Entity - Không expose ra ngoài
@Entity
public class PhieuDatPhong {
    private Integer maPhieuDat;
    private KhachHang khachHang;  // Complex object
    private Phong phong;          // Complex object
    // ... many fields
}

// DTO - Expose ra API
@Data
public class DatPhongResponse {
    private Integer maPhieuDat;
    private String tenKhachHang;  // Flattened
    private String tenPhong;      // Flattened
    private BigDecimal chiPhiDuKien;
    // ... only necessary fields
}
```

---

### 3.3. Builder Pattern ✅

**Mục đích:** Xây dựng complex objects step by step.

```java
// Sử dụng Lombok @Builder
@Builder
public class PhieuDatPhong {
    private KhachHang khachHang;
    private Phong phong;
    private LocalDateTime ngayDat;
    // ...
}

// Usage
PhieuDatPhong phieu = PhieuDatPhong.builder()
    .khachHang(khachHang)
    .phong(phong)
    .ngayDat(LocalDateTime.now())
    .trangThai("Đã đặt")
    .build();
```

---

### 3.4. Dependency Injection Pattern ✅

**Mục đích:** Inject dependencies thay vì tạo bên trong class.

```java
@Service
@RequiredArgsConstructor  // Constructor injection
public class QuanLyDatPhongServiceImpl {
    
    // Dependencies được inject tự động
    private final PhieuDatPhongRepository phieuDatPhongRepository;
    private final PhongRepository phongRepository;
    private final KhachHangRepository khachHangRepository;
    
    // Spring tự động inject 3 dependencies qua constructor
}
```

---

## 4. MỐI QUAN HỆ GIỮA CÁC LỚP

### 4.1. One-to-Many Relationship

```java
// Phong (1) ─── (N) PhieuDatPhong

@Entity
public class Phong {
    @Id
    private Integer maPhong;
    
    // ✅ One Phong has Many PhieuDatPhong
    @OneToMany(mappedBy = "phong", cascade = CascadeType.ALL)
    private List<PhieuDatPhong> phieuDatPhongList;
}

@Entity
public class PhieuDatPhong {
    @Id
    private Integer maPhieuDat;
    
    // ✅ Many PhieuDatPhong belong to One Phong
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaPhong")
    private Phong phong;
}
```

---

### 4.2. Many-to-Many Relationship

```java
// DonGoiMon (N) ─── (N) MatHang (through ChiTietGoiMon)

@Entity
public class DonGoiMon {
    @Id
    private Integer maDonGoiMon;
    
    @OneToMany(mappedBy = "donGoiMon")
    private List<ChiTietGoiMon> chiTietList;
}

@Entity
public class MatHang {
    @Id
    private Integer maMatHang;
    
    @OneToMany(mappedBy = "matHang")
    private List<ChiTietGoiMon> chiTietList;
}

@Entity
public class ChiTietGoiMon {
    @Id
    private Integer maChiTiet;
    
    @ManyToOne
    @JoinColumn(name = "MaDonGoiMon")
    private DonGoiMon donGoiMon;
    
    @ManyToOne
    @JoinColumn(name = "MaMatHang")
    private MatHang matHang;
    
    private Integer soLuong;
    private BigDecimal donGia;
}
```

---

## 5. VÍ DỤ CODE CỤ THỂ

### 5.1. Một Use Case Hoàn Chỉnh

**Use Case:** Tạo phiếu đặt phòng

**Flow:** Request → Controller → Service → Repository → Database

```java
// 1. REQUEST DTO
@Data
@Builder
public class DatPhongRequest {
    @NotBlank
    private String tenKhachHang;
    
    @Pattern(regexp = "^0[0-9]{9}$")
    private String soDienThoai;
    
    @Min(1)
    private Integer soNguoi;
    
    private LocalDateTime thoiGianBatDau;
    private LocalDateTime thoiGianKetThuc;
}

// 2. CONTROLLER LAYER
@RestController
@RequestMapping("/api/v1/dat-phong")
@RequiredArgsConstructor
public class DatPhongController {
    
    private final QuanLyDatPhongService datPhongService;
    
    @PostMapping
    public ResponseEntity<ApiResponse<DatPhongResponse>> datPhong(
            @Valid @RequestBody DatPhongRequest request) {
        
        DatPhongResponse response = datPhongService.taoPhieuDatPhong(request);
        
        return ResponseEntity.ok(
            ApiResponse.success("Đặt phòng thành công", response)
        );
    }
}

// 3. SERVICE LAYER (Interface)
public interface QuanLyDatPhongService {
    DatPhongResponse taoPhieuDatPhong(DatPhongRequest request);
}

// 4. SERVICE LAYER (Implementation)
@Service
@RequiredArgsConstructor
@Transactional
public class QuanLyDatPhongServiceImpl implements QuanLyDatPhongService {
    
    private final PhieuDatPhongRepository phieuDatPhongRepository;
    private final KhachHangRepository khachHangRepository;
    private final PhongRepository phongRepository;
    
    @Override
    public DatPhongResponse taoPhieuDatPhong(DatPhongRequest request) {
        
        // Business Logic
        
        // 1. Tìm hoặc tạo khách hàng
        KhachHang khachHang = khachHangRepository.findBySdt(request.getSoDienThoai())
                .orElseGet(() -> taoKhachHangMoi(request));
        
        // 2. Tìm phòng trống
        List<Phong> phongTrong = phongRepository.findByTrangThai("Trống");
        if (phongTrong.isEmpty()) {
            throw new BusinessException("Không có phòng trống");
        }
        
        Phong phong = phongTrong.get(0);
        
        // 3. Tính tiền cọc
        BigDecimal chiPhiDuKien = tinhChiPhi(phong, request.getThoiGianBatDau(), request.getThoiGianKetThuc());
        BigDecimal tienCoc = chiPhiDuKien.multiply(BigDecimal.valueOf(0.3));
        
        // 4. Tạo phiếu đặt (Builder Pattern)
        PhieuDatPhong phieuDat = PhieuDatPhong.builder()
                .khachHang(khachHang)
                .phong(phong)
                .ngayDat(LocalDateTime.now())
                .thoiGianBatDau(request.getThoiGianBatDau())
                .thoiGianKetThuc(request.getThoiGianKetThuc())
                .soNguoi(request.getSoNguoi())
                .tienCoc(tienCoc)
                .trangThai("Đã đặt")
                .build();
        
        // 5. Save to database
        phieuDat = phieuDatPhongRepository.save(phieuDat);
        
        // 6. Cập nhật trạng thái phòng
        phong.setTrangThai("Đã đặt");
        phongRepository.save(phong);
        
        // 7. Chuyển đổi sang DTO
        return chuyenDoiSangResponse(phieuDat, chiPhiDuKien);
    }
    
    private KhachHang taoKhachHangMoi(DatPhongRequest request) {
        KhachHang khach = KhachHang.builder()
                .tenKH(request.getTenKhachHang())
                .sdt(request.getSoDienThoai())
                .loaiKhach("Thường")
                .build();
        return khachHangRepository.save(khach);
    }
    
    private BigDecimal tinhChiPhi(Phong phong, LocalDateTime batDau, LocalDateTime ketThuc) {
        long phut = ChronoUnit.MINUTES.between(batDau, ketThuc);
        float soGio = phut / 60.0f;
        BigDecimal giaTheoGio = phong.getLoaiPhong().getGiaTheoGio();
        return giaTheoGio.multiply(BigDecimal.valueOf(soGio));
    }
    
    private DatPhongResponse chuyenDoiSangResponse(PhieuDatPhong phieu, BigDecimal chiPhiDuKien) {
        return DatPhongResponse.builder()
                .maPhieuDat(phieu.getMaPhieuDat())
                .tenKhachHang(phieu.getKhachHang().getTenKH())
                .soDienThoai(phieu.getKhachHang().getSdt())
                .tenPhong(phieu.getPhong().getTenPhong())
                .chiPhiDuKien(chiPhiDuKien)
                .tienCoc(phieu.getTienCoc())
                .trangThai(phieu.getTrangThai())
                .thongBao("Đặt phòng thành công")
                .build();
    }
}

// 5. REPOSITORY LAYER
public interface PhieuDatPhongRepository extends JpaRepository<PhieuDatPhong, Integer> {
    List<PhieuDatPhong> findByKhachHang_MaKhach(Integer maKhach);
    List<PhieuDatPhong> findByTrangThai(String trangThai);
}

public interface KhachHangRepository extends JpaRepository<KhachHang, Integer> {
    Optional<KhachHang> findBySdt(String sdt);
}

public interface PhongRepository extends JpaRepository<Phong, Integer> {
    List<Phong> findByTrangThai(String trangThai);
}

// 6. RESPONSE DTO
@Data
@Builder
public class DatPhongResponse {
    private Integer maPhieuDat;
    private String tenKhachHang;
    private String soDienThoai;
    private String tenPhong;
    private BigDecimal chiPhiDuKien;
    private BigDecimal tienCoc;
    private String trangThai;
    private String thongBao;
}
```

---

## 📝 TÓM TẮT

### OOP được áp dụng như thế nào trong project:

1. **Encapsulation:** ✅ Private fields + Public getters/setters
2. **Abstraction:** ✅ Service interfaces vs Implementations
3. **Inheritance:** ✅ JpaRepository, Exception hierarchy
4. **Polymorphism:** ✅ Multiple payment methods, service implementations

### SOLID được áp dụng:

1. **SRP:** ✅ Mỗi service một trách nhiệm
2. **OCP:** ✅ Dễ mở rộng qua interfaces
3. **LSP:** ✅ Implementations có thể thay thế nhau
4. **ISP:** ✅ Interfaces nhỏ, chuyên biệt
5. **DIP:** ✅ Phụ thuộc vào abstractions

### Design Patterns:

1. **Layered Architecture** ✅
2. **Repository Pattern** ✅
3. **DTO Pattern** ✅
4. **Builder Pattern** ✅
5. **Dependency Injection** ✅

---

**🎓 Đây là một đồ án OOP chuẩn chỉnh, ready để trình bày và bảo vệ!**

---

*OOP Explanation Document*  
*Karaoke NNice Project*  
*December 6, 2025*
