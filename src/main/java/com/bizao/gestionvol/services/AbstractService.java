package com.bizao.gestionvol.services;

import java.util.List;

public interface AbstractService<Entity>
{
    Entity save(Entity dto);

    Entity findById(Integer id);

    List<Entity> findAll();

    void delete(Integer id);
}
