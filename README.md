# 📘 JPA Basic Study - 김영한 강의 실습

이 저장소는 [인프런 - 자바 ORM 표준 JPA 프로그래밍 - 기본편](https://www.inflearn.com/course/ORM-JPA-Basic) 강의를 따라 학습한 내용을 실습하고 정리한 공간입니다.  
순수 JPA를 기반으로 ORM과 영속성 컨텍스트의 동작 원리를 직접 코드로 구현하며 학습합니다.

---

## 🛠 기술 스택

- Java 17
- JPA (Jakarta Persistence 3.1)
- Hibernate 6.x
- H2 Database
- Maven
- IntelliJ IDEA

---

## 📚 강의 목차 기반 실습 내용

### 📌 섹션 1. JPA 소개
- ORM(Object-Relational Mapping) 이해
- JPA와 Hibernate의 관계
- JDBC와 JPA 비교
- 학습 목표 및 환경 구성

### 📌 섹션 2. 프로젝트 환경설정
- Maven 프로젝트 생성
- 의존성 설정 (JPA, Hibernate, H2)
- `persistence.xml` 작성 및 설정
- EntityManager 생성 및 실행 테스트

### 📌 섹션 3. 영속성 컨텍스트
- 엔티티 생명주기: 비영속 → 영속 → 준영속 → 삭제
- `persist()`, `find()`, `remove()` 동작 실습
- 1차 캐시와 동일성 보장
- 쓰기 지연(Write-behind), `flush()`, `commit()` 확인

### 📌 섹션 4. 엔티티 매핑
- `@Entity`, `@Id`, `@Column` 등 주요 어노테이션
- 객체 필드 ↔ 테이블 컬럼 매핑
- 엔티티 필드 기본값 설정

### 📌 섹션 5. 기본 키 매핑
- 직접 할당, 자동 생성 전략 (IDENTITY, SEQUENCE, TABLE)
- `@GeneratedValue`, `@SequenceGenerator`, `@TableGenerator` 실습
- 각 전략에 따른 동작 방식 비교

### 📌 섹션 6. 필드와 컬럼 매핑
- 다양한 타입 매핑 (`String`, `int`, `Enum`, `Date`, `LocalDate`)
- `@Enumerated`, `@Temporal`, `@Lob`, `@Transient`
- DDL 생성 옵션: `nullable`, `length`, `unique`

### 📌 섹션 7. 연관관계 매핑 기초
- 단방향 연관관계 `@ManyToOne`
- 양방향 연관관계 `@OneToMany`, `mappedBy`
- 연관관계 주인과 비주인의 개념
- 외래 키 관리 전략

### 📌 섹션 8. 다양한 연관관계 매핑
- `@OneToOne`, `@ManyToMany` 매핑
- 조인 테이블 전략
- 실무에서 `@ManyToMany`를 피해야 하는 이유
- 중간 엔티티(연결 엔티티) 설계

### 📌 섹션 9. 고급 매핑
- 상속 매핑 전략: `SINGLE_TABLE`, `JOINED`, `TABLE_PER_CLASS`
- `@Inheritance`, `@DiscriminatorColumn`, `@MappedSuperclass`
- 추상 클래스 기반 매핑 전략 실습

### 📌 섹션 10. 값 타입
- `@Embeddable`, `@Embedded`를 이용한 값 타입 정의
- 컬렉션 값 타입: `@ElementCollection`
- 값 타입과 참조 타입의 차이
- 값 타입 복사와 불변 객체 설계

### 📌 섹션 11. 객체지향 쿼리 언어 - JPQL
- JPQL 기본 문법과 사용 방법
- `TypedQuery`, `Query` 차이점
- 파라미터 바인딩 (`setParameter`)
- 집합 함수와 정렬, 페이징, join 실습

### 📌 섹션 12. 영속성 전이와 고아 객체
- `cascade = CascadeType.ALL`
- `orphanRemoval = true`
- 생명주기 관리 연습
- 고아 객체 제거 주의사항

### 📌 섹션 13. 프록시와 지연 로딩
- 즉시 로딩(EAGER) vs 지연 로딩(LAZY)
- 프록시 객체의 동작 방식
- 초기화 시점과 `instanceof`, `getClass()` 비교
- `PersistenceUnitUtil.isLoaded()` 활용

### 📌 섹션 14. 값 타입 컬렉션과 한계
- 값 타입 컬렉션의 저장 및 조회
- 컬렉션 변경 시 동작 방식
- 별도의 엔티티로 분리하는 설계 전략

### 📌 섹션 15. 정리 및 실무 주의사항
- 영속성 컨텍스트 요약
- 연관관계 매핑 전략 정리
- 실무 적용 시 유의점 (양방향 매핑 최소화, 지연 로딩 활용 등)
