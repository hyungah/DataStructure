public class ArrayStack<E> implements StackInterface<E> {	
	private E stack[];
	private int topIndex;              // �뒪�깮�쓽 �깙 �씤�뜳�뒪
	private static final int DEFAULT_CAPACITY = 64;
	private final E ERROR = null;     // �엫�쓽�쓽 �뿉�윭 媛� 
 
	public ArrayStack() {	// �깮�꽦�옄 1
		stack = (E[]) new Object[DEFAULT_CAPACITY];
		topIndex = -1;
	}

	public ArrayStack(int n) {	// �깮�꽦�옄 2
		stack = (E[]) new Object[n];
		topIndex = -1;
	}
	
	// [�븣怨좊━利� 6-1] 援ы쁽: �뒪�깮�뿉 �썝�냼 x �궫�엯�븯湲�
	public void push(E newItem) {
		if (isFull()) { /* �뿉�윭 泥섎━ */ }
		else stack[++topIndex] = newItem;
	}
	
	// [�븣怨좊━利� 6-2] 援ы쁽: �뒪�깮�뿉�꽌 �썝�냼 �궘�젣�븯湲�
	public E pop() {
		if (isEmpty()) return ERROR;
		else return stack[topIndex--];
	}
	
	// [�븣怨좊━利� 6-3] 援ы쁽: �뒪�깮 �깙 �썝�냼 �븣�젮二쇨린
	public E top() {
		if (isEmpty()) return ERROR;
		else return stack[topIndex];
	}
	
	// [�븣怨좊━利� 6-4] 援ы쁽: �뒪�깮�씠 苑� 李쇰뒗吏� �솗�씤�븯湲�
	public boolean isEmpty() {
		return (topIndex < 0);
	}
	
	// [�븣怨좊━利� 6-5] 援ы쁽: �뒪�깮�씠 鍮꾩뿀�뒗吏� �솗�씤�븯湲�
	public boolean isFull() {
		return (topIndex == stack.length-1);
	}
 
	// [�븣怨좊━利� 6-6] 援ы쁽: �뒪�깮 鍮꾩슦湲�
	public void popAll( ) {
		stack = (E[]) new Object[stack.length];
		topIndex = -1;
	}

	////////////////////////////////////////////
	public void printAll() {
		System.out.print("Stack from top:");
		for(int i=topIndex; i>=0; i--) {
			System.out.print(stack[i] + " ");
		}
		System.out.println();
	}

	public int getTopIndex() {
		return topIndex;
	}
} // 肄붾뱶 6-2
