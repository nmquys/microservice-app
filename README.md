# 🚀 MongoDB Setup Guide (Docker Compose)

---

# 1. Khởi động MongoDB bằng Docker Compose

## Chạy MongoDB

```bash
docker compose up -d
```

## Kiểm tra container

```bash
docker ps
```

Kết quả mong đợi:

```
PORTS: 0.0.0.0:27017->27017
```

---

# 2. Thông tin cấu hình MongoDB trong docker-compose

```text
Username: root
Password: password
Database: product-service
```

---

# 3. Kiểm tra MongoDB hoạt động

## Mở Mongo Shell (có auth)

```bash
mongosh "mongodb://root:password@localhost:27017/product-service?authSource=admin"
```

Nếu thành công:

```
product-service>
```

## Test nhanh

```js
show dbs
```

---

# 4. Cấu hình Spring Boot

## application.properties

```properties
spring.data.mongodb.uri=mongodb://root:password@localhost:27017/product-service?authSource=admin
```

📌 Lưu ý:

* MongoDB có authentication → phải có username/password
* Port mặc định: 27017

---

# 5. Chạy Spring Boot

```bash
./mvnw spring-boot:run
```

hoặc

```bash
mvn spring-boot:run
```

---

# 6. Kiểm tra dữ liệu trong MongoDB

```js
use product-service
show collections
db.product.find()
```

---

# 7. Quản lý MongoDB container

## Start lại

```bash
docker compose start
```

## Stop

```bash
docker compose stop
```

## Xoá toàn bộ (container + network)

```bash
docker compose down
```

---

# 🐬 MySQL Setup Guide (Linux + IntelliJ)

## 1. Truy cập MySQL bằng quyền root (Linux)

Sử dụng quyền `sudo` để vào MySQL mà không cần password:

```bash
sudo mysql
```

---

## 2. Thiết lập password cho user `root`

### 🔹 Trường hợp CHƯA có password

Chạy các lệnh sau trong MySQL:

```sql
ALTER USER 'root'@'localhost'
IDENTIFIED WITH mysql_native_password BY 'Root@123456';

FLUSH PRIVILEGES;
```

---

### 🔹 Trường hợp ĐÃ có password

Thoát MySQL:

```sql
exit;
```

Login lại bằng password:

```bash
mysql -u root -p
```

Nhập password:

```text
Ex: Root@12345
```

---

## 3. Kiểm tra đăng nhập

Sau khi login thành công, bạn sẽ thấy:

```bash
mysql>
```

---

## 4. Kiểm tra Database
```bash
mysql> SHOW DATABASE;
```

## 5. Cấu hình IntelliJ IDEA

Trong IntelliJ:

* **Host**: `localhost`
* **Port**: `3306`
* **User**: `root`
* **Password**: (password đã set ở trên)
* **Database**: (có thể để trống hoặc nhập tên DB)

👉 URL:

```text
jdbc:mysql://localhost:3306/order_service
```

---

## 6. Kiểm tra kết nối

* Nhấn **Test Connection**
* Nếu thành công sẽ hiển thị version MySQL (ví dụ: 8.x.x)

---
<img width="682" height="741" alt="image" src="https://github.com/user-attachments/assets/29a4d754-94cb-4f8f-aaa9-5f72b9cd76a3" />


