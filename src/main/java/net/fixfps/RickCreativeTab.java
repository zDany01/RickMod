package net.fixfps;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class RickCreativeTab extends ItemGroup{

    public RickCreativeTab(int index, String id) {
        super(index, id);
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(MainClass.RickRollBlock);
    }
    

    
}
