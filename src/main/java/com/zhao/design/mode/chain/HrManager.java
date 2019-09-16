package com.zhao.design.mode.chain;

public class HrManager extends Handler {
    public HrManager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if (3 <= request.getLeaveDay() && request.getLeaveDay() < 7) {
            System.out.println("人事经理：" + name + " 审批了 " + request.getEmployee() + "请假" + request.getLeaveDay()
                    + "天的请求,请假原因：" + request.getReason());
        } else {
            if (this.nextHandler != null) {
                this.nextHandler.handleRequest(request);
            }
        }
    }
}
