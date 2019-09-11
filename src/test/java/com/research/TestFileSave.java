package com.research;

import com.research.configuration.Entry;
import com.research.utils.FileUtil;
import org.apache.coyote.InputBuffer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Entry.class)
public class TestFileSave {
    @Before
    public static void before(){

    }

    @Test
    public static void test() throws IOException {
        File file = new File("C:"+File.separator+"1.txt");
        FileOutputStream fos = new FileOutputStream(file);
        PrintWriter pw = new PrintWriter(fos);
        pw.println("jjj");
        pw.flush();
        pw.close();
        fos.close();
    }

    @After
    public static void after(){

    }
}
