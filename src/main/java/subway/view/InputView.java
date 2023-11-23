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

    public String getUserInputPathCriteria() {
        return scanner.next();
    }

    public String getUserInputStartStation() {
        return scanner.next();
    }
}
