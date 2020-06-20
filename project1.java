
public class DynamicNavStack<E> {
	private E[] navStack;
	private int undoI; // top element position in undo
	private int redoI; // top element position in redo
	private int initialCapacity;
	private int capacity;
	private static final int DEFAULT_CAPACITY = 2;

	// CONSTRUCTOR1
	// input: initial array capacity
	DynamicNavStack(int c) {

		// if capacity = 0 or negative: capacity = default
		if (c <= 0) {

			capacity = DEFAULT_CAPACITY;

		} else {

			capacity = c;
		}

		// initialize array with c capacity
		@SuppressWarnings("unchecked")
		E[] navStack = (E[]) new Object[capacity];
	}

	// CONSTRUCTOR2
	// when initial capacity = default
	DynamicNavStack() {
		if (initialCapacity == 2) {
			capacity = this.DEFAULT_CAPACITY;
		}
	}

	// NUMBER OF ELEMENTS IN ARRAY
	public int size() {
		// returns number of elements in undo and redo stacks
		// add undo and redo together?
		int size = undoI + redoI;
		return size;
		// RETURN TOP values?
	}

	// TOP ELEMENT UNDO
	public E undoTop() {
		// return top element of undo
		undoI = navStack[capacity()]
		if (undoI == 0) {
			return null;
		} else {
			return undoI;
		}
	}

	// TOP ELEMENT REDO
	public E redoTop() {
		// return top element of redo stack
		redo = 
		if (redoI == 0) {
			return null;
		} else {
			return navStack[redoI + 1]; // or + 1?
		}
	}

	// CURRENT CAPACITY OF ARRAY
	public int capacity() {
		// return current capacity of array
		capacity = navStack.length;
		return capacity;
	}

	// EMPTY STACKS?
	public boolean isEmpty() {
		// if no elements in both stacks
		// return true
		if (undoI == 0 && redoI == 0) {
			return true;
		} else {
			return false;
		}
	}

	// EMPTY UNDO?
	public boolean canUndo() {
		// if undo is not empty return true, otherwise false
		if (isEmpty() == false) {
			return true;
		} else {
			return false;
		}
	}

	// EMPTY REDO?
	public boolean canRedo() {
		// if redo is not empty return true, otherwise false
		if (isEmpty() == false) {
			return true;
		} else {
			return false;
		}
	}

	// PUSH
	public void push(E e) {
		// input: element e
		// push e on top of undo stack
		if (size() == capacity()) {
			capacity = 2 * capacity;
			
			@SuppressWarnings("unchecked")
			E[] newNavStack = (E[]) new Object[capacity];
			
			for(int i = 0; i < capacity; i++) {
				newNavStack[i] = this.navStack[i];
			}
			
			this.navStack = newNavStack;
		}
		navStack[undoI++] = e;
		// empty redo stack
		redoI = 0;
		// grow or shrink array according to rules
	}
	 public E undo() {  
		  	//if undo stack is not empty, pop top element
			if (canUndo() == true){
		  		E e = navStack[undoI];
		  		push(e);
		  		return e;
		  	} 
		  	else {
		  		return null;
		  	}
	}
	 public E redo() {  
		  	//if redo is not empty
		  	if (canRedo() == true){
		  		//pop top element off redo stack
		  		E e = navStack[redoI];
		  		push(e);
		  		return e;
		  	}
		  	else{
		  		return null;
		  	}
		  }
	}