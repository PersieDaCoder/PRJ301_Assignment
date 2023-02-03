

import java.util.Scanner;
import DAO.AccountDAO;
import java.util.ArrayList;

public class Test {

    static void showAccount() throws Exception {
        ArrayList accountList = AccountDAO.getAccounts();
        if (!accountList.isEmpty()) {
            for (int i = 0; i < accountList.size(); i++) {
                System.out.println(accountList.get(i));
            }
        }
    }

    static void updateStatus() throws Exception {
        boolean pass = false;
        String email = null;
        while (!pass) {
            email = myLibs.TextInput.StringRegex("Enter your email: ", "([^\\s]){0,100}(@gmail.com)", "Email format is not correct !");
            if (!AccountDAO.isEmailExist(email)) {
                System.out.println("Email is not existed ! \n Try again !");
            } else {
                pass = true;
            }
        }
        int status = myLibs.TextInput.IntergerRegex("Enter your status", "It must be from 0 to 1", 0, 1);
        if (!AccountDAO.isEmailExist(email) && AccountDAO.updateAccountStatus(email, Integer.valueOf(status))) {
            System.out.println("Sucess !");
        } else {
            System.out.println("Error !");
        }
    }

    static void updateAccount() throws Exception {
        boolean pass = false;
        String email = null;
        while (!pass) {
            email = myLibs.TextInput.StringRegex("Enter your email: ", "([^\\s]){0,100}(@gmail.com)", "Email format is not correct !");
            if (!AccountDAO.isEmailExist(email)) {
                System.out.println("Email is not existed ! \n Try again !");
            } else {
                pass = true;
            }
        }
        String password = myLibs.TextInput.StringRegex("Enter your password: ", "^[^\\s]$", "Password format is not correct !");
        String fullname = myLibs.TextInput.StringRegex("Enter your fullname: ", "^[^\\d]", "Full name format is not correct !");
        String phone = myLibs.TextInput.StringRegex("Enter your password: ", "^[^\\$\\a]{9,11}", "Password format is not correct !");
        if (AccountDAO.updateAccount(email, password, fullname, phone)) {
            System.out.println("Sucess !");
        } else {
            System.out.println("Error !");
        }
    }

    static void newAccount() throws Exception {
        boolean pass = false;
        String email = null;
        while (!pass) {
            email = myLibs.TextInput.StringRegex("Enter your email: ", "([^\\s]){0,100}(@gmail.com)", "Email format is not correct !");
            if (AccountDAO.isEmailExist(email)) {
                System.out.println("Email is existed ! \n Try again !");
            } else {
                pass = true;
            }
        }
        String password = myLibs.TextInput.StringRegex("Enter your password: ", "^[^\\s]{0,20}$", "Password format is not correct !");
        String fullname = myLibs.TextInput.StringRegex("Enter your fullname: ", "^[^\\d]{0,50}", "Password format is not correct !");
        String phone = myLibs.TextInput.StringRegex("Enter your phone: ", "^[\\d]{9,11}$", "Password format is not correct !");
        int status = myLibs.TextInput.IntergerRegex("Enter your status", "It must be from 0 to 1", 0, 1);
        int role = myLibs.TextInput.IntergerRegex("Enter your role", "It must be from 0 to 1", 0, 1);
        if (AccountDAO.insertAccount(email, password, fullname, phone, status, role)) {
            System.out.println("Sucess !");
        } else {
            System.out.println("Error !");
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("----------Menu----------");
        System.out.println("1. Show Account");
        System.out.println("2. Update Account Status");
        System.out.println("3. Update Account");
        System.out.println("4. New Account");
        int choose = myLibs.TextInput.IntergerRegex("Choose : ", "It must be from 0 to 4", 0, 5);
        switch (choose) {
            case (1):
                showAccount();
                break;
            case (2):
                updateStatus();
                break;
            case (3):
                updateAccount();
                break;
            case (4):
                newAccount();
                break;
            default:
                break;
        }
        System.exit(0);
    }
}
