## 1. 프로젝트 소개

> " 여행을 가고 싶은데 코로나 때문에 갈 수가 없네?" 😭
"백신이 보급되고 with 코로나 시대가 오면 다시 여행을 갈 수 있지않을까?"
> 
- 코로나에서 비교적 안전하고 여행 가능한 국가를 소개하고 국가별 여행지를 추천하는 서비스를  목표로 개발하고 있습니다.

---

## 2. 접속 정보

- [https://next-covid-kohl.vercel.app/](https://next-covid-kohl.vercel.app/)

---

## 3. 개발기간

- 2021년 08월 02일 ~ 2021년 10년 01일

---

## 4. Team (FE & BE)

* 조성재
* 김진원

---

## 5. 기술스택

### FrontEnd

- Javascript, Typescript
- React, Recoil, SWR, Next.js, Material-UI

### BackEnd

- Java 8, Javascript, Typescript
- SpringBoot 2.5.3, JPA, Querydsl, Spring Batch, Redis
- Spring Security, Oauth2 Client
- Express
- Mysql 5.7

### Build & Deploy

- jenkins
- Vercel
- Docker
- Gradle

---

## 6. Architecture
<img width="1000" alt="next-covid-architecture" src="https://user-images.githubusercontent.com/27146519/136890904-c35d152d-0cfd-44f8-abc9-f33703d2d53c.png">


---

## 7. Database
![Next-Covid_erd](https://user-images.githubusercontent.com/27146519/136890886-4eb76bd1-8f49-4f66-917c-3974791d5b39.png)


---

## 8. 주요 기능

- Security+로그인
    - 사용자가 로그인
- 코로나 국가별 현황/위험도
    - 국가별 코로나 위험도 레벨을 정보를 제공합니다.
    - 국가별 코로나 확진자/사망자 정보를 확인할 수 있습니다.
- 코로나 소식
    - 국가별, 코로나 관련 소식(입국/출국, 격리) 을 확인할 수 있습니다.
- 여행코스
    - 회원가입 및 관리자에게 권한을 부여받은 사용자는 여행 코스 정보를 입력하는 에디터가 되어 정보를 제공할 수 있습니다.
- 통합검색
    - 국가 정보, 코로나 관련 정보, 여행 코스 관련 정보 검색시 검색페이지에 관련된 정보가 일괄적으로 표시 됩니다.

---
