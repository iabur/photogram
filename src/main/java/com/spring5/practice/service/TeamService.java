package com.spring5.practice.service;
import com.spring5.practice.dtos.TeamDto;
import com.spring5.practice.exceptions.ResourceNotFoundException;
import com.spring5.practice.model.Team;
import com.spring5.practice.repositories.CountryRepository;
import com.spring5.practice.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service

@Transactional

public class TeamService {



    @Autowired

    private CountryRepository countryRepository;

    @Autowired
    private TeamRepository teamRepository;




/*

    public void saveEditedCourse(Course c) {



        var course = courseRepository.findByCourseId(c.getCourseId());

        BeanUtils.copyProperties(c, course);

        course.setCourseCode(course.getCourseName().substring(0, 2));

        courseRepository.save(course);



    }



    public Course getCourseByCourseCode(String courseCode) {

        var course = courseRepository.findByCourseCode(courseCode);

        return course;

    }

*/

    public List<Team> getAllTeam() {
        var teams = teamRepository.findAll();
        if(teams.size()==0){
            throw new ResourceNotFoundException("There is no Teams");
        }
        return teamRepository.findAll();

    }

    public void save(TeamDto teamDto) {
        var team = new Team();
        var country = countryRepository.findById(teamDto.getCountryId()).get();
        team.setCountry(country);
        team.setTeamName(teamDto.getTeamName());
        teamRepository.save(team);
    }
    public void  saveEdit(TeamDto teamDto){
        var team = teamRepository.findById(teamDto.getTeamId()).get();
        team.setTeamName(teamDto.getTeamName());
        var country = countryRepository.findById(teamDto.getCountryId());
        team.setCountry(country.get());
        teamRepository.save(team);

    }
    public void deleteTeam(Long id){
      var team =  teamRepository.findById(id).get();
      team.setActive(false);
      teamRepository.save(team);
    }

    public Team teamById(Long id){
      return   teamRepository.findById(id).get();
    }
}