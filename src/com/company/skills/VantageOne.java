package com.company.skills;


import com.company.Constants;

public class VantageOne extends Skill{

    public VantageOne(){
        name = "Vantage 1";
        description = "If unit’s HP ≤ 25% and foe initiates combat, unit can counterattack before foe’s first attack.";
        skillType = Constants.SkillType.PassiveB;
        conditions = new Constants.SkillCondition[]{
                Constants.SkillCondition.Defending,
                Constants.SkillCondition.lt25
        };
    }

    @Override
    public void activate() {

    }

    @Override
    public void deactivate() {

    }
}
