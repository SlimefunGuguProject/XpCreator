package io.github.muratkabia.xpcreator;

import io.github.muratkabia.xpcreator.items.XPCreatorItem;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.cscorelib2.config.Config;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;

import java.util.logging.Logger;

public class XpCreator extends JavaPlugin implements SlimefunAddon {

    @Override
    public void onEnable() {

        System.out.println("XPCreator activated");

        Config cfg = new Config(this);

        ItemStack categoryItem = new CustomItem(Material.EXPERIENCE_BOTTLE, "&4XP Creator", "", "&a> Açmak için tıklayın");

        NamespacedKey categoryId = new NamespacedKey(this, "xp_creator");
        Category category = new Category(categoryId, categoryItem);

        SlimefunItemStack xpcreator = new SlimefunItemStack("XP_CREATOR", Material.PLAYER_HEAD, "&7XP Creator", "","&7Made by MuratKabia");
        ItemStack[] xpcreatorrecipe = {new ItemStack(Material.EMERALD), null, new ItemStack(Material.DIAMOND),
                null, new ItemStack(Material.BELL), null,
                null, new ItemStack(Material.BELL), null
        };

        XPCreatorItem xpCreatorItem = new XPCreatorItem(category, xpcreator, RecipeType.ENHANCED_CRAFTING_TABLE, xpcreatorrecipe);
        xpCreatorItem.register(this);
    }

    @Override
    public void onDisable() {
        // Logic for disabling the plugin...
    }

    @Override
    public String getBugTrackerURL() {
        // You can return a link to your Bug Tracker instead of null here
        return null;
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        /*
         * You will need to return a reference to your Plugin here.
         * If you are using your main class for this, simply return "this".
         */
        return this;
    }

}
