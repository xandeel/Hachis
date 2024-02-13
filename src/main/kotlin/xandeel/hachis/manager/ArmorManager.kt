package xandeel.hachis.manager

import org.bukkit.Material
import org.bukkit.Color
import org.bukkit.entity.Player

import xandeel.hachis.Hachis
import xandeel.hachis.user.cosmetic.armor.Armor

class ArmorManager {

    private val armors: MutableList<Armor> = arrayListOf()

    init {
        val section = Hachis.instance.armorcfg.config.getConfigurationSection("armors")
        if (section != null) {
            for (armor in section.getKeys(false)) {
                val name = section.getString(armor)
                val permission = "hachis.armor.$armor"
                val icon = Material.valueOf(section.getString("$armor.icon"))
                val data = section.getInt("$armor.icon-data")
                val color = Color.fromRGB(section.getInt("$armor.armor-color"))

                armors.add(Armor(name, permission, icon, data, color))
            }
        }
    }

    fun getArmorAndEquip(player: Player, armor: Armor) {
        if (player.hasPermission(armor.permission)) {
            armor.equip(player, armor.color)
        }
    }

    fun getArmorByName(name: String): Armor? {
        for (armor in armors) {
            if (armor.name.equals(name, ignoreCase = true)) {
                return armor
            }
        }

        return null
    }
}
