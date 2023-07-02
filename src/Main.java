import Account.Account;
import Account.SimpleAccount;
import Account.CreditAccount;
import Account.Limit;

import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {


        Account simple = new SimpleAccount(3000);
        Account credit = new CreditAccount(new Limit(-10000));
        System.out.println("Здравству вас приветствует банкомат");
        while(true){
            System.out.println("Выберите операцию:\n" +
                    "1.Пополнение счета.\n" +
                    "2.Оплата услуг.\n" +
                    "3.Перевод с карты на карту.\n" +
                    "Конец работы \"End\"");
            System.out.println(simple + "\n" + credit);
            String command = scan.nextLine();
            if (command.equals("End")){
                System.out.println("До свидания");
                break;
            }
            if (command.equals("1") || command.equals("2") || command.equals("3")){
                useAtm(command, simple, credit);
            }else{
                System.out.println("Не верный ввод информации");
            }

        }
    }

    private static void useAtm(String command, Account simple, Account credit) {
        switch (command){
            case "1":
                System.out.println("Выберите счет для пополнения - 1." + simple + "\n2." + credit);
                String choiceCard = scan.nextLine();
                operationAdd(choiceCard,simple,credit);
                break;
            case "2":
                System.out.println("Выберите счет оплаты - 1." + simple + "\n2." + credit);
                String choiceCard2 = scan.nextLine();
                operationPay(choiceCard2,simple,credit);
                break;
            case "3":
                System.out.println("Выберите счет списания - 1." + simple + "\n2." + credit);
                String choiceCard3 = scan.nextLine();
                transferOperation(choiceCard3, simple, credit);
                break;
        }
    }

    private static void transferOperation(String choiceCard3,
                                          Account simple, Account credit) {
        if(choiceCard3.equals("1")){
            System.out.println("ВВедите сумму");
            String money = scan.nextLine();
            int moneyS = Integer.parseInt(money);
            System.out.println(simple.transfer(credit, moneyS)
                    ? "Операция прошла успешно" : "Ошибка операции");
        } else if (choiceCard3.equals("2")) {
            System.out.println("Введите сумму");
            String money = scan.nextLine();
            int moneyS = Integer.parseInt(money);
            System.out.println(credit.transfer(simple,moneyS)
                    ? "Операция прошла успешно":"Ошибка операции");
        }else {
            System.out.println("Не верная операция");
        }
    }

    private static void operationPay(String choiceCard2,
                                     Account simple, Account credit) {
        if(choiceCard2.equals("1")){
            System.out.println("Вставьте деньги");
            String money = scan.nextLine();
            int moneyS = Integer.parseInt(money);
            System.out.println(simple.pay(moneyS)
                    ? "Операция прошла успешно" : "Ошибка операции");
        } else if (choiceCard2.equals("2")) {
            System.out.println("Вставьте деньги");
            String money = scan.nextLine();
            int moneyS = Integer.parseInt(money);
            System.out.println(credit.pay(moneyS)
                    ? "Операция прошла успешно":"Ошибка операции");
        }else {
            System.out.println("Не верная операция");
        }
    }

    private static void operationAdd(String choiceCard,
                                     Account simple, Account credit) {
        if(choiceCard.equals("1")){
            System.out.println("Вставьте деньги");
            String money = scan.nextLine();
            int moneyS = Integer.parseInt(money);
            System.out.println(simple.add(moneyS)
                    ? "Операция прошла успешно" : "Ошибка операции");
        } else if (choiceCard.equals("2")) {
            System.out.println("Вставьте деньги");
            String money = scan.nextLine();
            int moneyS = Integer.parseInt(money);
            System.out.println(credit.add(moneyS)
                    ? "Операция прошла успешно":"Ошибка операции");
        }else {
            System.out.println("Не верная операция");
        }
    }
}