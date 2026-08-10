# Graph Report - .  (2026-08-01)

## Corpus Check
- Corpus is ~4,297 words - fits in a single context window. You may not need a graph.

## Summary
- 162 nodes · 291 edges · 16 communities (10 shown, 6 thin omitted)
- Extraction: 87% EXTRACTED · 13% INFERRED · 0% AMBIGUOUS · INFERRED: 39 edges (avg confidence: 0.8)
- Token cost: 0 input · 0 output

## Community Hubs (Navigation)
- Patient Entity & Request DTO
- Service Layer & Integrations
- REST Patient Controller
- Response DTO & CRUD Flow
- Exception Handling
- Billing Maven Wrapper
- Patient Maven Wrapper
- Billing gRPC Server
- Billing Service Tests
- DB Scratch Scripts
- Patient Service Tests
- Billing Boot Entry
- Kafka Producer
- Patient Boot Entry
- Billing Package Root
- Patient Package Root

## God Nodes (most connected - your core abstractions)
1. `PatientResponseDTO` - 23 edges
2. `Patient` - 20 edges
3. `PatientRequestDTO` - 19 edges
4. `PatientService` - 12 edges
5. `PatientController` - 11 edges
6. `BillingServiceGrpcClient` - 9 edges
7. `PatientRepository` - 9 edges
8. `EmailAlreadyExistsException` - 6 edges
9. `GlobalExceptionHandler` - 6 edges
10. `PatientNotFoundException` - 6 edges

## Surprising Connections (you probably didn't know these)
- `PatientController` --references--> `PatientService`  [EXTRACTED]
  patient-service/src/main/java/com/pm/patientservice/controller/PatientController.java → patient-service/src/main/java/com/pm/patientservice/service/PatientService.java
- `PatientRepository` --references--> `Patient`  [EXTRACTED]
  patient-service/src/main/java/com/pm/patientservice/repository/PatientRepository.java → patient-service/src/main/java/com/pm/patientservice/model/Patient.java
- `PatientService` --references--> `BillingServiceGrpcClient`  [EXTRACTED]
  patient-service/src/main/java/com/pm/patientservice/service/PatientService.java → patient-service/src/main/java/com/pm/patientservice/grpc/BillingServiceGrpcClient.java
- `PatientService` --references--> `PatientRepository`  [EXTRACTED]
  patient-service/src/main/java/com/pm/patientservice/service/PatientService.java → patient-service/src/main/java/com/pm/patientservice/repository/PatientRepository.java

## Import Cycles
- None detected.

## Communities (16 total, 6 thin omitted)

### Community 0 - "Patient Entity & Request DTO"
Cohesion: 0.13
Nodes (6): Email, Entity, NotBlank, PatientRequestDTO, Patient, Size

### Community 1 - "Service Layer & Integrations"
Cohesion: 0.15
Nodes (12): BillingRequest, BillingServiceBlockingStub, JpaRepository, BillingServiceGrpcClient, BillingResponse, Logger, Service, PatientMapper (+4 more)

### Community 2 - "REST Patient Controller"
Cohesion: 0.15
Nodes (12): CrossOrigin, DeleteMapping, GetMapping, Operation, ResponseEntity, PatientController, CreatePatientValidationGroup, PostMapping (+4 more)

### Community 4 - "Exception Handling"
Cohesion: 0.27
Nodes (7): ControllerAdvice, ExceptionHandler, MethodArgumentNotValidException, EmailAlreadyExistsException, GlobalExceptionHandler, Logger, ResponseEntity

### Community 5 - "Billing Maven Wrapper"
Cohesion: 0.33
Nodes (6): mvnw script, clean(), die(), exec_maven(), set_java_home(), verbose()

### Community 6 - "Patient Maven Wrapper"
Cohesion: 0.33
Nodes (6): mvnw script, clean(), die(), exec_maven(), set_java_home(), verbose()

### Community 7 - "Billing gRPC Server"
Cohesion: 0.36
Nodes (7): BillingGrpcService, BillingResponse, Logger, BillingServiceImplBase, GrpcService, Override, StreamObserver

### Community 8 - "Billing Service Tests"
Cohesion: 0.60
Nodes (3): BillingServiceApplicationTests, SpringBootTest, Test

### Community 9 - "DB Scratch Scripts"
Cohesion: 0.40
Nodes (4): DB_PASSWORD, DB_URL, DB_USERNAME, scratch.sh script

### Community 10 - "Patient Service Tests"
Cohesion: 0.60
Nodes (3): SpringBootTest, Test, PatientServiceApplicationTests

## Knowledge Gaps
- **6 isolated node(s):** `com.pm:billing-service`, `com.pm:patient-service`, `scratch.sh script`, `DB_URL`, `DB_USERNAME` (+1 more)
  These have ≤1 connection - possible missing edges or undocumented components.
- **6 thin communities (<3 nodes) omitted from report** — run `graphify query` to explore isolated nodes.

## Suggested Questions
_Questions this graph is uniquely positioned to answer:_

- **Why does `PatientResponseDTO` connect `Response DTO & CRUD Flow` to `Patient Entity & Request DTO`, `Service Layer & Integrations`, `REST Patient Controller`?**
  _High betweenness centrality (0.106) - this node is a cross-community bridge._
- **Why does `PatientRequestDTO` connect `Patient Entity & Request DTO` to `Service Layer & Integrations`, `REST Patient Controller`, `Response DTO & CRUD Flow`?**
  _High betweenness centrality (0.077) - this node is a cross-community bridge._
- **What connects `com.pm:billing-service`, `com.pm:patient-service`, `scratch.sh script` to the rest of the system?**
  _6 weakly-connected nodes found - possible documentation gaps or missing edges._
- **Should `Patient Entity & Request DTO` be split into smaller, more focused modules?**
  _Cohesion score 0.13227513227513227 - nodes in this community are weakly interconnected._
- **Should `Service Layer & Integrations` be split into smaller, more focused modules?**
  _Cohesion score 0.14761904761904762 - nodes in this community are weakly interconnected._
- **Should `REST Patient Controller` be split into smaller, more focused modules?**
  _Cohesion score 0.14761904761904762 - nodes in this community are weakly interconnected._
- **Should `Response DTO & CRUD Flow` be split into smaller, more focused modules?**
  _Cohesion score 0.14285714285714285 - nodes in this community are weakly interconnected._