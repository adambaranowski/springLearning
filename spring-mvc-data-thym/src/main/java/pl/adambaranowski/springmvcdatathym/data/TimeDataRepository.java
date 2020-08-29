package pl.adambaranowski.springmvcdatathym.data;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.adambaranowski.springmvcdatathym.model.TimeData;

public interface TimeDataRepository extends JpaRepository<TimeData, Long> {
}
