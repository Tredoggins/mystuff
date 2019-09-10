import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class RoomWriter {
    public static void writeRoomFile(String fileName, List<Room> roomList) throws IOException {
        FileOutputStream file = new FileOutputStream(fileName);
        ObjectOutputStream out = new ObjectOutputStream(file);
        for(Room room:roomList) {
            out.writeObject(room);
        }
        out.close();
        file.close();
    }
}
