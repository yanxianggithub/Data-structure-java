package single_list;

public class SingleList<E> {
	private Node<E> first;

	private static class Node<E> {
		E element;
		Node<E> next;
		public Node(E element,Node<E> next){
			this.element = element;
			this.next = next;
		}
	}

	/**
	 * 清除所有元素
	 */
	public void clear() {
		size = 0;
		first = null;
	}

	/**
	 * 获取index位置的元素
	 * @param index
	 * @return
	 */
	public E get(int index) {

		return node(index).element;
	}

	/**
	 * 设置index位置的元素
	 * @param index
	 * @param element
	 * @return 原来的元素ֵ
	 */
	public E set(int index,E element) {
		Node<E> node = node(index);
		E old = node.element;
		node.element = element;
		return old;
	}

	/**
	 * 在index位置插入一个元素
	 * @param index
	 * @param element
	 */
	public void add(int index,E element) {
		checkForAdd(index);

		if(index == 0){
			first = new Node<>(element,first);
		}else{
			Node<E> prev = node(index - 1);
			prev.next = new Node<>(element,prev.next);
		}
		size++;
	}

	/**
	 * 删除index位置的元素
	 * @param index
	 * @return
	 */
	public E remove(int index) {
		check(index);

		Node<E> node = first;
		if(index == 0){
			first = first.next;
		}else{
			Node<E> prev = node(index - 1);
			node = prev.next;
			prev.next = node.next;
		}
		size--;
		return node.element;
	}

	/**
	 * 查看元素的索引
	 * @param element
	 * @return
	 */
	public int indexOf(E element) {
		if(element == null) {
			Node<E> mode = first;
			for(int i = 0; i < size; i++) {
				if(node.element == null) return i;
				node = node.next;
			}
		}else {
			Node<E> mode = first;
			for(int i = 0; i < size; i++) {
				if(element.equals(node.element)) return i;
				node = node.next;
			}
		}
		return ELEMENT_NOT_FOUND;
	}

	/**
	 * 获取index位置对应的节点对象
	 * @param index
	 * @return
	 */
	private Node<E> node(int index){
		check(index);

		Node<E> node = first;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		retrun node;
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
		Node<E> node = first;
		for (int i = 0; i < size; i++) {
			if (i != 0) {
				string.append(", ");
			}

			string.append(node.element);

			node = node.next;
		}
		string.append("]");

//		Node<E> node1 = first;
//		while (node1 != null) {
//
//
//			node1 = node1.next;
//		}
		return string.toString();
	}

}

