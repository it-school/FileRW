package itschool;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String login = "";
        String RegOrLog = "";
        String password = "";
        String ReadLogin = "";

        System.out.println("1 - Registration\n2 - LogIn\n");
        RegOrLog = in.next();
        switch(RegOrLog) {
            case "1": {
                System.out.print("Input login: ");
                login = in.next();
                System.out.print("Input password: ");
                password = in.next();

                BufferedWriter bw = null;
                try {
                    bw = new BufferedWriter(new FileWriter("LogAndPass.txt"));
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }

                try {
                    StringBuilder sb = new StringBuilder();
                    String line = null;
                    try {
                        bw.write("Login: " + login + "\n");
                        bw.write("Password: " + password + "\n");

                    } catch (IOException e) {
                        e.printStackTrace();
                        return;
                    }

                } finally {
                    try {
                        bw.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        return;
                    }
                }
                break;
            }
            case "2":
            {
                System.out.print("Input login: ");
                login = in.next();
                System.out.print("Input password: ");
                password = in.next();
                BufferedReader br = null;
                try {
                    br = new BufferedReader(new FileReader("LogAndPass.txt"));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    return;
                }

                try {
                    StringBuilder sb = new StringBuilder();
                    String line = null;
                    try {
                        ReadLogin = br.readLine();
                        ReadLogin = ReadLogin.substring(ReadLogin.indexOf(" ") + 1).trim();
                        String ReadPassword = br.readLine();
                        ReadPassword = ReadPassword.substring(ReadPassword.indexOf(" ") + 1).trim();
                        if(login.equals(ReadLogin) && password.equals(ReadPassword))
                        {
                            System.out.println("Login successful!");
                        } else {
                            System.out.println("Login unsuccessful");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        return;
                    }

                } finally {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        return;
                    }
                }
                break;
            }
            default:
            {
                System.out.println("Error input!");
            }
        }
    }
}