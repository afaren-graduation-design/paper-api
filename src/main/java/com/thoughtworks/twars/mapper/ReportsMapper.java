package com.thoughtworks.twars.mapper;


import com.thoughtworks.twars.bean.Paper;

import java.util.List;
import java.util.Map;

public interface ReportsMapper {

    List<Map> selectData(Map map);
}
