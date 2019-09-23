package com.zhao.design.mode.memento;

public class Client {

    private static int index = -1;
    private static MementoCaretaker mc = new MementoCaretaker();

    public static void main(String[] args) {
        Chessman chess = new Chessman("车",1,1);
        play(chess);
        chess.setY(4);
        play(chess);
        chess.setX(5);
        play(chess);
        undo(chess);
        undo(chess);
        redo(chess);
        redo(chess);

    }
    public static void play(Chessman chess) {
        mc.addMemento(chess.save());
        index ++;
        chess.show();
    }

    // 悔棋，撤销到上一个备忘录
    public static void undo(Chessman chess) {
        System.out.println("*****悔棋******");
        index -- ;
        chess.restore(mc.getMemento(index));
        chess.show();
    }

    // 撤销悔棋，恢复到下一个备忘录
    public static void redo(Chessman chess) {
        System.out.println("*****撤销悔棋*******");
        index ++;
        chess.restore(mc.getMemento(index));
        chess.show();
    }


}
