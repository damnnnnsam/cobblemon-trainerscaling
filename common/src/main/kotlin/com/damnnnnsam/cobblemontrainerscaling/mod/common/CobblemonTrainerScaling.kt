package com.damnnnnsam.cobblemontrainerscaling.mod.common

import com.mojang.logging.LogUtils.getLogger
import org.slf4j.Logger
import com.damnnnnsam.cobblemontrainerscaling.mod.common.events.BattleEventHandler

object CobblemonTrainerScaling {
    const val MOD_ID = "cobblemontrainerscaling"
    const val VERSION = "1.0.0"
    val battleEventHandler: BattleEventHandler = BattleEventHandler()

    val LOGGER: Logger = getLogger()

    fun init() {
        LOGGER.info("REGISTERING EVENT HANDLERS")
        battleEventHandler.registerListeners()
    }
}