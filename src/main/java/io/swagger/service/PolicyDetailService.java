package io.swagger.service;

import io.swagger.dao.PolicyRepository;
import io.swagger.dto.*;
import io.swagger.entity.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class PolicyDetailService {

  @Autowired
  private ModelMapper modelMapper;

  @Autowired
  private PolicyRepository policyRepository;

  public Policy convertToDto(PolicyDetail PolicyDetail) {
    Policy dto = modelMapper.map(PolicyDetail, Policy.class);
    dto.calculateAnnualCoverageAmount(); // Apply additional logic return dto;
    return dto;
  }

  public PolicyDetail convertToEntity(Policy Policy) {
    if (Policy != null) {
      return modelMapper.map(Policy, PolicyDetail.class);
    } else {
      return null;
    }
  }

  public Policy findById(String id) {
    Optional<PolicyDetail> policyDetailOptional = policyRepository.findById(id);
    if (policyDetailOptional.isPresent()) {
      return convertToDto(policyDetailOptional.get());
    } else {
      // Handle the case where the policy is not found
      return null;
    }
  }

  public void save(Policy policy) {
    PolicyDetail policyDetail = convertToEntity(policy);
    policyRepository.save(policyDetail);
  }
}
