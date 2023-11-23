package subway.view;

import java.util.Scanner;

public class InputView {
    final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getUserSelectMenu() {
        return scanner.next();
    }
}
