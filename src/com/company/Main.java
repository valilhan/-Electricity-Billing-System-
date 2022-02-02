package com.company;
import javax.xml.crypto.Data;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Database MyDatabase = Database.getInstance();
        Scanner scan = new Scanner(System.in);
        System.out.println("We welcome to our program, you will need to set server date");
        System.out.println("then you will have options what to do, don't forget to sign up!!!");
        int Option;
        do{
            System.out.println("Enter 0 for passing K number of days");
            System.out.println("Enter 1 to login to system");
            System.out.println("Enter 2 to sign up to system");
            System.out.println("Enter 3 or any other number to finish program");
            System.out.println();

            Option = scan.nextInt();
             switch (Option){
                case 0:
                    System.out.print("Enter number of days: ");
                    int k = scan.nextInt();
                    for(int i = 1; i <= k; i ++){
                        MyDatabase.CurrentDate.increaseDay();
                        MyDatabase.calculateCosts();
                    }
                    break;
                case 1:
                    System.out.print("Enter your email: ");
                    String email2=scan.next();
                    System.out.print("Enter your password: ");
                    String password2=scan.next();
                    Account _account2 = new Account(email2, password2);
                    Customer loginedCustomer = MyDatabase.getCostumer(_account2);
                    if( loginedCustomer == null ){
                        System.out.println("***ERROR: There is no such account in the system!");
                        break;
                    }
                    int loginOption = 0;
                    do{

                        System.out.println("Enter 0 for making payment");
                        System.out.println("Enter 1 for printing summary of bills");
                        System.out.println("Enter 2 to know how much you dept");
                        System.out.println("Enter 3 to see your current balance");
                        System.out.println("Enter 4 to set a new password for your account");
                        System.out.println("Enter 5 to delete your account and tore the contract");
                        System.out.println("Enter 6 or any other number to logout");
                        System.out.println();

                        loginOption = scan.nextInt();
                         switch (loginOption){
                            case 0:
                                System.out.print("How much do you want to pay: ");
                                int payment = scan.nextInt();
                                loginedCustomer.makePayment(payment);
                                break;
                            case 1:
                                if( loginedCustomer.getSummary().isEmpty() ){
                                    System.out.println("There is no any bills!");
                                }
                                else{
                                    System.out.println("List of bills : ");
                                    for (Bill bill : loginedCustomer.getSummary()) {
                                        System.out.println(Integer.toString(bill.getYear()) + " " + Integer.toString(bill.getMonth()) + " " + Float.toString(bill.getPrice()));
                                    }
                                }
                                break;
                            case 2:
                                System.out.print("** Your debt is : ");
                                System.out.println(loginedCustomer.getRemainder());
                                break;
                            case 3:
                                System.out.print("** Your balance is : ");
                                System.out.println(loginedCustomer.getBalance());
                                break;
                            case 4:
                                System.out.print("Enter your new password : ");
                                String newPassword = scan.next();
                                loginedCustomer.account.setPassword(newPassword);
                                break;
                            case 5:
                                if(loginedCustomer.isDebtor == true){
                                    System.out.println("Bacause of your deptency, you can't tore the contract, please pay " + loginedCustomer.getRemainder() + " to tore the contract");
                                    loginOption = 0;
                                    break;
                                }
                                MyDatabase.deleteCustomer(loginedCustomer);
                                System.out.println("** You successfully deleted your account. Money on your balance was sent to your credit card");
                                break;
                            default:
                                break;
                        }
                    } while( loginOption >= 0 && 4 >= loginOption );
                    break;
                case 2:
                    System.out.print("Enter your email: ");
                    String email=scan.next();
                    if( MyDatabase.accountExist(email) ){
                        System.out.println("This account already exist");
                        break;
                    }
                    System.out.print("Enter your password: ");
                    String password=scan.next();
                    Account _account = new Account(email,password);

                    System.out.print("Enter your name: ");
                    String name=scan.next();
                    System.out.print("Enter your surname: ");
                    String surname=scan.next();
                    Information _information=new Information(name,surname, MyDatabase.CurrentDate);

                    Bill _bill = new Bill(MyDatabase.CurrentDate.getMonth(), MyDatabase.CurrentDate.getYear(), 0, false);

                    Customer _customer = new Customer(_information, _account, _bill);


                    MyDatabase.addCustomer(_customer);
                    break;
                default:
                    break;
            }
        }
        while( Option >= 0 && 2 >= Option );
    }
}
