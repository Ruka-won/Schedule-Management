# 📝 API 명세서 (API Documentation)

### ✅ 일정 관리 앱 만들기 과제 API 명세서

---
## 1. 일정 작성 (schedule Save)

* **API URL**: `/schedules`
* **Method**: `POST`
* **Description**: 새로운 일정 작성
* **header** : 'application/json'
### Request Body (JSON)
```json

{
  "title": "일정 제목",
  "content": "일정 내용",
  "author" : "작성자",
  "password": "일정 수정용 비밀번호",
  "createAt" : "일정 생성일",
  "modifiedAt" : "일정 수정일"
}
```
### Request Body 상세 설명
| Field | DataType | description |
| :---: | :---: | :---: |
|title | String | 일정 제목 |
|content | String | 일정 내용 |
| author | String | 작성자 |
| password | String | 일정 수정용 비밀번호 |
| creatAt | LocalDateTime | 일정 생성일 |
| modifiedAt | LocalDateTime | 일정 수정일 |


### Response Body (JSON)
Status Code : 201 Created
```Json
{
  "id" : 1
}
```
### Response 상세 설명
| Field | description |
| :---: | :---: |
|id | 고유한 식별값 |

---
## 2. 일정 단건 조회(schedule GetOne)

* **API URL**: `/schedules/{id}`
* **Method**: `GET`
* **Description**: 일정 단건 조회
* **header** : 'application/json'

### Response Body (JSON)
Status Code : 200 OK
```json

{
  "id" : 1,
  "title": "일정 제목",
  "content": "일정 내용",
  "author" : "작성자",
  "createAt" : "일정 생성일",
  "modifiedAt" : "일정 수정일"
}
```
### Response Body 상세 설명
| Field | DataType | description |
| :---: | :---: | :---: |
| id | Long | 고유 식별값|
|title | String | 일정 제목 |
|content | String | 일정 내용 |
| author | String | 작성자 |
| creatAt | LocalDateTime | 일정 생성일 |
| modifiedAt | LocalDateTime | 일정 수정일 |
---
## 3. 일정 다건 조회(schedule GetAll)

* **API URL**: `/schedules`
* **Method**: `GET`
* **Description**: 일정 전체 조회
* **header** : 'application/json'

### Response Body (JSON)
Status Code : 200 OK
```json
{
  "scheduleList" : [
    {
      "id" : 1,
      "title": "일정 제목",
      "content": "일정 내용",
      "author" : "작성자",
      "createAt" : "일정 생성일",
      "modifiedAt" : "일정 수정일"
    },
    {
      "id" : 2,
      "title": "일정 제목",
      "content": "일정 내용",
      "author" : "작성자",
      "createAt" : "일정 생성일",
      "modifiedAt" : "일정 수정일"
    }
  ]
}

```
### Response Body 상세 설명
| Field | DataType | description |
| :---: | :---: | :---: |
| id | Long | 고유 식별값|
|title | String | 일정 제목 |
|content | String | 일정 내용 |
| author | String | 작성자 |
| creatAt | LocalDateTime | 일정 생성일 |
| modifiedAt | LocalDateTime | 일정 수정일 |

---
## 4. 일정 수정(schedule Update)

* **API URL**: `/schedules/{id}`
* **Method**: `PATCH`
* **Description**: 일정 일부 수정(일정 수정시 비밀번호 대칭하여 수정 권한 줘야함)
* **header** : 'application/json'

### Request Body (JSON)
```json
{
  "title": "일정 제목",
  "content": "일정 내용",
  "author" : "작성자",
  "password": "일정 수정용 비밀번호",
  "modifiedAt" : "일정 수정일"
}
```
### Request Body 상세 설명
| Field | DataType | description |
| :---: | :---: | :---: |
|title | String | 일정 제목 |
| content | String | 일정 내용 |
| author | String | 작성자 |
| password | String | 일정 수정용 비밀번호 |
| modifiedAt | LocalDateTime | 일정 수정일 |

### Response Body (JSON)
Status Code : 200 OK
```json
{
  "id" : 1,
  "title": "수정된 제목",
  "content": "수정된 내용",
  "autor" : "수정된 작성자",
  "modifiedAt" : "수정된 일정 수정일"
}
```
### Response Body 상세 설명
| Field | DataType | description |
| :---: | :---: | :---: |
| id | Long | 고유 식별값 |
|title | String | 일정 제목 |
| content | String | 일정 내용 |
| author | String | 작성자 |
| modifiedAt | LocalDateTime | 일정 수정일 |
---
## 5. 일정 삭제(schedule Delete)

* **API URL**: `/schedules/{id}`
* **Method**: `DELETE`
* **Description**: 일정 선택 삭제
* **header** : 'application/json'

### Response Body (JSON)
Status Code : 204 No Content

```json
{
  "status": 204
}
```
### Response Body 상세 설명
| Field | DataType | description |
| :---: | :---: | :---: |
| status | int | status code 응답 (성공 유무) |
--- 