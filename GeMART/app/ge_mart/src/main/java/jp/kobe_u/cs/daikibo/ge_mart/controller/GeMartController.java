package jp.kobe_u.cs.daikibo.ge_mart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jp.kobe_u.cs.daikibo.ge_mart.form.DishForm;
import jp.kobe_u.cs.daikibo.ge_mart.service.GeMartService;

@Controller
public class GeMartController {
    @Autowired
    GeMartService geMartService;

    // topページの表示コントローラ
    @GetMapping("/")
    public String showDishList(Model model) {
        return "index.html";
    }

    // index.htmlの「はじめる」を押して提案メニュー一覧の表示をする
    @GetMapping("/propose")
    public String showPropose(Model model) {
        // DB内の全ての料理エンティティをフォームに直して取ってくる
        List<DishForm> dlist = geMartService.getProposal();
        model.addAttribute("dlist", dlist);
        return "proposal.html";
    }

    @GetMapping("/recipe/{dishId}")
    public String showRecipe(@PathVariable Long dishId, Model model) {
        // 該当IDの料理をDBからとってきてフォームに。
        // だけど料理フォームにレシピが入っていたので本当はわざわざまたDBにアクセスする意味はない
        // 本来なら一覧を表示する用のフォームと詳細を表示する用のフォームを分けるべき
        // 動けばいいの精神で一旦このまま実装
        DishForm dishForm = geMartService.getDishById(dishId);
        model.addAttribute("dishForm", dishForm);
        return "recipe";

    }

}