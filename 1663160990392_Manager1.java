package com.synchroni.demo;

class Student1{

    synchronized void test(){
        for(int i=0;i<10;i++){
            System.out.println(i);
        }
    }

    synchronized void test1(){
        for(int i=20;i<30;i++){
            System.out.println(i);
          
        }
    }
}
class Student2 extends Thread{
    Student1 obj;

    Student2(Student1 obj){
        this.obj = obj;  
    }

    @Override
    public void run() {
        obj.test();
    }
}
class Student3 extends Thread{
    Student1 obj;

    Student3(Student1 obj){
        this.obj = obj;  
    }

    @Override
    public void run() {
        obj.test1();
      
    }
}


public class Manager1 {
    public static void main(String[] args) {
        Student1 obj1 = new Student1();

        Student2 obj2 =new Student2(obj1);

        Student3 obj3 = new Student3(obj1);

      
        obj2.start();
        obj3.start();
        
    }
}