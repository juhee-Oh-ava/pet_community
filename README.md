# 🐾 Pet Community Board

Spring Boot 기반으로 구현한 간단한 **펫 커뮤니티 게시판 프로젝트**입니다.
현재는 **게시판 CRUD 기능**과 **회원가입 / 로그인 기능**까지 구현되어 있으며, 댓글(reply) 기능은 ERD 설계만 완료된 상태입니다.

---

## 📌 프로젝트 개요

* 펫 커뮤니티를 위한 기본 게시판 서비스
* Spring MVC + Spring Data JPA 기반
* 사용자 인증/인가에 **Spring Security** 적용
* mustache 이용한 서버 사이드 렌더링

---

## 🛠 기술 스택

### Backend

* Java 17
* Spring Boot
* Spring MVC
* Spring Data JPA
* Spring Security
* Hibernate

### Database

* MySQL (개발 환경 기준)

### Frontend

* mustache
* HTML

---

## 📂 주요 기능

### 📝 게시판 (Articles)

* 게시글 목록 조회
* 게시글 상세 조회
* 게시글 작성
* 게시글 수정
* 게시글 삭제

> 현재 모든 게시글 기능은 기본 CRUD 중심으로 구현되어 있습니다.

---

### 👤 사용자 (Users)

* 회원가입
* 로그인
* 비밀번호 암호화 (PasswordEncoder 사용)
* Spring Security 기반 인증 처리

> 사용자 인증은 Spring Security를 사용하여 구현되었으며,
> 이메일 중복 검증 후 회원가입이 진행됩니다.

---

## 🧱 ERD 설계

### 엔티티 구조

* **users**
* **posts**
* **reply** (미구현)

### 관계

* users : posts = **1 : N**
* users : reply = **1 : N**
* posts : reply = **1 : N**

> ⚠️ reply(댓글) 기능은 현재 ERD 설계만 완료된 상태이며,
> 엔티티 / 컨트롤러 / 서비스 구현은 추후 예정입니다.

---

## 🔐 Spring Security 적용 내용

* 사용자 인증 처리
* 비밀번호 단방향 암호화 저장
* 로그인 상태 확인 가능 (`@AuthenticationPrincipal` 사용)

---

## 📁 패키지 구조 (요약)

```
pet.community
 ├── controller
 │   ├── ArticleController
 │   └── UserController
 ├── dto
 ├── entity
 ├── repository
 ├── service
 └── config (Security 설정)
```

---

## 🚀 실행 방법

1. 프로젝트 클론
2. `application.properties`에 DB 설정
3. MySQL 실행
4. Spring Boot 실행
5. 브라우저 접속

```
http://localhost:8080/signup
```

---

## 📌 향후 개선 예정 사항

* 댓글(reply) 기능 구현
* 게시글 작성자 권한 체크
* 게시글/댓글 권한 기반 수정·삭제
* 페이징 처리
* 예외 처리 및 에러 페이지 개선

---

## 📄 참고

해당 프로젝트는 **Spring Boot 및 Spring Security 학습 목적**으로 제작된 개인 프로젝트입니다.

---

## 📑 API 명세서

### 📝 게시판 (Articles)

#### 1. 게시글 목록 조회

* **URL**: `/articles`
* **Method**: `GET`
* **Description**: 전체 게시글 목록 조회
* **Response View**: `articles/index`

---

#### 2. 게시글 상세 조회

* **URL**: `/articles/{id}`
* **Method**: `GET`
* **Path Variable**:

  * `id` (Long): 게시글 ID
* **Description**: 특정 게시글 상세 조회
* **Response View**: `articles/show`

---

#### 3. 게시글 작성 폼 이동

* **URL**: `/articles/new`
* **Method**: `GET`
* **Description**: 게시글 작성 페이지 이동
* **Response View**: `articles/new`

---

#### 4. 게시글 작성

* **URL**: `/articles/create`
* **Method**: `POST`
* **Request Body (Form)**:

  * `title`
  * `content`
* **Description**: 게시글 생성 후 상세 페이지로 리다이렉트
* **Redirect**: `/articles/{id}`

---

#### 5. 게시글 수정 폼 이동

* **URL**: `/articles/{id}/edit`
* **Method**: `GET`
* **Path Variable**:

  * `id` (Long): 게시글 ID
* **Description**: 게시글 수정 페이지 이동
* **Response View**: `articles/edit`

---

#### 6. 게시글 수정

* **URL**: `/articles/update`
* **Method**: `POST`
* **Request Body (Form)**:

  * `id`
  * `title`
  * `content`
* **Description**: 게시글 수정 후 상세 페이지로 리다이렉트
* **Redirect**: `/articles/{id}`

---

#### 7. 게시글 삭제

* **URL**: `/articles/{id}/delete`
* **Method**: `GET`
* **Path Variable**:

  * `id` (Long): 게시글 ID
* **Description**: 게시글 삭제 후 목록 페이지로 리다이렉트
* **Redirect**: `/articles`

---

### 👤 사용자 (Users)

#### 1. 회원가입 페이지 이동

* **URL**: `/signup`
* **Method**: `GET`
* **Description**: 회원가입 페이지 이동
* **Response View**: `signup`

---

#### 2. 회원가입 처리

* **URL**: `/signup`
* **Method**: `POST`
* **Request Body (Form)**:

  * `email`
  * `password`
  * `username`
* **Description**:

  * 이메일 중복 체크
  * 비밀번호 암호화 후 사용자 저장
* **Redirect**: `/login`

---

#### 3. 로그인 페이지 이동

* **URL**: `/login`
* **Method**: `GET`
* **Description**:

  * 로그인 페이지 이동
  * 로그인 상태일 경우 사용자 정보 조회 가능
* **Response View**: `login`

---

### 💬 댓글 (Reply)

> ⚠️ 현재 미구현 상태

#### 예정 기능

* 댓글 작성
* 댓글 수정
* 댓글 삭제
* 게시글별 댓글 조회


* 모든 요청/응답은 서버 렌더링(Thymeleaf)을 기준으로 동작합니다.
* API 명세는 Controller 기준으로 작성되었습니다.

---<img width="580" height="508" alt="pet_community_ERD" src="https://github.com/user-attachments/assets/09ac4580-ee1b-4edf-b235-94b17c1dcef3" />

![IMG_0355](https://github.com/user-attachments/assets/2ae9a673-415e-4163-b907-a6c2ea35003e)
![IMG_0354](https://github.com/user-attachments/assets/b8755370-f671-47dd-ba80-26e503fb496c)
![IMG_0353](https://github.com/user-attachments/assets/3270a451-bd66-405c-8a47-5d9b509b42f9)
![IMG_0352](https://github.com/user-attachments/assets/9a91b149-9075-4bdb-951e-e30e251ccf7a)
![IMG_0351](https://github.com/user-attachments/assets/6a1f3056-0714-481c-aa77-34abdb71f28e)
![IMG_0350](https://github.com/user-attachments/assets/4b903efc-8093-4bd8-bb9d-1d69af0e717f)
![IMG_0349](https://github.com/user-attachments/assets/bfc337ce-6ff5-4272-92ea-4352d2a318f9)
![IMG_0348](https://github.com/user-attachments/assets/555361e9-30ae-4b19-8f9a-290b9cb987da)
