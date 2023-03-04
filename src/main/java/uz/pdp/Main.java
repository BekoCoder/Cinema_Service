package uz.pdp;

import uz.pdp.model.Card;
import uz.pdp.model.Cinema;
import uz.pdp.model.User;
import uz.pdp.service.CardService;
import uz.pdp.service.CinemaService;
import uz.pdp.service.UserService;

import java.util.Scanner;

public class Main {
    static Scanner scannerStr=new Scanner(System.in);
    static  Scanner scannerInt=new Scanner(System.in);
    static CinemaService cinemaService=new CinemaService();
    static  CardService cardService=new CardService();
    static UserService userService=new UserService();


    public static void main(String[] args) {
        User admin=new User("Bekzod", "bekzod@gmail.com", "123");


        int stepCode=10;
        while (stepCode!=0){
            System.out.println("1.Register, 2.Login, 0.Exit");
            stepCode=scannerInt.nextInt();
            switch (stepCode){
                case 1->{
                    System.out.println("Enter name: ");
                    String  name=scannerStr.nextLine();
                    System.out.println("Enter email: ");
                    String  email=scannerStr.nextLine();
                    System.out.println("Enter password");
                    String  password=scannerStr.nextLine();
                    User user =new User(name, email, password);
                    boolean register = userService.Register(user);
                   if (register){
                       System.out.println("Succesfully Register: ");
                   }
                   else {
                       System.out.println("Please Try again!!! ");
                   }
                }

                case 2->{
                    System.out.println("Enter email: ");
                    String  email=scannerStr.nextLine();
                    System.out.println("Enter password");
                    String  password=scannerStr.nextLine();
                    User login = userService.login(email, password);

                    if (login==null){
                        System.out.println("Wrong enter: ");
                    }
                    else if(login.getEmail().equals("bekzod@gmail.com") && login.getPassword().equals("123")){
                        System.out.println("########### Welcome to Admin Panel ###########");
                       stepCode=5;
                       while (stepCode!=0){
                           System.out.println("1.Add Cinema, 2. Those who bought movies tickets, 0.Exit ");
                           stepCode=scannerInt.nextInt();
                           switch (stepCode){
                               case 1->{
                                   System.out.println("Enter cinema name: ");
                                   String cinemaName=scannerStr.nextLine();
                                   System.out.println("Enter cinema price: ");
                                   int price=scannerInt.nextInt();
                                   Cinema cinema=new Cinema(cinemaName, price);
                                   System.out.println(cinemaService.addCinema(cinema));
                               }
                               case 2->{
//                                        cinemaService.whoBoughtCinema();
                               }
                           }
                       }

                    }
                    else {
                         stepCode=2;
                        System.out.println("###### Welcome ######");
                        while (stepCode!=0){
                            System.out.println("1.Add Card, 2.Fill Card, 3.Cinema List, 4.Buy ticket for cinema, 5.My Card List 0.Exit");
                            stepCode=scannerInt.nextInt();
                            switch (stepCode){
                                case 1->{
                                    System.out.println("Enter cardNumber: ");
                                    String cardNumber=scannerStr.nextLine();
                                    System.out.println("Enter Expiry Date: ");
                                    String expiryDate=scannerStr.nextLine();
                                    System.out.println("Enter balance: ");
                                    int balance=scannerInt.nextInt();
                                    Card card=new Card(cardNumber, balance, expiryDate,login.getId());
                                    System.out.println(cardService.addCard(card));
                                }
                                case 2->{
                                    System.out.println("Enter cardNumber: ");
                                    String cardNumber=scannerStr.nextLine();
                                    System.out.println("Enter balance: ");
                                    int balance=scannerInt.nextInt();
                                    System.out.println(cardService.fillCard(cardNumber,login.getId(),balance));
                                }
                                case 3->{
                                    System.out.println(cinemaService.getCinemaListFile());

                                }
                                case 4->{
                                    Card card=new Card();
                                    Cinema cinema=new Cinema();
                                    System.out.println(cinemaService.getCinemaListFile());
                                    System.out.println("Choose cinema: ");
                                    int choose=scannerInt.nextInt();
                                    Cinema cinema1=cinemaService.getCinemaListFile().get(choose-1);
                                    if(cinema.getPrice()>=card.getBalance()){
                                        System.out.println(cinemaService.buyTicket(cinema.getId()));
                                    }
                                    else {
                                        System.out.println("Not enough money!!!");
                                    }



                                }
                                case 5->{
                                    cardService.myCardList(login.getId());
                                }

                            }
                        }




                    }


                }


            }

        }



    }
}