package com.lzq.junit;

import com.lzq.mapper.ProjectMapper;
import com.lzq.pojo.Project;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.xml.crypto.Data;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestProject {
    @Test
    public void testCreateProject(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        ProjectMapper mapper = ac.getBean(ProjectMapper.class);
        Project project = new Project();
        project.setProName("21we");
        project.setUserId(1);
        project.setProDescription("sadsdaq2e");
        mapper.createProject(project);
    }

    @Test
    public void testGetProjectsByUserId(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        ProjectMapper mapper = ac.getBean(ProjectMapper.class);
        mapper.getProjectsByUserId(1);
    }

    public static void main(String args[]){
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(new Timestamp(System.currentTimeMillis()));// new Date()为获取当前系统时间
    }
}
