# 📝 API 명세서 (API Documentation)

### ✅ 일정 관리 앱 만들기 과제 API 명세서

---
## 1. 일정 작성 (schedule Save)

* **URL**: `/schedules`
* **Method**: `POST`
* **Description**: 새로운 일정 작성(날짜,설명,위치)
* **데이터 전달 형식** : 'application/json'

### Request Body (JSON)
```json

{
  "title": "제목",
  "content": "내용",
  "scheduleDate": "2026-10-13"
}
```
### Response Body (JSON)
Status Code : 201 Created
```Json
{
  "id" : 1,
  "title": "제목",
  "content": "내용",
  "scheduleDate": "2026-10-13"
}
```
---
## 2. 일정 단건 조회(schedule GetOne)

* **URL**: `/schedules/{id}`
* **Method**: `GET`
* **Description**: 일정 단건 조회
* **데이터 전달 형식** : 'application/json'

### Response Body (JSON)
Status Code : 200 OK
```json

{
  "id" : 1,
  "title": "제목",
  "content": "내용",
  "scheduleDate": "2026-10-13"
}
```
---
## 3. 일정 다건 조회(schedule GetAll)

* **URL**: `/schedules`
* **Method**: `GET`
* **Description**: 일정 전체 조회
* **데이터 전달 형식** : 'application/json'

### Response Body (JSON)
Status Code : 200 OK
```json
[
  {
    "id" : 1,
    "title": "제목",
    "content": "내용",
    "scheduleDate": "2026-10-13"
  }
]
```
---
## 4. 일정 수정(schedule Update)

* **URL**: `/schedules/{id}`
* **Method**: `PATCH`
* **Description**: 일정 수정
* **데이터 전달 형식** : 'application/json'

### Request Body (JSON)
```json
{
  "title": "제목",
  "content": "내용",
  "scheduleDate": "2026-10-13"
}
```

### Response Body (JSON)
Status Code : 200 OK
```json
{
  "id" : 1,
  "title": "제목",
  "content": "내용",
  "scheduleDate": "2026-10-13"
}
```
---
## 5. 일정 삭제(schedule Delete)

* **URL**: `/schedules/{id}`
* **Method**: `DELETE`
* **Description**: 일정 선택 삭제
* **데이터 전달 형식** : 'application/json'

### Response Body (JSON)
Status Code : 204 No Content
```json
{
  
  
}
```
--- 