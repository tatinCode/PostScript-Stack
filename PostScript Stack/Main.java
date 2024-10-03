
//This program  reads a series of commands, processes them using the stack, and displays 
//as well as more complex operations like exchanging, duplicating, and copying elements
///the final state of the stack. The commands can include basic stack operations like 
//pushing and popping elements, 
import java.util.Scanner; // Import the Scanner class

public class Main {

	public static void main(String[] args) {
		PSStack a = makeStack(); // Create a stack and process commands
		a.displayStack(); // Display the final state of the stack
	}

	public static PSStack makeStack() {
		PSStack temp = new PSStack(); // Create a temporary stack
		Scanner input = new Scanner(System.in); // Create a Scanner object for input
		String s = input.nextLine(); // Read a line of input
		String[] array = s.split(" "); // Split the input into commands
		for (String command : array) {
			temp.evaluate(command); // Evaluate each command
		}
		input.close(); // Close the Scanner
		return temp; // Return the processed stack
	}
}

class StackNode {

	public String data; // Data stored in the node
	public StackNode next; // Reference to the next node

	public StackNode(String s) {
		data = s; // Initialize data
		next = null; // Initialize next as null
	}

	StackNode() {
	}
}

class Stack {

	public StackNode top; // Top of the stack
	public int size; // Size of the stack

	public Stack() {
		top = null; // Initialize top as null
	}

	public void push(String command) {
		StackNode temp = null;
		if (top == null) {
			top = new StackNode(command); // Create a new node if stack is empty
		} else {
			temp = top; // Save the current top
			top = new StackNode(command); // Create a new node
			top.next = temp; // Link the new node to the previous top
		}
		++size; // Increment the size
	}

	public StackNode pop() {
		if (isEmpty()) {
			System.out.println("Not enough items on the stack to perform this operation.");
			return null; // Return null if stack is empty
		} else {
			StackNode temp = top; // Save the current top
			top = top.next; // Move the top to the next node
			--size; // Decrement the size
			return temp; // Return the popped node
		}
	}

	public String peek() {
		StackNode temp = top;

		if (isEmpty()) {
			System.out.println("Not enough items on the stack to perform this operation.");
			return null; // Return null if stack is empty
		}

		return temp.data; // Return the data of the top node
	}

	public boolean isEmpty() {
		if (size < 1) {
			return true; // Return true if stack is empty
		}
		return false; // Return false otherwise
	}
}

class PSStack extends Stack {

	public void displayStack() {
		System.out.print("-> ");
		if (size < 1) {
			System.out.println("<empty>"); // Display empty if stack is empty
		} else {
			StackNode temp = top;
			while (temp != null) {
				System.out.print(temp.data + " "); // Display each element in the stack
				temp = temp.next;
			}
		}
		System.out.println();
	}

	public void exch() {
		if (peek() == null) {
			return; // Return if stack is empty
		}
		String first = pop().data; // Pop the top element

		if (peek() == null) {
			return; // Return if stack is empty
		}
		String second = pop().data; // Pop the second element

		push(first); // Push the first element
		push(second); // Push the second element
	}

	public void dup() {
		if (isEmpty()) {
			System.out.println("Not enough items on the stack to perform this operation.");
			return; // Return if stack is empty
		}
		String duplicate = pop().data; // Pop the top element
		push(duplicate); // Push the duplicate element
		push(duplicate); // Push the duplicate element again
	}

	public void clear() {
		while (size > 0) {
			pop(); // Pop all elements to clear the stack
		}
	}

	public void count() {
		push(Integer.toString(size)); // Push the size of the stack
	}

	public void index() {
		int n = Integer.parseInt(pop().data); // Pop the index

		if (size < n) {
			clear(); // Clear the stack if not enough elements
			System.out.println("Not enough items on the stack to perform this operation.");
			return;
		}

		StackNode curr = top;
		for (int i = 0; i < n - 1; i++) {
			curr = curr.next; // Traverse to the nth element
		}
		push(curr.data); // Push the nth element
	}

	public void copy() {
		int n = Integer.parseInt(pop().data); // Pop the number of elements to copy

		if (size < n) {
			clear(); // Clear the stack if not enough elements
			System.out.println("Not enough items on the stack to perform this operation.");
			return;
		}

		StackNode curr = top;
		for (int i = 0; i < n; i++) {
			push(curr.data); // Push each element to copy
			curr = curr.next;
		}
	}

	public void evaluate(String command) {
		if (command.equalsIgnoreCase("pop"))
			pop(); // Evaluate pop command
		else if (command.equalsIgnoreCase("dup"))
			dup(); // Evaluate dup command
		else if (command.equalsIgnoreCase("exch"))
			exch(); // Evaluate exch command
		else if (command.equalsIgnoreCase("clear"))
			clear(); // Evaluate clear command
		else if (command.equalsIgnoreCase("index"))
			index(); // Evaluate index command
		else if (command.equalsIgnoreCase("copy"))
			copy(); // Evaluate copy command
		else if (command.equalsIgnoreCase("count"))
			count(); // Evaluate count command
		else if (command.matches("-?(0|[1-9]\\d*)"))
			push(command); // Evaluate push command for numbers
	}
}
