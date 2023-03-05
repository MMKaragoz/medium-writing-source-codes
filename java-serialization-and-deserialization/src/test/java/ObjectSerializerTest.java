import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class ObjectSerializerTest {
	
	private Serializer serializer;

    @Before
    public void setUp() {
    	serializer = new ObjectSerializer();
    }

    @DisplayName("testSerialize when everyhing is OK.")
    @Test
    public void testSerialize() throws IOException {
    	 Person person = new Person("a", "a", 10);
    	 String filePath = "test.ser";

         serializer.serialize(person, filePath);
          
         File file = new File(filePath);
         assertTrue(file.exists());
         assertTrue(file.isFile());

         file.delete();
    }
    
    @DisplayName("testSerialize should throw IOException when file does not exist.")
    @Test(expected=IOException.class)
    public void testSerialize_shouldThrowIOException_whenFileDoesNotExist() throws IOException {
    	Person person = new Person("a", "a", 10);
        String filePath = "/does/not/exist/test.ser";

        serializer.serialize(person, filePath);
    }
    
    @DisplayName("testDeserialize when everything is OK.")
    @Test
    public void testDeserialize() throws IOException, ClassNotFoundException {
    	String filePath = "test.ser";
    	String expected = "Hi!";
    	
    	serializer.serialize(expected, filePath);
    	
    	Object actual = serializer.deserialize(filePath);
    	
    	assertEquals(expected, actual);

    	File file = new File(filePath);
        file.delete();
    }
    
    @DisplayName("testDeserialize should throw IOException when file does not exist.")
    @Test(expected=IOException.class)
    public void testDeserializeIOException_shouldThrowIOException_whenFileDoesNotExist() throws IOException, ClassNotFoundException {
        String filePath = "/does/not/exist/test.ser";
        serializer.deserialize(filePath);
    }
    
    @After
    public void tearDown() {
    }
}
