package com.company.skills;

import com.company.Constants;

public class NoSkill extends Skill {

    public NoSkill(){
        name="None";
        description = "";
        skillType = Constants.SkillType.None;
    }

    @Override
    public void activate() {

    }

    @Override
    public void deactivate() {

    }


}
