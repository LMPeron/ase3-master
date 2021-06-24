package br.pucpr.ed.ase3.util;

import br.pucpr.ed.ase3.list.List;
import br.pucpr.ed.ase3.list.UnorderedArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Timer {
    private Map<String, List<Long>> timers;

    public Timer() {
        this.timers = new LinkedHashMap<>();
    }

    public void startTimer(String timerId){
        timers.put(timerId, new UnorderedArrayList<>(4));
        timers.get(timerId).add(System.currentTimeMillis());
    }

    public void addStop(String timerId){
        if(timers.get(timerId) == null){
            throw new RuntimeException("Timer não iniciado");
        }
        timers.get(timerId).add(System.currentTimeMillis());
    }

    public List<Long> getResult(String timerId){
        if(timers.get(timerId).size() < 2){
            throw new RuntimeException("Não é possível obter o resultado sem ao menos 1 ponto de parada.");
        }
        List<Long> result = new UnorderedArrayList<>(timers.get(timerId).size()-1);
        for(int i = 0; i < timers.get(timerId).size() -1; i++){
            result.add(timers.get(timerId).get(i+1) - timers.get(timerId).get(i));
        }
        return result;
    }

    public Long getTotal(String timerId){
        if(timers.get(timerId).size() < 2){
            throw new RuntimeException("Não é possível obter o resultado sem ao menos 1 ponto de parada.");
        }
        List<Long> times = timers.get(timerId);
        return times.get(times.size()-1) - times.get(0);
    }

    public Set<String> getTimerIds(){
        return timers.keySet();
    }
}
