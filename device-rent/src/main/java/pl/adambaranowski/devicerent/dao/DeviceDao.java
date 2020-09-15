package pl.adambaranowski.devicerent.dao;

import pl.adambaranowski.devicerent.model.Device;

public interface DeviceDao {
    void create(Device device);
    Device read(Long id);
    void update(Device device);
    void delete(Device device);

}
