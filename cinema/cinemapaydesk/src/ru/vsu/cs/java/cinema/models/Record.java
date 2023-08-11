package ru.vsu.cs.java.cinema.models;

public class Record {
    public long id;
    public String name;
    public String number1;
    public String number2;
    public String number3;



    public Record(String name, String number1, String number2,  String number3) {
        this.name = name;
        this.number1 = number1;
        this.number2 = number2;
        this.number3 = number3;
    }

    public Record(long id, String name, String number1, String number2,  String number3) {
        this.id = id;
        this.name = name;
        this.number1 = number1;
        this.number2 = number2;
        this.number3 = number3;
    }

    public Record(Record other){
        this(other.id, other.name, other.number1, other.number2, other.number3);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber1() {
        return number1;
    }

    public void setNumber1(String number1) {
        this.number1 = number1;
    }

    public String getNumber2() {
        return number2;
    }

    public void setNumber2(String number2) {
        this.number2 = number2;
    }

    public String getNumber3() {
        return number3;
    }

    public void setNumber3(String number3) {
        this.number3 = number3;
    }
}
