package subway.utils;

import subway.domain.Distance;
import subway.domain.Line;
import subway.domain.Section;
import subway.domain.Station;
import subway.repository.LineRepository;
import subway.repository.SectionRepository;
import subway.repository.StationRepository;

import java.util.List;

public class MapInitializer {

    public static void init() {
        initLine();
        initStation();
        initSection();
    }

    public static void initLine() {
        LineRepository.addLine(new Line("2호선"));
        LineRepository.addLine(new Line("3호선"));
        LineRepository.addLine(new Line("신분당선"));
    }

    public static void initStation() {
        StationRepository.addStation(new Station("교대역"));
        StationRepository.addStation(new Station("강남역"));
        StationRepository.addStation(new Station("역삼역"));
        StationRepository.addStation(new Station("남부터미널역"));
        StationRepository.addStation(new Station("양재역"));
        StationRepository.addStation(new Station("매봉역"));
        StationRepository.addStation(new Station("양재시민의숲역"));
    }

    public static void initSection() {
        List<Section> sections = List.of(
                new Section("교대역", "강남역", new Distance(2, 3)),
                new Section("강남역", "역삼역", new Distance(2, 3)),
                new Section("교대역","남부터미널역", new Distance(3, 2)),
                new Section("남부터미널역","양재역", new Distance(6, 5)),
                new Section("남부터미널역","양재역", new Distance(1, 1)),
                new Section("강남역","양재역", new Distance(2, 8)),
                new Section("양재역","양재시민의숲역", new Distance(10, 3))
                );

        SectionRepository.addAll(sections);
    }

}
