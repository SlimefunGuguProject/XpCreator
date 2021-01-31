package io.github.muratkabia.xpcreator;

import io.github.muratkabia.xpcreator.items.XPCreatorItem;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
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

        SlimefunItemStack xpcreator = new SlimefunItemStack("XP_CREATOR", "955f241fe5ac449a8f9be19489372c5e", "&cXP Creator", "","&7Made by MuratKabia");
        SlimefunItemStack godPiece = new SlimefunItemStack("GOD_PIECE", "fd539892f22846caabd75ee7dbd7a901", "&aGod Piece", "&7Crafting Material", "&7Made by MuratKabia");
        ItemStack[] xpcreatorrecipe = {new ItemStack(Material.DIAMOND), new ItemStack(Material.BELL), new ItemStack(Material.DIAMOND),
                new ItemStack(Material.BELL), godPiece, new ItemStack(Material.BELL),
                new ItemStack(Material.DIAMOND), new ItemStack(Material.BELL), new ItemStack(Material.DIAMOND)
        };
        ItemStack[] godPiecerecipe = {new ItemStack(Material.DIAMOND), new ItemStack(Material.EMERALD), new ItemStack(Material.DIAMOND),
                new ItemStack(Material.EMERALD), new ItemStack(Material.ENCHANTING_TABLE), new ItemStack(Material.DIAMOND),
                new ItemStack(Material.DIAMOND), new ItemStack(Material.EMERALD), new ItemStack(Material.DIAMOND)
        };

        XPCreatorItem xpCreatorItem = new XPCreatorItem(category, xpcreator, RecipeType.ENHANCED_CRAFTING_TABLE, xpcreatorrecipe);
        SlimefunItem godPieceItem = new SlimefunItem(category, godPiece, RecipeType.ANCIENT_ALTAR, godPiecerecipe);
        xpCreatorItem.register(this);
        godPieceItem.register(this);
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
