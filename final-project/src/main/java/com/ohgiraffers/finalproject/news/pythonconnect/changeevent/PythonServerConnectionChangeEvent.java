//ApplicationEvent를 확장하여, Python 서버 연결 상태의 변경을 알리는 이벤트

package com.ohgiraffers.finalproject.news.pythonconnect.changeevent;

import org.springframework.context.ApplicationEvent;


public class PythonServerConnectionChangeEvent extends ApplicationEvent {

    // 연결 상태를 나타내는 불리언 값
    private final boolean connected;

    // 이벤트 발생 시점과 Python 서버의 연결 상태를 받음
    public PythonServerConnectionChangeEvent(Object source, boolean connected) {
        super(source);
        this.connected = connected; // 연결 상태 초기화
    }

    // Python 서버 연결 상태를 반환
    public boolean isConnected() {
        return connected;
    }
}
