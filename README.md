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
