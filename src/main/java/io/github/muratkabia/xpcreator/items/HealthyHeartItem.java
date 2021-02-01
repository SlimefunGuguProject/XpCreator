package io.github.muratkabia.xpcreator.items;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockUseHandler;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Location;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class HealthyHeartItem extends SlimefunItem {

    public HealthyHeartItem(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe){
        super(category, item, recipeType, recipe);
    }

    @Override
    public void preRegister() {
        BlockUseHandler itemUseHandler = this::onItemRightClick;
        addItemHandler(itemUseHandler);
    }

    private void onItemRightClick(PlayerRightClickEvent event) {
        Player target = event.getPlayer();
        target.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 10, 1, true, false));
        target.sendMessage("&aHealthy Heart &c>> &aGave you &lregeneration&r&a for &l10 &r&aseconds with amplifier &l1");
    }

}
