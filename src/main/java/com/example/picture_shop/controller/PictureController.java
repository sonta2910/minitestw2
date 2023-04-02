package com.example.picture_shop.controller;

import com.example.picture_shop.model.Category;
import com.example.picture_shop.model.Picture;
import com.example.picture_shop.service.ICategoryService;
import com.example.picture_shop.service.IPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/pictures")
public class PictureController {
    @Autowired
    private IPictureService pictureService;

    @Autowired
    private ICategoryService categoryService;
    @ModelAttribute("categories")
    private List<Category> getCategories() {
        return categoryService.findAll();
    }
    @GetMapping("/categories")
    private String getCategories(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories",categories);
        return "category/list";
    }

    @GetMapping
    public String findAll(Model model) {
        List<Picture> pictures = pictureService.findAll();
        model.addAttribute("pictures", pictures);
        return "picture/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("picture", new Picture());
        return "picture/create";
    }

    @PostMapping()
    public String create(@ModelAttribute Picture picture){
        pictureService.save(picture);
        return "redirect:/pictures";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        pictureService.delete(id);
        return "redirect:/pictures";
    }
    @GetMapping("/update/{id}")
    public String updateForm(Model model, @PathVariable Long id) {
        model.addAttribute("picture", pictureService.findById(id));
        return "picture/update";
    }

    @PostMapping("/update")
    public String updatePicture(@ModelAttribute Picture picture) {
        pictureService.save(picture);
        return "redirect:/pictures";
    }

    @GetMapping("/category")
    public ModelAndView findByCategory(@RequestParam("category") Category category) {
        List<Picture> pictures = pictureService.findByCategory(category);
        ModelAndView modelAndView = new ModelAndView("picture/list");
        modelAndView.addObject("pictures", pictures);
        return modelAndView;
    }

    @GetMapping("/search")
    public ModelAndView findByCode(@RequestParam("pictureCode") String pictureCode) {
        List<Picture> pictures = pictureService.findByCode(pictureCode);
        if (pictures.isEmpty()){
            pictures = pictureService.findAll();
        }
        ModelAndView modelAndView = new ModelAndView("picture/list");
        modelAndView.addObject("pictures", pictures);
        return modelAndView;
    }
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id,Model model){
        model.addAttribute("pictures", pictureService.findById(id));
        return "picture/detail";
    }
}
