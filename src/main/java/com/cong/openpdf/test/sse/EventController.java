package com.cong.openpdf.test.sse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;

/**
 * @author cong
 * @since 2023/11/14 14:40
 */
@Slf4j
@RestController
@RequestMapping("sse")
public class EventController {

    private Map<String, SseEmitter> sMap = new ConcurrentHashMap<>();
    private Map<String, MyEvent> msgMap = new ConcurrentHashMap<>();

    @Autowired
    private ApplicationContext applicationContext;

    @SneakyThrows
    @GetMapping(path = "/event", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter event(HttpServletRequest request) {
        // 设置超时时间为半小时
        SseEmitter emitter = new SseEmitter(1000 * 60 * 30L);
        log.info("{}", emitter.hashCode());
        String userId = request.getParameter("userId");
        sMap.put(userId, emitter);
        //TODO 查询数据库中是否存在未通知的记录
        MyEvent myEvent = msgMap.get(userId);
        if (null!=myEvent) {
            log.info("历史消息通知");
            emitter.send(myEvent);
        }
        return emitter;
    }

    /**
     * 模拟某一事件触发动作
     * 
     * @param eventType
     */
    @GetMapping(path = "/trigger")
    public void trigger(@RequestParam String eventType,@RequestParam String userId) {
        MyEvent myEvent = new MyEvent(eventType);
        myEvent.setUserId(userId);
        applicationContext.publishEvent(myEvent);
    }

    /**
     * 监听动作，发送给客户端数据
     */
    @EventListener(classes = MyEvent.class)
    public void triggerEvent(MyEvent event) throws IOException {
        String userId = event.getUserId();
        SseEmitter sseEmitter = sMap.get(userId);
        if (null == sseEmitter) {
            // TODO 链接断开，更新任务状态，重连时再发送
            log.info("{} 尚未连接，稍后再发",userId);
            msgMap.put(userId,event);
        } else {
            sseEmitter.send(event);
        }

    }

}
