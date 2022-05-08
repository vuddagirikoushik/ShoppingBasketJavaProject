package customer;

import java.util.Scanner;

import presentation.CustomerPresentation;
import presentation.CustomerPresentationImpl;

public class CustomerMain {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		CustomerPresentation presentation=new CustomerPresentationImpl();
		presentation.showMenu();
		System.out.println("Enter choice");
		presentation.perform(scanner.nextInt());

	}

}
