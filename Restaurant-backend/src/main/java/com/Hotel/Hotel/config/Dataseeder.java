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

        // Create starter menu items
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
       // soup menu
        MenuItems Chickensoup = new MenuItems();
        Chickensoup.setName("Chicken Hot & Sour Soup");
        Chickensoup.setPrice(150.00);
        Chickensoup.setImgURL("https://www.shutterstock.com/image-photo/chicken-hot-n-sour-soup-600nw-2310125917.jpg");
        Chickensoup.setCategory(savedSoups);

        MenuItems MuttonSoup = new MenuItems();
        MuttonSoup.setName("Mutton Yakhni Soup");
        MuttonSoup.setPrice(180.00);
        MuttonSoup.setImgURL("https://www.faskitchen.com/wp-content/uploads/2018/09/kashmiri-yakhni.jpg");
        MuttonSoup.setCategory(savedSoups);

        MenuItems Prawnsoup = new MenuItems();
        Prawnsoup.setName("Prawn Clear Soup");
        Prawnsoup.setPrice(200.00);
        Prawnsoup.setImgURL("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS802C3fb2Prttv3rtATPMrW7rG57CO4MgsIQ&s");
        Prawnsoup.setCategory(savedSoups);

        MenuItems ChickenManchowsoup = new MenuItems();
        ChickenManchowsoup.setName("Chicken Manchow Soup");
        ChickenManchowsoup.setPrice(160.00);
        ChickenManchowsoup.setImgURL("https://www.shutterstock.com/image-photo/chinese-chicken-manchow-soup-white-600nw-2308032343.jpg");
        ChickenManchowsoup.setCategory(savedSoups);

        menuItemsRepository.saveAll(Arrays.asList(Chickensoup,MuttonSoup,Prawnsoup,ChickenManchowsoup));

        //main course chicken
        MenuItems ButterChicken = new MenuItems();
        ButterChicken.setName("Butter Chicken (Murgh Makhani)");
        ButterChicken.setPrice(320.00);
        ButterChicken.setImgURL("https://www.shutterstock.com/image-photo/indian-butter-chicken-murgh-makhani-600nw-1490858222.jpg");
        ButterChicken.setCategory(savedChicken);

        MenuItems ChickenChettinad = new MenuItems();
        ChickenChettinad.setName("Chicken Chettinad (South Indian)");
        ChickenChettinad.setPrice(320.00);
        ChickenChettinad.setImgURL("https://www.shutterstock.com/image-photo/chettinad-chicken-curry-popular-south-600nw-1423521875.jpg");
        ChickenChettinad.setCategory(savedChicken);

        MenuItems Chickencurry = new MenuItems();
        Chickencurry.setName("Chicken Curry (North Indian");
        Chickencurry.setPrice(300.00);
        Chickencurry.setImgURL("https://www.shutterstock.com/image-photo/homemade-chicken-curry-pan-wooden-600nw-2476480287.jpg");
        Chickencurry.setCategory(savedChicken);

        MenuItems ChickenKolhapuri = new MenuItems();
        ChickenKolhapuri.setName("Chicken Kolhapuri");
        ChickenKolhapuri.setPrice(320.00);
        ChickenKolhapuri.setImgURL("https://www.shutterstock.com/image-photo/top-view-kolhapuri-chicken-curry-600nw-766366987.jpg");
        ChickenKolhapuri.setCategory(savedChicken);

        MenuItems ChickenDoPyaz = new MenuItems();
        ChickenDoPyaz.setName("Chicken Do Pyaza");
        ChickenDoPyaz.setPrice(300.00);
        ChickenDoPyaz.setImgURL("https://5.imimg.com/data5/SELLER/Default/2024/9/449743382/IU/UH/LC/230584086/chicken-do-pyaza-half-500x500.jpg");
        ChickenDoPyaz.setCategory(savedChicken);

        MenuItems ChickenKorma = new MenuItems();
        ChickenKorma.setName("Chicken Korma");
        ChickenKorma.setPrice(310.00);
        ChickenKorma.setImgURL("https://www.shutterstock.com/image-photo/chicken-curry-masalakerala-style-using-600nw-1903754356.jpg");
        ChickenKorma.setCategory(savedChicken);

        menuItemsRepository.saveAll(Arrays.asList(ButterChicken,ChickenChettinad,Chickencurry,ChickenKolhapuri,ChickenDoPyaz,ChickenKorma));

        // -------- Mutton Main Course --------
        MenuItems MuttonRoganJosh = new MenuItems();
        MuttonRoganJosh.setName("Mutton Rogan Josh");
        MuttonRoganJosh.setPrice(380.00);
        MuttonRoganJosh.setImgURL("https://www.shutterstock.com/image-photo/traditional-spicy-indian-chicken-madras-600nw-2259821081.jpg");
        MuttonRoganJosh.setCategory(savedMutton);

        MenuItems MuttonCurry = new MenuItems();
        MuttonCurry.setName("Mutton Curry (North Indian)");
        MuttonCurry.setPrice(360.00);
        MuttonCurry.setImgURL("https://www.shutterstock.com/image-photo/mutton-curry-isolated-on-white-600nw-2501205411.jpg");
        MuttonCurry.setCategory(savedMutton);

        MenuItems MuttonKeema = new MenuItems();
        MuttonKeema.setName("Mutton Keema Masala");
        MuttonKeema.setPrice(370.00);
        MuttonKeema.setImgURL("https://www.shutterstock.com/image-photo/mutton-kheema-pav-indian-spicy-600nw-665755342.jpg");
        MuttonKeema.setCategory(savedMutton);

        MenuItems MuttonKorma = new MenuItems();
        MuttonKorma.setName("Mutton Korma");
        MuttonKorma.setPrice(390.00);
        MuttonKorma.setImgURL("https://st.depositphotos.com/1005682/2724/i/450/depositphotos_27241837-stock-photo-mutton-korma-famous-food-with.jpg");
        MuttonKorma.setCategory(savedMutton);

        MenuItems MuttonVindallo = new MenuItems();
        MuttonVindallo.setName("Mutton Vindaloo (Goan Style)");
        MuttonVindallo.setPrice(420.00);
        MuttonVindallo.setImgURL("https://www.indianhealthyrecipes.com/wp-content/uploads/2022/11/lamb-vindaloo-recipe.webp");
        MuttonVindallo.setCategory(savedMutton);

        MenuItems MuttonHandi = new MenuItems();
        MuttonHandi.setName("Mutton Handi");
        MuttonHandi.setPrice(450.00);
        MuttonHandi.setImgURL("https://www.shutterstock.com/image-photo/delicious-mutton-curry-served-traditional-600nw-2611092687.jpg");
        MuttonHandi.setCategory(savedMutton);



        menuItemsRepository.saveAll(Arrays.asList(MuttonRoganJosh, MuttonCurry, MuttonKeema, MuttonKorma,MuttonVindallo,MuttonHandi));

// -------- Seafood Main Course --------
        MenuItems PrawnMasala = new MenuItems();
        PrawnMasala.setName("Prawn Masala Curry");
        PrawnMasala.setPrice(400.00);
        PrawnMasala.setImgURL("https://st3.depositphotos.com/4231041/14342/i/450/depositphotos_143428851-stock-photo-homemade-prawn-curry.jpg");
        PrawnMasala.setCategory(savedSeafood);

        MenuItems FishCurry = new MenuItems();
        FishCurry.setName("Andhra Fish Curry");
        FishCurry.setPrice(350.00);
        FishCurry.setImgURL("https://vismaifood.com/storage/app/uploads/public/c0d/434/20d/thumb__700_0_0_0_auto.jpg");
        FishCurry.setCategory(savedSeafood);

        MenuItems CrabMasala = new MenuItems();
        CrabMasala.setName("Crab Masala Curry");
        CrabMasala.setPrice(420.00);
        CrabMasala.setImgURL("https://www.shutterstock.com/image-photo/stirfried-crab-curry-powder-yellow-600nw-1476886670.jpg");
        CrabMasala.setCategory(savedSeafood);

        MenuItems FishTandoori = new MenuItems();
        FishTandoori.setName("Tandoori Fish");
        FishTandoori.setPrice(380.00);
        FishTandoori.setImgURL("https://st2.depositphotos.com/1570716/8035/i/450/depositphotos_80351428-stock-photo-indian-tandoori-pomfret.jpg");
        FishTandoori.setCategory(savedSeafood);

        MenuItems PrawnCurry = new MenuItems();
        PrawnCurry.setName("Prawn Malai");
        PrawnCurry.setPrice(420.00);
        PrawnCurry.setImgURL("https://www.shutterstock.com/image-photo/traditional-spicy-indian-prawn-madras-600nw-2259821155.jpg");
        PrawnCurry.setCategory(savedSeafood);

        menuItemsRepository.saveAll(Arrays.asList(PrawnMasala, FishCurry, CrabMasala, FishTandoori,PrawnCurry));

// -------- Biryani & Rice --------
        MenuItems ChickenBiryani = new MenuItems();
        ChickenBiryani.setName("Hyderabadi Chicken Biryani");
        ChickenBiryani.setPrice(300.00);
        ChickenBiryani.setImgURL("https://static.vecteezy.com/system/resources/thumbnails/040/703/949/small_2x/ai-generated-royal-feast-master-the-art-of-chicken-biryani-at-home-generative-ai-photo.jpg");
        ChickenBiryani.setCategory(savedRice);

        MenuItems MuttonBiryani = new MenuItems();
        MuttonBiryani.setName("Kolkata Mutton Biryani");
        MuttonBiryani.setPrice(350.00);
        MuttonBiryani.setImgURL("https://upload.wikimedia.org/wikipedia/commons/thumb/1/1a/Kolkata_mutton_biryani.jpg/1200px-Kolkata_mutton_biryani.jpg");
        MuttonBiryani.setCategory(savedRice);

        MenuItems PrawnBiryani = new MenuItems();
        PrawnBiryani.setName("Prawn Biryani");
        PrawnBiryani.setPrice(340.00);
        PrawnBiryani.setImgURL("https://www.kannammacooks.com/wp-content/uploads/prawn-biryani-eral-biriyani-recipe-1.jpg");
        PrawnBiryani.setCategory(savedRice);

        MenuItems EggFriedRice = new MenuItems();
        EggFriedRice.setName("Egg Fried Rice");
        EggFriedRice.setPrice(220.00);
        EggFriedRice.setImgURL("https://st4.depositphotos.com/1027198/24201/i/450/depositphotos_242015694-stock-photo-rice-egg-pea.jpg");
        EggFriedRice.setCategory(savedRice);

        MenuItems JeeraRice = new MenuItems();
        JeeraRice.setName("Jeera Rice");
        JeeraRice.setPrice(120.00);
        JeeraRice.setImgURL("https://www.shutterstock.com/image-photo/cumin-rice-jeera-popular-indian-600nw-1785410987.jpg");
        JeeraRice.setCategory(savedRice);

        MenuItems KushkaRice = new MenuItems();
        KushkaRice.setName("Kuska Rice");
        KushkaRice.setPrice(130.00);
        KushkaRice.setImgURL("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRKrCUVPfOsy8sknT9HG4LfUkCmPRkU8niF6w&s");
        KushkaRice.setCategory(savedRice);

        MenuItems SteamRice = new MenuItems();
        SteamRice.setName("Steam Rice");
        SteamRice.setPrice(100.00);
        SteamRice.setImgURL("https://static.vecteezy.com/system/resources/thumbnails/052/952/063/small_2x/indian-cuisine-steamed-basmati-rice-photo.jpg");
        SteamRice.setCategory(savedRice);

        menuItemsRepository.saveAll(Arrays.asList(ChickenBiryani, MuttonBiryani, PrawnBiryani, EggFriedRice,JeeraRice,KushkaRice,SteamRice));

// -------- Indian Breads --------
        MenuItems ButterNaan = new MenuItems();
        ButterNaan.setName("Butter Naan");
        ButterNaan.setPrice(60.00);
        ButterNaan.setImgURL("https://www.shutterstock.com/image-photo/tandoori-naan-indian-roti-flat-600nw-2241211579.jpg");
        ButterNaan.setCategory(savedBreads);

        MenuItems GarlicNaan = new MenuItems();
        GarlicNaan.setName("Garlic Naan");
        GarlicNaan.setPrice(80.00);
        GarlicNaan.setImgURL("https://pabulum.co.in/wp-content/uploads/2024/08/Untitled-design-9.jpg");
        GarlicNaan.setCategory(savedBreads);

        MenuItems TandooriRoti = new MenuItems();
        TandooriRoti.setName("Tandoori Roti");
        TandooriRoti.setPrice(40.00);
        TandooriRoti.setImgURL("https://st2.depositphotos.com/3147737/5351/i/450/depositphotos_53512437-stock-photo-tandoori-roti-is-indian-unleavened.jpg");
        TandooriRoti.setCategory(savedBreads);

        MenuItems LachhaParatha = new MenuItems();
        LachhaParatha.setName("Lachha Paratha");
        LachhaParatha.setPrice(70.00);
        LachhaParatha.setImgURL("https://img.cdnx.in/338572/1701529622476_LachhaParatha.jpeg?width=600&format=webp");
        LachhaParatha.setCategory(savedBreads);

        MenuItems Roomaliroti = new MenuItems();
        Roomaliroti.setName("Roomali Roti");
        Roomaliroti.setPrice(40.00);
        Roomaliroti.setImgURL("https://pabulum.co.in/wp-content/uploads/2024/08/Rumali-Roti.jpg");
        Roomaliroti.setCategory(savedBreads);

        MenuItems Chapathi = new MenuItems();
        Chapathi.setName("Wheat Chapati");
        Chapathi.setPrice(70.00);
        Chapathi.setImgURL("https://static.vecteezy.com/system/resources/thumbnails/048/161/900/small_2x/close-up-of-flatbreads-on-white-plate-free-photo.jpg");
        Chapathi.setCategory(savedBreads);

        menuItemsRepository.saveAll(Arrays.asList(ButterNaan, GarlicNaan, TandooriRoti, LachhaParatha,Roomaliroti,Chapathi));

// -------- Side Dishes --------
        MenuItems Raita = new MenuItems();
        Raita.setName("Cucumber Raita");
        Raita.setPrice(80.00);
        Raita.setImgURL("https://www.shutterstock.com/image-photo/raita-minty-sauce-creamy-yogurt-600nw-2383796617.jpg");
        Raita.setCategory(savedSideDishes);

        MenuItems GreenSalad = new MenuItems();
        GreenSalad.setName("Indian Green Salad");
        GreenSalad.setPrice(90.00);
        GreenSalad.setImgURL("https://manjits.com/wp-content/uploads/2025/03/indian-green-salad.jpg");
        GreenSalad.setCategory(savedSideDishes);

        MenuItems MasalaPapad = new MenuItems();
        MasalaPapad.setName("Masala Papad");
        MasalaPapad.setPrice(60.00);
        MasalaPapad.setImgURL("https://t4.ftcdn.net/jpg/09/34/65/85/360_F_934658531_7yhFm5BQ6NJ9lieQr9hc31RFqMe1cycQ.jpg");
        MasalaPapad.setCategory(savedSideDishes);

        MenuItems AcharPickles = new MenuItems();
        AcharPickles.setName("Pickles (Achar)");
        AcharPickles.setPrice(30.00);
        AcharPickles.setImgURL("https://st4.depositphotos.com/5653638/39254/i/450/depositphotos_392540212-stock-photo-homemade-mango-pickle-aam-achar.jpg");
        AcharPickles.setCategory(savedSideDishes);


        menuItemsRepository.saveAll(Arrays.asList(Raita, GreenSalad, MasalaPapad, AcharPickles));

// -------- Beverages --------
        MenuItems MasalaChaas = new MenuItems();
        MasalaChaas.setName("Masala Chaas (Buttermilk)");
        MasalaChaas.setPrice(70.00);
        MasalaChaas.setImgURL("https://i.pinimg.com/736x/3d/02/88/3d0288c6100dc1bf6bdcef6a94a68b6f.jpg");
        MasalaChaas.setCategory(savedBeverages);

        MenuItems SweetLassi = new MenuItems();
        SweetLassi.setName("Sweet Lassi");
        SweetLassi.setPrice(90.00);
        SweetLassi.setImgURL("https://static.vecteezy.com/system/resources/thumbnails/041/899/954/small_2x/ai-generated-ayran-refreshment-drink-generate-ai-photo.jpg");
        SweetLassi.setCategory(savedBeverages);

        MenuItems MasalaSoda = new MenuItems();
        MasalaSoda.setName("Masala Soda");
        MasalaSoda.setPrice(80.00);
        MasalaSoda.setImgURL("https://5.imimg.com/data5/SELLER/Default/2021/12/FN/CF/GO/3180617/masala-soda-soft-drink-concentrate.jpg");
        MasalaSoda.setCategory(savedBeverages);

        MenuItems LemonJuice = new MenuItems();
        LemonJuice.setName("Fresh Lime Soda");
        LemonJuice.setPrice(70.00);
        LemonJuice.setImgURL("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcThqvo3YtZxakAWJsWc7ZY6OigdrXwVun8Ahw&s");
        LemonJuice.setCategory(savedBeverages);

        MenuItems SoftDrinks = new MenuItems();
        SoftDrinks.setName("Soft Drink");
        SoftDrinks.setPrice(70.00);
        SoftDrinks.setImgURL("https://www.shutterstock.com/image-photo/soft-drinks-fruit-juice-mixed-600nw-2440839647.jpg");
        SoftDrinks.setCategory(savedBeverages);

        menuItemsRepository.saveAll(Arrays.asList(MasalaChaas, SweetLassi, MasalaSoda, LemonJuice,SoftDrinks));

// -------- Desserts --------
        MenuItems GulabJamun = new MenuItems();
        GulabJamun.setName("Gulab Jamun");
        GulabJamun.setPrice(120.00);
        GulabJamun.setImgURL("https://www.shutterstock.com/image-photo/gulab-jamun-perfect-600nw-2479049165.jpg");
        GulabJamun.setCategory(savedDesserts);

        MenuItems Rasmalai = new MenuItems();
        Rasmalai.setName("Rasmalai");
        Rasmalai.setPrice(150.00);
        Rasmalai.setImgURL("https://www.shutterstock.com/image-photo/angoori-rasmalai-indian-dessert-sweet-600nw-659254714.jpg");
        Rasmalai.setCategory(savedDesserts);

        MenuItems GajarHalwa = new MenuItems();
        GajarHalwa.setName("Gajar ka Halwa");
        GajarHalwa.setPrice(160.00);
        GajarHalwa.setImgURL("https://www.shutterstock.com/image-photo/gajar-ka-halwa-carrotbased-sweet-600nw-759925777.jpg");
        GajarHalwa.setCategory(savedDesserts);

        MenuItems Kulfi = new MenuItems();
        Kulfi.setName("Matka Kulfi");
        Kulfi.setPrice(130.00);
        Kulfi.setImgURL("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRLX2tLtaSM5QZsfvRhiHNnopUlfILSVzjhGg&s");
        Kulfi.setCategory(savedDesserts);

        MenuItems Phirni = new MenuItems();
        Phirni.setName("Phirni");
        Phirni.setPrice(90.00);
        Phirni.setImgURL("https://content.jdmagicbox.com/quickquotes/listicle/listicle_1741592203079_tzdgx_826x551.jpg?impolicy=queryparam&im=Resize=(847,400),aspect=fit&q=75");
        Phirni.setCategory(savedDesserts);

        menuItemsRepository.saveAll(Arrays.asList(GulabJamun, Rasmalai, GajarHalwa, Kulfi, Phirni));





    }
}
