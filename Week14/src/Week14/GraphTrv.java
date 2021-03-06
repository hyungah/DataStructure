package Week14;

class StackNode{
   int data;
   StackNode link;
}

class LinkedStack{
   StackNode top;
   public boolean isEmpty() {
      return (top == null); //top가 null값인지 check
   }
   public void push(int item) {
      StackNode newNode = new StackNode();
      newNode.data = item;
      newNode.link = top;
      top = newNode;
   }
   
   public int pop() {
      if(isEmpty()) {
         System.out.println("삭제 실패! 링크스택이 비어있음");
         return 0;
   } else {
      int item = top.data;
      top = top.link;
      return item;
      }
   }
}


class QNode{
   int data;
   QNode link;
   
}

class LinkedQueue{
   QNode front, rear;
   public LinkedQueue() {
      front = rear = null;
   }
   
   public boolean isEmpty() {
      return (front == null);
   }
   
   public void enQueue(int item) {
      QNode newNode = new QNode();
      newNode.data = item;
      newNode.link = null;
      if(isEmpty())
         front = rear = newNode;
      else {
         rear.link = newNode;
         rear = newNode;
      }
   }
   public int deQueue() {
      if(isEmpty()) {
         System.out.println("삭제 실패! 링크스택이 비어있음 ");
         return 0;
      }else {
         int item = front.data;
         front = front.link;
         if(front == null)
            rear = null;
         return item;
      }
   }
}

class GraphNode{
   int vertex;
   GraphNode link;
}

class AdjList{
   private GraphNode[] head = new GraphNode[10];
   private int totalV = 0;
   public void insertVertex() {
      totalV++;
   }
   
   public void insertEdge(int v1, int v2) {
      if(v1 >= totalV || v2 >= totalV)
         System.out.println("그래프에 없는 정점입니다.");
      else {
         GraphNode gNode = new GraphNode();
         gNode.vertex = v2;
         gNode.link = head[v1];
         head[v1] = gNode;
      }
   }
   public void printAdjList() {
      GraphNode gNode = new GraphNode();
      for(int i=0; i<totalV; i++) {
         System.out.printf("|n정점 %c의 인접리스트: ", i+65);
         gNode = head[i];
         while(gNode != null) { //gNode가 null값이 아니면
            System.out.printf("=>%c", gNode.vertex + 65);
            gNode = gNode.link;
         }
      }
   }
   
   public void DFS(int v) {
      GraphNode w = new GraphNode();
      LinkedStack s = new LinkedStack();
      boolean visited[] = new boolean[10]; //visited 값 10개로 잡아주기
      
      s.push(v);
      visited[v] = true; //방문했다면 visited도 true값으로 만들기
      System.out.printf(" %c", v + 65); //방문한 것 출력하기
      
      while(s.top != null) {
         w = head[v];
         while (w != null) {
            if(visited [w.vertex]==false) { //visited가 홀수, 즉 방문하지 않았다면
               s.push(w.vertex);
               visited[w.vertex] = true;
               System.out.printf("%c", w.vertex+65);
               v = w.vertex;
               w = head[v];
            }
            else
               w=w.link;
         }
         v = s.pop();
      }
   }
   public void BFS(int v) {
      GraphNode w = new GraphNode();
      LinkedQueue q = new LinkedQueue();
      boolean[] visited = new boolean[10];
      visited[v]=true;
      System.out.printf("%c", v+65);
      q.enQueue(v);
      while(!q.isEmpty()) {
         v = q.deQueue();
         for( w = head[v]; w != null; w = w.link) {
            if(visited[w.vertex] == false) { //홀수하면? 즉,방문하지 않았다면
               visited[w.vertex] = true;
               System.out.printf("%c", w.vertex+65);
               q.enQueue(w.vertex);
            }
         }
      }
   }
}

public class GraphTrv {
   public static void main(String args[]) {
      AdjList g9 = new AdjList();
      for(int i=0; i<7; i++) {
         g9.insertVertex();
      g9.insertEdge(0,2);
      g9.insertEdge(0,1);
      g9.insertEdge(1,4);
      g9.insertEdge(1,3);
      g9.insertEdge(2,4);
      g9.insertEdge(2,0);
      g9.insertEdge(3,6);
      g9.insertEdge(3,1);
      g9.insertEdge(4,6);
      g9.insertEdge(4,2);
      g9.insertEdge(4,1);
      g9.insertEdge(5,6);
      
      g9.insertEdge(6,5);
      g9.insertEdge(6,4);
      g9.insertEdge(6,3);
      System.out.printf("|n 그래프 g9의 인접 리스트: ");
      g9.printAdjList();
      System.out.println();
      
      System.out.printf("깊이 우선 탐색 ");
      g9.DFS(0);
      
      System.out.println("|n|n 너비 우선 탐색");
      g9.DFS(0);
      }
   }
}