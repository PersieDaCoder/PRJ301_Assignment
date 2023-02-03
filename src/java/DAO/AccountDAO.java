/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Account;
import java.sql.*;
import java.util.ArrayList;
import myLibs.DBUtils;

public class AccountDAO {

    public static ArrayList<Account> getAccounts() throws Exception {
        ArrayList<Account> accountList = new ArrayList<>();
        Connection cn = DBUtils.makeConnection();
        Statement st = cn.createStatement();
        String s = "SELECT email,password,fullname,phone,status,role FROM Accounts";
        ResultSet rs = st.executeQuery(s);
        if (rs != null) {
            while (rs.next()) {
                String email = rs.getString("email");
                String password = rs.getString("password");
                String fullname = rs.getString("fullname");
                String phone = rs.getString("phone");
                String status = rs.getString("status");
                String role = rs.getString("role");
                accountList.add(
                        new Account(email, password, fullname, phone, status, role)
                );
            }
        }
        cn.close();
        return accountList;
    }

    public static boolean updateAccountStatus(String email, int status)
            throws Exception {
        Connection cn = DBUtils.makeConnection();
        String s
                = "UPDATE Accounts SET status= ? where email=? COLLATE Latin1_General_CI_AS";
        PreparedStatement ps = cn.prepareStatement(s);
        ps.setString(1, String.valueOf(status));
        ps.setString(2, email);
        if (ps.executeUpdate() >= 0) {
            cn.close();
            return true;
        }
        cn.close();
        return false;
    }

    public static boolean updateAccount(
            String email,
            String newPassword,
            String newFullname,
            String newPhone
    ) throws Exception {
        Connection cn = DBUtils.makeConnection();
        String s
                = "update Accounts set [fullname]=?,[password]=?,[phone]=? where email=? COLLATE Latin1_General_CI_AS";
        PreparedStatement ps = cn.prepareStatement(s);
        ps.setString(1, newFullname);
        ps.setString(2, newPassword);
        ps.setString(3, newPhone);
        ps.setString(4, email);
        if (ps.executeUpdate() >= 0) {
            cn.close();
            return true;
        }
        cn.close();
        return false;
    }

    public static boolean insertAccount(
            String newEmail,
            String newPassword,
            String newFullname,
            String newPhone,
            int newStatus,
            int newRole
    ) throws Exception {
        Connection cn = DBUtils.makeConnection();
        String s
                = "insert into Accounts([email],[password],[fullname],[phone],[status],[role]) values (?,?,?,?,?,?)";
        PreparedStatement ps = cn.prepareStatement(s);
        ps.setString(1, newEmail);
        ps.setString(2, newPassword);
        ps.setString(3, newFullname);
        ps.setString(4, newPhone);
        ps.setString(5, String.valueOf(newStatus));
        ps.setString(6, String.valueOf(newRole));
        if (ps.executeUpdate() >= 0) {
            cn.close();
            return true;
        }
        cn.close();
        return false;
    }

    public static boolean isEmailExist(String email) throws Exception {
        ArrayList<Account> accountList = getAccounts();
        if (accountList.isEmpty()) {
            return false;
        }
        try {
            for (int i = 0; i < accountList.size(); i++) {
                if (accountList.get(i).getEmail().matches(email)) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("error !");
        }
        return false;
    }
}
