package com.net.winsion.areas.domain.repository;


import com.net.winsion.areas.domain.entity.Areas;

public interface AreasRepository   extends BaseRepository<Areas> {

    void deleteAllByAreatypeid(String areatypeid);
}
