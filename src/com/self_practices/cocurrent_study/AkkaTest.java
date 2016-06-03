package com.self_practices.cocurrent_study;

/**
 * Created by Administrator on 2016/5/13.
 */
interface PlayerA {
    void pong(long ball); //发完就忘的方法调用
}

interface PlayerB {
    void ping(PlayerA playerA, long ball); //发完就忘的方法调用
}

class PlayerAImpl implements PlayerA {
    @Override
    public void pong(long ball) {
    }
}

class PlayerBImpl implements PlayerB {
    @Override
    public void ping(PlayerA playerA, long ball) {
        playerA.pong(ball);
    }
}

public class AkkaTest {
//    public void testPingPong() {
//        // 管理器隐藏了线程间通讯的复杂性
//        // 控制actor代理，actor实现和线程
//        ActorManager manager = new ActorManager();
//        // 在管理器内注册actor实现
//        manager.registerImpl(PlayerAImpl.class);
//        manager.registerImpl(PlayerBImpl.class);
//        //创建actor代理。代理会将方法调用转换成内部消息。
//        //会在线程间发给特定的actor实例。
//        PlayerA playerA = manager.createActor(PlayerA.class);
//        PlayerB playerB = manager.createActor(PlayerB.class);
//        for (int i = 0; i < 1000000; i++) {
//            playerB.ping(playerA, i);
//        }
//    }
}