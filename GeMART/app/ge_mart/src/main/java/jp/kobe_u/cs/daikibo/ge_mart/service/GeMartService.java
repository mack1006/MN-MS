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
        Iterable<Dish> dishListAll = dishRepository.findAll();
        // イテラブル型なので拡張forでList型に
        List<DishForm> dishFormListAll = new ArrayList<DishForm>();
        for (Dish d : dishListAll) {
            dishFormListAll.add(DishForm.toDishForm(d));
        }
        return dishFormListAll;
    }

    public DishForm getDishById(Long id) {
        // ふつうにIDでとってくる
        Dish dish = dishRepository.findById(id).orElseThrow(() -> new GeMartException("No such Dish"));
        DishForm dishForm = DishForm.toDishForm(dish);
        return dishForm;
    }

}