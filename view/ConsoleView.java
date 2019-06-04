package view;

import java.util.Scanner;

public class ConsoleView implements View {

    public String inputFromUser() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    public void showMessage(String str) {
        System.out.println(str);
    }
}
