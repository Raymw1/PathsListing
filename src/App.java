import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class App {
	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		System.out.print("How many locals?");
//		Integer localsNumber = scanner.nextInt();
		Integer localsNumber = 6;
		Character character = 'A';
		List<Character> charsVector = new ArrayList<>();
		for (int i = 0; i < localsNumber; i++) {
			charsVector.add(character++);
		}
		List<List<Character>> vectorsList = new ArrayList<>();
		vectorsList.add(charsVector);
		vectorsList = recursionVector(vectorsList, charsVector, localsNumber);
		System.out.println(vectorsList);
		
	

	}
	
	
	static List<List<Character>> recursionVector(List<List<Character>> vectorsList, List<Character> vector, Integer count) {
		if (count == 1) {
			return vectorsList;
		}
		var newVector = new ArrayList<>(vector);
		newVector.add(0, newVector.get(newVector.size()-1));
		newVector.remove(newVector.size()-1);
		vectorsList.add(newVector);
		return recursionVector(vectorsList, newVector, count-1);
	}
}
