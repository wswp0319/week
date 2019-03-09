package com.wp.week.model;

import java.io.Serializable;
import java.util.Date;

public class DailyDto implements Serializable {
    private Integer id;

    private Integer userId;

    private Integer lookRole;

    private String workResult;

    private String submitContent;

    private String contentDescription;

    private String planStartDate;

    private String planEndDate;

    private String workSchedule;

    private String demoAddress;

    private Integer claim;

    private String planB;

    private String submitter;

    private String remarks;

    private Integer dept;

    private Date updateTime;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getLookRole() {
        return lookRole;
    }

    public void setLookRole(Integer lookRole) {
        this.lookRole = lookRole;
    }

    public String getWorkResult() {
        return workResult;
    }

    public void setWorkResult(String workResult) {
        this.workResult = workResult == null ? null : workResult.trim();
    }

    public String getSubmitContent() {
        return submitContent;
    }

    public void setSubmitContent(String submitContent) {
        this.submitContent = submitContent == null ? null : submitContent.trim();
    }

    public String getContentDescription() {
        return contentDescription;
    }

    public void setContentDescription(String contentDescription) {
        this.contentDescription = contentDescription == null ? null : contentDescription.trim();
    }

    public String getPlanStartDate() {
        return planStartDate;
    }

    public void setPlanStartDate(String planStartDate) {
        this.planStartDate = planStartDate == null ? null : planStartDate.trim();
    }

    public String getPlanEndDate() {
        return planEndDate;
    }

    public void setPlanEndDate(String planEndDate) {
        this.planEndDate = planEndDate == null ? null : planEndDate.trim();
    }

    public String getWorkSchedule() {
        return workSchedule;
    }

    public void setWorkSchedule(String workSchedule) {
        this.workSchedule = workSchedule == null ? null : workSchedule.trim();
    }

    public String getDemoAddress() {
        return demoAddress;
    }

    public void setDemoAddress(String demoAddress) {
        this.demoAddress = demoAddress == null ? null : demoAddress.trim();
    }

    public Integer getClaim() {
        return claim;
    }

    public void setClaim(Integer claim) {
        this.claim = claim;
    }

    public String getPlanB() {
        return planB;
    }

    public void setPlanB(String planB) {
        this.planB = planB == null ? null : planB.trim();
    }

    public String getSubmitter() {
        return submitter;
    }

    public void setSubmitter(String submitter) {
        this.submitter = submitter == null ? null : submitter.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Integer getDept() {
        return dept;
    }

    public void setDept(Integer dept) {
        this.dept = dept;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        DailyDto other = (DailyDto) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getWorkResult() == null ? other.getWorkResult() == null : this.getWorkResult().equals(other.getWorkResult()))
            && (this.getSubmitContent() == null ? other.getSubmitContent() == null : this.getSubmitContent().equals(other.getSubmitContent()))
            && (this.getContentDescription() == null ? other.getContentDescription() == null : this.getContentDescription().equals(other.getContentDescription()))
            && (this.getPlanStartDate() == null ? other.getPlanStartDate() == null : this.getPlanStartDate().equals(other.getPlanStartDate()))
            && (this.getPlanEndDate() == null ? other.getPlanEndDate() == null : this.getPlanEndDate().equals(other.getPlanEndDate()))
            && (this.getWorkSchedule() == null ? other.getWorkSchedule() == null : this.getWorkSchedule().equals(other.getWorkSchedule()))
            && (this.getDemoAddress() == null ? other.getDemoAddress() == null : this.getDemoAddress().equals(other.getDemoAddress()))
            && (this.getClaim() == null ? other.getClaim() == null : this.getClaim().equals(other.getClaim()))
            && (this.getPlanB() == null ? other.getPlanB() == null : this.getPlanB().equals(other.getPlanB()))
            && (this.getSubmitter() == null ? other.getSubmitter() == null : this.getSubmitter().equals(other.getSubmitter()))
            && (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()))
            && (this.getDept() == null ? other.getDept() == null : this.getDept().equals(other.getDept()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getWorkResult() == null) ? 0 : getWorkResult().hashCode());
        result = prime * result + ((getSubmitContent() == null) ? 0 : getSubmitContent().hashCode());
        result = prime * result + ((getContentDescription() == null) ? 0 : getContentDescription().hashCode());
        result = prime * result + ((getPlanStartDate() == null) ? 0 : getPlanStartDate().hashCode());
        result = prime * result + ((getPlanEndDate() == null) ? 0 : getPlanEndDate().hashCode());
        result = prime * result + ((getWorkSchedule() == null) ? 0 : getWorkSchedule().hashCode());
        result = prime * result + ((getDemoAddress() == null) ? 0 : getDemoAddress().hashCode());
        result = prime * result + ((getClaim() == null) ? 0 : getClaim().hashCode());
        result = prime * result + ((getPlanB() == null) ? 0 : getPlanB().hashCode());
        result = prime * result + ((getSubmitter() == null) ? 0 : getSubmitter().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        result = prime * result + ((getDept() == null) ? 0 : getDept().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }
}