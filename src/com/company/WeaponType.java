package com.company;

public class WeaponType {

    private Constants.WeaponColor weaponColor;
    private Constants.DamageType damageType;

    private Constants.WeaponType weaponType;

    public WeaponType(Constants.WeaponType weapon){
        switch (weapon){
            case Sword:
                setWeaponColor(Constants.WeaponColor.Red);
                setDamageType(Constants.DamageType.Physical);
                setWeaponType(Constants.WeaponType.Sword);
                break;
            case Lance:
                setWeaponColor(Constants.WeaponColor.Blue);
                setDamageType(Constants.DamageType.Physical);
                setWeaponType(Constants.WeaponType.Lance);
                break;
            case Axe:
                setWeaponColor(Constants.WeaponColor.Green);
                setDamageType(Constants.DamageType.Physical);
                setWeaponType(Constants.WeaponType.Axe);
                break;
            case Bow:
                setWeaponColor(Constants.WeaponColor.Colorless);
                setDamageType(Constants.DamageType.Physical);
                setWeaponType(Constants.WeaponType.Bow);
                break;
            case Dagger:
                setWeaponColor(Constants.WeaponColor.Colorless);
                setDamageType(Constants.DamageType.Physical);
                setWeaponType(Constants.WeaponType.Dagger);
                break;
            case Staff:
                setWeaponColor(Constants.WeaponColor.Colorless);
                setDamageType(Constants.DamageType.Magical);
                setWeaponType(Constants.WeaponType.Staff);
                break;
            case RedTome:
                setWeaponColor(Constants.WeaponColor.Red);
                setDamageType(Constants.DamageType.Magical);
                setWeaponType(Constants.WeaponType.RedTome);
                break;
            case BlueTome:
                setWeaponColor(Constants.WeaponColor.Blue);
                setDamageType(Constants.DamageType.Magical);
                setWeaponType(Constants.WeaponType.BlueTome);
                break;
            case GreenTome:
                setWeaponColor(Constants.WeaponColor.Green);
                setDamageType(Constants.DamageType.Magical);
                setWeaponType(Constants.WeaponType.GreenTome);
                break;
            default:
                setWeaponColor(Constants.WeaponColor.None);
                setDamageType(Constants.DamageType.None);
                setWeaponType(Constants.WeaponType.None);
                break;
        }
    }

    public Constants.WeaponColor getWeaponColor() {
        return weaponColor;
    }

    public void setWeaponColor(Constants.WeaponColor weaponColor) {
        this.weaponColor = weaponColor;
    }

    public Constants.DamageType getDamageType() {
        return damageType;
    }

    public void setDamageType(Constants.DamageType damageType) {
        this.damageType = damageType;
    }

    public Constants.WeaponType getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(Constants.WeaponType weaponType) {
        this.weaponType = weaponType;
    }
}
