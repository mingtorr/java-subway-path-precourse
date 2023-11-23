package subway.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.FindResult;
import subway.domain.PathCriteria;
import subway.domain.Station;
import subway.utils.MapInitializer;

import java.util.List;

class GraphRepositoryTest {

    @BeforeEach
    void setUp() {
        MapInitializer.init();
    }

    @Test
    void setWeightByDistance() {
    }

    @Test
    void setWeightByTravelTime() {
    }

    @Test
    @DisplayName("경로 찾기 테스트_바로 옆")
    void getShortestPath() {
        List<Station> expectStation = List.of(StationRepository.findByName("교대역")
                , StationRepository.findByName("강남역")
        );
        GraphRepository graphRepository = new GraphRepository(expectStation.get(0),  expectStation.get(1));
        FindResult shortestPath = PathCriteria.SHORTEST_DISTANCE.getShortestPath(graphRepository);

        Assertions.assertThat(shortestPath.getStations()).isEqualTo(expectStation);
    }
    @Test
    @DisplayName("경로 찾기 테스트_떨어진 역")
    void getShortestPath2() {
        List<Station> expectStation = List.of(StationRepository.findByName("교대역"),
                StationRepository.findByName("강남역"),
                StationRepository.findByName("역삼역")
        );
        GraphRepository graphRepository = new GraphRepository(expectStation.get(0),  expectStation.get(2));
        FindResult shortestPath = PathCriteria.SHORTEST_DISTANCE.getShortestPath(graphRepository);

        Assertions.assertThat(shortestPath.getStations()).isEqualTo(expectStation);
    }

    @Test
    @DisplayName("경로 찾기 테스트_환승")
    void getShortestPath3() {
        List<Station> expectStation = List.of(StationRepository.findByName("교대역"),
                StationRepository.findByName("강남역"),
                StationRepository.findByName("양재역"),
                StationRepository.findByName("양재시민의숲역")
        );
        GraphRepository graphRepository = new GraphRepository(expectStation.get(0),  expectStation.get(3));
        FindResult shortestPath = PathCriteria.SHORTEST_DISTANCE.getShortestPath(graphRepository);

        Assertions.assertThat(shortestPath.getStations()).isEqualTo(expectStation);
    }
}