package adamsjac.dev.runners.run;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class RunRepository {
    private List<Run> runs = new ArrayList<>();
    
    List<Run> findAll(){
        return runs;
    }

    Optional<Run> findOne(Integer id){
        return runs
            .stream()
            .filter(run -> run.id() == id)
            .findFirst();
    }

    void updateOne(Run newRun, Integer id){
        Optional<Run> run = findOne(id);
        if(run.isPresent()){
            runs.set(runs.indexOf(run.get()),newRun);
        }
    }

    void createOne(Run run){
        runs.add(run);
    }

    @PostConstruct
    private void init(){
        runs.add(
            new Run(
                1, 
                "first run", 
                LocalDateTime.now(), 
                LocalDateTime.now().plus(1,ChronoUnit.HOURS),
                5,
                Location.OUTDOOR
            )
        );

        runs.add(
            new Run(
                2, 
                "Second run", 
                LocalDateTime.now(), 
                LocalDateTime.now().plus(1,ChronoUnit.HOURS),
                10,
                Location.INDOOR
            )
        );
    }
}
