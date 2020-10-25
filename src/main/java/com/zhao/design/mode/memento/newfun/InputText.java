package com.zhao.design.mode.memento.newfun;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-10-20 00:31
 * @description
 **/
public class InputText {

    private StringBuilder text = new StringBuilder();

    public String getText() {
        return text.toString();
    }

    public void append(String input) {
        text.append(input);
    }

    public Snapshot createSnapshot() {

        return new Snapshot(text.toString());
    }

    public void restoreSnapshot(Snapshot snapshot) {
        this.text.replace(0, this.text.length(), snapshot.getText());
    }
}
