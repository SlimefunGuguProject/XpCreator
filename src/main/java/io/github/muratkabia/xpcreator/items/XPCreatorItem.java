package io.github.muratkabia.xpcreator.items;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockUseHandler;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class XPCreatorItem extends SlimefunItem {

    public XPCreatorItem(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe){
        super(category, item, recipeType, recipe);
    }

    @Override
    public void preRegister() {
        BlockUseHandler blockUseHandler = this::onBlockRightClick;
        addItemHandler(blockUseHandler);
    }

    private void onBlockRightClick(PlayerRightClickEvent event) {
        Player target = event.getPlayer();
        Inventory targetInventory = target.getInventory();
        if (targetInventory.containsAtLeast(new ItemStack(Material.DIAMOND), 1)) {
            target.getInventory().remove(Material.DIAMOND);
            target.giveExp(2000);
            target.sendMessage("&cXP Creator &7>> &aYour xp has been given in an exchange of an diamond");
        } else {
            target.sendMessage("&cXP Creator &7>> &4You do not have the required item for xp. You need an diamond in your inventory. Now because you tried toı fool the gods, you will be punished!");
            target.setFireTicks(10 * 20);
        }
    }

}
