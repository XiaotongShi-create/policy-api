package io.swagger.entity;

import com.google.cloud.spring.data.spanner.core.mapping.Column;
import com.google.cloud.spring.data.spanner.core.mapping.Table;

@Table(name = "policies")
public class PolicyDetail {

  @Column(name = "coverageId")
  private String coverageId;

  @Column(name = "coverageName")
  private String coverageName;

  @Column(name = "coverageAmount")
  private String coverageAmount;

  // Getters and Setters
  public String getcoverageId() {
    return coverageId;
  }

  public void setcoverageId(String coverageId) {
    this.coverageId = coverageId;
  }

  public String getcoverageName() {
    return coverageName;
  }

  public void setcoverageName(String coverageName) {
    this.coverageName = coverageName;
  }

  public String getcoverageAmount() {
    return coverageAmount;
  }

  public void setcoverageAmount(String coverageAmount) {
    this.coverageAmount = coverageAmount;
  }

  // isEmpty method
  public boolean isEmpty() {
    return (coverageId == null || coverageId.isEmpty()) &&
        (coverageName == null || coverageName.isEmpty()) &&
        (coverageAmount == null || coverageAmount.isEmpty());
  }
}
