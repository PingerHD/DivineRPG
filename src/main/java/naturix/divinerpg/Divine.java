package naturix.divinerpg;

import naturix.divinerpg.proxy.CommonProxy;
import naturix.divinerpg.utils.ModRecipes;
import naturix.divinerpg.utils.world.*;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = Divine.modId, name = Divine.name, version = Divine.version)
public class Divine {

	public static final String modId = "divinerpg";
	public static final String name = "Divine RPG";
	public static final String version = "1.12.2.0";
	
	@SidedProxy(serverSide = "naturix.divinerpg.proxy.CommonProxy", clientSide = "naturix.divinerpg.proxy.ClientProxy")
	public static CommonProxy proxy;
	
	@Mod.Instance(modId)
	public static Divine instance;
	public static org.apache.logging.log4j.Logger logger;

	 @Mod.EventHandler
	    public void preInit(FMLPreInitializationEvent event) {
	        logger = event.getModLog();
	        proxy.preInit(event);
	        logger.info(name + " is now loading");
	        GameRegistry.registerWorldGenerator(new ModWorldGen(), 3);
	        
	    }

	    @Mod.EventHandler
	    public void init(FMLInitializationEvent e) {
	        proxy.init(e);
	    }

	    @Mod.EventHandler
	    public void postInit(FMLPostInitializationEvent e) {
	        proxy.postInit(e);
	        logger.info(name + " is now loaded");
	    }
	    @Mod.EventBusSubscriber
		public static class RegistrationHandler {
		
			@SubscribeEvent
			public static void registerItems(RegistryEvent.Register<Item> event) {
				ModItems.register(event.getRegistry());
				ModBlocks.registerItemBlocks(event.getRegistry());
				ModRecipes.init();
			}
			@SubscribeEvent
			public static void registerItems(ModelRegistryEvent event) {
				ModItems.registerModels();
				ModBlocks.registerModels();
				
			}
	    	@SubscribeEvent
	    	public static void registerBlocks(RegistryEvent.Register<Block> event) {
	    		ModBlocks.register(event.getRegistry());
	    	}
	    }
	    public static final CreativeTabs BlocksTab = new CreativeTabs("Blocks")
	    {

	        @SideOnly(Side.CLIENT)
	        public ItemStack getTabIconItem()
	        {
	            return new ItemStack(ModBlocks.oreArlemite);
	        }
			
	    };
	    public static final CreativeTabs ItemsTab = new CreativeTabs("Item")
	    {

	        @SideOnly(Side.CLIENT)
	        public ItemStack getTabIconItem()
	        {
	            return new ItemStack(ModItems.ingotArlemite);
	        }
			
	    };
	    public static final CreativeTabs CombatTab = new CreativeTabs("Combat")
	    {

	        @SideOnly(Side.CLIENT)
	        public ItemStack getTabIconItem()
	        {
	            return new ItemStack(ModItems.arlemiteSword);
	        }
			
	    };
}