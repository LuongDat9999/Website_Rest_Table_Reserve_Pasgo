## Website Đặt Bàn Nhà Hàng – Pasgo

Hệ thống web đặt bàn nhà hàng xây dựng với Spring Boot 3, Thymeleaf, và Microsoft SQL Server. Dự án hỗ trợ quản lý nhà hàng/đối tác, đặt bàn, theo dõi đơn, thống kê, và trang chủ giới thiệu dịch vụ cho khách hàng.

> 🔎 Báo cáo chi tiết dự án: xem file PDF ngay tại repo
>
> 👉 [Report_Detail.pdf](Report_Detail.pdf)

### Nổi bật
- **Spring Boot 3.3.1**, **Java 17**
- **Thymeleaf** cho giao diện server-side, thư mục `templates/` và `static/`
- **JPA/Hibernate** với SQL Server
- Tổ chức module rõ ràng: `controller/`, `service/`, `repository/`, `model/`
- Nhiều trang giao diện sẵn: `trangchu/`, `doitac/`, `quanly/`, `fragments/`

### Cấu trúc chính
- `src/main/java/com/example/baimoi/` – mã nguồn backend (controller, service, repository, model)
- `src/main/resources/templates/` – trang Thymeleaf (HTML)
- `src/main/resources/static/` – tài nguyên tĩnh (CSS/JS/Images, CKEditor)
- `application.properties` – cấu hình ứng dụng
- `pom.xml` – phụ thuộc Maven
- `Report_Detail.pdf` – 📄 báo cáo chi tiết dự án

### Công nghệ
- Spring Boot Starter Web, Thymeleaf, Data JPA, Validation, DevTools
- Hibernate Core
- Microsoft SQL Server JDBC Driver

### Yêu cầu môi trường
- Java 17
- Maven 3.9+
- SQL Server đang chạy và cho phép kết nối

### Cấu hình cơ sở dữ liệu
Cập nhật `src/main/resources/application.properties` (ví dụ):

```properties
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=pasgo;encrypt=false
spring.datasource.username=sa
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### Chạy dự án
```bash
mvn spring-boot:run
```
Hoặc build JAR:
```bash
mvn clean package
java -jar target/baimoi-0.0.1-SNAPSHOT.jar
```

### Các trang tiêu biểu
- Trang chủ/đặt bàn: `templates/trangchu/`
- Quản lý đối tác/nhà hàng: `templates/doitac/`
- Quản lý hệ thống: `templates/quanly/`
- Thành phần giao diện dùng lại: `templates/fragments/`

### Phát triển
- IDE khuyến nghị: IntelliJ IDEA / VS Code (Extensions Java)
- Sử dụng **DevTools** để tự động reload khi phát triển

### Báo cáo chi tiết (PDF)
- Tài liệu thuyết minh, luồng hệ thống, thiết kế CSDL, và hướng dẫn sử dụng ở: **[Report_Detail.pdf](Report_Detail.pdf)**

### Giấy phép
Mã nguồn thuộc quyền tác giả của nhóm phát triển dự án Pasgo. Vui lòng tham khảo điều khoản sử dụng nội bộ của bạn.


