# test_Website

자동차 정보 웹사이트를 연습하기 위해 만든 Spring MVC 기반 실습 저장소입니다.

회원가입/로그인, 자동차 모델 페이지, 게시판, 검색 화면 등 여러 웹 기능을 한 프로젝트 안에서 실험한 코드입니다. 저장소 이름처럼 포트폴리오 대표 프로젝트보다는 Spring MVC와 Thymeleaf 화면 연결을 연습한 보조 학습 자료로 보는 것이 적절합니다.

## 주요 기능

| 기능 | 설명 |
| --- | --- |
| 메인 화면 | `/` 요청 시 메인 페이지를 렌더링합니다. |
| 회원가입 | 사용자 정보를 입력받아 저장합니다. |
| 로그인 | 이메일과 비밀번호를 기반으로 로그인 흐름을 처리하고 Session에 사용자 정보를 저장합니다. |
| 자동차 모델 페이지 | 브랜드/모델 관련 화면을 Thymeleaf 템플릿으로 구성했습니다. |
| 게시판 | 게시글 관련 Controller, Service, Repository 구조를 실습했습니다. |
| 검색 | 검색 화면과 관련 Controller/Service 구조를 포함합니다. |

## 기술 스택

- Java
- Spring MVC
- Spring Data JPA
- Thymeleaf
- Session

## 프로젝트 구조

```text
java/com/example/CarSite
├── Controller
├── Dto
├── Entity
├── Repository
└── Service

resources
├── application.properties
└── templates
```

## 학습 포인트

- Controller에서 요청 URL과 Thymeleaf 템플릿을 연결하는 흐름
- 회원가입/로그인에서 DTO와 Entity를 사용하는 방식
- Session을 활용한 로그인 상태 유지
- 게시판, 검색, 모델 페이지처럼 여러 기능을 패키지로 분리하는 연습

## 개선 예정

- 일반적인 Spring Boot 프로젝트 구조(`src/main/java`, `src/main/resources`)로 정리
- 프로젝트명 변경
- 로그인 검증 로직 보강
- 민감 정보와 로그 출력 정리
- 대표 포트폴리오 프로젝트와 학습용 프로젝트 구분
