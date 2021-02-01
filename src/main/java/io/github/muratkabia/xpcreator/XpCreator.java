package io.github.muratkabia.xpcreator;

import io.github.muratkabia.xpcreator.items.HealthyHeartItem;
import io.github.muratkabia.xpcreator.items.XPCreatorItem;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.implementation.items.medical.Medicine;
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

        SlimefunItemStack xpcreator = new SlimefunItemStack("XP_CREATOR", "87d885b32b0dd2d6b7f1b582a34186f8a5373c46589a273423132b448b803462", "&cXP Creator", "","&7Made by MuratKabia");
        SlimefunItemStack godPiece = new SlimefunItemStack("GOD_PIECE", "fc8b1f6bbb0e2a1a9e08b4346dfaa61a3949436c792f54308a48a80e5f9d829a", "&aGod Piece", "&7Crafting Material", "&7Made by MuratKabia");
        SlimefunItemStack healthyHeart = new SlimefunItemStack("HEALTHY_HEART", "4dfada67cb261410a24890ec74d1cb605517df1469c19bdc5fe3aa448877c621", "&aHealthy &cHeart", "&7Place to use the item to regenerate health.", "&7Crafting Material", "&7Made by MuratKabia");
        SlimefunItemStack godApple = new SlimefunItemStack("GOD_APPLE", Material.ENCHANTED_GOLDEN_APPLE, "&aHumanmade &cEnchanted Golden Apple", "", "&7Made by MuratKabia");
        ItemStack[] xpcreatorrecipe = {new ItemStack(Material.DIAMOND), new ItemStack(Material.BELL), new ItemStack(Material.DIAMOND),
                new ItemStack(Material.BELL), godPiece, new ItemStack(Material.BELL),
                new ItemStack(Material.DIAMOND), new ItemStack(Material.BELL), new ItemStack(Material.DIAMOND)
        };
        ItemStack[] godPiecerecipe = {new ItemStack(Material.DIAMOND), new ItemStack(Material.EMERALD), new ItemStack(Material.DIAMOND),
                new ItemStack(Material.EMERALD), new ItemStack(Material.ENCHANTING_TABLE), new ItemStack(Material.EMERALD),
                new ItemStack(Material.DIAMOND), new ItemStack(Material.EMERALD), new ItemStack(Material.DIAMOND)
        };
        ItemStack[] healtyHeartrecipe = {new ItemStack(Material.DIAMOND), SlimefunItems.MEDICINE, new ItemStack(Material.GOLD_BLOCK),
                SlimefunItems.MEDICINE, godPiece, SlimefunItems.MEDICINE,
                new ItemStack(Material.GOLD_BLOCK), SlimefunItems.MEDICINE, new ItemStack(Material.DIAMOND)
        };
        ItemStack[] godApplerecipe = {
                new ItemStack(Material.GOLDEN_APPLE), SlimefunItems.TALISMAN_LAVA, new ItemStack(Material.GOLDEN_APPLE),
                SlimefunItems.GOLDEN_APPLE_JUICE, new ItemStack(Material.APPLE), SlimefunItems.TALISMAN_MAGICIAN,
                healthyHeart, healthyHeart, healthyHeart
        };

        XPCreatorItem xpCreatorItem = new XPCreatorItem(category, xpcreator, RecipeType.ANCIENT_ALTAR, xpcreatorrecipe);
        SlimefunItem godPieceItem = new SlimefunItem(category, godPiece, RecipeType.ANCIENT_ALTAR, godPiecerecipe);
        HealthyHeartItem healthyHeartItem = new HealthyHeartItem(category, healthyHeart, RecipeType.ANCIENT_ALTAR, healtyHeartrecipe);
        SlimefunItem godAppleItem = new SlimefunItem(category, godApple, RecipeType.ANCIENT_ALTAR, godApplerecipe);
        xpCreatorItem.register(this);
        godPieceItem.register(this);
        healthyHeartItem.register(this);
        godAppleItem.register(this);
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
