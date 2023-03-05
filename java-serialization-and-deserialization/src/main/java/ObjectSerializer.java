import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectSerializer implements Serializer {

	public void serialize(Object object, String filePath) throws IOException {
		FileOutputStream fileOut = new FileOutputStream(filePath);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(object);
        out.close();
        System.out.println("Serialized data is saved in " + filePath);

	}

	public Object deserialize(String filePath) throws IOException, ClassNotFoundException {
		FileInputStream fileIn = new FileInputStream(filePath);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        Object object = in.readObject();
        in.close();
        System.out.println("Deserialized data:");
        System.out.println(object);
        return object;
	}

}
