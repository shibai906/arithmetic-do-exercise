package com.zhao.design.mode.chain;

public class Manager extends Handler {

    public Manager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if (request.getLeaveDay() < 3) {
            System.out.println("经理：" + name + " 审批了 " + request.getEmployee() + "请假" + request.getLeaveDay()
                    + "天的请求,请假原因：" + request.getReason());
        } else {
            if (this.nextHandler != null) {
                this.nextHandler.handleRequest(request);
            }
        }
    }
}
