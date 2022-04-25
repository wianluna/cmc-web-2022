package dao;

import models.Expeditions;
import utils.SessionUtilImpl;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;


public class ExpeditionsDAO extends SessionUtilImpl implements DAO<Expeditions> {
    public List<Expeditions> getByDate(Date start,
                                                          Date end) {
        List<Expeditions> expeditions = this.getAll(Expeditions.class);

        return expeditions.stream()
                .filter(e -> e.getDateStart().before(end) && e.getDateStart().after(start)
                        && e.getDateEnd().after(start) && e.getDateEnd().after(start))
                .collect(Collectors.toList());
    }
}