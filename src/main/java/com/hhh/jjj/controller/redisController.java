package com.hhh.jjj.controller;

import com.hhh.jjj.po.User;
import com.hhh.jjj.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

;import java.util.List;

@Controller

public class redisController {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/toSeckillPage")

    public String toSeckillPage() {

        return "seckillPage";
    }

    @RequestMapping("/doseckill")
    @ResponseBody
    public String doseckill(String productid) {

        String userid="userid"+Math.random()*1000;

        Boolean opinionproductid = opinionproductid(productid, userid);

        return ""+opinionproductid;
    }


    private Boolean opinionproductid(String productid,String userid) {
        if(productid!=null||productid!=""){

            String prduct="stu:"+productid+":kc";

            if(stringRedisTemplate.opsForValue().get(prduct)==null){
                System.out.println("秒杀没开始");
                return  false;
            }else if(stringRedisTemplate.opsForValue().get(prduct).equals("0")){
                System.out.println("秒杀已经结束");
                return  false;
            }else {


                SessionCallback<Object> callback = new SessionCallback<Object>() {
                    @Override
                    public Object execute(RedisOperations operations) throws DataAccessException {

                        operations.watch(prduct);
                        operations.multi();
                        String o =(String) operations.opsForValue().get(prduct);
                     int  s= Integer.parseInt(o)-1;
                        if(s<0){
                            return  null;
                        }
                        operations.opsForValue().decrement(prduct);
                        operations.opsForSet().add("user",userid);
                        List exec = operations.exec();
                        return exec;
                    }

                };
                System.out.println(stringRedisTemplate.execute(callback));
                return true;
            }



        }
      return  false;
    }

}