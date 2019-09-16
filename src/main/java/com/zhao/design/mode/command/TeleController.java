package com.zhao.design.mode.command;

import java.util.ArrayList;
import java.util.List;

public class TeleController {

    // 播放记录
    List<Command> historyCommand = new ArrayList<>();

    // 切换卫视
    public void switchCommand(Command command) {
        historyCommand.add(command);
        command.execute();
    }
    //遥控器返回命令
    public void back() {
        if (historyCommand.isEmpty()) {
            return;
        }
        int size = historyCommand.size();
        int preIndex = size-2<=0?0:size-2;

        //获取上一个播放某卫视的命令
        Command preCommand = historyCommand.remove(preIndex);

        preCommand.execute();
    }


}
