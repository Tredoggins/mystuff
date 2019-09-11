
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PaintCalculator {

    private List<Paintable> roomList = new ArrayList<Paintable>();
    private Scanner keyboard;

    public static void main(String[] args) {
        new PaintCalculator();
    }

    public PaintCalculator() {
        keyboard = new Scanner(System.in);

        int option = 0;

        while (option != 5) {
            printMenu();

            String s = keyboard.nextLine();
            try {
                int choice = Integer.parseInt(s);
                switch (choice) {
                    case 1:
                        createRoom();
                        break;
                    case 2:
                        createDoor();
                        break;
                    case 3:
                        // writeFile();
                        RoomWriter.writeRoomFile("file.txt",roomList);
                        break;
                    case 4:
                        // readFile();
                        roomList.addAll(RoomReader.readRoomFile("file.txt"));
                        break;
                    case 5:
                        printRooms();
                        break;
                    case 6:
                        System.out.println("Goodbye");
                        System.exit(0);
                }
            } catch (NumberFormatException | IOException | ClassNotFoundException e) {
                System.out.println("Invalid choice");
            }
        }

    }

    private void printRooms() {
        if (roomList.isEmpty()) {
            System.out.println("No rooms yet");
        }

        for (Paintable thing : roomList) {
            System.out.println(thing.toString());
        }
    }

    private void printMenu() {
        System.out.println();
        System.out.println("1. Add room");
        System.out.println("2. Add door");
        System.out.println("3. Write rooms/doors to file");
        System.out.println("4. Read rooms/doors from file");
        System.out.println("5. View rooms/doors");
        System.out.println("6. Exit");
        System.out.println();
    }

    private int promptForDimension(String name) {
        System.out.print("Enter the room's " + name + ": ");
        String response = keyboard.nextLine();
        try {
            return Integer.parseInt(response);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private void createRoom() {
        int length = promptForDimension("length");
        int width = promptForDimension("width");
        int height = promptForDimension("height");

        try {
            Room room = new Room(length, width, height);
            roomList.add(room);

            System.out.println("Room successfully created");
        } catch (BadWidthException | BadHeightException e) {
            System.out.println("Could not create room.");
        }

    }
    private void createDoor(){
        int length=promptForDimension("length");
        int width=promptForDimension("width");
        try{
            Door door=new Door(length,width);
            System.out.println("Door Created");

        }
        catch (Exception e){

        }
    }
}
