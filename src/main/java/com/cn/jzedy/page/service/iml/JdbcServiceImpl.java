package com.cn.jzedy.page.service.iml;

import com.cn.jzedy.page.entity.Page;
import com.cn.jzedy.page.service.JdbcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by Jzedy on 2018/4/10
 */
@Service(value = "jdbcService")
public class JdbcServiceImpl implements JdbcService {

    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

//    private List<Map<String, Object>> search(String sql, Object[] params) {
//        return  jdbcTemplate.queryForList(sql, params);
//    }
    private List<String> searchTitles(String sql,Object[] params){
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql, params);
        SqlRowSetMetaData metaData = sqlRowSet.getMetaData();
        return Arrays.asList(metaData.getColumnNames());
    }




    @Override
    public Page findPage(String sql, Object[] params,int pageNum,int pageSize) {
        //为了得到sql总数
        StringBuffer buf = new StringBuffer("select count(1) from (");
        buf.append(sql).append(") temp ");
        long total = (long) jdbcTemplate.queryForList(buf.toString(),params).get(0).get("count(1)");

        StringBuffer buffer = new StringBuffer(sql);
        buffer.append(" limit ").append((pageSize-1)*pageNum).append(",").append(pageNum);
        List<Map<String, Object>> contents = jdbcTemplate.queryForList(buffer.toString(), params);

        return new Page(pageNum,pageSize,total,contents);
    }


}
