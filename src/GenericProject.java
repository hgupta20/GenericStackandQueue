
// The project is about creating a generic class and implement stack and queue.
// In this simplified version, each data structure is a singly linked list. The stack is LIFO
// (last in first out) while the queue is FIFO (first in first out). Your implementation must be
//  generic as to allow for different types when each data structure object is instantiated.

public class GenericProject {
    public static void main(String[] args){
        System.out.println("Stack:");
        GenericStack<Integer> stack = new GenericStack(100);
        // check empty stack behaviour;
        /*stack.pop();
        stack.pop();
        stack.print();*/
        // push and pop the stack
        stack.push(200);        //push
        stack.push(300);
        stack.print();
        System.out.println("Length: " + stack.getLength());
        stack.pop();                  //pop
        stack.print();
        System.out.println("Length: " + stack.getLength());
        stack.push(400);
        stack.print();
        System.out.println("Length: " + stack.getLength());
        stack.pop();
        stack.print();
        System.out.println("Length: " + stack.getLength());
        stack.print(); //example stack
        System.out.println("Length: " + stack.getLength());


        System.out.println();
        System.out.println("Queue:");
        GenericQueue<Integer> queue = new GenericQueue(100);
        // check empty queue behaviour;
        /*queue.dequeue();
        queue.dequeue();
        queue.print();*/

        // enqueue and dequeue the queue
        queue.print();
        System.out.println("Length: " + queue.getLength());
        queue.enqueue(200);      //enqueue
        queue.print();
        System.out.println("Length: " + queue.getLength());
        queue.enqueue(300);
        queue.print();
        System.out.println("Length: " + queue.getLength());
        queue.dequeue();                // dequeue
        queue.print();
        System.out.println("Length: " + queue.getLength());
        queue.enqueue(400);
        queue.print();
        System.out.println("Length: " + queue.getLength());

    }

}

abstract class GenericList<I>{ //abstract implementation of the Generic List Class
    Node<I> head;               // data member head
    private int length;         // private data member length

    public void print(){
        if (head == null){      // check if the list is empty otherwise traverse and print
            System.out.println("The List is Empty.");
            return;
        }
        Node<I> currentNode = head;
        System.out.print("List: ");
        while( currentNode!= null ){
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        return;

    }
    public abstract void add(I data);       // abstract implementation for add method later overridden

    public I delete(){                      // delete method
        if (head == null){                  // to check if the list is empty
            System.out.println("The List is Empty.");
            return null;
        }
        Node<I> currentHead = head;
        I currentData = head.data;

        head = head.next;
        length--;                           // decrement the length
        return currentData;
    }
    public int getLength(){                 // getLength method
        return length;
    }
    public void incLength(){                // method to increase the length since it is private
        length++;
        return;
    }
    public void decLength(){                // method to decrease the length since it is private
        length--;
        return;
    }

    public class Node<T>{                   // Node class inside the generic list class
        public T data;
        public Node<T> next;

        public Node (T data) {              // constructors
            this.data= data;
            this.next = null;
        }
        public Node (T data, Node next) {    // constructors
            this.data= data;
            this.next = next;
        }
        public void setData(T input){       // setter and getter functions
            data = input;
        }

        public T getData(){
            return data;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getNext() {
            return next;
        }

    }
}
class GenericQueue<I> extends GenericList<I>{           // queue implementation extending generic list

    public GenericQueue (I data){                       // constructor
        Node newHead = new Node(data, null);
        head = newHead;
        incLength();
    }

    public void add(I data){ // Implementing the add according to the behaviour of queue- FIFO
        Node<I> addNode = new Node(data);
        if (head == null){
            addNode.next = null;
            head = addNode;
            //addNode.next = null;
            incLength();
            return;
        }
        Node currentNode = head;
        while (currentNode.next != null){
            currentNode = currentNode.next;
        }
        // insert the new node at the last
        currentNode.next = addNode;
        incLength();
        return;
        /*else{
            Node currentNode = head;
            while (currentNode.next != null){
                currentNode = currentNode.next;
            }
            // insert the new node at the last
            currentNode.next = addNode;
        }
        //length++;
        */

    }
    public I dequeue(){         // using delete to dequeue
        return delete();
    }
    public void enqueue(I data){        // using add to enqueue
        add(data);
        return;

    }

}
class GenericStack<I> extends GenericList<I>{       // stack implementation extending generic list

    public GenericStack (I data){               // constructor
        Node newHead = new Node(data,null);
        head = newHead;
        incLength();
    }

    public void add(I data){ // Stack implementation using LIFO
        Node<I> addNode = new Node(data, head);
        head = addNode;
        incLength();
        return;
        /*if(head == null){
            head = addNode;
        }
        else{
            head = addNode;
            incLength();
        }*/
    }
    public void push(I data){       // using add to push
        add(data);
        return;
    }
    public I pop(){                 // using delete to pop
        return delete();
    }
}