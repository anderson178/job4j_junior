package ru.job4j.lsp;

import org.junit.Before;
import ru.job4j.lsp.storage.Storage;

import java.util.ArrayList;
import java.util.List;

/**
 * Тесты заокментированны так как в классах используется текущая дата. Которая при запуске тестов будет меняться
 * а статические даты будут естественно неизменными
 */
public class UIStorageFoodTest {
    private List<Storage> storages = new ArrayList<>();
    private MenuStorage menu = new MenuStorage();

    @Before
    public void addStoreges() {
        storages.clear();
    }


//    @Test
//    public void whenAddShop() throws ParseException {
//        Date expiryDate = new SimpleDateFormat("yyyy-MM-dd").parse("2019-12-24");
//        Date createDate = new SimpleDateFormat("yyyy-MM-dd").parse("2019-08-24");
//        Food apple = new Food("Apple", expiryDate, createDate, 100);
//        InputInterface input = new StabInput(new ArrayList<>(Arrays.asList("0", apple.getName(), "2019-12-24", "2019-08-24", String.valueOf(apple.getPrice()), "1", "2")));
//        storages.add(new Shop());
//        UIStorageFood ui = new UIStorageFood(menu, input, storages);
//        ui.execute();
//        apple.setId(ui.getStorages().get(0).getFoods().get(0).getId());
//        assertThat(ui.getStorages().get(0).getFoods().toString(),
//                Is.is("[Food(id=" + apple.getId() + ", name=Apple, expiryDate=Tue Dec 24 00:00:00 MSK 2019, "
//                        + "createDate=Sat Aug 24 00:00:00 MSK 2019, price=100, disscount=0)]"));
//    }
//
//    @Test
//    public void whenAddTrash() throws ParseException {
//        Date expiryDate = new SimpleDateFormat("yyyy-MM-dd").parse("2019-08-24");
//        Date createDate = new SimpleDateFormat("yyyy-MM-dd").parse("2019-07-24");
//        Food apple = new Food("Apple", expiryDate, createDate, 100);
//        InputInterface input = new StabInput(new ArrayList<>(Arrays.asList("0", apple.getName(), "2019-08-24", "2019-07-24", String.valueOf(apple.getPrice()), "1", "2")));
//        storages.add(new Trash());
//        UIStorageFood ui = new UIStorageFood(menu, input, storages);
//        ui.execute();
//        apple.setId(ui.getStorages().get(0).getFoods().get(0).getId());
//        assertThat(ui.getStorages().get(0).getFoods().toString(),
//                Is.is("[Food(id=" + apple.getId() + ", name=Apple, expiryDate=Sat Aug 24 00:00:00 MSK 2019, "
//                        + "createDate=Wed Jul 24 00:00:00 MSK 2019, price=100, disscount=0)]"));
//    }
//
//
//    @Test
//    public void whenAddWareHouse() throws ParseException {
//        Date expiryDate = new SimpleDateFormat("yyyy-MM-dd").parse("2019-12-28");
//        Date createDate = new SimpleDateFormat("yyyy-MM-dd").parse("2019-09-10");
//        Food apple = new Food("Apple", expiryDate, createDate, 100);
//        InputInterface input = new StabInput(new ArrayList<>(Arrays.asList("0", apple.getName(), "2019-12-28", "2019-09-10", String.valueOf(apple.getPrice()), "1", "2")));
//        storages.add(new Warehouse());
//        UIStorageFood ui = new UIStorageFood(menu, input, storages);
//        ui.execute();
//        apple.setId(ui.getStorages().get(0).getFoods().get(0).getId());
//        assertThat(ui.getStorages().get(0).getFoods().toString(),
//                Is.is("[Food(id=" + apple.getId() + ", name=Apple, expiryDate=Sat Dec 28 00:00:00 MSK 2019, "
//                        + "createDate=Tue Sep 10 00:00:00 MSK 2019, price=100, disscount=0)]"));
//    }

//    @Test
//    public void whenAddWareHouseAdditional() throws ParseException {
//        Date expiryDate = new SimpleDateFormat("yyyy-MM-dd").parse("2019-12-28");
//        Date createDate = new SimpleDateFormat("yyyy-MM-dd").parse("2019-09-10");
//        Food apple = new Food("Apple", expiryDate, createDate, 100);
//        InputInterface input = new StabInput(new ArrayList<>(Arrays.asList("0", apple.getName(), "2019-12-28", "2019-09-10", String.valueOf(apple.getPrice()), "1", "2")));
//        storages.add(new WarehouseAdditional());
//        UIStorageFood ui = new UIStorageFood(menu, input, storages);
//        ui.execute();
//        apple.setId(ui.getStorages().get(0).getFoods().get(0).getId());
//        assertThat(ui.getStorages().get(0).getFoods().toString(),
//                Is.is("[Food(id=" + apple.getId() + ", name=Apple, expiryDate=Sat Dec 28 00:00:00 MSK 2019, "
//                        + "createDate=Tue Sep 10 00:00:00 MSK 2019, price=100, disscount=0)]"));
//    }
//
//    @Test
//    public void whenAddWareHouseCold() throws ParseException {
//        Date expiryDate = new SimpleDateFormat("yyyy-MM-dd").parse("2019-12-28");
//        Date createDate = new SimpleDateFormat("yyyy-MM-dd").parse("2019-09-10");
//        Food apple = new Food("Apple", expiryDate, createDate, 100);
//        InputInterface input = new StabInput(new ArrayList<>(Arrays.asList("0", apple.getName(), "2019-12-28", "2019-09-10", String.valueOf(apple.getPrice()), "1", "2")));
//        storages.add(new WarehouseCold(new Warehouse(), -10));
//        UIStorageFood ui = new UIStorageFood(menu, input, storages);
//        ui.execute();
//        apple.setId(ui.getStorages().get(0).getFoods().get(0).getId());
//        assertThat(ui.getStorages().get(0).getFoods().toString(),
//                Is.is("[Food(id=" + apple.getId() + ", name=Apple, expiryDate=Sat Dec 28 00:00:00 MSK 2019, "
//                        + "createDate=Tue Sep 10 00:00:00 MSK 2019, price=100, disscount=0)]"));
//    }

//
//    @Test
//    public void whenAddShopWithDisscount() throws ParseException {
//        Date expiryDate = new SimpleDateFormat("yyyy-MM-dd").parse("2019-09-28");
//        Date createDate = new SimpleDateFormat("yyyy-MM-dd").parse("2019-09-10");
//        Food apple = new Food("Apple", expiryDate, createDate, 100);
//        InputInterface input = new StabInput(new ArrayList<>(Arrays.asList("0", apple.getName(), "2019-09-28", "2019-09-10", String.valueOf(apple.getPrice()), "1", "2")));
//        storages.add(new Shop());
//        UIStorageFood ui = new UIStorageFood(menu, input, storages);
//        ui.execute();
//        apple.setId(ui.getStorages().get(0).getFoods().get(0).getId());
//        assertThat(ui.getStorages().get(0).getFoods().toString(),
//                Is.is("[Food(id=" + apple.getId() + ", name=Apple, expiryDate=Sat Sep 28 00:00:00 MSK 2019, "
//                        + "createDate=Tue Sep 10 00:00:00 MSK 2019, price=100, disscount=50)]"));
//    }

}
