package com.microservices.auditservice.service;

import com.microservices.auditservice.model.AuditLog;
import com.microservices.auditservice.repository.AuditLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class AuditService {

    @Autowired
    private AuditLogRepository auditLogRepository;

    public List<AuditLog> getAuditLogsForEntity(UUID entityId) {
        return auditLogRepository.findByEntityId(entityId);
    }

    public void logEvent(String eventType, String entityType, UUID entityId, UUID userId, String auditData) {
        AuditLog auditLog = new AuditLog();
        auditLog.setEventType(eventType);
        auditLog.setEntityType(entityType);
        auditLog.setEntityId(entityId);
        auditLog.setUserId(userId);
        auditLog.setTimestamp(LocalDateTime.now());
        auditLog.setAuditData(auditData);
        auditLog.setHash(generateHash(eventType, entityType, entityId, userId, auditData));

        auditLogRepository.save(auditLog);
    }

    private String generateHash(String eventType, String entityType, UUID entityId, UUID userId, String auditData) {
        return eventType + "|" + entityType + "|" + entityId + "|" + userId + "|" + auditData;
    }
}