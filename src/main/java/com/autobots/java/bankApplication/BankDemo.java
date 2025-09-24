package com.autobots.java.bankApplication;

import org.w3c.dom.ls.LSOutput;

public class BankDemo {
    public static void main(String[] args) throws Exception {

        MBank aliMBank = new MBank(123456789111L,444444444);

//        System.out.println(aliMBank.getBalance());
        aliMBank.deposit(100000);
        System.out.println("__________");
//        System.out.println(aliMBank.getBalance());

OptimaBank uluOptima = new OptimaBank(123456789122L, 555555555);
//        System.out.println(uluOptima.getBalance());

        Bank.transferFunds(aliMBank,uluOptima,500);
//        System.out.println(aliMBank.getBalance());
//        System.out.println(uluOptima.getBalance());

//        DemirBank zinaDemir = new DemirBank(123456789L,666666666 );
//        Bank.transferFunds(zinaDemir, uluOptima, 1000);
//        System.out.println(zinaDemir.getBalance());
//        System.out.println(uluOptima.getBalance());

        BankBase.allBankRecords.stream()
                .filter(n -> n.getBalance() > 100)
                .forEach(System.out::println);


        double allSumOfBanks = BankBase.allBankRecords.stream().mapToDouble(Bank::getBalance).sum();
        System.out.println(allSumOfBanks);
    }


}
