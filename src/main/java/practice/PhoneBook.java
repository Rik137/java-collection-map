package practice;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.TreeMap;

public class PhoneBook {
    Map<String, String> phoneBook = new TreeMap<>();

    public void addContact(String phone, String name) {
        if (!checkName(name).equals("-1") && !checkPhoneNumber(phone).equals("-1")) {
            if (phoneBook.containsKey(phone)) {
                phoneBook.replace(phone, phoneBook.get(phone), name);
            } else if (phoneBook.containsValue(name)) {
                getContactTwoNumbers(phone, name);
            } else {
                phoneBook.put(phone, name);
            }
        }
    }

    public String getContactByPhone(String phone) {
        if (phoneBook.containsKey(phone)) {
            return phoneBook.get(phone) + " - " + phone;
        } else {
            return "";
        }
    }

    public Set<String> getContactByName(String name) {
        Set<String> setPhoneBook = new TreeSet<>();
        String namePlusTel = "";
        if (phoneBook.containsValue(name)) {
            namePlusTel = namePlusTel.concat(name) + " - ";
            for (String tel : phoneBook.keySet()) {
                if (phoneBook.get(tel).equals(name)) {
                    namePlusTel = namePlusTel.concat(tel) + ", ";
                }
            }
            setPhoneBook.add(namePlusTel.substring(0, namePlusTel.length() - 2));
            return setPhoneBook;
        } else {
            return new TreeSet<>();
        }
    }

    public Set<String> getAllContacts() {
        Set<String> setPhoneBook = new TreeSet<>();
        for (String key : phoneBook.keySet()) {
            setPhoneBook.add(phoneBook.get(key) + " - " + key);
        }
        return setPhoneBook;
    }

    public Set<String> getContactTwoNumbers(String phone, String name) {
        TreeSet<String> result = new TreeSet<>();
        String key = "";
        String namePlusNumber = "";
        if (phoneBook.containsValue(name)) {
            for (String k : phoneBook.keySet()) {
                if (phoneBook.get(k).equals(name)) {
                    key = k;
                    result.add(name + " - " + key + ", " + phone);
                    namePlusNumber = key + ", " + phone;
                    break;
                }
            }
        }
        phoneBook.remove(key);
        phoneBook.put(namePlusNumber, name);
        return result;
    }

    public String checkPhoneNumber(String phone) {
        String regex = "[^0-9]";
        String regex1 = "[0-9]{11}";
        String correctPhone = phone.replaceAll(regex, "");
        if (!correctPhone.matches(regex1)) {
            correctPhone = "-1";
        }
        return correctPhone;
    }

    public String checkName(String name) {
        if (!name.matches("[А-Я][а-я]+")) {
            name = "-1";
        }
        return name;
    }
}