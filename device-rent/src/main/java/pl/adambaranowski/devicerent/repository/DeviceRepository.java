package pl.adambaranowski.devicerent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.adambaranowski.devicerent.model.Device;

@Repository
public interface DeviceRepository  extends JpaRepository<Device, Long> {
}
