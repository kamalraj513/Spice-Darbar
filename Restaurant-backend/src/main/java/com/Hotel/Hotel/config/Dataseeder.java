package com.Hotel.Hotel.config;

import com.Hotel.Hotel.model.Category;
import com.Hotel.Hotel.model.MenuItems;
import com.Hotel.Hotel.repository.CategoriesRepository;
import com.Hotel.Hotel.repository.MenuItemsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class Dataseeder implements CommandLineRunner {

    private final CategoriesRepository categoriesRepository;
    private final MenuItemsRepository menuItemsRepository;

    public Dataseeder(CategoriesRepository categoriesRepository, MenuItemsRepository menuItemsRepository) {
        this.categoriesRepository = categoriesRepository;
        this.menuItemsRepository = menuItemsRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Delete existing data
        menuItemsRepository.deleteAll();
        categoriesRepository.deleteAll();

        // Create categories
        Category starters = new Category();
        starters.setName("Starters");

        Category soups = new Category();
        soups.setName("Soups");

        Category chicken = new Category();
        chicken.setName("MainCourse - Chicken");

        Category mutton = new Category();
        mutton.setName("MainCourse - Mutton");

        Category seafood = new Category();
        seafood.setName("MainCourse - Seafood");

        Category rice = new Category();
        rice.setName("Biryani & Rice");

        Category breads = new Category();
        breads.setName("Indian Breads");

        Category sideDishes = new Category();
        sideDishes.setName("Side Dishes");

        Category beverages = new Category();
        beverages.setName("Beverages");

        Category desserts = new Category();
        desserts.setName("Desserts");

        // Save categories
        categoriesRepository.saveAll(Arrays.asList(
                starters, soups, chicken, mutton, seafood, rice, breads, sideDishes, beverages, desserts
        ));

        // Fetch managed entities from DB
        Category savedStarters = categoriesRepository.findByName("Starters").orElseThrow();
        Category savedSoups = categoriesRepository.findByName("Soups").orElseThrow();
        Category savedChicken = categoriesRepository.findByName("MainCourse - Chicken").orElseThrow();
        Category savedMutton = categoriesRepository.findByName("MainCourse - Mutton").orElseThrow();
        Category savedSeafood = categoriesRepository.findByName("MainCourse - Seafood").orElseThrow();
        Category savedRice = categoriesRepository.findByName("Biryani & Rice").orElseThrow();
        Category savedBreads = categoriesRepository.findByName("Indian Breads").orElseThrow();
        Category savedSideDishes = categoriesRepository.findByName("Side Dishes").orElseThrow();
        Category savedBeverages = categoriesRepository.findByName("Beverages").orElseThrow();
        Category savedDesserts = categoriesRepository.findByName("Desserts").orElseThrow();

        // Create menu items
        MenuItems chickenTikka = new MenuItems();
        chickenTikka.setName("Chicken Tikka");
        chickenTikka.setPrice(250.00);
        chickenTikka.setImgURL("https://www.shutterstock.com/image-photo/deliciously-spiced-chicken-tikka-kabab-600nw-2495838045.jpg");
        chickenTikka.setCategory(savedStarters);

        MenuItems muttonSB = new MenuItems();
        muttonSB.setName("Mutton Seekh Kebab");
        muttonSB.setPrice(300.00);
        muttonSB.setImgURL("https://img.freepik.com/free-photo/side-view-lula-kebab-with-red-onions-sumakh-grilled-green-chili-peppers-wooden-board_140725-11481.jpg?semt=ais_hybrid&w=740&q=80");
        muttonSB.setCategory(savedStarters);

        MenuItems fishAF = new MenuItems();
        fishAF.setName("Fish Amritsari Fry");
        fishAF.setPrice(280.00);
        fishAF.setImgURL("https://www.indianhealthyrecipes.com/wp-content/uploads/2023/08/amritsari-fish-tawa-fry.webp");
        fishAF.setCategory(savedStarters);

        MenuItems prawnTe = new MenuItems();
        prawnTe.setName("Prawn Tempura(Indian Style)");
        prawnTe.setPrice(350.00);
        prawnTe.setImgURL("https://www.shutterstock.com/image-photo/butterfly-king-prawn-sweet-chili-600nw-2558942239.jpg");
        prawnTe.setCategory(savedStarters);

        MenuItems chickenPakora = new MenuItems();
        chickenPakora.setName("Chicken Pakora");
        chickenPakora.setPrice(200.00);
        chickenPakora.setImgURL("https://www.shutterstock.com/image-photo/chicken-pakora-dish-sweet-chilli-600nw-2006135621.jpg");
        chickenPakora.setCategory(savedStarters);

        MenuItems tangdiKebab = new MenuItems();
        tangdiKebab.setName("Tangdi Kebab");
        tangdiKebab.setPrice(220.00);
        tangdiKebab.setImgURL("https://www.shutterstock.com/image-photo/chicken-tangri-kabab-kebab-three-600nw-672818386.jpg");
        tangdiKebab.setCategory(savedStarters);

        // Save menu items
        menuItemsRepository.saveAll(Arrays.asList(
                chickenTikka, muttonSB, fishAF, prawnTe, chickenPakora, tangdiKebab
        ));
    }
}
