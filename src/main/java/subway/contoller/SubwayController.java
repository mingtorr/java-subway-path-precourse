package subway.contoller;

import subway.domain.MainMenu;
import subway.domain.PathCriteria;
import subway.domain.FindResult;
import subway.domain.Station;
import subway.repository.GraphRepository;
import subway.repository.StationRepository;
import subway.utils.MapInitializer;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class SubwayController {
    InputView inputView;

    public SubwayController(Scanner scanner) {
        inputView = new InputView(scanner);
    }

    public void run() {
        MapInitializer.init();
        MainMenu menu;
        while(true) {
            menu = printMainMenuSelection();
            if(menu.isQuitOption()){
                break;
            }
            getPath();
        }
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

    private void getPath() {
        try {
            PathCriteria inputPathCriteria = getInputPathCriteria();
            if(inputPathCriteria.isBackOption()) {
                return;
            }
            GraphRepository graphRepository = new GraphRepository(getStartStation(), getEndStation());
            FindResult shortestPath = inputPathCriteria.getShortestPath(graphRepository);
            printFindResult(shortestPath);
        } catch (Exception ex) {
            OutputView.printErrorMessage(ex.getMessage());
            getPath();
        }
    }

    private Station getStartStation() {
        OutputView.printInputStartStation();
        return StationRepository.findByName(inputView.getUserInputStartStation());
    }

    private Station getEndStation() {
        OutputView.printInputEndStation();
        return StationRepository.findByName(inputView.getUserInputEndStation());
    }

    private void printFindResult(FindResult findResult) {
        OutputView.printFindResult(findResult.getSumOfDistance(), findResult.getSumOfTravelTime());
        OutputView.printVisitStations(findResult.getStations());
    }
}
