package bdbt_bada_project.SpringApplication;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class PocztyDAO {
    public PocztyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Poczta> list(){
        String sql = "SELECT * FROM SALES";

        List<Poczta> listPoczta = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Poczta.class));
        return listPoczta;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Poczta poczta) {
    }
    /* Read – odczytywanie danych z bazy */
    public Poczta get(int nr_poczty) {
        return null;
    }
    /* Update – aktualizacja danych */
    public void update(Poczta poczta) {
    }
    /* Delete – wybrany rekord z danym id */
    public void delete(int nr_poczty) {
    }

}
