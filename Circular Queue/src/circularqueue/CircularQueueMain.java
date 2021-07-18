package circularqueue;

import java.util.Scanner;

public class CircularQueueMain {

	static int front = 0;// always pointing to the 1st element inserted.
	static int rear = 0;// always pointing to the 'index' where element(next) to be inserted .
	static int counter = 0;// at enqueue +1 , and dequeue -1.
	Scanner sc = new Scanner(System.in);

	public boolean underflow() {
		if (counter == 0) {//this means rear and front pointing to the same place , and though counter is zero (net) = its empty.
			return true;
		} else
			return false;
	}

	public boolean overflow(int queue[], int Max) {
		if (rear == front && counter != 0) {//rear and front same - pointing and here counter is not equal to 0= net sum is not empty, rather full
			return true;
		} else
			return false;
	}

	public void enqueue(int queue[], int Max) {
		boolean x = overflow(queue, Max);
		System.out.println("Enter Info");
		int element = sc.nextInt();
		if (x == true) {

			System.out.println("OVERFLOW : Queue is full.");
		} else {

			queue[rear] = element;
			rear = (rear + 1) % Max;// "%max" only affects when the rear reaches the maximum size or last element
			counter++;   			// and directing it to the zero'th index.

		}

	}

	public void dequeue(int queue[], int Max) {
		boolean u = underflow();
		if (u == true) {
			return;
		} else {
			queue[front] = 0;
			front = (front + 1) % Max;// "%max" only affects when the front reaches the maximum size or last element
										// and directing it to the zero'th index.
			counter--;

		}

	}

	public void display(int queue[], int size) {
		if (front == rear && counter == 0) {// rear has not crossed max size.
			System.out.println("Underflow : queue is empty");
			return;
		} else {
			System.out.println("ELEMENTS ARE :");

			int i = 0;
			do {
				System.out.println(i + ". " + queue[i]);
				i++;
			} while (i < size);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CircularQueueMain obj = new CircularQueueMain();
		System.out.println("Enter the size of the queue : ");
		int size = sc.nextInt();
		int queue[] = new int[size];
		int Max = queue.length;
		obj.overflow(queue, Max);

		int p = 1;
		do {
			System.out.println("MENU >>>>>>>>>");
			System.out.println("1.enqueue:");
			System.out.println("2.dequeue");
			System.out.println("3.Display :");

			int q = sc.nextInt();
			switch (q) {
			case 1:// enqueue
				obj.enqueue(queue, Max);
				break;
			case 2:// dequeue
				obj.dequeue(queue, Max);
				break;
			case 3://displaying the elements.
				obj.display(queue, Max);
				break;
			default:
				System.out.println("Please choose from the menu .(wrong input)");
				break;
			}

			System.out.println("IF YOU WANT TO END PRESS '0' . ELSE PRESS ANY NUMBER .");
			p = sc.nextInt();
		} while (p != 0);
		System.out.println(" THE PROGRAM HAS BEEN ELIMINATED .");
		sc.close();

	}

}
