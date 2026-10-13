# CampusCare Backend

Java 21 + Spring Boot REST API for campus complaint and maintenance tracking.

## API
- `GET /api/health` — health check
- `GET /api/complaints` — list complaints, newest first
- `GET /api/complaints/{id}` — fetch a complaint
- `POST /api/complaints` — create a complaint
- `PATCH /api/complaints/{id}/status` — update status (`OPEN`, `ASSIGNED`, `IN_PROGRESS`, `RESOLVED`, `CLOSED`)
- `PATCH /api/complaints/{id}/assignment` — assign a staff member
- `DELETE /api/complaints/{id}` — delete a complaint

## Configuration
Set `DATABASE_URL`, `DB_USERNAME`, `DB_PASSWORD`, and `CORS_ALLOWED_ORIGINS` in the deployment environment. The app uses Hibernate `update` to create/update the complaints table. For production, restrict CORS to the deployed frontend origin.

Build with `mvn clean package` and run with `java -jar target/campuscare-backend-1.0.0.jar`.