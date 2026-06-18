# 🌿 LeafyGo (리피고)
> **생태 관광지 정보 제공부터 나만의 코스 생성, 커뮤니티, 투어 예약까지 가능한 통합 관광 서비스**

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
1. **생태 관광지 탐색 및 조회**: 지역별, 테마별 생태 관광지 검색 및 상세 정보 제공
2. **나만의 코스 생성**: 내가 원하는 관광지들을 선택하고 조합하여 여행 코스 목록 및 동선(지도) 확인
3. **커뮤니티 소통**: 여행 후기, 코스 추천, 관광지 꿀팁 등을 공유하는 게시판 및 댓글 기능 제공
4. **투어 예약 시스템**: 생태 관광 가이드 투어 상품 상세 정보 조회 및 장바구니/예약/결제 진행
5. **마이페이지 관리**: 내가 찜한 관광지, 작성한 게시글, 진행 중인 예약 내역 등을 일괄 관리

<br/>

## 🖥️ 3. 페이지 구성 (Page Composition)
| 구분 | 페이지명 | 경로 (Path) | 설명 |
|---|---|---|---|
| **메인** | 메인 페이지 | `/` | 프로젝트 메인 홈 화면 |
| **회원** | 로그인 페이지 | `/login` | 기존 회원 로그인 |
| | 회원가입 페이지 | `/join` | 신규 회원가입 진행 |
| | 아이디 찾기 | `/searchId` | 회원 아이디 찾기 |
| | 비밀번호 찾기 | `/searchPw` | 회원 비밀번호 찾기 |
| | 마이페이지 | `/mypage/*` | 내 정보 수정, 찜 목록, 작성한 글 확인 |
| **관광지** | 관광지 검색 페이지 | `/attraction/list` | 조건 필터(지역, 요금, 편의시설)를 통한 관광지 및 지도 조회 |
| **코스** | 코스 리스트 페이지 | `/course/list` | 사용자들이 생성한 추천 코스 목록 조회 |
| | 코스 상세 페이지 | `/course/view/:courseNo` | 개별 코스 상세 내용 및 포함된 관광지 동선 확인 |
| | 코스 작성 페이지 | `/course/write` | 나만의 코스 새로 만들기 (관광지 검색 및 추가) |
| | 코스 수정 페이지 | `/course/update/:courseNo` | 기존에 작성한 내 코스 수정 |
| **커뮤니티** | 게시글 목록 페이지 | `/board/list` | 여행 후기, 자유 게시글 목록 조회 |
| | 게시글 상세 페이지 | `/board/view/:boardNo` | 게시글 읽기 및 댓글 작성/조회 |
| | 게시글 작성 페이지 | `/board/write` | 스마트 에디터를 활용한 새 글 작성 |
| | 게시글 수정 페이지 | `/board/modify/:boardNo` | 작성한 게시글 수정 |
| | 네이버맵 검색 팝업 | `/boardNavermap` | 게시글 작성 시 장소 지도를 첨부하기 위한 팝업 |
| **투어 예약** | 투어 상품 목록 | `/tour/list` | 판매/진행 중인 투어 상품 리스트 |
| | 투어 상품 상세 | `/tour/detail/:tourItemNo` | 투어 상세 일정, 안내 사항 확인 |
| | 장바구니 | `/tour/cart` | 장바구니에 담아둔 투어 상품 조회 |
| | 예약/결제 페이지 | `/tour/booking` | 예약자 정보 입력 및 결제 진행 |
| | 예약 내역 (마이페이지) | `/tour/mypage` | 나의 투어 예약/결제 내역 확인 |
| | (관리자) 상품 등록 | `/admin/tour/insertitem` | 관리자용 투어 상품 신규 등록 |
| | (관리자) 상품 수정 | `/admin/tour/modifytour/:tourItemNo` | 기존 투어 상품 정보 업데이트 |

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

<br/>

## 📁 5. 프로젝트 구조 (Project Structure)
본 프로젝트는 프론트엔드와 백엔드가 하나의 레포지토리 안에서 관리되는 **모노레포(Monorepo) 형태**로 구성되어 있습니다.
```text
LefayGo/
├── semi_project_front/     # React 프론트엔드 프로젝트
│   ├── public/             # 정적 이미지 및 로고
│   ├── src/
│   │   ├── components/     # 도메인/기능별 분리된 UI 컴포넌트
│   │   ├── pages/          # 실제 라우팅되는 페이지 컴포넌트 모음
│   │   └── utils/          # 상태 관리(Zustand) 및 커스텀 로직
│   └── package.json        
│
└── react_semi_back/        # Spring Boot 백엔드 프로젝트
    ├── src/main/java/      # Java 비즈니스 로직
    ├── src/main/resources/ # application.properties 및 Mapper XML 파일
    └── pom.xml             # Maven 의존성 관리
```

<br/>

## 📦 6. 백엔드 패키지 구조 (Backend Architecture)
Spring Boot 백엔드는 기능(도메인)별로 모듈을 철저히 분리하여, 각 폴더 내에서 **MVC 패턴(Controller-Service-Dao-VO)**을 독립적으로 갖도록 설계되었습니다.

```text
kr.co.iei
├── attraction/       # 관광지 데이터 제공 관련 로직
├── board/            # 커뮤니티(게시판, 댓글) 관련 로직
├── course/           # 코스 생성 및 조회 관련 로직 (도메인 단위 구조 예시 ▼)
│   ├── controller/   # CourseController.java (요청 분기 및 결과 응답)
│   └── model/
│       ├── service/  # CourseService.java (트랜잭션 및 비즈니스 로직)
│       ├── dao/      # CourseDao.java (DB 접근 및 MyBatis 맵핑)
│       └── vo/       # CourseVO.java (데이터 객체)
├── member/           # 회원가입, 로그인, 인증 등 유저 관련 로직
├── tour/             # 투어 예약 및 장바구니 관련 로직
├── touritem/         # 투어 상품(아이템) 자체 관리 로직
└── utils/            # JWT 토큰, 암호화 등 공통 활용 유틸리티
```

<br/>

## 🗄️ 7. DB 주요 테이블 (Main Database Tables)
실제 데이터베이스에 구성된 핵심 테이블 목록입니다.

| 기능 분류 | 테이블명 (Table Name) | 역할 및 설명 |
|---|---|---|
| **회원** | `member_tbl` | 유저 계정 정보 (아이디, 암호화된 비밀번호 등) |
| **지역 구분** | `area_tbl` | 도/광역시 단위의 지역 분류 데이터 |
| | `sigungu_tbl` | 시/군/구 단위의 지역 분류 데이터 |
| **관광지** | `attraction_tbl` | 관광지 기본 상세 정보 및 위치(좌표) |
| | `attraction_wish_tbl` | 유저가 찜한 관광지(Wishlist) 내역 |
| **코스** | `course_tbl` | 사용자가 작성한 코스 마스터 정보 (제목, 내용) |
| | `course_attraction_tbl` | 특정 코스에 포함된 실제 관광지 및 순서 매핑 |
| | `course_like_tbl` | 코스 좋아요/추천 내역 |
| **커뮤니티** | `board_tbl` | 작성된 자유/후기 게시글 마스터 정보 |
| | `board_comment_tbl` | 게시글에 달린 댓글 데이터 |
| | `board_like_tbl` | 게시글 좋아요 내역 |
| | `emoji_tbl` | 게시글 감정/이모지 반응 데이터 |
| **투어 예약** | `tour_item_tbl` | 판매 등록된 투어 상품 마스터 정보 |
| | `tour_item_info_tbl` | 투어 상품의 상세 일정 및 세부 안내 |
| | `tour_item_img_tbl` | 투어 상품 소개에 사용되는 첨부 이미지들 |
| | `tour_cart_tbl` | 유저 장바구니에 담긴 투어 내역 |
| | `tour_wish_tbl` | 투어 상품 찜하기 내역 1 |
| | `tour_wishlist_tbl` | 투어 상품 찜하기 내역 2 (관련 확장) |
