package dynamic.array;

public class DynamicArray<E> {

	private int size;
	private E[] elements;
	private static final int DEFAULT_CAPACITY= 10;
	private static final int ELEMENT_NOT_FOUND = -1;
	
	
	public DynamicArray() {
		this(DEFAULT_CAPACITY);
	}
	public DynamicArray(int capaticy) {
		capaticy = (capaticy < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capaticy;
		elements = (E[]) new Object[capaticy];
	}
	
	public void clear() {
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		size = 0;
	}//清除数组
	
	public int size() {
		return size;
	}//获取数组大小
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean contains(E element) {
		return indexOf(element) != ELEMENT_NOT_FOUND;
	}
	
	public void add(E element) {
		add(size,element);
	}
	
	public E get(int index) {
		check(index);
		return elements[index];
	}
	
	public E set(int index,E element) {
		check(index);
		E old = elements[index];
		elements[index] = element;
		return old;
	}
	
	public void add(int index,E element) {
		checkForAdd(index);
		ensureCapacity(size + 1);
		
		for (int i = size - 1; i >= index; i--) {
			elements[i + 1] = elements[i];
		}
		elements[index] = element;
		size++;
	}
	
	public E remove(int index) {
		check(index);
		E old = elements[index];
		
		for (int i = index + 1; i <= size - 1; i++) {
			elements[i - 1] = elements[i];
		}
		elements[--size] = null;
		return old;
	}
	
	public int indexOf(E element) {
		if(element == null) {
			for(int i = 0; i < size; i++) {
				if(elements[i] == null) return i;
			}
		}else {
			for(int i = 0; i < size; i++) {
				if(element.equals(elements[i])) return i;
			}
		}
		return ELEMENT_NOT_FOUND;
	}
	
	private void ensureCapacity(int capacity) {
		int oldCapacity = elements.length;
		if(oldCapacity >= capacity)return;
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		E[] newElements = (E[]) new Object[newCapacity];
		
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[i];
		}
		elements = newElements;
	}
	
	private void outOfBounds(int index) {
		throw new IndexOutOfBoundsException("Index:" + index + ",Size:" + size);
	}
	
	private void check(int index) {
		if(index < 0 || index >= size) {
			outOfBounds(index);
		}
	}
	
	private void checkForAdd(int index) {
		if(index < 0 || index > size) {
			outOfBounds(index);
		}
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("size=").append(size).append(", [");
		
		for(int i = 0; i < size; i++) {
			if(i != 0)string.append(", ");
			string.append(elements[i]);
		}
		string.append("]");
		return string.toString();
	}
}
