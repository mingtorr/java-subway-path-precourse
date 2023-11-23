package subway.contoller;

import subway.domain.MainMenu;
import subway.domain.PathCriteria;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class SubwayController {
    InputView inputView;

    public SubwayController(Scanner scanner) {
        inputView = new InputView(scanner);
    }

    public void run() {
        MainMenu menu;
        do {
            menu = printMainMenuSelection();
            PathCriteria inputPathCriteria = getInputPathCriteria();
            if (PathCriteria.isOptionForFindPath(inputPathCriteria)) {
                getPath(inputPathCriteria);
            }
        } while (MainMenu.isProgramQuit(menu));
    }

    private MainMenu printMainMenuSelection() {
        try {
            OutputView.printMainMenuList();
            OutputView.printMenuSelection();
            String userSelectMenu = inputView.getUserSelectMenu();
            return MainMenu.findByCommand(userSelectMenu);
        } catch (Exception ex) {
            OutputView.printErrorMessage(ex.getMessage());
            return printMainMenuSelection();
        }
    }

    private PathCriteria getInputPathCriteria() {
        try {
            OutputView.printPathCriteria();
            OutputView.printPathCriteriaSelection();
            return PathCriteria.findByCommand(inputView.getUserInputPathCriteria());
        } catch (Exception ex) {
            OutputView.printErrorMessage(ex.getMessage());
            return getInputPathCriteria();
        }
    }
    private void getPath(PathCriteria pathCriteria) {

    }
}
