package io.swagger.dto;

public class Policy {
  private String coverageId;
  private String coverageName;
  private double coverageAmount;
  private double annualCoverageAmount;

  // Getters and Setters
  public String getCoverageId() {
    return coverageId;
  }

  public void setCoverageId(String coverageId) {
    this.coverageId = coverageId;
  }

  public String getCoverageName() {
    return coverageName;
  }

  public void setCoverageName(String coverageName) {
    this.coverageName = coverageName;
  }

  public double getCoverageAmount() {
    return coverageAmount;
  }

  public void setCoverageAmount(double coverageAmount) {
    this.coverageAmount = coverageAmount;
  }

  public double getAnnualCoverageAmount() {
    return annualCoverageAmount;
  }

  public void setAnnualCoverageAmount(double annualCoverageAmount) {
    this.annualCoverageAmount = annualCoverageAmount;
  }

  // Additional logic to calculate annual coverage amount
  public void calculateAnnualCoverageAmount() {
    this.annualCoverageAmount = this.coverageAmount * 12;
  }
}
