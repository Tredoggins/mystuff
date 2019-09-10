import java.io.*;
import java.util.*;

public class RoomReader {
    public static List<Room> readRoomFile(String fileName) throws IOException, ClassNotFoundException {
        List<Room> roomList=new ArrayList<Room>();
        FileInputStream file = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(file);
        Object obj = null;try {// Allow the EOF Exception to happen
             while ((obj = ois.readObject()) != null) {Room room= (Room) obj;roomList.add(room);}} catch (EOFException e) {// Do nothing, we expect this to happen
             }
        file.close();
        ois.close();
        return roomList;

    }
}
