package rmit.SADI;

import rmit.SADI.ActionChoser.ChooseAction;
import rmit.SADI.FileInputOutput.FileIO;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean quit = false;
        byte option;
        FileIO.read();
        do{
            System.out.println("1. Add enrolment                5. Show all enrolments");
            System.out.println("2. Delete enrolment             6. Show enrolments for a semester");
            System.out.println("3. Undo last delete             7. Show enrolments of 1 student");
            System.out.println("4. Update an enrolment          8. Quit");
            System.out.println("-------------------------------------------------------------------");
            System.out.print("Input option: ");
            try{
                option = scan.nextByte();
                if (option<1 || option>8)
                {
                    System.out.println("Please enter only 1-8\n");
                    continue;
                }
                if (option == 8){
                    FileIO.export();
                    quit = true;
                    continue;
                }
                    ChooseAction.getInstance().performOption(option);
            }catch (InputMismatchException e){
                System.out.println("Please enter only 1-8\n");
                scan.nextLine();
            }
        }while (!quit);
    }
}
