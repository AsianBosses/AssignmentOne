import javax.swing.JOptionPane;

/*
 *Part 1- USERNAME and PASSWORD authentication.
Develop an authentication module using JAVA. Use JOptionPanes to prompt the user to enter username and password. 
For the first JOptionPane (USER NAME), the application will evaluate if the user name is correct 
after the user click OK. 
If the user name is correct then the second JOptionPane (PASSWORD) will be prompted, 
otherwise the application will prompt the user to enter the user name again. 

For the password authentication, 
if the user enter the password wrong, the program will prompt the user to enter the password again, 
otherwise the program will return a welcome USERNAME using JOptionPane. 

There is a limit for 3 trials (for both USERNAME and PASSWORD all together). 


The account will be locked, if the attempts are over the limit and the application will return “Contact Administrator” message. 
If the username does not exist in the system, the application will return “Invalid Username” message.

 * Part 2-VALIDATE User account type
After part 1 is complete, we want to expand the application to check for user account using switch case. 
The application will prompt the user with drop down list to pick type of account. 
The application will validate username and password as usual. 
If the username and password are correct based on the user account type, then an appropriate message will be returned 
as indicated below. 

Admin: Welcome Admin! You can update and read file.
Student: Welcome Student! You can only read file.
Staff: Welcome Staff! You can update, read, add, delete file.

If the user select the wrong account type, the application will prompt the user to select the account again 
until the user select the right account type.

Resource:
Import javax.swing.JOptionPane;
String[] choices = { "Admin", "Student", "Staff"};
String input = (String) JOptionPane.showInputDialog(null, "Choose account type...",
"Account Type",JOptionPane.QUESTION_MESSAGE, null,choices,choices[1]); 
System.out.println(input);

 */
public class PrintNumbers {
	public enum AccountType {
		Admin, Staff, Student
	};

	public static void main(String[] args) {
		String[] userNames = { "admin", "staff", "student" };
		String[] passwords = { "admin1", "staff1", "student1" };
		AccountType[] account = { AccountType.Admin, AccountType.Staff, AccountType.Student };

		boolean foundUsername = false;
		boolean foundPassword = false;

		String userStr = JOptionPane.showInputDialog("Enter Username");

		int limit = 1;
		int i = 0;

		while (limit < 3) {
			while (i < 3) {
				if (userStr.equals(userNames[i])) {
					foundUsername = true;
					break;
				}
				i++;
			}

			if (foundUsername) {
				String passStr = JOptionPane.showInputDialog("Enter Password");
				while (i < 3) {
					limit = 0;
					if (passStr.equals(passwords[i])) {
						foundPassword = true;
						break;
					}
					i++;
				}
				if (foundPassword) {
					JOptionPane.showMessageDialog(null, "Welcome " + userNames[i]);
					AccountType input = (AccountType)JOptionPane.showInputDialog(
							null, "Select account type", "Account Type", 
							JOptionPane.INFORMATION_MESSAGE, null, account, account[0]);
					switch (input) {
						case Admin:
							JOptionPane.showMessageDialog(null, "Welcome Admin! You can update and read file.");
							System.exit(0);
							// break;
						case Staff:
							JOptionPane.showMessageDialog(null, "Welcome Staff! You can update, read, add, delete file.");
							System.exit(0);
							// break;
						case Student:
							JOptionPane.showMessageDialog(null, "Welcome Student! You can only read file.");
							System.exit(0);
							// break;
						default:
							break;
					}
				} else {
					JOptionPane.showMessageDialog(null, "Invalid Password");
					limit++;
				}
			} else {
				JOptionPane.showMessageDialog(null, "Invalid Username");
				userStr = JOptionPane.showInputDialog("Enter Username");
				limit++;
			}

		}
		JOptionPane.showMessageDialog(null, "Account is locked. Please contact administrator.");
	}

}




