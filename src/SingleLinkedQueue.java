public class SingleLinkedQueue<T> implements QueueI<T> {
	private Node<T> firstNode;
	private Node<T> lastNode;

	public SingleLinkedQueue() {
		firstNode = null; // references node at front of queue
		lastNode = null; // references node at back of queue

	}

	@Override
	public void enqueue(T newEntry) {

		Node<T> newNode = new Node(newEntry, null);
		if (isEmpty()) {
			firstNode = newNode;
		} else {
			lastNode.next = newNode;
		}
		lastNode = newNode;
	}

	@Override
	public T dequeue() {

		T front = null;

		if (!isEmpty()) {
			front = firstNode.data;
			firstNode = firstNode.next;
			if (firstNode == null)
				lastNode = null;
		}
		return front;
	}

	@Override
	public T getFront() {

		T front = null;

		if (!isEmpty())
			front = firstNode.data;
		return front;
	}

	@Override
	public boolean isEmpty() {
		return (firstNode == null) && (lastNode == null);
	}

	@Override
	public void clear() {
		firstNode = null;
		lastNode = null;
	}

	// if not static - the inner class can use the instance fields from the
	// outer class and the T
	private static class Node<T> {

		// all fields are visible to the outer class
		private T data; // entry in bag
		private Node<T> next; // link to next node

		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}

	} // end Node<T> class
}
