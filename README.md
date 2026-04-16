
# 🚀 MongoDB setup guide

---

# 1. Khởi động MongoDB bằng Docker

## Chạy MongoDB

```bash
docker run -d -p 27017:27017 --name mongodb mongo
```

## Kiểm tra container

```bash
docker ps
```

Kết quả mong đợi:

```
0.0.0.0:27017->27017
```

---

# 2. Kiểm tra MongoDB hoạt động

## Mở Mongo Shell

```bash
mongosh
```

Nếu thành công:

```
test>
```

## Test nhanh

```js
show dbs
```

---

# 3. Cấu hình Spring Boot

## application.properties

```properties
spring.data.mongodb.uri=mongodb://localhost:27017/product-service
```

* Port mặc định MongoDB là 27017

---

# 4. Chạy Spring Boot

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
docker start mongodb
```

## Stop

```bash
docker stop mongodb
```

## Xoá container

```bash
docker rm -f mongodb
```

---

