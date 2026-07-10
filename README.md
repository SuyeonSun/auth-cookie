# auth-cookie

## Backend (Spring Boot)

기본 실행 포트: `http://localhost:8080`

### H2 Database

인메모리 DB이므로 백엔드 애플리케이션이 실행 중일 때만 접속 가능합니다.

- H2 콘솔: http://localhost:8080/h2-console
- JDBC URL: `jdbc:h2:mem:authdb`
- Username: `sa`
- Password: (없음, 빈 값)

> H2 콘솔 접속 시 JDBC URL 기본값(`jdbc:h2:mem:testdb`)을 위 값으로 반드시 변경해야 합니다.

### Swagger / OpenAPI

- Swagger UI: http://localhost:8080/swagger-ui.html
- API Docs (JSON): http://localhost:8080/v3/api-docs
