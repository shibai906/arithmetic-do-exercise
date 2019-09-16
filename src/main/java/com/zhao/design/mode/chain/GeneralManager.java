package com.zhao.design.mode.chain;

public class GeneralManager extends Handler {
    public GeneralManager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if (7 <= request.getLeaveDay() && request.getLeaveDay() <= 15) {
            System.out.println("总经理：" + name + " 审批了 " + request.getEmployee() + "请假" + request.getLeaveDay()
                    + "天的请求,请假原因：" + request.getReason());
        } else {
            System.out.println(
                    "总经理：" + name + " 拒绝了 " + request.getEmployee() + "请假" + request.getLeaveDay() + "天的请求,请假不能超过15天");
        }
    }
}
