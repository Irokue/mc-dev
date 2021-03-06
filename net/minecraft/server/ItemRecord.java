package net.minecraft.server;

public class ItemRecord extends Item {

    public final String a;

    protected ItemRecord(int i, String s) {
        super(i);
        this.a = s;
        this.maxStackSize = 1;
        this.a(CreativeModeTab.f);
    }

    public boolean interactWith(ItemStack itemstack, EntityHuman entityhuman, World world, int i, int j, int k, int l, float f, float f1, float f2) {
        if (world.getTypeId(i, j, k) == Block.JUKEBOX.id && world.getData(i, j, k) == 0) {
            if (world.isStatic) {
                return true;
            } else {
                ((BlockJukeBox) Block.JUKEBOX).e(world, i, j, k, this.id);
                world.a((EntityHuman) null, 1005, i, j, k, this.id);
                --itemstack.count;
                return true;
            }
        } else {
            return false;
        }
    }
}
