package com.example.demo.repo;

import com.example.demo.domain.GroupParams;
import com.example.demo.domain.Parameters;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ParamsRepo {
    private final JdbcTemplate jdbcTemplate;

    public ParamsRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String FIND_PARAMS_BY_ID = "SELECT * FROM PARAMETERS WHERE id = ?";
    private static final String SAVE_PARAMS = "UPDATE PARAMETERS set parameter1 = ?,parameter2 = ?,parameter3 = ?,parameter4 = ?,parameter5 = ?," +
            "parameter6 = ?,parameter7 = ?,parameter8 = ?,parameter9 = ?,parameter10 = ?," +
            "parameter11 = ?,parameter12 = ?,parameter13 = ?,parameter14 = ?,parameter15 = ?," +
            "parameter16 = ?,parameter17 = ?,parameter18 = ?,parameter19 = ?,parameter20 = ?," +
            "parameter21 = ?,parameter22 = ?,parameter23 = ?,parameter24 = ?,parameter25 = ?," +
            "parameter26 = ?,parameter27 = ?,parameter28 = ?,parameter29 = ?,parameter30 = ?," +
            "parameter31 = ?,parameter32 = ?,parameter33 = ?,parameter34 = ?,parameter35 = ?," +
            "parameter36 = ?,parameter37 = ?,parameter38 = ? where id = 1";

    public Parameters findParamsById(int id) {
        return jdbcTemplate.queryForObject(FIND_PARAMS_BY_ID,
                new Object[]{id},
                (rs, i) -> new Parameters(
                        rs.getInt("id"),
                        rs.getDouble("parameter1"),
                        rs.getDouble("parameter2"),
                        rs.getDouble("parameter3"),
                        rs.getDouble("parameter4"),
                        rs.getDouble("parameter5"),
                        rs.getDouble("parameter6"),
                        rs.getDouble("parameter7"),
                        rs.getDouble("parameter8"),
                        rs.getDouble("parameter9"),
                        rs.getDouble("parameter10"),
                        rs.getDouble("parameter11"),
                        rs.getDouble("parameter12"),
                        rs.getDouble("parameter13"),
                        rs.getDouble("parameter14"),
                        rs.getDouble("parameter15"),
                        rs.getDouble("parameter16"),
                        rs.getDouble("parameter17"),
                        rs.getDouble("parameter18"),
                        rs.getDouble("parameter19"),
                        rs.getDouble("parameter20"),
                        rs.getDouble("parameter21"),
                        rs.getDouble("parameter22"),
                        rs.getDouble("parameter23"),
                        rs.getDouble("parameter24"),
                        rs.getDouble("parameter25"),
                        rs.getDouble("parameter26"),
                        rs.getDouble("parameter27"),
                        rs.getDouble("parameter28"),
                        rs.getDouble("parameter29"),
                        rs.getDouble("parameter30"),
                        rs.getDouble("parameter31"),
                        rs.getDouble("parameter32"),
                        rs.getDouble("parameter33"),
                        rs.getDouble("parameter34"),
                        rs.getDouble("parameter35"),
                        rs.getDouble("parameter36"),
                        rs.getDouble("parameter37"),
                        rs.getDouble("parameter38")
                )
        );
    }

    public void saveParams(Parameters parameters) {
        jdbcTemplate.update(SAVE_PARAMS,
                parameters.getParameter1(),
                parameters.getParameter2(),
                parameters.getParameter3(),
                parameters.getParameter4(),
                parameters.getParameter5(),
                parameters.getParameter6(),
                parameters.getParameter7(),
                parameters.getParameter8(),
                parameters.getParameter9(),
                parameters.getParameter10(),
                parameters.getParameter11(),
                parameters.getParameter12(),
                parameters.getParameter13(),
                parameters.getParameter14(),
                parameters.getParameter15(),
                parameters.getParameter16(),
                parameters.getParameter17(),
                parameters.getParameter18(),
                parameters.getParameter19(),
                parameters.getParameter20(),
                parameters.getParameter21(),
                parameters.getParameter22(),
                parameters.getParameter23(),
                parameters.getParameter24(),
                parameters.getParameter25(),
                parameters.getParameter26(),
                parameters.getParameter27(),
                parameters.getParameter28(),
                parameters.getParameter29(),
                parameters.getParameter30(),
                parameters.getParameter31(),
                parameters.getParameter32(),
                parameters.getParameter33(),
                parameters.getParameter34(),
                parameters.getParameter35(),
                parameters.getParameter36(),
                parameters.getParameter37(),
                parameters.getParameter38()
        );
    }

    public void saveGroupParams(GroupParams params) {
        jdbcTemplate.update(SAVE_PARAMS,
                params.getGroupParams1(),
                params.getGroupParams1(),
                params.getGroupParams1(),
                params.getGroupParams2(),
                params.getGroupParams2(),
                params.getGroupParams2(),
                params.getGroupParams3(),
                params.getGroupParams3(),
                params.getGroupParams3(),
                params.getGroupParams3(),
                params.getGroupParams4(),
                params.getGroupParams4(),
                params.getGroupParams4(),
                params.getGroupParams4(),
                params.getGroupParams4(),
                params.getGroupParams5(),
                params.getGroupParams5(),
                params.getGroupParams5(),
                params.getGroupParams5(),
                params.getGroupParams5(),
                params.getGroupParams5(),
                params.getGroupParams6(),
                params.getGroupParams6(),
                params.getGroupParams6(),
                params.getGroupParams6(),
                params.getGroupParams6(),
                params.getGroupParams6(),
                params.getGroupParams6(),
                params.getGroupParams7(),
                params.getGroupParams7(),
                params.getGroupParams7(),
                params.getGroupParams7(),
                params.getGroupParams7(),
                params.getGroupParams7(),
                params.getGroupParams7(),
                params.getGroupParams7(),
                params.getGroupParams7(),
                params.getGroupParams7());
    }

    public void saveAllParams(double allParams) {
        jdbcTemplate.update(SAVE_PARAMS,
                allParams,
                allParams,
                allParams,
                allParams,
                allParams,
                allParams,
                allParams,
                allParams,
                allParams,
                allParams,
                allParams,
                allParams,
                allParams,
                allParams,
                allParams,
                allParams,
                allParams,
                allParams,
                allParams,
                allParams,
                allParams,
                allParams,
                allParams,
                allParams,
                allParams,
                allParams,
                allParams,
                allParams,
                allParams,
                allParams,
                allParams,
                allParams,
                allParams,
                allParams,
                allParams,
                allParams,
                allParams,
                allParams
        );
    }
}
