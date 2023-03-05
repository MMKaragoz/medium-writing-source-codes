import java.io.IOException;

public interface Serializer {
	void serialize(Object object, String filePath) throws IOException;
    Object deserialize(String filePath) throws IOException, ClassNotFoundException;
}
