## CybersoftBnb Website – Test Automation Project

### 1. Giới thiệu dự án
Đây là dự án **kiểm thử cho Website đặt phòng khách sạn CybersoftBnb**, kết hợp cả **Manual Testing** và **Automation Testing** nhằm đảm bảo:
- **Tính đúng đắn** của các chức năng chính.
- **Trải nghiệm người dùng ổn định** trong nhiều kịch bản sử dụng khác nhau.
- **Hạn chế lỗi phát sinh** khi phát triển và triển khai tính năng mới.

### 2. Phạm vi kiểm thử
- **Xác thực người dùng**
  - Đăng ký tài khoản.
  - Đăng nhập.
- **Tìm kiếm phòng**
  - Tìm phòng theo địa điểm.
  - Tìm phòng theo ngày nhận/trả phòng.
  - Tìm phòng theo số lượng khách.
- **Đặt phòng**
  - Chọn phòng và xem chi tiết.
  - Thực hiện quy trình đặt phòng.
- **Quản lý hồ sơ người dùng**
  - Xem và chỉnh sửa thông tin cá nhân.
  - Xem lịch sử đặt phòng.

### 3. Loại hình kiểm thử
- **Manual Testing**
  - Thiết kế và thực thi test case thủ công.
  - Ghi nhận kết quả và log bug trên Jira.
- **Automation Testing**
  - Tự động hóa các kịch bản quan trọng, có tính lặp lại cao.
  - Tập trung vào các luồng nghiệp vụ chính (happy path & critical flow).

### 4. Công cụ & Công nghệ
- **Quản lý test case**: Google Sheets.
- **Quản lý bug**: Jira.
- **Automation framework**: Selenium.
- **Ngôn ngữ lập trình**: Java.
- **Trình duyệt chạy automation**: Chrome.
- **Mô hình thiết kế**: Page Object Model (POM).

### 5. Cấu trúc dự án (thư mục chính)
- **`src/main/java/pages`**: Chứa các lớp Page Object cho từng trang (Login, Register, Search, Room Detail, Profile, v.v.).
- **`src/test/java/tests`**: Chứa các test case automation (theo module hoặc theo chức năng).
- **`test-output`**: Thư mục chứa **báo cáo test** và **screenshot** khi chạy test.
- **`pom.xml` / file cấu hình build** (nếu là Maven/Gradle): Khai báo dependency, plugin, cấu hình chạy test.

> Lưu ý: Cấu trúc chi tiết có thể thay đổi tùy vào cách tổ chức trong dự án thực tế, nhưng vẫn bám theo mô hình POM.

### 6. Thiết lập môi trường (Setup)
#### 6.1. Yêu cầu hệ thống
- **JDK** 8+ (khuyến nghị JDK 11 trở lên).
- **Maven** hoặc công cụ build tương ứng (nếu dự án dùng Maven).
- **Git** để lấy mã nguồn.
- **Google Chrome** bản mới nhất.
- IDE khuyến nghị: **IntelliJ IDEA** hoặc **VS Code** với plugin Java.

#### 6.2. Cài đặt & chạy dự án
1. **Clone source code**
   ```bash
   git clone <repository-url>
   cd airbnb-clone-automation
   ```
2. **Cài đặt dependency**
   - Nếu dùng Maven:
     ```bash
     mvn clean install
     ```
3. **Cấu hình base URL & browser (nếu có file config)**
   - Cập nhật URL môi trường test:
     - **URL**: `https://demo5.cybersoft.edu.vn/`
   - Đảm bảo cấu hình sử dụng **Chrome** làm trình duyệt mặc định.
4. **Chạy test**
   - Chạy toàn bộ test suite:
     ```bash
     mvn test
     ```
   - Hoặc chạy theo class / group tùy theo cấu hình TestNG/JUnit (nếu có).

### 7. Tự động hóa kiểm thử (Test Automation)
- **Kịch bản được tự động hóa**
  - Đăng nhập/Đăng xuất.
  - Tìm kiếm phòng theo địa điểm, ngày, số khách.
  - Đặt phòng thành công (happy path).
  - Cập nhật thông tin cá nhân cơ bản.
- **Thiết kế POM**
  - Mỗi trang được biểu diễn bởi một lớp Page Object.
  - Tách riêng **locator** và **hàm hành động** giúp:
    - Dễ bảo trì.
    - Dễ tái sử dụng cho nhiều test case.
- **Báo cáo & log**
  - Tự động sinh **báo cáo HTML** sau mỗi lần chạy test (ExtentReport).
  - Lưu **screenshot** khi test fail để hỗ trợ phân tích lỗi.

### 8. Môi trường kiểm thử (Test Environment)
- **URL**: `https://demo5.cybersoft.edu.vn/`
- **Browser chính**: Google Chrome.
- Có thể bổ sung thêm các trình duyệt khác (Edge, Firefox, …) trong tương lai nếu mở rộng phạm vi automation.

### 9. Cách đọc báo cáo & kết quả test
- Sau khi chạy test, báo cáo nằm trong thư mục:
  - `test-output/ExtentReport.html` (hoặc tương đương).
- Mở file báo cáo bằng trình duyệt để xem:
  - Tổng quan số test **Passed/Failed/Skipped**.
  - Chi tiết từng test case.
  - Screenshot đính kèm cho test lỗi (nếu có cấu hình).

### 10. Đóng góp & phát triển thêm
- **Mở rộng test case**:
  - Thêm test case negative, edge case, boundary value.
  - Thêm test cho các module mới của website.
- **Mở rộng automation**:
  - Tích hợp chạy test song song (parallel execution).
  - Tích hợp CI/CD (Jenkins/GitHub Actions) để chạy test tự động khi có commit mới.

---


