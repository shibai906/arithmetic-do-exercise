package com.zhao.design.mode.chain;

/**
 * @program: arithmetic-do-exercise
 * @description
 * @author: zhaohuan
 * @create: 2020-04-10 10:51
 **/
public class Client {

    public static void main(String[] args) {

        LeaveRequest request = new LeaveRequest();
        request.setEmployee("找经历");
        request.setLeaveDay(17);
        request.setReason("找你大爷去");
        Manager generalManager = new Manager("傻逼");
        generalManager.handleRequest(request);

    }

}
