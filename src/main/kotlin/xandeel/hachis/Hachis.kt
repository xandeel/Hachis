package xandeel.hachis

import org.bukkit.plugin.java.JavaPlugin
import xandeel.hachis.layout.ScoreboardLayout
import xandeel.hachis.listener.wListener
import xandeel.hachis.manager.ArmorManager
import xandeel.hachis.utils.config.FileConfig


class Hachis : JavaPlugin() {

    val armorcfg by lazy { FileConfig(this, "armors.yml")}
    val settingscfg by lazy { FileConfig(this, "settings.yml")}
    val messagecfg by lazy { FileConfig(this, "message.yml")}
    val scoreboardcfg by lazy { FileConfig(this, "sbr.yml")}


    companion object {
        @JvmStatic
        lateinit var instance: Hachis
    }

    override fun onEnable() {
        instance = this

        armorcfg.save()
        settingscfg.save()
        messagecfg.save()
        scoreboardcfg.save()

        //Manager
        ScoreboardLayout()
        ArmorManager()

        //listener
        wListener()

    }
}