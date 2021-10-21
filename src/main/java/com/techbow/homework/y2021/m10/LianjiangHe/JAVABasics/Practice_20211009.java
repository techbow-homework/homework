package com.techbow.homework.y2021.m10.LianjiangHe.JAVABasics;

public class Practice_20211009 {
    public static void main(String[] args) {
        Teacher t = new Teacher("Peter",20,'F',"2000/1/1","Teacher","CS","2");
        t.eat();
        t.sleep();
        t.teach();
//        Person p = new Person();
//        p.setName("Peter");
//        p.setAge(20);
//        p.setGender('F');
//        p.setBirthday("08/09");
//
//        p.eat();
//        p.sleep();
    }
}
class Person{
    private String  name;
    private int age;
    private char gender;
    private String birthday;

    public Person(){}
    public Person(String name,int age,char gender,String birthday){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.birthday  = birthday;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void eat(){
        System.out.println(name+" is eating sth");
    }
    public void sleep(){
        System.out.println(name+" is sleeping");
    }
}
class Teacher extends Person{
    private String title;
    private String course;
    private String className;

    public Teacher(){}
    public Teacher(String title,String course,String className){
        this.title = title;
        this.course = course;
        this.className = className;
    }
    public Teacher(String name,int age,char gender,String birthday,String title,String course,String className){
        // super();//调用父类里面的无参构造方法
        super(name, age, gender, birthday);
        init(title,course,className);
    }

    private void init(String title, String course, String className) {
        this.title = title;
        this.course = course;
        this.className = className;
    }

    public  void teach(){
        System.out.println(getName()+" is teaching");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}