package com.zhao.design.mode.flyweight;

public class Client {

    public static void main(String[] args) {
        Address adrs1 , adrs2 ;
        AddressFactory factory = AddressFactory.getInstance();
        adrs1 = factory.getAddress("C");
        adrs2 = factory.getAddress("R");

        adrs1.display(new UserInfo("老大","230238493"));
        adrs1.display(new UserInfo("二统","230238493"));
        adrs1.display(new UserInfo("小五","230238493"));
        adrs1.display(new UserInfo("老于","230238493"));
        System.out.println("\n--------------------------------\n");
        adrs2.display(new UserInfo("老大","230238493"));
        adrs2.display(new UserInfo("老小","230238493"));

    }

}
