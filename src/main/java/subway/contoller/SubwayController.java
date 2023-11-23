package subway.contoller;

import subway.domain.MainMenu;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class SubwayController {
    InputView inputView;

    public SubwayController(Scanner scanner) {
        inputView = new InputView(scanner);
    }

    public void run() {
        String menu;
        do {
             menu = printMainMenuSelection();

        }while (MainMenu.isProgramQuit(menu));
    }

    private void printMainMenuList() {
        OutputView.printMainMenuList();
    }

    private String printMainMenuSelection() {
        try {
            printMainMenuList();
            OutputView.printMenuSelection();
            String userSelectMenu = inputView.getUserSelectMenu();
            MainMenu.validateSelectMenu(userSelectMenu);
            return userSelectMenu;
        }
        catch (Exception ex) {
            OutputView.printErrorMessage(ex.getMessage());
            return printMainMenuSelection();
        }
    }
}
