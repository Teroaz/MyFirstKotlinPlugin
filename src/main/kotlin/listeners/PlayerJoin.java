package listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.json.JSONObject;
import utils.NMSUtils;

import java.util.Collection;
import java.util.Map;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onPrelogin(PlayerJoinEvent event) {
        JSONObject jsonObject = new JSONObject("{\"customName\":\"Teroaz_\",\"signature\":\"cQbIox1VNY+k1g3O1uifAET7QPu81PiQb1x3pk4HJyKiQeHlMbGfGXf8xHbjqbH4TAYDJbJNSyskr9nj7CVW/9kNuTMka/58ur1Kayg9BCQDJh3Jf1F9FOeUghB7TQ6sIH7KYc1Eucs32KoA4W0fqrzP9zjwS2C5O4jznyopHZDW+pKH4THh/BO2I9T6QLA9m85tjmDhRM5Mmag8QQ6aJ5tnAvW1fTdQ5L8SLQzOhORxW5L82zJ2r1ymUFiMOizut0sIKKdr/MDoCQaWv3YuUR3A4D4DxpGI2Kh++cvBxqS28Rxf2oPT6LeAuZ/HOI6DmUbyTtgWv6ejX/aVH/MhDPeLdf3MaMAcaIIseRePlg/yce3eVeFvRI3u6YjdAVA9aKL+lwjv0xBhgdBWp/ilRc//bPS5XRSDpLMZ3+BbVq7SMzgg68GDZgNYkJL0XJCX6qQyeJop2L2iKyLV52WWEuU47AydG9eGF7QgM14RCfU4NLZn0QSSSHwalcCmkRxsMiGttyXl2Fjoyd8DI7rWoQLZkxIqOqJVjhtunVI9hEy8h+jlNXUA4glQ9qGFvcNtnpAJGYZLI/hFhjaBqcugWt7O6lMLA5JqZLqHQn6fVY2UEr9zer2nlQvttes+j4eFG8aufPYzwsYyJ60e51sRELgrBelXUFA+NdNA17ROI74=\",\"value\":\"ewogICJ0aW1lc3RhbXAiIDogMTU5NzA3MTI1OTQ2NywKICAicHJvZmlsZUlkIiA6ICJhODJhZTIyZWI1Y2I0YTczYWRhMzRkNWZlNjdjZDdjZCIsCiAgInByb2ZpbGVOYW1lIiA6ICJUZXJvYXpfIiwKICAic2lnbmF0dXJlUmVxdWlyZWQiIDogdHJ1ZSwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlL2E5ZWU0MzlhMzYxNWUzMWMxYTQ1ZmFhMjYwNGM5OWJhZDljOGMzNWFiMzdkZWM3MjQ2ZmVjMDc1NTJhNzE1OGQiLAogICAgICAibWV0YWRhdGEiIDogewogICAgICAgICJtb2RlbCIgOiAic2xpbSIKICAgICAgfQogICAgfQogIH0KfQ==\"}");
        setInformation(event.getPlayer(), jsonObject);
    }

    private void setInformation(Player player, JSONObject jsonObject) {
        Object handle = NMSUtils.getHandle(player);
        Object profile = NMSUtils.invokeMethod(handle, NMSUtils.getMethod(handle.getClass(), "getProfile", new Class[0]));
        NMSUtils.setField(profile, NMSUtils.getField(NMSUtils.getMojangClass("GameProfile"), "name"), "Teroaz_");
        Object pmap = NMSUtils.invokeMethod(profile, NMSUtils.getMethod(profile.getClass(), "getProperties", new Class[0]));
        Map<Object, Collection<?>> map = (Map)NMSUtils.invokeMethod(pmap, NMSUtils.getMethod(NMSUtils.getMojangClass("properties.PropertyMap"), "asMap", new Class[0]));
        Collection<?> textures = map.get("textures");
        if (textures != null) {
            Object pro = textures.iterator().next();
            NMSUtils.setField(pro, NMSUtils.getField(NMSUtils.getMojangClass("properties.Property"), "value"), jsonObject.getString("value"));
            NMSUtils.setField(pro, NMSUtils.getField(NMSUtils.getMojangClass("properties.Property"), "signature"), jsonObject.getString("signature"));
        }
    }
}
