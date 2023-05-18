// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY! ALL CHANGES TO IT WILL BE OVERWRITTEN ON EACH BUILD
package godot

import battle.BattleScene
import battle.entity.AbstractEntityNode
import battle.entity.character.AbstractCharacterNode
import battle.entity.character.aj.AjNode
import battle.entity.character.dogman.DogmanNode
import battle.entity.character.jad.JadNode
import battle.entity.character.kew.KewNode
import battle.entity.character.peek.PeekNode
import battle.entity.character.wiewior.WiewiorNode
import battle.entity.enemy.AbstractEnemyNode
import battle.entity.enemy.BasicEnemyNode
import game.GameManager
import godot.battle.BattleSceneRegistrar
import godot.battle.entity.AbstractEntityNodeRegistrar
import godot.battle.entity.character.AbstractCharacterNodeRegistrar
import godot.battle.entity.character.aj.AjNodeRegistrar
import godot.battle.entity.character.dogman.DogmanNodeRegistrar
import godot.battle.entity.character.jad.JadNodeRegistrar
import godot.battle.entity.character.kew.KewNodeRegistrar
import godot.battle.entity.character.peek.PeekNodeRegistrar
import godot.battle.entity.character.wiewior.WiewiorNodeRegistrar
import godot.battle.entity.enemy.AbstractEnemyNodeRegistrar
import godot.battle.entity.enemy.BasicEnemyNodeRegistrar
import godot.game.GameManagerRegistrar
import godot.graphics.BattleCameraRegistrar
import godot.graphics.SmoothCameraRegistrar
import godot.registration.Entry
import godot.registration.Entry.Context
import godot.ui.PregameMenuRegistrar
import godot.ui.PrimaryUIRegistrar
import godot.ui.battle.DamageNumberRegistrar
import godot.ui.battle.EntityOverlayRegistrar
import godot.ui.battle.HealthbarRegistrar
import godot.ui.battle.PlayerOverlayRegistrar
import godot.utils.helpers.JvmFacadeRegistrar
import graphics.BattleCamera
import graphics.SmoothCamera
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.listOf
import kotlin.reflect.KClass
import ui.PregameMenu
import ui.PrimaryUI
import ui.battle.DamageNumber
import ui.battle.EntityOverlay
import ui.battle.Healthbar
import ui.battle.PlayerOverlay
import utils.helpers.JvmFacade

public class Entry : Entry() {
  public override fun Context.`init`(): Unit {
    BattleSceneRegistrar().register(registry)
    AbstractEntityNodeRegistrar().register(registry)
    AbstractCharacterNodeRegistrar().register(registry)
    AjNodeRegistrar().register(registry)
    DogmanNodeRegistrar().register(registry)
    JadNodeRegistrar().register(registry)
    KewNodeRegistrar().register(registry)
    PeekNodeRegistrar().register(registry)
    WiewiorNodeRegistrar().register(registry)
    AbstractEnemyNodeRegistrar().register(registry)
    BasicEnemyNodeRegistrar().register(registry)
    GameManagerRegistrar().register(registry)
    BattleCameraRegistrar().register(registry)
    SmoothCameraRegistrar().register(registry)
    PregameMenuRegistrar().register(registry)
    PrimaryUIRegistrar().register(registry)
    DamageNumberRegistrar().register(registry)
    EntityOverlayRegistrar().register(registry)
    HealthbarRegistrar().register(registry)
    PlayerOverlayRegistrar().register(registry)
    JvmFacadeRegistrar().register(registry)
  }

  public override fun Context.initEngineTypes(): Unit {
    registerVariantMapping()
    registerEngineTypes()
    registerEngineTypeMethods()
  }

  public override fun Context.getRegisteredClasses(): List<KClass<*>> = listOf(BattleScene::class,
      AbstractEntityNode::class, AbstractCharacterNode::class, AjNode::class, DogmanNode::class,
      JadNode::class, KewNode::class, PeekNode::class, WiewiorNode::class, AbstractEnemyNode::class,
      BasicEnemyNode::class, GameManager::class, BattleCamera::class, SmoothCamera::class,
      PregameMenu::class, PrimaryUI::class, DamageNumber::class, EntityOverlay::class,
      Healthbar::class, PlayerOverlay::class, JvmFacade::class)
}
