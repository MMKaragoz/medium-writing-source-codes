import java.io.IOException;

public class SerializationAndDeserializationExample {
	public static void main(String[] args) {
		try {
			Person person = new Person("FirstName", "LastName", 10);
			Serializer serializer = new ObjectSerializer();
			String fileName = "person.ser";
            serializer.serialize(person, fileName);			
		} catch (IOException i) {
			 i.printStackTrace();
		}
		
		try {
			Serializer serializer = new ObjectSerializer();
			String fileName = "person.ser";
            Person person = (Person) serializer.deserialize(fileName);
            System.out.println("Country: " + Person.country);
		} catch (IOException i) {
			i.printStackTrace();
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
		}

	}
}
