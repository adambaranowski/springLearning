package pl.adambaranowski.devicerent.dao;

import org.springframework.stereotype.Repository;
import pl.adambaranowski.devicerent.model.Device;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class DeviceDaoImpl implements DeviceDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(Device device) {
        entityManager.persist(device);
    }

    @Override
    public Device read(Long id) {
        return entityManager.find(Device.class, id);
    }

    @Override
    public void update(Device device) {
        entityManager.merge(device);
    }

    @Override
    public void delete(Device device) {
        Device toRemove = entityManager.find(Device.class, device.getId());
        entityManager.remove(toRemove);
    }
}
