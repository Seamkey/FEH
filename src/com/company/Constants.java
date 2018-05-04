package com.company;

public class Constants {
    private Constants(){}

    public static enum SkillType {PassiveA, PassiveB, PassiveC, Special, Assist, None}

    public static enum SkillCondition {
        InCombat, Attacking, Defending, FoeIniateCombat, InitiateCombat,
        lt25, lt50, lt75
    }

    public static enum WeaponType {Sword, Lance, Axe, Bow, Dagger, Staff, RedTome, BlueTome, GreenTome, None}

    public static enum DamageType {Physical, Magical, None}

    public static enum WeaponColor {Red, Blue, Green, Colorless, None}
}
