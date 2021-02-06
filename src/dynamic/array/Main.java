package dynamic.array;

public class Main {

	public static void main(String[] args) {
		
		DynamicArray<Integer> array = new DynamicArray<>();
		
		array.add(99);
		array.add(88);
		array.add(77);
		array.add(66);
		array.add(55);
		
		array.set(3, 80);
		
		System.out.println(array);
		
	}

}
