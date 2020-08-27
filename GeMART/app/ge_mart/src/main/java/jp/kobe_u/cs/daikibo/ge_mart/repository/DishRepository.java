package jp.kobe_u.cs.daikibo.ge_mart.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.kobe_u.cs.daikibo.ge_mart.entity.Dish;

@Repository
public interface DishRepository extends CrudRepository<Dish, Long> {
    public Iterable<Dish> findAllByOrderByPrice();
}
