# 🌿 LeafyGo (리피고)
> **생태 관광지 정보 제공부터 나만의 코스 생성, 커뮤니티, 투어 예약까지 가능한 올인원(All-in-one) 생태 관광 통합 서비스**

<br/>

## 🎯 1. 프로젝트 개요 및 목표

### 🌍 생태 관광 특화 플랫폼
한국관광공사의 공공 데이터를 활용하여 국내의 다양한 생태관광지 정보를 체계적으로 제공합니다. 사용자가 지역별 생태 관광지를 손쉽게 탐색할 수 있으며, 관련 경험과 정보를 공유하는 커뮤니티를 포함한 통합 서비스를 제공하는 생태 관광 플랫폼을 구축하는 것을 목표로 합니다.

#### 📊 생태관광 데이터 체계화
공공데이터(생태관광 API)를 수집 및 가공하여 사용자가 한눈에 파악할 수 있는 직관적인 정보 구조를 설계했습니다.

#### 🧭 사용자 맞춤형 탐색 환경 제공
지역별 카테고리 분류를 통해 사용자가 원하는 관광지를 쉽게 찾고, 효율적으로 최적의 관광 코스를 직접 생성할 수 있도록 지원합니다.

#### 💬 활발한 정보 공유 공간 형성
게시판과 댓글 기능을 통해 실제 관광지 여행객의 생생한 후기와 정보를 공유할 수 있는 사용자 참여형 커뮤니티 공간을 제공합니다.

<br/>

## 💡 2. 주요 기능 (Key Features)
1. **생태 관광지 탐색 및 조회**: 지역별, 테마별 생태 관광지 검색 및 상세 정보(입장료, 주차장, 편의시설 등) 제공
2. **나만의 맞춤형 코스 생성**: 선택한 관광지들을 조합하여 나만의 여행 코스 설계 및 지도(Map) 연동 제공
3. **사용자 커뮤니티 (게시판/리뷰)**: 여행 후기, 코스 추천, 관광지 꿀팁 등을 공유할 수 있는 소통의 장 제공
4. **투어 예약 시스템**: 생태 관광 가이드 투어 및 관련 프로그램 예약 및 결제 확인 기능
5. **마이페이지 (My Page)**: 찜한 관광지(Wishlist), 내가 쓴 글, 내 예약 내역 등을 한눈에 관리

<br/>

## 🖥️ 3. 페이지 구성 (Page Composition)
* **메인 페이지 (Home)** : 인기 관광지 추천, 배너, 퀵 메뉴 등 제공
* **관광지 검색 페이지 (Attraction Search)** : 필터링(지역, 무료/유료, 장애인 편의시설 등)을 통한 관광지 목록 및 지도 뷰
* **코스 플래너 페이지 (Course Planner)** : 드래그 앤 드롭 및 동선 확인을 통한 여행 코스 만들기
* **커뮤니티 페이지 (Board)** : 여행 후기 및 자유 게시판, 댓글 소통
* **예약 페이지 (Reservation)** : 날짜 및 인원 선택을 통한 투어 예약
* **마이페이지 (My Page)** : 찜 목록, 내 작성 글, 예약 현황 조회

<br/>

## 🛠️ 4. 기술 스택 (Tech Stack)

### 🎨 Frontend
* **Core**: React 19, Vite, JavaScript (ES6+)
* **State Management**: Zustand
* **Styling**: Vanilla CSS (CSS Modules), Material-UI (MUI)
* **Routing & HTTP**: React Router DOM, Axios
* **Utils**: SweetAlert2, Swiper, Tiptap (Rich Text Editor)

### ⚙️ Backend
* **Core**: Java 17, Spring Boot 4.x
* **Database Access**: MyBatis
* **Security**: Spring Security, JWT (JSON Web Token)
* **API Parsing**: Jsoup

### ☁️ Infrastructure & Deployment
* **Frontend Hosting**: Vercel (CI/CD 자동화)
* **Backend Hosting**: Render (Web Service, Docker 기반 배포)
* **Database**: Supabase (PostgreSQL, Connection Pooling 적용)
* **Image Hosting**: Cloudinary (클라우드 이미지 서버)

<br/>

## 📁 5. 프로젝트 구조 (Project Structure)
본 프로젝트는 프론트엔드와 백엔드가 하나의 레포지토리 안에서 관리되는 **모노레포(Monorepo) 형태**로 구성되어 있습니다.
```text
LefayGo/
├── semi_project_front/     # React 프론트엔드 프로젝트
│   ├── public/             # 파비콘, 정적 에셋
│   ├── src/
│   │   ├── components/     # 재사용 가능한 UI 컴포넌트
│   │   ├── pages/          # 라우팅되는 전체 페이지 화면
│   │   └── utils/          # 커스텀 훅 및 상태 관리(Zustand) 등
│   ├── package.json
│   └── vercel.json         # Vercel 새로고침(404) 방지 설정 파일
│
└── react_semi_back/        # Spring Boot 백엔드 프로젝트
    ├── src/main/java/      # Java 소스 코드
    ├── src/main/resources/ # 설정 파일(application.properties) 및 Mapper XML
    ├── pom.xml             # Maven 의존성 관리
    └── Dockerfile          # Render 배포를 위한 도커 빌드 설정
```

<br/>

## 📦 6. 백엔드 패키지 구조 (Backend Architecture)
Spring Boot 백엔드는 철저한 **MVC 패턴**을 기반으로 역할을 분리하여 설계되었습니다.
```text
kr.co.iei
├── controller/     # 클라이언트의 HTTP 요청을 받고 응답(JSON)을 반환하는 계층
├── service/        # 비즈니스 로직을 처리하고 트랜잭션을 관리하는 계층
├── dao/            # MyBatis Mapper를 통해 DB와 직접 통신하는 계층
├── dto/            # 클라이언트와 서버 간 데이터 전송을 위한 객체 (Request/Response)
├── config/         # Security, CORS, Cloudinary 등 스프링 전역 설정 계층
└── util/           # JWT 토큰 생성, 비밀번호 암호화 등 공통 유틸리티
```

<br/>

## 🗄️ 7. DB 주요 테이블 (Main Database Tables)
* **`MEMBER` (회원)**: 유저 식별자, 아이디, 비밀번호(암호화), 이메일, 닉네임, 가입일
* **`ATTRACTION` (관광지)**: 관광지 고유 번호, 이름, 주소, 위도/경도, 이미지 URL, 편의시설 정보
* **`COURSE` (코스)**: 코스 아이디, 작성자, 코스 이름, 코스 설명, 공개 여부
* **`COURSE_DETAIL` (코스 상세)**: 코스 아이디에 속한 관광지 순서 및 경유지 정보
* **`BOARD` (게시판/커뮤니티)**: 게시글 번호, 작성자, 제목, 내용(HTML), 조회수, 작성일
* **`REPLY` (댓글)**: 댓글 번호, 게시글 번호, 작성자, 내용, 작성일
* **`WISH_LIST` (찜하기)**: 유저 식별자와 관광지 번호를 매핑하는 다대다 연결 테이블
* **`RESERVATION` (예약)**: 예약 번호, 유저 아이디, 예약 날짜, 참여 인원, 결제 상태

<br/>

## 🚀 8. 배포 관련 핵심 가이드
성공적인 클라우드 배포를 위해 적용된 필수 설정들입니다. 차후 다른 프로젝트에도 동일하게 적용할 수 있습니다.

1. **Vercel (React)**
   * `vercel.json` 파일에 `rewrites` 설정을 추가하여 SPA 라우팅 시 발생하는 404 에러를 방지했습니다.
   * `import.meta.env`를 사용해 백엔드 API 주소를 동적으로 관리합니다.
2. **Render (Spring Boot)**
   * 프로젝트 최상단에 `Dockerfile`을 작성하여 Java 17 빌드 환경과 실행 환경을 분리(Multi-stage build)하여 배포 최적화를 이루었습니다.
3. **Supabase (PostgreSQL)**
   * `application.properties`에 기본 접속 주소가 아닌 **Transaction Connection Pooler 주소(포트 6543)**를 사용하여 클라우드 환경에서의 DB 커넥션 병목 현상을 해결했습니다.
4. **Cloudinary (Image Hosting)**
   * 로컬 스토리지 한계를 극복하기 위해 `Cloudinary API`를 연동하여 이미지 업로드 시 영구적인 보안 URL(`secure_url`)을 DB에 저장하도록 설계했습니다.
