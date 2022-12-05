import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class App {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("How many locals? ");
		Integer localsNumber = scanner.nextInt();
		Character character = 'A';
		List<Character> charsVector = new ArrayList<>();
		for (int i = 0; i < localsNumber; i++) {
			charsVector.add(character++);
		}
		
		List<Integer> intVector = new ArrayList<>();
		for (int i = 0; i < localsNumber; i++) {
			intVector.add(i);
		}
		
		List<List<Character>> vectorsList = new ArrayList<>();
		List<Character> currentVector = new ArrayList<>();
		vectorsList = recursionVector(vectorsList, charsVector, intVector, currentVector);
		
		System.out.println(vectorsList);
		System.out.println(vectorsList.size());
	}
	
	
	static List<List<Character>> recursionVector(List<List<Character>> vectorsList, List<Character> charsVector, List<Integer> intVector, List<Character> currentVector) {
		for (int i : intVector) {
			var newCurrentVector = new ArrayList<>(currentVector);
			newCurrentVector.add(charsVector.get(i));
			if (intVector.size() == 1) {
				newCurrentVector.add(newCurrentVector.get(0));
				vectorsList.add(newCurrentVector);
			} else {
				var newIntVector = new ArrayList<>(intVector);
				newIntVector.remove((Integer) i);
				recursionVector(vectorsList, charsVector, newIntVector, newCurrentVector);	
			}
		}

		return vectorsList;
	}
}
