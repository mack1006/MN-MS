package jp.kobe_u.cs.daikibo.ge_mart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.kobe_u.cs.daikibo.ge_mart.entity.Dish;
import jp.kobe_u.cs.daikibo.ge_mart.exception.GeMartException;
import jp.kobe_u.cs.daikibo.ge_mart.form.DishForm;
import jp.kobe_u.cs.daikibo.ge_mart.repository.DishRepository;

@Service
public class GeMartService {
    @Autowired
    DishRepository dishRepository;

    // リポジトリから全部のメニューを取ってくる
    public List<DishForm> getProposal() {
        final Iterable<Dish> dishListAll = dishRepository.findAll();
        // イテラブル型なので拡張forでList型に
        final List<DishForm> dishFormListAll = new ArrayList<DishForm>();
        for (final Dish d : dishListAll) {
            dishFormListAll.add(DishForm.toDishForm(d));
        }
        return dishFormListAll;
    }

    public DishForm getDishById(final Long id) {
        // ふつうにIDでとってくる
        final Dish dish = dishRepository.findById(id).orElseThrow(() -> new GeMartException("No such Dish"));
        final DishForm dishForm = DishForm.toDishForm(dish);
        return dishForm;
    }

    public Dish addDish(Dish d) {
        return dishRepository.save(d);
    }

    public List<DishForm> getDishMenuSortedByPrice() {
        Iterable<Dish> sortedDishes = dishRepository.findAllByOrderByPrice(); // Sort済みのやつを取ってくるヤツに後で変更
        List<DishForm> dishList = new ArrayList<DishForm>();

        for ( Dish d : sortedDishes ) {
            dishList.add( DishForm.toDishForm(d) );
        }

        return dishList;
    }
}
