package pl.adambaranowski.devicerent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.adambaranowski.devicerent.model.Category;
import pl.adambaranowski.devicerent.repository.CategoryRepository;

import java.util.Optional;
import java.util.Scanner;

@Service
public class CategoryController {
    private Scanner scanner;
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryController(Scanner scanner, CategoryRepository categoryRepository) {
        this.scanner = scanner;
        this.categoryRepository = categoryRepository;
    }

    public void createCategory(){
        Category category = readCategory();
        categoryRepository.save(category);
        System.out.println("Dodano kategorie: ");
        System.out.println(category);
    }

    public void removeCategory(){
        System.out.println("Podaj id kategorii: ");
        long id = scanner.nextLong();
        Optional<Category> category = categoryRepository.findById(id);
        category.ifPresentOrElse(category1 -> categoryRepository.delete(category1), () -> System.out.println("Brak kategorii o takim id!"));
    }

    private Category readCategory(){
        System.out.println("Podaj nazwe kategorii: ");
        Category category = new Category();
        category.setName(scanner.nextLine());
        System.out.println("Podaj opis kategorii: ");
        category.setDescription(scanner.nextLine());
        return category;
    }
}
