import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class RoomWriter {
    public static void writeRoomFile(String fileName, List<Paintable> roomList) throws IOException {
        FileOutputStream file = new FileOutputStream(fileName);
        ObjectOutputStream out = new ObjectOutputStream(file);
        for(Paintable thing:roomList) {
            out.writeObject(thing);
        }
        out.close();
        file.close();
    }
}
