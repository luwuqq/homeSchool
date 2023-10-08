package cn.zfy.school.gateway.filter;

import com.alibaba.nacos.shaded.com.google.gson.JsonObject;
import cn.zfy.school.common.utils.StringUtils;
import cn.zfy.school.gateway.config.IgnoreWhiteProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * 网关鉴权
 *
 */
@Component
public class
AuthFilter implements GlobalFilter, Ordered{
    private static final Logger log = LoggerFactory.getLogger(AuthFilter.class);

    // 排除过滤的 uri 地址，nacos自行添加
    @Autowired
    private IgnoreWhiteProperties ignoreWhite;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain){
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpRequest.Builder mutate = request.mutate();
        String url = request.getURI().getPath();
        System.out.println("开启验证");
        // 跳过不需要验证的路径
        if (StringUtils.matches(url, ignoreWhite.getWhites())){
            System.out.println("无需验证！");
            return chain.filter(exchange);
        }
        //获取token
        List<String> tokens = request.getHeaders().get("Token");

        if (tokens != null && StringUtils.isNotEmpty(tokens.get(0))){//如果tokens存在
            //判断token是否存在
            String token = redisTemplate.opsForValue().get("Token::" + (tokens.get(0)));
            System.out.println("token" + token);
            if(StringUtils.isEmpty(token)){
                //token失效
                //返回登录失效
                ServerHttpResponse response = exchange.getResponse();
                return out(response, "登录失效");
            }else{
                return chain.filter(exchange);
            }
        }else{
            //返回登录失效
            ServerHttpResponse response = exchange.getResponse();
            return out(response, "登录失效");
        }
    }

    private Mono<Void> out(ServerHttpResponse response, String msg) {
        JsonObject message = new JsonObject();
        message.addProperty("message", "登录失效");
        message.addProperty("code", -2);
        message.addProperty("datas", msg);
        byte[] bits = message.toString().getBytes(StandardCharsets.UTF_8);
        DataBuffer buffer = response.bufferFactory().wrap(bits);
        //response.setStatusCode(HttpStatus.UNAUTHORIZED);
        //指定编码，否则在浏览器中会中文乱码
        response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        return response.writeWith(Mono.just(buffer));
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
