package com.damnnnnsam.cobblemontrainerscaling.mod.common.events
import com.cobblemon.mod.common.api.Priority
import com.cobblemon.mod.common.api.battles.model.PokemonBattle
import com.cobblemon.mod.common.api.battles.model.actor.ActorType
import com.cobblemon.mod.common.api.battles.model.actor.BattleActor
import com.cobblemon.mod.common.api.events.CobblemonEvents
import com.cobblemon.mod.common.api.events.battles.BattleStartedPreEvent
class BattleEventHandler: EventHandler { override fun registerListeners() { CobblemonEvents.BATTLE_STARTED_PRE.subscribe(Priority.HIGHEST) { event -> battlePreStartHandler(event)} }private fun battlePreStartHandler(event: BattleStartedPreEvent) {if(event.battle.isPvN) scaleOpponentPokemon(event.battle) }private fun scaleOpponentPokemon(battle: PokemonBattle) { val players: List<BattleActor> = battle.actors.filter { actor-> actor.type == ActorType.PLAYER };val maxPlayerPokemonLevel: Int = players.maxOf { it.pokemonList.maxOf { pokemon ->  pokemon.originalPokemon.level }};val npcs: List<BattleActor> = battle.actors.filter { actor -> actor.type == ActorType.NPC };npcs.forEach { npc-> npc.pokemonList.forEach { pokemon -> pokemon.effectedPokemon.level = maxPlayerPokemonLevel } }}}