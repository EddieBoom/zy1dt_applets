package com.zy1dt.entity;

public class CollegeType {
    private String sprint;//冲刺型
    private String safe;//稳妥型
    private String conservative;//保守型



    public void setConservative(String conservative) {
        if (conservative==null || conservative==""){
            this.conservative = "0";
        }else {
            this.conservative = conservative;
        }
    }

    public void setSafe(String safe) {
        if(safe==null || safe==""){
            this.safe = "0";
        }else {
            this.safe = safe;
        }
    }

    public void setSprint(String sprint) {
        if(sprint==null || sprint==""){
            this.sprint = "0";
        }else{
            this.sprint = sprint;
        }
    }

    public String getConservative() {
        return conservative;
    }

    public String getSafe() {
        return safe;
    }

    public String getSprint() {
        return sprint;
    }


}
