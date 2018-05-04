package com.company.skills;

import com.company.Constants;

public class AtkDefOneSkill extends Skill{

    private int boost = 1;

    public AtkDefOneSkill(){
        name = "Atk/Def 1";
        description = "Grants Atk/Def+1.";
        skillType = Constants.SkillType.PassiveA;
        conditions = new Constants.SkillCondition[0]; //active when equipped
    }

    @Override
    public void activate() {
        unit.setStr(unit.getStr()+boost);
        unit.setDef(unit.getDef()+boost);
    }

    @Override
    public void deactivate() {
        unit.setStr(unit.getStr()-boost);
        unit.setDef(unit.getDef()-boost);
    }

    
}
