package xandeel.hachis.utils

import net.md_5.bungee.api.ChatColor

class Chat {

    fun color(s: String?): String? {
        return ChatColor.translateAlternateColorCodes('&', s)
    }

    fun color(lines: List<String?>): List<String>? {
        val toReturn: MutableList<String> = ArrayList()
        for (line in lines) {
            toReturn.add(ChatColor.translateAlternateColorCodes('&', line))
        }
        return toReturn
    }

    fun color(lines: Array<String?>): List<String>? {
        val toReturn: MutableList<String> = ArrayList()
        for (line in lines) {
            if (line != null) {
                toReturn.add(ChatColor.translateAlternateColorCodes('&', line))
            }
        }

        return toReturn
    }

    fun strip(`in`: String?): String? {
        return ChatColor.stripColor(color(`in`))
    }
}