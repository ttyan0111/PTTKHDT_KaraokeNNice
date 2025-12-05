/**
 * ========================================================================
 * HƯỚNG DẪN CHI TIẾT CẤU TRÚC KARAOKE NNICE API
 * ========================================================================
 * 
 * 1. LUỒNG DỮ LIỆU (DATA FLOW)
 * ========================================================================
 * 
 * Client (Postman/Frontend)
 *        ↓
 *    HTTP Request
 *        ↓
 *   CONTROLLER (DatPhongController)
 *        ↓
 *   SERVICE (QuanLyDatPhongServiceImpl)
 *        ↓
 *   REPOSITORY (DatPhongRepository)
 *        ↓
 *   DATABASE (MySQL)
 * 
 * ========================================================================
 * 
 * 2. CÁC LAYER VÀ TRÁCH NHIỆM
 * ========================================================================
 * 
 * A. ENTITY (entity/)
 *    - Đại diện cho bảng trong database
 *    - Chứa các trường dữ liệu tương ứng với cột bảng
 *    - Ví dụ: DatPhong.java có các field: id, khachHang, phong, thoiGianVao...
 *    - Sử dụng @Entity, @Table, @Column, @ManyToOne...
 * 
 * B. DTO - Data Transfer Object (dto/)
 *    
 *    b1. REQUEST DTO (dto/request/)
 *        - Nhận dữ liệu từ client
 *        - Ví dụ: DatPhongRequest nhận: khachHangId, phongId, thoiGianVao, thoiGianRaDuKien
 *        - Không chứa ID (vì chưa lưu vào database)
 *        - Không chứa các trường tính toán (như tongTien - được tính bằng logic)
 * 
 *    b2. RESPONSE DTO (dto/response/)
 *        - Trả dữ liệu về cho client
 *        - Ví dụ: DatPhongResponse trả về: id, khachHangId, phongId, tongTien, trangThai...
 *        - Chứa ID (vì đã lưu vào database)
 *        - Chứa các trường tính toán
 * 
 * C. REPOSITORY (repository/)
 *    - Giao tiếp trực tiếp với database
 *    - Chỉ chứa các phương thức CRUD (Create, Read, Update, Delete)
 *    - Ví dụ: DatPhongRepository extends JpaRepository<DatPhong, Long>
 *    - Có sẵn: findAll(), findById(), save(), delete()...
 *    - Có thể thêm custom query nếu cần
 * 
 * D. SERVICE (service/ + service/impl/)
 *    
 *    d1. SERVICE INTERFACE (service/IQuanLyDatPhongService.java)
 *        - Định nghĩa các phương thức abstract
 *        - Giống hợp đồng - các phương thức nào cần implement
 *        - Ví dụ: datPhongMoi(), layChiTietDatPhong(), checkIn()...
 * 
 *    d2. SERVICE IMPLEMENTATION (service/impl/QuanLyDatPhongServiceImpl.java)
 *        - Implement các phương thức từ interface
 *        - Chứa BUSINESS LOGIC chính
 *        - Nhận Request DTO → Xử lý logic → Trả Response DTO
 *        - Gọi Repository để lấy/lưu dữ liệu
 *        - Ví dụ:
 *          • Kiểm tra khách hàng có tồn tại
 *          • Kiểm tra phòng có trống
 *          • Tính tiền theo giờ sử dụng
 *          • Cập nhật trạng thái
 * 
 * E. CONTROLLER (controller/)
 *    - Là "nhân viên tiếp nhận" của API
 *    - Nhận HTTP request từ client
 *    - Gọi Service để xử lý
 *    - Trả HTTP response về client
 *    - Ví dụ: DatPhongController
 *      • POST /api/dat-phong → datPhongMoi()
 *      • GET /api/dat-phong/{id} → layChiTietDatPhong()
 *      • GET /api/dat-phong → layTatCaDatPhong()
 *      • PUT /api/dat-phong/{id} → capNhatDatPhong()
 *      • DELETE /api/dat-phong/{id} → xoaDatPhong()
 * 
 * ========================================================================
 * 
 * 3. MỐI QUAN HỆ GIỮA CÁC LAYER
 * ========================================================================
 * 
 * EXAMPLE: Tạo mới đặt phòng
 * 
 * CLIENT gửi JSON:
 * {
 *     "khachHangId": 1,
 *     "phongId": 5,
 *     "thoiGianVao": "2024-12-04T14:00:00",
 *     "thoiGianRaDuKien": "2024-12-04T16:00:00"
 * }
 * 
 * ↓
 * 
 * CONTROLLER (DatPhongController.datPhongMoi)
 * @PostMapping
 * public ResponseEntity<DatPhongResponse> datPhongMoi(@RequestBody DatPhongRequest request)
 * 
 * - @RequestBody tự động convert JSON → DatPhongRequest object
 * - Gọi: datPhongService.datPhongMoi(request)
 * 
 * ↓
 * 
 * SERVICE (QuanLyDatPhongServiceImpl.datPhongMoi)
 * 
 * 1. Kiểm tra KhachHang có tồn tại:
 *    khachHangRepository.findById(request.getKhachHangId())
 *    Nếu không → throw ResourceNotFoundException
 * 
 * 2. Kiểm tra Phong có tồn tại:
 *    phongRepository.findById(request.getPhongId())
 *    Nếu không → throw ResourceNotFoundException
 * 
 * 3. Tạo Entity DatPhong từ Request:
 *    DatPhong datPhong = new DatPhong();
 *    datPhong.setKhachHang(khachHang);
 *    datPhong.setPhong(phong);
 *    datPhong.setThoiGianVao(request.getThoiGianVao());
 *    datPhong.setThoiGianRaDuKien(request.getThoiGianRaDuKien());
 *    datPhong.setTrangThai("CHO_SU_DUNG");
 * 
 * 4. Lưu vào database:
 *    datPhong = datPhongRepository.save(datPhong);
 *    → Database tự tạo ID và lưu record
 * 
 * 5. Convert Entity → Response DTO:
 *    DatPhongResponse response = convertToResponse(datPhong);
 *    - Lấy dữ liệu từ Entity
 *    - Đưa vào Response DTO
 * 
 * ↓
 * 
 * CONTROLLER trả Response:
 * return ResponseEntity.status(HttpStatus.CREATED).body(response);
 * 
 * ↓
 * 
 * CLIENT nhận JSON Response:
 * {
 *     "id": 1,
 *     "khachHangId": 1,
 *     "phongId": 5,
 *     "thoiGianVao": "2024-12-04T14:00:00",
 *     "thoiGianRaDuKien": "2024-12-04T16:00:00",
 *     "thoiGianRaThucTe": null,
 *     "tongTien": null,
 *     "trangThai": "CHO_SU_DUNG"
 * }
 * 
 * ========================================================================
 * 
 * 4. REQUEST vs RESPONSE DTO
 * ========================================================================
 * 
 * REQUEST DTO (Input từ client):
 * - Chứa: khachHangId, phongId, thoiGianVao, thoiGianRaDuKien
 * - Không chứa: id (vì chưa tạo), tongTien (chưa tính), thoiGianRaThucTe (chưa check-out)
 * - Dùng cho: CREATE, UPDATE
 * 
 * RESPONSE DTO (Output về client):
 * - Chứa: TOÀN BỘ thông tin (id, khachHangId, phongId, thoiGianVao, thoiGianRaDuKien, thoiGianRaThucTe, tongTien, trangThai)
 * - Dùng cho: Trả về kết quả sau khi xử lý
 * 
 * ========================================================================
 * 
 * 5. KHI NÀO DÙNG REPOSITORY TRỰC TIẾP?
 * ========================================================================
 * 
 * DÙNG:
 * - Trong SERVICE để lấy/lưu dữ liệu từ database
 * - Ví dụ: datPhongRepository.findById(), save(), delete()
 * 
 * KHÔNG DÙNG:
 * - Trực tiếp trong Controller (phá vỡ MVC pattern)
 * - Service sẽ gọi Repository thay bạn
 * 
 * ========================================================================
 * 
 * 6. EXCEPTION HANDLING
 * ========================================================================
 * 
 * ResourceNotFoundException:
 * - Khi không tìm thấy bản ghi
 * - Ví dụ: throw new ResourceNotFoundException("Khách hàng không tồn tại")
 * 
 * BusinessException:
 * - Khi business logic bị vi phạm
 * - Ví dụ: throw new BusinessException("Phòng đã bị đặt")
 * 
 * GlobalExceptionHandler:
 * - @RestControllerAdvice tự động catch exceptions
 * - Trả về error response cho client
 * 
 * ========================================================================
 * 
 * 7. DEPENDENCIES (@Autowired)
 * ========================================================================
 * 
 * Controller inject Service:
 * @Autowired
 * private IQuanLyDatPhongService datPhongService;
 * → Gọi: datPhongService.datPhongMoi(request)
 * 
 * Service inject Repository:
 * @Autowired
 * private DatPhongRepository datPhongRepository;
 * → Gọi: datPhongRepository.save(datPhong)
 * 
 * ========================================================================
 * 
 * 8. EXAMPLE: COMPLETE FLOW
 * ========================================================================
 * 
 * Tạo mới đặt phòng:
 * 
 * 1. CLIENT:
 *    POST http://localhost:8080/api/dat-phong
 *    {
 *        "khachHangId": 1,
 *        "phongId": 5,
 *        "thoiGianVao": "2024-12-04T14:00:00",
 *        "thoiGianRaDuKien": "2024-12-04T16:00:00"
 *    }
 * 
 * 2. CONTROLLER (DatPhongController):
 *    @PostMapping
 *    public ResponseEntity<DatPhongResponse> datPhongMoi(@RequestBody DatPhongRequest request)
 *    {
 *        // request = { khachHangId: 1, phongId: 5, ... }
 *        DatPhongResponse response = datPhongService.datPhongMoi(request);
 *        return ResponseEntity.status(HttpStatus.CREATED).body(response);
 *    }
 * 
 * 3. SERVICE (QuanLyDatPhongServiceImpl):
 *    @Override
 *    public DatPhongResponse datPhongMoi(DatPhongRequest request)
 *    {
 *        // Kiểm tra KhachHang
 *        KhachHang khachHang = khachHangRepository.findById(request.getKhachHangId())
 *                .orElseThrow(() -> new ResourceNotFoundException("Khách hàng không tồn tại"));
 *        
 *        // Kiểm tra Phong
 *        Phong phong = phongRepository.findById(request.getPhongId())
 *                .orElseThrow(() -> new ResourceNotFoundException("Phòng không tồn tại"));
 *        
 *        // Tạo Entity
 *        DatPhong datPhong = new DatPhong();
 *        datPhong.setKhachHang(khachHang);
 *        datPhong.setPhong(phong);
 *        datPhong.setThoiGianVao(request.getThoiGianVao());
 *        datPhong.setThoiGianRaDuKien(request.getThoiGianRaDuKien());
 *        datPhong.setTrangThai("CHO_SU_DUNG");
 *        
 *        // Lưu vào database
 *        datPhong = datPhongRepository.save(datPhong);
 *        
 *        // Convert sang Response DTO
 *        return convertToResponse(datPhong);
 *    }
 * 
 * 4. REPOSITORY (DatPhongRepository):
 *    datPhongRepository.save(datPhong)
 *    → INSERT vào bảng dat_phong
 *    → Database trả về Entity với ID tự sinh
 * 
 * 5. CLIENT nhận:
 *    {
 *        "id": 1,
 *        "khachHangId": 1,
 *        "phongId": 5,
 *        "thoiGianVao": "2024-12-04T14:00:00",
 *        "thoiGianRaDuKien": "2024-12-04T16:00:00",
 *        "thoiGianRaThucTe": null,
 *        "tongTien": null,
 *        "trangThai": "CHO_SU_DUNG"
 *    }
 * 
 * ========================================================================
 */
