package pl.adambaranowski.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.adambaranowski.springdata.model.Car;

import java.util.Collection;
import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findAllByBrand(String brand);

    Car findFirstByBrand(String brand);


    //NamedQueries in Car
    @Query(name = "Car.findById")
    List<Car> findByIdWithQuery(Long Id);

    @Query(name = "Car.findByPriceAsc")
    List<Car> findByPriceAsc(@Param("price") Double price);

    @Query("SELECT c FROM Car c WHERE c.name=:name AND c.price<:price")
    List<Car> findByNameAndAndPrice(@Param("name") String name, @Param("price") Double price);

    List<Car> findByBrand(String brand);

    List<Car> findFirst3ByBrand(String brand);

    List<Car> findAllByBrandAndPrice(String brand, Double price);

    List<Car> findAllByBrandOrBrand(String brand1, String brand2);

    List<Car> findAllByBrandLike(String pattern);

    List<Car> findAllByNameEndingWith(String pattern);

    List<Car> findAllByPriceLessThan(Double low);

    List<Car> findAllByPriceBetweenAndBrandOrderByPriceAsc(Double low, Double high, String brand);

    List<Car> findAllByBrandOrderByPriceAsc(String brand);

    List<Car> findAllByPriceBetween(double low, double high);

    List<Car> findAllByBrandNotNull();

    List<Car> findAllByNameIn(Collection<String> names);


}
