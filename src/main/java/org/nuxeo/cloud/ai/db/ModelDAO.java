package org.nuxeo.cloud.ai.db;

import java.util.List;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import org.nuxeo.cloud.ai.model.Model;

public interface ModelDAO {

    @SqlUpdate("INSERT INTO model(id, name) VALUES (:id, :name)")
    void insertBean(@BindBean Model model);


    @SqlQuery("SELECT * FROM model ORDER BY name")
    @RegisterBeanMapper(Model.class)
    List<Model> listModels();
}
