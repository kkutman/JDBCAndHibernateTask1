package peaksoft;

import peaksoft.service.UserServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserServiceImpl userService = new UserServiceImpl();
        userService.saveUser("kutman1","kaseiinov",(byte) 39);
        userService.saveUser("kutman2","kaseiinov",(byte) 49);
        userService.saveUser("kutman3","kaseiinov",(byte) 19);

        while (true){
            System.out.println("""
                    PRESS 1 CREATE TABLE!
                    PRESS 2 DROP TABLE!
                    PRESS 3 SAVE USER!
                    PRESS 4 REMOVE USER BY ID!
                    PRESS 5 ALL USERS!
                    PRESS 6 CLEAN USERS!
                    """);
            switch (scanner.nextInt()){
                case 1:
                    System.out.println(userService.createUsersTable());
                    break;
                case 2:
                    userService.dropUsersTable();
                    break;
                case 3:
                    String d = scanner.nextLine();
                    System.out.print("NAME : ");
                    String name = scanner.nextLine();
                    System.out.print("LAST NAME : ");
                    String last_name = scanner.nextLine();
                    System.out.print("AGE : ");
                    byte age = scanner.nextByte();
                    System.out.println(userService.saveUser(name, last_name, age));
                    break;
                case 4:
                    System.out.print("ID : ");
                    userService.removeUserById(scanner.nextLong());
                    break;
                case 5:
                    userService.getAllUsers().forEach(System.out::println);
                    break;
                case 6:
                    userService.cleanUsersTable();
                    break;
                default:
                    System.out.println("1-6");
                    break;

            }
        }

    }
}
