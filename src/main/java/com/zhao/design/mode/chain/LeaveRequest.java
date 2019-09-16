package com.zhao.design.mode.chain;

/**
 * LeaveRequest 封装请假实体类
 * @author zhaohuan
 */
public class LeaveRequest {

    private String employee;

    private int leaveDay;

    private String reason;

    public LeaveRequest() {

    }

    public LeaveRequest(String employee, int leaveDay, String reason) {
        this.employee = employee;
        this.leaveDay = leaveDay;
        this.reason = reason;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public int getLeaveDay() {
        return leaveDay;
    }

    public void setLeaveDay(int leaveDay) {
        this.leaveDay = leaveDay;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
