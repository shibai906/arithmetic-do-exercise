package com.zhao.design.mode.memento.newfun;

import java.util.Scanner;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-10-20 00:33
 * @description
 **/
public class ApplicationMain {

    public static void main(String[] args) {
        InputText inputText = new InputText();
        SnapshotHolder snapshotsHolder = new SnapshotHolder();
        inputText.append("zhaohuan");
        snapshotsHolder.pushSnapshot(inputText.createSnapshot());
        inputText.append("guojinshu");
        snapshotsHolder.pushSnapshot(inputText.createSnapshot());

        System.out.println(snapshotsHolder.popSnapshot().getText());
        System.out.println(snapshotsHolder.popSnapshot().getText());
    }


}
