package com.javarush.task.task22.task2212;

/* 
1) если номер начинается с '+', то он содержит 12 цифр
2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
3) может содержать 0-2 знаков '-', которые не могут идти подряд
4) может содержать 1 пару скобок '(' и ')' , причем если она есть, то она расположена левее знаков '-'
5) скобки внутри содержат четко 3 цифры
6) номер не содержит букв
7) номер заканчивается на цифру
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null){
            return false;
        }
        //System.out.println("telNumber = "+ telNumber);
        int cntDigit = telNumber.replaceAll("\\D", "").length();
        //System.out.println("cntDigit = "+ cntDigit);

        //номер не содержит букв
        if (telNumber.matches("\\w")){
            return false;
        }

        //+12
        if (telNumber.matches("^\\+{1}\\d{12}")){
            return true;
        }
        //+12 скобки
        if (telNumber.matches("^\\+\\d+[\\(]{1}\\d{3}[\\)]{1}\\d*") && cntDigit == 12 ){
            return true;
        }
        //+12 скобки 1 дефис
        if (telNumber.matches("^\\+\\d+[\\(]{1}\\d{3}[\\)]{1}\\d+-{1}\\d+") && cntDigit == 12 ){
            return true;
        }
        //+12 скобки 2 дефиса
        if (telNumber.matches("^\\+\\d+[\\(]{1}\\d{3}[\\)]{1}\\d+-{1}\\d+-{1}\\d+") && cntDigit == 12 ){
            return true;
        }
        //+12 0-2 дефиса
        if (telNumber.matches("^\\+\\d+-?\\d+-?\\d+") && cntDigit == 12 ){
            return true;
        }
        //10 скобки
        if (telNumber.matches("^\\d*[\\(]{1}\\d{3}[\\)]{1}\\d*") && cntDigit == 10){
            return true;
        }
        //10 скобки 1 дефис
        if (telNumber.matches("^\\d*[\\(]{1}\\d{3}[\\)]{1}\\d+-{1}\\d+") && cntDigit == 10){
            return true;
        }
        //10 скобки 2 дефиса
        if (telNumber.matches("^\\d*[\\(]{1}\\d{3}[\\)]{1}\\d+-{1}\\d+-{1}\\d+") && cntDigit == 10){
            return true;
        }
        //10 0-2 дефиса
        if (telNumber.matches("^\\d+-?\\d+-?\\d+") && cntDigit == 10){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkTelNumber("+380501234567")); //- true
        System.out.println(checkTelNumber("+3(805)01234567")); // - true
        System.out.println(checkTelNumber("+38(050)1234567")); // - true
        System.out.println(checkTelNumber("+380(501)234567")); // - true
        System.out.println(checkTelNumber("+3805(012)34567")); // - true
        System.out.println(checkTelNumber("+38050(123)4567")); // - true
        System.out.println(checkTelNumber("+380501(234)567")); // - true
        System.out.println(checkTelNumber("+3805012(345)67")); // - true
        System.out.println(checkTelNumber("+38050123(456)7")); // - true
        System.out.println(checkTelNumber("+380501234(567)")); // - true
        System.out.println(checkTelNumber("+38050123-45-67")); // - true
        System.out.println(checkTelNumber("050123-4567")); // - true
        System.out.println(checkTelNumber("(050)123-4567")); // - true
        System.out.println(checkTelNumber("0-50123-4567")); // - true
        System.out.println(checkTelNumber("-050123-4567")); // - false
        System.out.println(checkTelNumber("(050)123-4567-")); // - false
        System.out.println(checkTelNumber("+38050123-4567-")); // - false
        System.out.println(checkTelNumber("+3805012(345)67-")); // - false
        System.out.println(checkTelNumber("+38-05012(345)67")); // - false

        System.out.println(checkTelNumber("+38)050(1234567")); // - false
        System.out.println(checkTelNumber("+38(050)1-23-45-6-7")); // - false
        System.out.println(checkTelNumber("050ххх4567")); // - false
        System.out.println(checkTelNumber("050123456")); //" - false
        System.out.println(checkTelNumber("(0)501234567")); // - false
    }
}
