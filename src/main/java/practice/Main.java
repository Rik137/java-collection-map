package practice;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        String phone = "";
        String name = "";
        while (true) {
            System.out.println("Введите номер, имя или команду:");
            String input = new Scanner(System.in).nextLine().strip();
            if (input.equals("LIST")) {
                System.out.println(phoneBook.getAllContacts());
            } else {
                String inputPhone = phoneBook.checkPhoneNumber(input);
                String inputName = phoneBook.checkName(input);

                if (!inputPhone.equals("-1")) {
                    phone = input;
                    if (phoneBook.getContactByPhone(inputPhone).equals("") && name.equals("")) {
                        System.out.println("Такого номера нет в телефонной книге.\n" +
                                "Введите имя абонента для номера " + "\"" + inputPhone + "\"" + " :");
                    } else {
                        System.out.println(phoneBook.getContactByPhone(phone));
                    }
                } else if (!inputName.equals("-1")) {
                    name = input;
                    if (phoneBook.getContactByName(input).equals(new TreeSet<>()) && phone.equals("")) {
                        System.out.println("Такого имени в телефонной книге нет.\n" +
                                "Введите номер телефона для абонента " + "\"" + inputName + "\"" + ": ");
                    } else {
                        System.out.println(phoneBook.getContactByName(name));
                    }
                } else {
                    System.out.println("не корректный ввод!");
                }
                if (!name.equals("") && !phone.equals("")) {
                    phoneBook.addContact(phone, name);
                    System.out.println("контакт сохранен!");
                    name = "";
                    phone = "";
                }
            }
        }
    }
}
