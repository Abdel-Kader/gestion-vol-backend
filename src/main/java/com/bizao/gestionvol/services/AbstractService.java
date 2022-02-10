package com.bizao.gestionvol.services;

import java.util.List;

public interface AbstractService<Entity>
{
    Entity save(Entity dto);

    List<Entity> findAll();

}
