package presentation;

import java.util.Optional;
import java.util.Scanner;

import entity.Customer;
import service.CustomerService;
import service.CustomerServiceImpl;
import service.ProductService;
import service.ProductServiceImpl;

public class CustomerPresentationImpl implements CustomerPresentation {
	Scanner scanner=new Scanner(System.in);
	CustomerService customerService=new CustomerServiceImpl();
	ProductService productService=new ProductServiceImpl();

	@Override
	public void showMenu() {
		System.out.println("1.Log in with customer details");
		System.out.println("2.Create a new account");
		System.out.println("3.Exit");

	}

	@Override
	public void showBooks() {
		System.out.println("1.Harry potter");

	}

	@Override
	public void showCd() {
		System.out.println("1.Avatar");

	}

	@Override
	public void showCosmetics() {
		System.out.println("1.Body lotion");

	}

	@Override
	public void perform(int choice) {
		switch(choice) {
		case 1:
			System.out.println("Enter customer id");
			int id=scanner.nextInt();
			System.out.println("Enter password");
			String pass=scanner.next();
			Optional<Customer> customer=customerService.checkCustomer(id);
			if(customer.isEmpty()) {
				System.out.println("Id doesnt exist");
				perform(1);
			}
			if(customer.get().getPassword().equals(pass)) {
				System.out.println("Hello "+customer.get().getCustomerName()+",");
				productPerform();	
			}else {
				System.out.println("Incorrect password or username");
				showMenu();
				System.out.println("Enter choice");
				perform(scanner.nextInt());
		}
			break;
		case 2:
			System.out.println("Enter customer id");
			int cId=scanner.nextInt();
			System.out.println("Enter name");
			String name=scanner.next();
			System.out.println("Enter address");
			String address=scanner.next();
			System.out.println("Enter phone number");
			String phone=scanner.next();
			System.out.println("Enter password");
			String password=scanner.next();
			Customer newCustomer=new Customer(cId, name, address, phone, password);
			if(customerService.createCustomer(newCustomer)) {
				System.out.println("Account created successfully!");
				perform(1);
			}
			else {
				System.out.println("User id already exists,choose a new one");
				perform(2);
			}
			break;
		case 3:
			System.exit(0);
			break;
		default:
			System.out.println("Invalid choice");
			break;
		}

	}

	@Override
	public void productMenu() {
		System.out.println("1.Books");
		System.out.println("2.Cd");
		System.out.println("3.Cosmetics");
		System.out.println("4.check out");
	}

	@Override
	public void productPerform() {
		String bill="";
		String current="";
		while(true) {
			productMenu();
			System.out.println("Select category");
			int cat=scanner.nextInt();
			switch(cat) {
			case 1:
				showBooks();
				System.out.println("select choice");
				int catChoice=scanner.nextInt();
				System.out.println("Enter no of items");
				int quantity=scanner.nextInt();
				if(catChoice>1) {
					System.out.println("Invalid choice");
					continue;
				}
				current=productService.eachTransaction(cat, catChoice, quantity);
				if(current== null)
					continue;
				bill+=current;
				break;
			case 2:
				showCd();
				System.out.println("select choice");
				catChoice=scanner.nextInt();
				System.out.println("Enter no of items");
				quantity=scanner.nextInt();
				if(catChoice>1) {
					System.out.println("Invalid choice");
					continue;
				}
				current=productService.eachTransaction(cat, catChoice, quantity);
				if(current== null)
					continue;
				bill+=current;
				break;
			case 3:
				showCosmetics();
				System.out.println("select choice");
				catChoice=scanner.nextInt();
				if(catChoice>1) {
					System.out.println("Invalid choice");
					continue;
				}
				System.out.println("Enter no of items");
				quantity=scanner.nextInt();
				current=productService.eachTransaction(cat, catChoice, quantity);
				if(current== null)
					continue;
				bill+=current;
				break;
			case 4:
				if(bill.isEmpty()) {
					System.out.println("Your cart is empty");
					continue;
				}
				System.out.println(bill);
				System.out.println("Total cost:"+productService.getTotalCost());
				System.out.println("Thanks for shopping with us!");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}
			
		}
		
	}

}
