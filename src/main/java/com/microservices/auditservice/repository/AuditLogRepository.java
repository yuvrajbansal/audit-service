package com.microservices.auditservice.repository;

import com.microservices.auditservice.model.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
    List<AuditLog> findByEntityId(UUID entityId);
}