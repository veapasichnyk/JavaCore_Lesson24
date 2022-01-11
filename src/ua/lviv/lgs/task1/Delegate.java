package ua.lviv.lgs.task1;

import java.util.Scanner;

public class Delegate extends Human{
    private String lastName;
    private String firstName;
    private int age;
    private boolean bribeTaker;
    private int bribeSize;

    public Delegate (String lastName, String firstName){
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public Delegate ( String lastName, String firstName, int age, boolean bribeTaker,
                      int weight, int height) {
        super(weight, height);
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.bribeTaker = bribeTaker;
    }

    public Delegate(int weight, int height){
        super(weight, height);
    }

    void takeBribe(){

        if (!bribeTaker){
            System.out.println("Цей депутат не бере хабарів");
        }
        else {
            System.out.println("Введіть суму хабаря: ");
            Scanner scanner =  new Scanner(System.in);
            int     temp    =0;
            try{temp = scanner.nextInt ();
                this.bribeSize += temp;}
            catch (IllegalArgumentException exception){
                System.out.println(exception.getMessage());
            }
            if (temp>5000){
                System.out.println("Поліція увязнить депутата");
            }

        }

    }

    public void setBribeSize ( int bribeSize ) {
        this.bribeSize = bribeSize;
    }

    public int getBribeSize ( ) {
        return bribeSize;
    }

    public String getLastName ( ) {
        return lastName;
    }

    public String getFirstName ( ) {
        return firstName;
    }

    public int getAge ( ) {
        return age;
    }

    public boolean isBribeTaker ( ) {
        return bribeTaker;
    }

    @Override
    public double getWeight ( ) {
        return super.getWeight ( );
    }

    @Override
    public double getHeight ( ) {
        return super.getHeight ( );
    }

    @Override
    public String toString ( ) {
        return "Delegate{" +
               "lastName='" + lastName + '\'' +
               ", firstName='" + firstName + '\'' +
               ", age=" + age +
               ", bribeTaker=" + bribeTaker +
               ", bribeSize=" + bribeSize +
               '}';
    }
}
