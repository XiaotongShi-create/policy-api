package io.swagger.controller;

import io.swagger.dto.*;
import io.swagger.service.PolicyDetailService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {
  private static final Logger logger = LoggerFactory.getLogger(PolicyController.class);

  @Autowired
  private PolicyDetailService policyDetailService;

  @PostMapping("/addPolicy")
  public ResponseEntity<Policy> createPolicy(@RequestBody Policy policy) {
    logger.info("Received request to create policy: (}", policy);
    policyDetailService.save(policy);
    logger.info("Policy created successfully: {}", policy);
    return ResponseEntity.ok(policy);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Policy> getPolicy(@PathVariable String id) {
    // Retrieve the policy entity from the database (assuming a findByld method
    // exists in the service)
    Policy policy = policyDetailService.findById(id);
    return ResponseEntity.ok(policy);
  }
}
