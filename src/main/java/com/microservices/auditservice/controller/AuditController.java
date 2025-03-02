package com.microservices.auditservice.controller;

import com.microservices.auditservice.model.AuditLog;
import com.microservices.auditservice.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/audit")
public class AuditController {

    @Autowired
    private AuditService auditService;

    @GetMapping("/{entityId}")
    public List<AuditLog> getAuditLogs(@PathVariable UUID entityId) {
        return auditService.getAuditLogsForEntity(entityId);
    }

    @PostMapping("/log")
    public void logAuditEvent(@RequestParam String eventType,
                              @RequestParam String entityType,
                              @RequestParam UUID entityId,
                              @RequestParam UUID userId,
                              @RequestBody String auditData) {
        auditService.logEvent(eventType, entityType, entityId, userId, auditData);
    }
}