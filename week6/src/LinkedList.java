
public class LinkedList<E> implements ListInterface<E> {
	private Node<E> head;
	private int numItems;

	public LinkedList() { 			// �깮�꽦�옄
		numItems = 0;
		head = new Node<>(null, null); 	// �뜑誘� �뿤�뱶
	}

	// [�븣怨좊━利� 5-10] 援ы쁽: �뿰寃� 由ъ뒪�듃�뿉 �썝�냼 x �궫�엯�븯湲�
	public void add(int index, E item) {
		if (index >= 0 && index <= numItems) {
			Node<E> prevNode = getNode(index - 1);
			Node<E> newNode = new Node<>(item, prevNode.next);
			prevNode.next = newNode;
			numItems++;
		}
	}
 
	public void append(E item) {
		Node<E> prevNode = head;  		// �뜑誘� �끂�뱶
		while (prevNode.next != null) {
			prevNode = prevNode.next;
		}
		Node<E> newNode = new Node<>(item, null);
		prevNode.next = newNode;
		numItems++;
	}

	// [�븣怨좊━利� 5-12] 援ы쁽: 由ъ뒪�듃�쓽 �썝�냼 �궘�젣�븯湲�
	public E remove(int index) {
		if (index >= 0 && index < numItems) {
			Node<E> prevNode = getNode(index - 1);
			Node<E> currNode = prevNode.next;
			prevNode.next = currNode.next;
			numItems--;
			return currNode.item;
		} else
			return null;
	}

	public boolean removeItem(E x) {
		Node<E> currNode = head;  	// �뜑誘� �뿤�뱶
		Node<E> prevNode;
		for (int i = 0; i < numItems; i++) {
			prevNode = currNode;
			currNode = currNode.next;
			if (((Comparable)(currNode.item)).compareTo(x) == 0) {
				prevNode.next = currNode.next;
				numItems--;
				return true;
			}
		}
		return false; 			// not found
	}

	// [�븣怨좊━利� 5-13] 援ы쁽: �뿰寃� 由ъ뒪�듃�쓽 k踰덉㎏ �썝�냼 �븣�젮二쇨린
	public E get(int index) {
		if (index >= 0 && index <= numItems - 1) {
			return getNode(index).item;
		} else
			return null; 		// �뿉�윭
	}
 
		public Node<E> getNode(int index) {
		if (index >= -1 && index <= numItems - 1) {
			Node<E> currNode = head;  	// �뜑誘� �끂�뱶
			for (int i = 0; i <= index; i++) {
				currNode = currNode.next;
			}
			return currNode;
		} else {
			return null;
		}
	}

	// [�븣怨좊━利� 5-14] 援ы쁽:�뿰寃� 由ъ뒪�듃�쓽 k踰덉㎏ �썝�냼瑜� x濡� ��泥댄븯湲�
	public void set(int index, E x) {
		if (index >= 0 && index <= numItems - 1) {
			getNode(index).item = x;
		} else { /* �뿉�윭 泥섎━ */ }
	}

	// [�븣怨좊━利� 5-15] 援ы쁽: �썝�냼 x媛� �뿰寃� 由ъ뒪�듃�쓽 紐� 踰덉㎏ �썝�냼�씤吏� �븣�젮二쇨린
	public final int NOT_FOUND = -12345;
	public int indexOf(E x) {
		Node<E> currNode = head;   // �뜑誘� �끂�뱶
		int i;
		for (i = 0; i < numItems; i++) {
			currNode = currNode.next;
			if (((Comparable)(currNode.item)).compareTo(x) == 0)
				return i;
		}
		return NOT_FOUND; 	// not found
	}
	
	// [�븣怨좊━利� 5-16(1)] 援ы쁽: 由ъ뒪�듃�쓽 珥� �썝�냼 �닔 �븣�젮二쇨린
	public int len() {
		return numItems;
	}
	
	// [�븣怨좊━利� 5-16(2)] 援ы쁽: 由ъ뒪�듃媛� 鍮꾩뿀�뒗吏� �븣�젮二쇨린
	public boolean isEmpty() {
		return numItems == 0;
	}

	// [�븣怨좊━利� 5-16(3)] 援ы쁽: 由ъ뒪�듃 源⑤걮�씠 泥��냼�븯湲�
	public void clear() {
		numItems = 0;
		head = new Node<>(null, null);
	}
	
	///////////////////////////////////////////////////////////////////////
	public void printAll() {
		Node<E> t;
		System.out.print("Print list (#items=" + numItems + ") ");
		for(t=head.next; t != null; t = t.next) {
			System.out.print(t.item + " ");
		}
		System.out.println();
	}
} // 肄붾뱶 5-9
