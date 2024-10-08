package me.shadowsense.aktier.userinterface.guis.stocklist;

import eu.okaeri.injector.annotation.Inject;
import eu.okaeri.platform.core.annotation.Component;
import me.shadowsense.aktier.database.StoreManager;
import me.shadowsense.aktier.invest.objects.Stock;
import me.shadowsense.aktier.userinterface.AktieGUI;
import me.shadowsense.aktier.userinterface.guis.home.Home;
import me.shadowsense.aktier.userinterface.util.Button;
import org.bukkit.entity.Player;

@Component
public class StockList {

    private @Inject StoreManager storeManager;

    public void open(Player player) {
        new GUI(player).open(player);
    }

    public class GUI extends AktieGUI<StockListConfig> {


        public GUI(Player player) {
            super(new StockListConfig());
            Button.setBack(this, 36, () -> new Home().open(player));
            setStocksList();

        }

        private void setStocksList() {
            int i = 9;
            for (Stock stock : storeManager.getStockStore().getAll()) {
                System.out.println("Stock: " + stock.getName() + " " + stock.getPrice() + " " + stock.getRisk());
                setItem(i, getConfig().getStockItem().getItem(), stock);
                i++;
            }
        }


    }


}
