
public class LinkedStack<E> implements StackInterface<E> {
	private Node<E> topNode;
	private final E ERROR = null;   // �엫�쓽�쓽 �뿉�윭 媛�
	public LinkedStack() {
		topNode = null;
	}
	
	// [�븣怨좊━利� 6-7] 援ы쁽: �뒪�깮�뿉 �썝�냼 x �궫�엯�븯湲�
	public void push(E newItem) {
		topNode = new Node<>(newItem, topNode);
	}
	
	// [�븣怨좊━利� 6-8] 援ы쁽: �뒪�깮�뿉�꽌 �썝�냼 �궘�젣�븯湲�
	public E pop() {
		if (isEmpty( )) return ERROR;
		else {
			Node<E> temp = topNode;
			topNode = topNode.next;
			return temp.item;
		}
	}
	
	// [�븣怨좊━利� 6-9] 援ы쁽: �뒪�깮 �깙 �썝�냼 �븣�젮二쇨린
	public E top() {
		if (isEmpty()) return ERROR; 
		else return topNode.item;
	}
	
	// [�븣怨좊━利� 6-10] 援ы쁽: �뒪�깮�씠 鍮꾩뿀�뒗吏� �솗�씤�븯湲�
	public boolean isEmpty() {
		return (topNode == null);
	}
	
	// [�븣怨좊━利� 6-11] 援ы쁽: �뒪�깮 鍮꾩슦湲�
	public void popAll() {
		topNode = null;
	}

	//////////////////////////////////////////////
	public void printAll() {
		Node<E> t;
		System.out.print("Stack from top: ");
		for(t=topNode; t != null; t = t.next) {
			System.out.print(t.item + " ");
		}
		System.out.println();
	}
} // 肄붾뱶 6-4
