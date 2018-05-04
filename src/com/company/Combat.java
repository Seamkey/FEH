package com.company;

import java.util.LinkedList;
import static com.company.Constants.*;

public class Combat {

    private static LinkedList<Unit> exchange = new LinkedList<>();

    private static final int spdDif = 5;
    private static final double advantage = 0.2;

    private Combat(){}

    public static void start(Unit aggressor, Unit defender){ //TODO Use strategy design pattern for attack order with skills maybe
        aggressor.updateCondition(SkillCondition.Attacking, true);
        defender.updateCondition(SkillCondition.Defending, true);
        aggressor.updateCondition(SkillCondition.InCombat, true);
        defender.updateCondition(SkillCondition.InCombat, true);

        exchange.clear();

        exchange.addLast(aggressor);
        exchange.addLast(defender);
        if (aggressor.getSpd()>defender.getSpd()+spdDif) exchange.addLast(aggressor);
        else if (aggressor.getSpd()+spdDif<defender.getSpd()) exchange.addLast(defender);

        for (Unit unit : exchange){
            if (unit.isDefeated()) break;
            if (unit.equals(defender)) attack(unit, aggressor);
            else attack(unit, defender);
        }

        System.out.println(String.format("%s | %s", aggressor, defender));
        System.out.println();


        aggressor.updateCondition(SkillCondition.Attacking, false);
        defender.updateCondition(SkillCondition.Defending, false);
        aggressor.updateCondition(SkillCondition.InCombat, false);
        defender.updateCondition(SkillCondition.InCombat, false);
    }

    private static void attack(Unit aggressor, Unit defender){
        String attack = String.format("%s attacks %s", aggressor.getName(), defender.getName());
        System.out.println(attack);
        int attackPower = aggressor.getStr() + aggressor.getWeapon().getMight(); //TODO maybe awakening attack formula?
        attackPower *= getTriangleAdvantage(aggressor.getWeapon(), defender.getWeapon());

        int defensePower = calculateDefense(aggressor.getWeapon(), defender) + defender.getTerrainBonus(); //Defense Power of the defender
        int damage = Math.max(attackPower - defensePower, 0); //make sure damage is >= 0
        String defense = String.format("%s takes %d damage", defender.getName(), Math.min(damage, defender.getRemainingHp()));
        System.out.println(defense);
        defender.setRemainingHp(defender.getRemainingHp() - damage);
    }

    private static int calculateDefense(Weapon attacking, Unit defender){
        if(attacking.getWeaponType().getDamageType() == DamageType.Physical) return defender.getDef();
        return defender.getRes();
    }

    private static double getTriangleAdvantage(Weapon attacking, Weapon defending){
        if (compareWeaponTriangle(attacking.getWeaponType().getWeaponColor(), defending.getWeaponType().getWeaponColor()))
            return 1+advantage; //aggressor has weapon advantage
        if (compareWeaponTriangle(defending.getWeaponType().getWeaponColor(), attacking.getWeaponType().getWeaponColor()))
            return 1-advantage; //defender has weapon advantage
        return 1; //No weapon advantage
    }

    private static boolean compareWeaponTriangle (WeaponColor attacking, WeaponColor defending){
        if (attacking == WeaponColor.Red && defending == WeaponColor.Green) return true;
        if (attacking == WeaponColor.Green && defending == WeaponColor.Blue) return true;
        if (attacking == WeaponColor.Blue && defending == WeaponColor.Red) return true;
        return false;
    }

}
