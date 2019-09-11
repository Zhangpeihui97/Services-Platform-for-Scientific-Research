package com.research;

import com.research.configuration.Entry;
import com.research.constant.WebConstant;
import com.research.dao.RoleMapper;
import com.research.dao.UserMapper;
import com.research.model.Vo.Role;
import com.research.model.Vo.RoleExample;
import com.research.model.Vo.User;
import com.research.model.Vo.UserExample;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


/**
 * 测试事务可靠性以及文件存储位置
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Entry.class)
public class TranscationTest {
    @Autowired
    RoleMapper roleMapper;
    @Test
    @Transactional
    public void test() throws IOException{
        Role role  = new Role();
        role.setNameEn("test");
        roleMapper.insert(role);
        RoleExample re= new RoleExample();
        re.createCriteria().andNameEnEqualTo("test");
        List<Role> list =roleMapper.selectByExample(re);
        System.out.println(list.size());
        File file = new File(WebConstant.FILE_LOCATIONS);
        if(!file.exists()){
            file.mkdirs();
        }
        file = new File(file.getPath()+File.separator+"1.txt");
//        try {
            FileOutputStream fos = new FileOutputStream(file);
            PrintWriter pw = new PrintWriter(fos);
            pw.println("jjj");
            pw.flush();
            pw.close();
            fos.close();
//        }catch (IOException ioe){
//            System.out.println(ioe);
//        }
    }

    @After
    public void after(){
        RoleExample re= new RoleExample();
         re.createCriteria().andNameEnEqualTo("test");
        List<Role> list =roleMapper.selectByExample(re);
        System.out.println(list.size()+"number");
//        roleMapper.deleteByExample(re);
    }

}
