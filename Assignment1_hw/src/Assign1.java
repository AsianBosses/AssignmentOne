import javax.swing.JOptionPane;

public class PrintNumbers {
	public enum AccountType {
		Admin, Staff, Student
	};

	public static void main(String[] args) {
		String[] user = { "cqd2292", "name", "csc200" };
		String[] password = { "password", "pass", "not" };
		String[] acType = { "Admin", "Staff", "Student" };
		String[] TrueAccount = { "cqd2292passwordAdmin" };
		boolean found = false;

		AccountType[] account = { AccountType.Admin, AccountType.Staff, AccountType.Student };

		String euser = JOptionPane.showInputDialog("Enter Username");
		/*
		 * if (x.equals(user[0])) { } int y =0; int a = 0;
		 */
		// if(euser.equals(user[0]))
		String x = "", y = "", z = "", a = "";
		x.equals(user[0]);
		y.equals(password[0]);
		z.equals(acType[0]);
		a.equals(x + y + z);
		int i = 0;
		while (i <= 2) {
			if (euser.equals(user[i])) {
				found = true;
				// break;
			}

			// i++;

			if (found) {
				String epass = JOptionPane.showInputDialog("Enter Password");
				if (epass.equals(password[i])) {
					AccountType select = (AccountType) JOptionPane.showInputDialog(null, "Select account type",
							"Account Type", JOptionPane.INFORMATION_MESSAGE, null, account, account[0]);
					String b = "";
					b.equals(euser + epass + select);
					switch (select) {
					case Admin:
						JOptionPane.showMessageDialog(null, "Welcome Admin! You can update and read file.");
						break;
					case Staff:
						JOptionPane.showMessageDialog(null, "Welcome Staff! You can update, read, add, delete file.");
						break;
					case Student:
						JOptionPane.showMessageDialog(null, "Welcome Student! You can only read file.");
						break;
					default:
						break;
					}
					break;
				} else {

					JOptionPane.showMessageDialog(null, "Invalid Password");
					i++;
				}
			} else {

				JOptionPane.showMessageDialog(null, "Invalid Username");
				i++;
				euser = JOptionPane.showInputDialog("Enter Username");
			}
		}
		while (i >= 3) {
			JOptionPane.showMessageDialog(null, "Account is locked");
			break;
		}

	}
}
