package com.spring5.practice.dtos;

public class TeamDto {
    Long teamId;
    Long countryId;
    String teamName;

    public Long getTeamId(){
        return teamId;
    }
    public void setTeamId(Long id){
        teamId = id;
    }
    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
