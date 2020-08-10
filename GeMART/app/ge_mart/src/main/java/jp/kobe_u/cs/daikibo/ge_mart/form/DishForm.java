package jp.kobe_u.cs.daikibo.ge_mart.form;

import jp.kobe_u.cs.daikibo.ge_mart.entity.Dish;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class DishForm {
    Long id;
    String name;
    String recipe;
    String foodstuff;
    int price;
    String cookingTime;
    String photoUrl;

    // entityからformへの変換するための変換器。業務ロジックというほどではないのでserviceではなくここに
    public static DishForm toDishForm(Dish dish) {
        DishForm dishForm = new DishForm();
        dishForm.setId(dish.getId());
        dishForm.setName(dish.getName());
        dishForm.setRecipe(dish.getRecipe());
        dishForm.setFoodstuff(dish.getFoodstuff());
        dishForm.setCookingTime(dish.getCookingTime());
        dishForm.setPhotoUrl(dish.getPhotoUrl());
        dishForm.setPrice(dish.getPrice());
        return dishForm;
    }

}
