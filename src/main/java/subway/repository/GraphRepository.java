package subway.repository;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Section;
import subway.domain.Station;

import java.util.List;

public class GraphRepository {
    WeightedMultigraph<Station, DefaultWeightedEdge> graph;
    private final Station startStation;
    private final Station endStation;
    private final String ERR_WRONG_INPUT_GRAPH = "[ERROR] 출발역과 도착역이 동일합니다.";

    public GraphRepository(Station startStation, Station endStation) {
        validateStation();
        this.startStation = startStation;
        this.endStation = endStation;
        initGraph();
    }


    private void initGraph() {
        graph = new WeightedMultigraph<>(DefaultWeightedEdge.class);
        List<Station> stations = StationRepository.stations();
        stations.forEach(graph::addVertex);
    }

    private void validateStation() {
        if (startStation.equals(endStation)) {
            throw new IllegalArgumentException(ERR_WRONG_INPUT_GRAPH);
        }
    }

    public void setWeightByDistance() {
        List<Section> sections = SectionRepository.getSections();
        sections.forEach(section -> graph.setEdgeWeight(
                section.getStartStation(),
                section.getEndStation(),
                section.getDistance().getDistance()
        ));
    }

    public void setWeightByTravelTime() {
        List<Section> sections = SectionRepository.getSections();
        sections.forEach(section -> graph.setEdgeWeight(
                section.getStartStation(),
                section.getEndStation(),
                section.getDistance().getTravelTime()
        ));
    }
    public List<Station> getShortestPath() {
        DijkstraShortestPath<Station, DefaultWeightedEdge> dijkstraShortestPath = new DijkstraShortestPath<>(graph);
        return dijkstraShortestPath.getPath(startStation, endStation).getVertexList();
    }
}
