package com.winsion.net.areatypes.domain.repository;


import com.winsion.net.areatypes.domain.entity.Areatypes;

public interface AreasTypeRepository extends BaseRepository<Areatypes> {
    void deleteAllByAreatypeid(String areaTypeid);
}
