package com.microservices.auditservice.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "audit_logs")
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "event_type", nullable = false)
    private String eventType;

    @Column(name = "entity_type", nullable = false)
    private String entityType;

    @Column(name = "entity_id", nullable = false)
    private UUID entityId;

    @Column(name = "user_id", nullable = false)
    private UUID userId;

    @Column(name = "timestamp", nullable = false)
    private LocalDateTime timestamp;

    @Column(name = "audit_data", columnDefinition = "jsonb", nullable = false)
    private String auditData;

    @Column(name = "hash", nullable = false)
    private String hash;

    // Getters and Setters
public String getEventType() {
    return eventType;
}

public void setEventType(String eventType) {
    this.eventType = eventType;
}

public String getEntityType() {
    return entityType;
}

public void setEntityType(String entityType) {
    this.entityType = entityType;
}

public UUID getEntityId() {
    return entityId;
}

public void setEntityId(UUID entityId) {
    this.entityId = entityId;
}

public UUID getUserId() {
    return userId;
}

public void setUserId(UUID userId) {
    this.userId = userId;
}

public LocalDateTime getTimestamp() {
    return timestamp;
}

public void setTimestamp(LocalDateTime timestamp) {
    this.timestamp = timestamp;
}

public String getAuditData() {
    return auditData;
}

public void setAuditData(String auditData) {
    this.auditData = auditData;
}

public String getHash() {
    return hash;
}

public void setHash(String hash) {
    this.hash = hash;
}
}