package com.company;

public class Constants {
    private Constants(){}

    public static int MAP_HEIGHT = 8;
    public static int MAP_WIDTH = 6;

    public static enum SkillType {PassiveA, PassiveB, PassiveC, Special, Assist, None}

    public static enum SkillCondition {
        InCombat, Attacking, Defending,
        lt25, lt50, lt75, None
    }

    public static enum WeaponType {Sword, Lance, Axe, Bow, Dagger, Staff, RedTome, BlueTome, GreenTome, None}

    public static enum DamageType {Physical, Magical, None}

    public static enum WeaponColor {Red, Blue, Green, Colorless, None}
}
