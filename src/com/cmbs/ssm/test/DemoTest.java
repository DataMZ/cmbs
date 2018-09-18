package com.cmbs.ssm.test;

import com.cmbs.ssm.pojo.Account;
import com.cmbs.ssm.pojo.Customer;
import com.cmbs.ssm.pojo.Operator;
import com.cmbs.ssm.service.AccountService;
import com.cmbs.ssm.service.CustomerService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author: zwc
 * @date: 2018/9/5 22:39
 * @description:
 */
public class DemoTest {


    @Test
    public void demoTest() {
        Operator operator = new Operator();
        System.out.println(operator.getClass().equals(Operator.class));


    }

    @Test
    public void testAirportsService() {
        ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext-*.xml");
        AccountService accountService = app.getBean(AccountService.class);
        System.out.println(accountService.queryAccountById("12"));
    }


    @Test
    public void testCustomerService() {
        ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext-*.xml");
//        CustomerService customerService = app.getBean(CustomerService.class);
//        Customer customer = new Customer();
//        customer.setIdType("0");
//        customer.setIdNumber("330683199307252415");
//        System.out.println(customerService.queryByIdTypeAndNum(customer));
        CustomerService customerService = app.getBean(CustomerService.class);
        Customer customer = new Customer();
        customer.setIdType("0");
        customer.setIdNumber("330683199307252415");
        customer.setCustomerName("123");
        customer.setCustomerBirthday(new Date());
        customer.setCustomerSex("男");
        customer.setCustomerAddress("12312");
        System.out.println(customerService.addCustomer(customer));
    }

    @Test
    public void test() {
        System.out.println(Long.parseLong("13900000000".trim()));
    }

    @Test
    public void parseTxt() throws IOException {
        File file = new File("G:\\javaBigData\\IdeaProjects\\cmbs\\src\\com\\cmbs\\ssm\\test\\a.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String b = null;
        Map<String,Integer> count = new HashMap<>();
        while ((b = bufferedReader.readLine()) != null) {
            String[] split = b.split(" ");
            for (int i = 0; i < split.length; i++) {
                Set<String> strings = count.keySet();
                String s = split[i].replaceAll("\\.|\\?", "");
                if(strings.contains(s)) {
                    count.put(s,count.get(s)+1);
                }else {
                    count.put(s,1);
                }
            }
        }
        bufferedReader.close();

        System.out.println(count);







    }
}
