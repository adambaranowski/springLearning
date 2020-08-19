package pl.adambaranowski.jparelationsonetomany.dao;

import org.springframework.stereotype.Repository;
import pl.adambaranowski.jparelationsonetomany.model.Client;
import pl.adambaranowski.jparelationsonetomany.model.Order;

import javax.transaction.Transactional;

@Repository
@Transactional
public class ClientDao extends GenericDao<Client, Long> {
    @Override
    public Client get(Long key) {
        Client client = super.get(key);
        //wywołanie metody żeby hibernate zaciągnął
        //pełną kolekcję, bo w onetomany jest wczytywanie leniwe
        //a w main chcemy wyprintować klienta czyli też i jego zamówienia

        client.getOrders().size();
        return client;
    }

    public void removeAllOrders(Client client) {
        Client managedClient = get(client.getId());
        //przy usuwaniu samej kolekcji zencji nie jest używany entityManager
        //więc nie wykonają się operacje kaskadowe
        //musimy ręcznie zerwać relacje z klientem ustawiając go na null
        //a potem w kliencie onetomany orders
        //ustawić orphanRemoval = true
        for (Order order: managedClient.getOrders()
             ) {
            order.setClient(null);
        }
        managedClient.getOrders().clear();
    }


}
